package com.tencent.mobileqq.mini.appbrand.ui;

import android.content.Context;
import android.content.SharedPreferences;
import bgkv;
import com.tencent.mobileqq.mini.apkg.BaseLibManager;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.OnLoadBaselibListener;
import java.io.File;

public class AppBrandUI3$QQBaselibLoader
  extends BaselibLoader
{
  public static final String TAG = "QQBaselibLoader";
  private static volatile QQBaselibLoader instance;
  private static volatile byte[] lock = new byte[0];
  
  public static QQBaselibLoader g()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new QQBaselibLoader();
      }
      return instance;
    }
  }
  
  public void loadBaselib(Context paramContext, BaselibLoader.OnLoadBaselibListener paramOnLoadBaselibListener)
  {
    int i = 0;
    for (;;)
    {
      String str2;
      String str1;
      try
      {
        if (isBaseLibInit())
        {
          if (paramOnLoadBaselibListener != null) {
            paramOnLoadBaselibListener.onResult(0, "", this.mBaselibContent.clone());
          }
          return;
        }
        paramContext = new BaselibLoader.BaselibContent();
        str2 = StorageUtil.getPreference().getString("downloadUrl", "");
        str1 = StorageUtil.getPreference().getString("version", "1.14.0.00225");
        QLog.i("minisdk-start", 1, "execute baseLibLoad task. url=" + str2 + " version=" + str1);
        str2 = BaseLibManager.g().getBaseLibDir(str2, str1);
      }
      finally {}
      try
      {
        if (!BaseLibInfo.needUpdateVersion("1.14.0.00225", str1)) {
          break label507;
        }
        QLog.e("minisdk-start", 1, "download baselib invalid! use assert baselib. download_version=" + str1 + " assert_version=" + "1.14.0.00225");
        if ((!paramContext.isBaseLibInited()) && (i != 0))
        {
          QLog.d("minisdk-start", 1, "readJsFromFile from download.");
          paramContext.waWebviewJsStr = bgkv.a(new File(str2, "QView.js"));
          paramContext.waServiceJsStr = bgkv.a(new File(str2, "QLogic.js"));
          paramContext.waServicePath = (str2 + File.separator + "QLogic.js");
          paramContext.waConsoleJsStr = bgkv.a(new File(str2, "QVConsole.js"));
          paramContext.waRemoteDebugStr = bgkv.a(new File(str2, "QRemoteDebug.js"));
          paramContext.miniappWebviewStr = bgkv.a(new File(str2, "QWebview.js"));
          paramContext.waWorkerStr = bgkv.a(new File(str2, "QWorker.js"));
          paramContext.pageFrameStr = bgkv.a(new File(str2, "QPageFrame.html"));
        }
        if (!paramContext.isBaseLibInited())
        {
          QLog.d("minisdk-start", 1, "readJsFromFile from Assets.");
          paramContext.waWebviewJsStr = FileUtils.readFileFromAssets("mini/QView.js");
          paramContext.waServiceJsStr = FileUtils.readFileFromAssets("mini/QLogic.js");
          paramContext.waServicePath = "assets://mini/QLogic.js";
          paramContext.waConsoleJsStr = FileUtils.readFileFromAssets("mini/QVConsole.js");
          paramContext.waRemoteDebugStr = FileUtils.readFileFromAssets("mini/QRemoteDebug.js");
          paramContext.miniappWebviewStr = FileUtils.readFileFromAssets("mini/QWebview.js");
          paramContext.waWorkerStr = FileUtils.readFileFromAssets("mini/QWorker.js");
          paramContext.pageFrameStr = FileUtils.readFileFromAssets("QPageFrame.html");
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("minisdk-start", 1, "readJsFromFile failed." + localThrowable);
        continue;
        paramOnLoadBaselibListener.onResult(-1, "基础库加载失败", null);
      }
      setBaselib(paramContext);
      if (paramOnLoadBaselibListener != null) {
        if (isBaseLibInit())
        {
          paramOnLoadBaselibListener.onResult(0, "", this.mBaselibContent.clone());
        }
        else
        {
          continue;
          label507:
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI3.QQBaselibLoader
 * JD-Core Version:    0.7.0.1
 */