package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qqmini.miniapp.receiver.WebProcessReceiver;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.AsyncTask;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.smtt.sdk.QbSdk;
import java.util.HashMap;
import java.util.Map;

@ClassTag(tag="TbsAsyncTask")
public class TbsAsyncTask
  extends AsyncTask
{
  public static final int MSG_WHAT_CHECK_TBS = 6;
  public static final int MSG_WHAT_X5_DOWNLOAD_PROGRESS = 3;
  public static final int MSG_WHAT_X5_TIMEOUT = 7;
  private static int X5_STATE_DOWNLOAD_EXIST_IN_WX = 122;
  private static int X5_STATE_DOWNLOAD_FAIL_INIT_THREAD = 121;
  private static int X5_STATE_DOWNLOAD_OTHER_PROCESS = 177;
  private static int X5_STATE_DOWNLOAD_READY = 120;
  private static int X5_STATE_DOWNLOAD_REPEAT = 110;
  private static int X5_STATE_DOWNLOAD_SUCC = 100;
  private static int X5_STATE_INSTALL_COPY_SUCC = 220;
  private static int X5_STATE_INSTALL_SUCC = 200;
  private static int X5_STATE_INSTALL_SUCCESS_AND_RELEASE_LOCK = 232;
  private final int X5_LOAD_TIME_OUT = 30000;
  private boolean mDownloadForground = false;
  public boolean mIsTimeout = false;
  private int mTbsProgress = 0;
  private boolean mWaitForX5 = false;
  protected Handler workHander;
  
  public TbsAsyncTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  public static String getSubProcessName()
  {
    Object localObject3 = null;
    Object localObject2;
    try
    {
      String str = AppLoaderFactory.g().getProcessName();
      Object localObject1 = localObject3;
      if (str.contains(":")) {
        localObject1 = str.substring(str.indexOf(":") + 1);
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start", "getSubProcessName exception!", localThrowable);
      localObject2 = localObject3;
    }
    localObject3 = localObject2;
    if (TextUtils.isEmpty(localObject2)) {
      localObject3 = "mini";
    }
    return localObject3;
  }
  
  public void doCheckTbs()
  {
    int i = QbSdk.getTbsVersion(this.mContext);
    int j = QbSdk.getTmpDirTbsVersion(this.mContext);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getTbsVersion=");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" tmpDirTbsVersion=");
    ((StringBuilder)localObject).append(j);
    QMLog.d("minisdk-start", ((StringBuilder)localObject).toString());
    localObject = this.mContext;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mContext.getPackageName());
    localStringBuilder.append("_preferences");
    localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 4);
    int k = ((SharedPreferences)localObject).getInt("tbs_download_complete", -1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("tbs download result: ");
    localStringBuilder.append(k);
    QMLog.i("minisdk-start", localStringBuilder.toString());
    if (((k != X5_STATE_INSTALL_SUCCESS_AND_RELEASE_LOCK) && (k != X5_STATE_INSTALL_COPY_SUCC)) || ((i <= 0) && (j <= 0)))
    {
      if (k != -1)
      {
        getWorkHander().removeMessages(6);
        onTaskFailed();
        return;
      }
      i = ((SharedPreferences)localObject).getInt("tbs_download_progress", 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tbs download progress ");
      ((StringBuilder)localObject).append(i);
      QMLog.d("minisdk-start", ((StringBuilder)localObject).toString());
      if (i > this.mTbsProgress)
      {
        this.mTbsProgress = i;
        getWorkHander().removeMessages(7);
        getWorkHander().sendEmptyMessageDelayed(7, 30000L);
        localObject = Message.obtain();
        ((Message)localObject).what = 3;
        ((Message)localObject).arg1 = i;
      }
      if (!isDone()) {
        getWorkHander().sendEmptyMessageDelayed(6, 1000L);
      }
      return;
    }
    getWorkHander().removeMessages(6);
    onTaskSucceed();
  }
  
  public void executeAsync()
  {
    QMLog.i("minisdk-start", "startTbs");
    int i = QbSdk.getTbsVersion(this.mContext);
    int j = QbSdk.getTmpDirTbsVersion(this.mContext);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tbsVersion=");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" tmpDirTbsVersion=");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(",data_directory_suffix:");
    ((StringBuilder)localObject).append(getSubProcessName());
    QMLog.i("minisdk-start", ((StringBuilder)localObject).toString());
    localObject = new HashMap();
    ((HashMap)localObject).put("data_directory_suffix", getSubProcessName());
    QbSdk.initTbsSettings((Map)localObject);
    this.mIsTimeout = false;
    if ((i <= 0) && (j <= 0))
    {
      if (QUAUtil.isQQApp())
      {
        QMLog.i("minisdk-start", "QQ App no need to update x5 in sdk.");
        onTaskSucceed();
        return;
      }
      if (!this.mWaitForX5)
      {
        QMLog.i("minisdk-start", "X5 isn't completed， use system core。");
        localObject = new Intent(this.mContext, WebProcessReceiver.class);
        ((Intent)localObject).setAction("action_download_tbs");
        ((Intent)localObject).putExtra("isDownloadForeground", this.mDownloadForground);
        ((Intent)localObject).putExtra("fromMiniApp", true);
        this.mContext.sendBroadcast((Intent)localObject);
        onTaskSucceed();
        return;
      }
      getWorkHander().sendEmptyMessageDelayed(7, 30000L);
      this.mTbsProgress = 0;
      localObject = this.mContext;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mContext.getPackageName());
      localStringBuilder.append("_preferences");
      localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 4);
      ((SharedPreferences)localObject).edit().remove("tbs_download_complete").commit();
      ((SharedPreferences)localObject).edit().remove("tbs_download_progress").commit();
      localObject = new Intent(this.mContext, WebProcessReceiver.class);
      ((Intent)localObject).setAction("action_download_tbs");
      ((Intent)localObject).putExtra("isDownloadForeground", this.mDownloadForground);
      ((Intent)localObject).putExtra("fromMiniApp", true);
      this.mContext.sendBroadcast((Intent)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start WebProcessReceiver isDownloadForeground");
      ((StringBuilder)localObject).append(this.mDownloadForground);
      QMLog.d("minisdk-start", ((StringBuilder)localObject).toString());
      getWorkHander().sendEmptyMessageDelayed(6, 1000L);
      return;
    }
    onTaskSucceed();
  }
  
  public Handler getWorkHander()
  {
    if (this.workHander == null) {
      this.workHander = new Handler(Looper.getMainLooper(), this);
    }
    return this.workHander;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 6)
    {
      if (i == 7)
      {
        i = QbSdk.getTbsVersion(this.mContext);
        int j = QbSdk.getTmpDirTbsVersion(this.mContext);
        paramMessage = new StringBuilder();
        paramMessage.append("X5安装超时 tbsVersion=");
        paramMessage.append(i);
        paramMessage.append(" tmpDirTbsVersion=");
        paramMessage.append(j);
        QMLog.d("minisdk-start", paramMessage.toString());
        if ((i <= 0) && (j <= 0))
        {
          this.mIsTimeout = true;
          onTaskFailed();
        }
        else
        {
          onTaskSucceed();
        }
      }
    }
    else {
      doCheckTbs();
    }
    return false;
  }
  
  public void needDownloadForeground(boolean paramBoolean)
  {
    this.mDownloadForground = paramBoolean;
  }
  
  public void onTaskFailed()
  {
    getWorkHander().removeMessages(7);
    boolean bool = this.mIsTimeout;
    QMLog.d("minisdk-start", "TbsAsyncTask failed! Work continue as same as succeed anyway. ");
    super.onTaskSucceed();
  }
  
  public void onTaskSucceed()
  {
    getWorkHander().removeMessages(7);
    super.onTaskSucceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.task.TbsAsyncTask
 * JD-Core Version:    0.7.0.1
 */