package com.tencent.mobileqq.mini.tfs.mini;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.tfs.AsyncTask;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.util.HashMap;
import java.util.Map;

public class TbsAsyncTask
  extends AsyncTask
{
  public static final int MSG_WHAT_CHECK_TBS = 6;
  private static int X5_STATE_DOWNLOAD_EXIST_IN_WX;
  private static int X5_STATE_DOWNLOAD_FAIL_INIT_THREAD;
  private static int X5_STATE_DOWNLOAD_OTHER_PROCESS;
  private static int X5_STATE_DOWNLOAD_READY;
  private static int X5_STATE_DOWNLOAD_REPEAT;
  private static int X5_STATE_DOWNLOAD_SUCC = 100;
  private static int X5_STATE_INSTALL_COPY_SUCC = 220;
  private static int X5_STATE_INSTALL_SUCC;
  private static int X5_STATE_INSTALL_SUCCESS_AND_RELEASE_LOCK = 232;
  private final int X5_LOAD_TIME_OUT = 30000;
  private boolean mDownloadForground;
  public boolean mIsTimeout;
  private int mTbsProgress;
  private boolean mWaitForX5;
  protected Handler workHander;
  
  static
  {
    X5_STATE_DOWNLOAD_REPEAT = 110;
    X5_STATE_DOWNLOAD_READY = 120;
    X5_STATE_DOWNLOAD_FAIL_INIT_THREAD = 121;
    X5_STATE_DOWNLOAD_EXIST_IN_WX = 122;
    X5_STATE_DOWNLOAD_OTHER_PROCESS = 177;
    X5_STATE_INSTALL_SUCC = 200;
  }
  
  public TbsAsyncTask(Context paramContext)
  {
    super(paramContext);
  }
  
  public static String getSubProcessName()
  {
    localObject3 = null;
    try
    {
      String str = BaseApplicationImpl.getApplication().getQQProcessName();
      localObject1 = localObject3;
      if (str.contains(":")) {
        localObject1 = str.substring(str.indexOf(":") + 1);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject1;
        QLog.e("miniapp-start", 1, "getSubProcessName exception!", localThrowable);
        Object localObject2 = localObject3;
      }
    }
    localObject3 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject3 = "mini";
    }
    return localObject3;
  }
  
  public void doCheckTbs()
  {
    int i = QbSdk.getTbsVersion(this.mContext);
    int j = QbSdk.getTmpDirTbsVersion(this.mContext);
    QLog.d("miniapp-start", 1, "getTbsVersion=" + i + " tmpDirTbsVersion=" + j);
    Object localObject = this.mContext.getSharedPreferences(this.mContext.getPackageName() + "_preferences", 4);
    int k = ((SharedPreferences)localObject).getInt("tbs_download_complete", -1);
    QLog.i("miniapp-start", 1, "tbs download result: " + k);
    if (((k == X5_STATE_INSTALL_SUCCESS_AND_RELEASE_LOCK) || (k == X5_STATE_INSTALL_COPY_SUCC)) && ((i > 0) || (j > 0)))
    {
      getWorkHander().removeMessages(6);
      onTaskSucceed();
    }
    do
    {
      return;
      if (k != -1)
      {
        getWorkHander().removeMessages(6);
        onTaskFailed();
        return;
      }
      i = ((SharedPreferences)localObject).getInt("tbs_download_progress", 0);
      QLog.d("miniapp-start", 1, "tbs download progress " + i);
      if (i > this.mTbsProgress)
      {
        this.mTbsProgress = i;
        getWorkHander().removeMessages(306);
        getWorkHander().sendEmptyMessageDelayed(306, 30000L);
        localObject = Message.obtain();
        ((Message)localObject).what = 303;
        ((Message)localObject).arg1 = i;
        AppLoaderFactory.getAppLoaderManager().notifyMessage((Message)localObject);
      }
    } while (isDone());
    getWorkHander().sendEmptyMessageDelayed(6, 1000L);
  }
  
  public void executeAsync()
  {
    QLog.i("miniapp-start", 1, "startTbs");
    int i = QbSdk.getTbsVersion(this.mContext);
    int j = QbSdk.getTmpDirTbsVersion(this.mContext);
    QLog.i("miniapp-start", 1, "tbsVersion=" + i + " tmpDirTbsVersion=" + j);
    Object localObject = new HashMap();
    ((HashMap)localObject).put("data_directory_suffix", getSubProcessName());
    QbSdk.initTbsSettings((Map)localObject);
    if (MiniAppGameDebugSettingFragment.shouldUseSystemWebView(this.mContext)) {
      QbSdk.forceSysWebView();
    }
    this.mIsTimeout = false;
    if ((i > 0) || (j > 0) || (MiniAppGameDebugSettingFragment.shouldUseSystemWebView(this.mContext)))
    {
      onTaskSucceed();
      return;
    }
    if (!this.mWaitForX5)
    {
      QLog.i("miniapp-start", 1, "X5 isn't completed， use system core。");
      localObject = new Intent(this.mContext, WebProcessReceiver.class);
      ((Intent)localObject).setAction("action_download_tbs");
      ((Intent)localObject).putExtra("isDownloadForeground", this.mDownloadForground);
      ((Intent)localObject).putExtra("fromMiniApp", true);
      this.mContext.sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
      onTaskSucceed();
      return;
    }
    getWorkHander().sendEmptyMessageDelayed(306, 30000L);
    this.mTbsProgress = 0;
    localObject = this.mContext.getSharedPreferences(this.mContext.getPackageName() + "_preferences", 4);
    ((SharedPreferences)localObject).edit().remove("tbs_download_complete").commit();
    ((SharedPreferences)localObject).edit().remove("tbs_download_progress").commit();
    localObject = new Intent(this.mContext, WebProcessReceiver.class);
    ((Intent)localObject).setAction("action_download_tbs");
    ((Intent)localObject).putExtra("isDownloadForeground", this.mDownloadForground);
    ((Intent)localObject).putExtra("fromMiniApp", true);
    this.mContext.sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    QLog.d("miniapp-start", 1, "start WebProcessReceiver isDownloadForeground" + this.mDownloadForground);
    getWorkHander().sendEmptyMessageDelayed(6, 1000L);
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
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      doCheckTbs();
      continue;
      int i = QbSdk.getTbsVersion(this.mContext);
      int j = QbSdk.getTmpDirTbsVersion(this.mContext);
      QLog.d("miniapp-start", 1, "X5安装超时 tbsVersion=" + i + " tmpDirTbsVersion=" + j);
      if ((i > 0) || (j > 0))
      {
        onTaskSucceed();
      }
      else
      {
        this.mIsTimeout = true;
        onTaskFailed();
      }
    }
  }
  
  public void needDownloadForeground(boolean paramBoolean)
  {
    this.mDownloadForground = paramBoolean;
  }
  
  public void onTaskFailed()
  {
    getWorkHander().removeMessages(306);
    if (this.mIsTimeout) {
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 604, null, null, null, 0);
    }
    for (;;)
    {
      QLog.d("miniapp-start", 1, "TbsAsyncTask failed! Work continue as same as succeed anyway. ");
      super.onTaskSucceed();
      return;
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 603, null, null, null, 0);
    }
  }
  
  public void onTaskSucceed()
  {
    getWorkHander().removeMessages(306);
    MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 602, null, null, null, 0);
    super.onTaskSucceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.mini.TbsAsyncTask
 * JD-Core Version:    0.7.0.1
 */