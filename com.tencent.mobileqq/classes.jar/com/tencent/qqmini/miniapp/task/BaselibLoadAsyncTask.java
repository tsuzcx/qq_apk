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
    MiniAppReportManager2.reportLaunchPiecewise(204, "", getRuntimeLoader().getMiniAppInfoForReport());
    if (getRuntimeLoader().getMiniAppInfoForReport() != null) {}
    for (String str = getRuntimeLoader().getMiniAppInfoForReport().appId;; str = "")
    {
      QMLog.d("BaseRuntimeLoader", "startLoadBaseLib. appid:" + str);
      if (!isBaseLibInit()) {
        break;
      }
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
    return (this.mBaselibContent != null) && (this.mBaselibContent.isBaseLibInited());
  }
  
  public void loadBaselib()
  {
    try
    {
      BaselibLoader.BaselibContent localBaselibContent = new BaselibLoader.BaselibContent();
      String str2 = StorageUtil.getPreference().getString("downloadUrl", "");
      String str1 = StorageUtil.getPreference().getString("version", "1.19.0.00043");
      QMLog.i("BaselibLoadAsyncTask", "execute baseLibLoad task. url=" + str2 + " version=" + str1);
      str2 = BaseLibManager.g().getBaseLibDir(str2, str1);
      try
      {
        MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
        if ((localMiniAppProxy != null) && (localMiniAppProxy.isDebugVersion()))
        {
          QMLog.d("BaselibLoadAsyncTask", "readJsFromFile from sdcard.");
          localBaselibContent.waWebviewJsStr = FileUtils.readFileToStr(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator, "QView.js"));
          localBaselibContent.waServiceJsStr = FileUtils.readFileToStr(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator, "QLogic.js"));
          localBaselibContent.waServicePath = (Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "QLogic.js");
          localBaselibContent.waConsoleJsStr = FileUtils.readFileToStr(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator, "QVConsole.js"));
          localBaselibContent.waRemoteDebugStr = FileUtils.readFileToStr(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator, "QRemoteDebug.js"));
          localBaselibContent.miniappWebviewStr = FileUtils.readFileToStr(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator, "QWebview.js"));
          localBaselibContent.waWorkerStr = FileUtils.readFileToStr(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator, "QWorker.js"));
          localBaselibContent.pageFrameStr = FileUtils.readFileToStr(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator, "QPageFrame.html"));
          localBaselibContent.version = "1.19.0.00043";
        }
        int j = 1;
        int i;
        if (!BaseLibInfo.needUpdateVersion("1.19.0.00043", str1))
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
          QMLog.e("BaselibLoadAsyncTask", "download baselib invalid! use assert baselib. download_version=" + str1 + " assert_version=" + "1.19.0.00043");
        }
        if ((!localBaselibContent.isBaseLibInited()) && (i != 0))
        {
          QMLog.d("BaselibLoadAsyncTask", "readJsFromFile from download.");
          localBaselibContent.waWebviewJsStr = FileUtils.readFileToStr(new File(str2, "QView.js"));
          localBaselibContent.waServiceJsStr = FileUtils.readFileToStr(new File(str2, "QLogic.js"));
          localBaselibContent.waServicePath = (str2 + File.separator + "QLogic.js");
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
          localBaselibContent.version = "1.19.0.00043";
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QMLog.e("BaselibLoadAsyncTask", "readJsFromFile failed.", localThrowable);
        }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.task.BaselibLoadAsyncTask
 * JD-Core Version:    0.7.0.1
 */