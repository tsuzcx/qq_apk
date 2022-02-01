package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.manager.BaseLibManager;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniProgramReportHelper;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.AsyncTask;
import java.io.File;

@ClassTag(tag="BaselibLoadAsyncTask")
public class BaselibLoadAsyncTask
  extends AsyncTask
{
  public static final String TAG = "BaselibLoadAsyncTask";
  private BaselibLoader.BaselibContent mBaselibContent;
  
  public BaselibLoadAsyncTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  public void executeAsync()
  {
    Object localObject = getRuntimeLoader().getMiniAppInfoForReport();
    String str = "";
    MiniAppReportManager2.reportLaunchPiecewise(204, "", (MiniAppInfo)localObject);
    if (getRuntimeLoader().getMiniAppInfoForReport() != null) {
      str = getRuntimeLoader().getMiniAppInfoForReport().appId;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startLoadBaseLib. appid:");
    ((StringBuilder)localObject).append(str);
    QMLog.d("BaseRuntimeLoader", ((StringBuilder)localObject).toString());
    if (isBaseLibInit())
    {
      onTaskSucceed();
      return;
    }
    MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 10, "0");
    loadBaselib();
    MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 11, "0");
    if (isBaseLibInit())
    {
      com.tencent.qqmini.sdk.report.MiniAppStartState.isBaseLibLoaded = true;
      onTaskSucceed();
      return;
    }
    onTaskFailed();
  }
  
  public BaselibLoader.BaselibContent getBaselibContent()
  {
    return this.mBaselibContent;
  }
  
  public boolean isBaseLibInit()
  {
    BaselibLoader.BaselibContent localBaselibContent = this.mBaselibContent;
    return (localBaselibContent != null) && (localBaselibContent.isBaseLibInited());
  }
  
  public void loadBaselib()
  {
    try
    {
      BaselibLoader.BaselibContent localBaselibContent = new BaselibLoader.BaselibContent();
      String str2 = StorageUtil.getPreference().getString("downloadUrl", "");
      String str1 = StorageUtil.getPreference().getString("version", "1.29.0.00002");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("execute baseLibLoad task. url=");
      ((StringBuilder)localObject2).append(str2);
      ((StringBuilder)localObject2).append(" version=");
      ((StringBuilder)localObject2).append(str1);
      QMLog.i("BaselibLoadAsyncTask", ((StringBuilder)localObject2).toString());
      str2 = BaseLibManager.g().getBaseLibDir(str2, str1);
      try
      {
        localObject2 = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
        if ((localObject2 != null) && (((MiniAppProxy)localObject2).isDebugVersion()))
        {
          QMLog.d("BaselibLoadAsyncTask", "readJsFromFile from sdcard.");
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(Environment.getExternalStorageDirectory().getAbsolutePath());
          ((StringBuilder)localObject2).append(File.separator);
          localBaselibContent.waWebviewJsStr = FileUtils.readFileToStr(new File(((StringBuilder)localObject2).toString(), "QView.js"));
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(Environment.getExternalStorageDirectory().getAbsolutePath());
          ((StringBuilder)localObject2).append(File.separator);
          localBaselibContent.waServiceJsStr = FileUtils.readFileToStr(new File(((StringBuilder)localObject2).toString(), "QLogic.js"));
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(Environment.getExternalStorageDirectory().getAbsolutePath());
          ((StringBuilder)localObject2).append(File.separator);
          ((StringBuilder)localObject2).append("QLogic.js");
          localBaselibContent.waServicePath = ((StringBuilder)localObject2).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(Environment.getExternalStorageDirectory().getAbsolutePath());
          ((StringBuilder)localObject2).append(File.separator);
          localBaselibContent.waConsoleJsStr = FileUtils.readFileToStr(new File(((StringBuilder)localObject2).toString(), "QVConsole.js"));
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(Environment.getExternalStorageDirectory().getAbsolutePath());
          ((StringBuilder)localObject2).append(File.separator);
          localBaselibContent.waRemoteDebugStr = FileUtils.readFileToStr(new File(((StringBuilder)localObject2).toString(), "QRemoteDebug.js"));
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(Environment.getExternalStorageDirectory().getAbsolutePath());
          ((StringBuilder)localObject2).append(File.separator);
          localBaselibContent.miniappWebviewStr = FileUtils.readFileToStr(new File(((StringBuilder)localObject2).toString(), "QWebview.js"));
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(Environment.getExternalStorageDirectory().getAbsolutePath());
          ((StringBuilder)localObject2).append(File.separator);
          localBaselibContent.waWorkerStr = FileUtils.readFileToStr(new File(((StringBuilder)localObject2).toString(), "QWorker.js"));
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(Environment.getExternalStorageDirectory().getAbsolutePath());
          ((StringBuilder)localObject2).append(File.separator);
          localBaselibContent.pageFrameStr = FileUtils.readFileToStr(new File(((StringBuilder)localObject2).toString(), "QPageFrame.html"));
          localBaselibContent.version = "1.29.0.00002";
        }
        int j = 1;
        int i;
        if (!BaseLibInfo.needUpdateVersion("1.29.0.00002", str1))
        {
          i = j;
          if (!TextUtils.isEmpty(str2))
          {
            i = j;
            if (BaseLibManager.verifyBaselib(new File(str2))) {}
          }
        }
        else
        {
          i = 0;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("download baselib invalid! use assert baselib. download_version=");
          ((StringBuilder)localObject2).append(str1);
          ((StringBuilder)localObject2).append(" assert_version=");
          ((StringBuilder)localObject2).append("1.29.0.00002");
          QMLog.e("BaselibLoadAsyncTask", ((StringBuilder)localObject2).toString());
        }
        if ((!localBaselibContent.isBaseLibInited()) && (i != 0))
        {
          QMLog.d("BaselibLoadAsyncTask", "readJsFromFile from download.");
          localBaselibContent.waWebviewJsStr = FileUtils.readFileToStr(new File(str2, "QView.js"));
          localBaselibContent.waServiceJsStr = FileUtils.readFileToStr(new File(str2, "QLogic.js"));
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(str2);
          ((StringBuilder)localObject2).append(File.separator);
          ((StringBuilder)localObject2).append("QLogic.js");
          localBaselibContent.waServicePath = ((StringBuilder)localObject2).toString();
          localBaselibContent.waConsoleJsStr = FileUtils.readFileToStr(new File(str2, "QVConsole.js"));
          localBaselibContent.waRemoteDebugStr = FileUtils.readFileToStr(new File(str2, "QRemoteDebug.js"));
          localBaselibContent.miniappWebviewStr = FileUtils.readFileToStr(new File(str2, "QWebview.js"));
          localBaselibContent.waWorkerStr = FileUtils.readFileToStr(new File(str2, "QWorker.js"));
          localBaselibContent.pageFrameStr = FileUtils.readFileToStr(new File(str2, "QPageFrame.html"));
          localBaselibContent.version = str1;
        }
        if (!localBaselibContent.isBaseLibInited())
        {
          QMLog.d("BaselibLoadAsyncTask", "readJsFromFile from Assets.");
          localBaselibContent.waWebviewJsStr = FileUtils.readFileFromAssets(getContext(), "mini/QView.js");
          localBaselibContent.waServiceJsStr = FileUtils.readFileFromAssets(getContext(), "mini/QLogic.js");
          localBaselibContent.waServicePath = "assets://mini/QLogic.js";
          localBaselibContent.waConsoleJsStr = FileUtils.readFileFromAssets(getContext(), "mini/QVConsole.js");
          localBaselibContent.waRemoteDebugStr = FileUtils.readFileFromAssets(getContext(), "mini/QRemoteDebug.js");
          localBaselibContent.miniappWebviewStr = FileUtils.readFileFromAssets(getContext(), "mini/QWebview.js");
          localBaselibContent.waWorkerStr = FileUtils.readFileFromAssets(getContext(), "mini/QWorker.js");
          localBaselibContent.pageFrameStr = FileUtils.readFileFromAssets(getContext(), "mini/QPageFrame.html");
          localBaselibContent.version = "1.29.0.00002";
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("BaselibLoadAsyncTask", "readJsFromFile failed.", localThrowable);
      }
      if (localBaselibContent.isBaseLibInited()) {
        this.mBaselibContent = localBaselibContent;
      }
      return;
    }
    finally {}
  }
  
  public void onTaskSucceed()
  {
    super.onTaskSucceed();
    MiniAppReportManager2.reportLaunchPiecewise(205, "", getRuntimeLoader().getMiniAppInfoForReport());
  }
  
  public void reset()
  {
    super.reset();
    this.mBaselibContent = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.task.BaselibLoadAsyncTask
 * JD-Core Version:    0.7.0.1
 */