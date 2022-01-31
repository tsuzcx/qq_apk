package com.tencent.mobileqq.mini.appbrand.ui;

import android.content.Context;
import android.content.SharedPreferences;
import belh;
import bess;
import best;
import besu;
import com.tencent.mobileqq.mini.apkg.BaseLibManager;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AppBrandUI3$QQBaselibLoader
  extends bess
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
  
  public void loadBaselib(Context paramContext, besu parambesu)
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
          if (parambesu != null) {
            parambesu.a(0, "", this.mBaselibContent.a());
          }
          return;
        }
        paramContext = new best();
        str2 = StorageUtil.getPreference().getString("downloadUrl", "");
        str1 = StorageUtil.getPreference().getString("version", "1.13.0.00013");
        QLog.i("minisdk-start", 1, "execute baseLibLoad task. url=" + str2 + " version=" + str1);
        str2 = BaseLibManager.g().getBaseLibDir(str2, str1);
      }
      finally {}
      try
      {
        if (!BaseLibInfo.needUpdateVersion("1.13.0.00013", str1)) {
          break label507;
        }
        QLog.e("minisdk-start", 1, "download baselib invalid! use assert baselib. download_version=" + str1 + " assert_version=" + "1.13.0.00013");
        if ((!paramContext.a()) && (i != 0))
        {
          QLog.d("minisdk-start", 1, "readJsFromFile from download.");
          paramContext.a = belh.a(new File(str2, "QView.js"));
          paramContext.b = belh.a(new File(str2, "QLogic.js"));
          paramContext.h = (str2 + File.separator + "QLogic.js");
          paramContext.c = belh.a(new File(str2, "QVConsole.js"));
          paramContext.d = belh.a(new File(str2, "QRemoteDebug.js"));
          paramContext.e = belh.a(new File(str2, "QWebview.js"));
          paramContext.f = belh.a(new File(str2, "QWorker.js"));
          paramContext.g = belh.a(new File(str2, "QPageFrame.html"));
        }
        if (!paramContext.a())
        {
          QLog.d("minisdk-start", 1, "readJsFromFile from Assets.");
          paramContext.a = FileUtils.readFileFromAssets("mini/QView.js");
          paramContext.b = FileUtils.readFileFromAssets("mini/QLogic.js");
          paramContext.h = "assets://mini/QLogic.js";
          paramContext.c = FileUtils.readFileFromAssets("mini/QVConsole.js");
          paramContext.d = FileUtils.readFileFromAssets("mini/QRemoteDebug.js");
          paramContext.e = FileUtils.readFileFromAssets("mini/QWebview.js");
          paramContext.f = FileUtils.readFileFromAssets("mini/QWorker.js");
          paramContext.g = FileUtils.readFileFromAssets("QPageFrame.html");
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("minisdk-start", 1, "readJsFromFile failed." + localThrowable);
        continue;
        parambesu.a(-1, "基础库加载失败", null);
      }
      setBaselib(paramContext);
      if (parambesu != null) {
        if (isBaseLibInit())
        {
          parambesu.a(0, "", this.mBaselibContent.a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI3.QQBaselibLoader
 * JD-Core Version:    0.7.0.1
 */