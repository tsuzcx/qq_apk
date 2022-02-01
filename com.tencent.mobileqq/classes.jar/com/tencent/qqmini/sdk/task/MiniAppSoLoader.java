package com.tencent.qqmini.sdk.task;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.EngineInstaller;
import com.tencent.qqmini.sdk.manager.InstalledEngine;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.utils.JarReflectUtil;
import com.tencent.qqmini.sdk.utils.QzoneModuleLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"WrongConstant"})
public class MiniAppSoLoader
{
  public static final String LIBNAME_AVSDK_SO = "liteavsdk";
  public static final String LIBNAME_CPLUS_SHARE_SO = "c++_shared";
  public static final String LIBNAME_LAME_MP3_SO = "mini_lamemp3";
  public static final String LIBNAME_LITEAVSDK_JAR = "liteavsdk.jar";
  public static final String LIBNAME_SATURN_SO = "saturn";
  public static final String LIBNAME_TRAEIMP_SO = "traeimp-rtmp";
  public static final String LIBNAME_TXFFMPEG_SO = "txffmpeg";
  public static final String LOCAL_ENGINE_VERSION = "0.1";
  public static final String[] MINI_APP_LIB_SO = { "mini_lamemp3", "c++_shared", "saturn", "traeimp-rtmp", "txffmpeg", "liteavsdk" };
  private static final String TAG = "MiniAppSoLoader";
  private static volatile MiniAppSoLoader sInstance;
  private boolean lameMp3SoLoaded = false;
  private InstalledEngine mEngine;
  private int mEngineType = 3;
  
  public MiniAppSoLoader()
  {
    Iterator localIterator = EngineInstaller.getInstalledEngine(this.mEngineType).iterator();
    while (localIterator.hasNext())
    {
      InstalledEngine localInstalledEngine = (InstalledEngine)localIterator.next();
      if (localInstalledEngine.isVerify) {
        this.mEngine = localInstalledEngine;
      }
    }
  }
  
  public static MiniAppSoLoader g()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new MiniAppSoLoader();
      }
      return sInstance;
    }
    finally {}
  }
  
  private String getBaseEnginePath(InstalledEngine paramInstalledEngine)
  {
    if ((paramInstalledEngine != null) && (paramInstalledEngine.isVerify)) {
      return paramInstalledEngine.engineDir;
    }
    return null;
  }
  
  public boolean isLameMp3SoLoaded()
  {
    return this.lameMp3SoLoaded;
  }
  
  public boolean loadAllMiniSo()
  {
    if (this.mEngine != null) {}
    for (;;)
    {
      try
      {
        bool1 = QzoneModuleLoader.loadModuleDex(this.mEngine.engineDir + File.separator + "liteavsdk.jar", AppLoaderFactory.g().getContext(), getClass().getClassLoader(), "com.tencent.rtmp.ui.TXCloudVideoView", false);
        if (bool1)
        {
          QMLog.e("MiniAppSoLoader", "load liteavsdk.jar successful!!!");
          bool3 = bool1;
          String[] arrayOfString = MINI_APP_LIB_SO;
          int j = arrayOfString.length;
          int i = 0;
          bool1 = true;
          if (i >= j) {
            continue;
          }
          str = arrayOfString[i];
          if ((!"liteavsdk".equals(str)) || (bool3)) {
            continue;
          }
          QMLog.e("MiniAppSoLoader", "load liteavsdk.jar failed?!!, and don't load liteavsdk.so ?!!");
          bool1 = false;
          i += 1;
          continue;
        }
      }
      catch (Exception localException)
      {
        String str;
        QMLog.e("MiniAppSoLoader", "load liteavsdk.jar failed, e:" + localException.toString());
        boolean bool1 = false;
        continue;
        QMLog.e("MiniAppSoLoader", "load liteavsdk.jar failed ？!! ");
        bool3 = bool1;
        continue;
        if ((bool1) && (loadLibSo(str)))
        {
          bool2 = true;
          bool1 = bool2;
          if (!"mini_lamemp3".equals(str)) {
            continue;
          }
          bool1 = bool2;
          if (!bool2) {
            continue;
          }
          this.lameMp3SoLoaded = true;
          bool1 = bool2;
          continue;
        }
        boolean bool2 = false;
        continue;
        if ((bool1) && (this.mEngine != null) && (!TextUtils.isEmpty(this.mEngine.engineDir)))
        {
          QMLog.d("MiniAppSoLoader", "loadAllOk, TXLiveBase.setLibraryPath:" + this.mEngine.engineDir);
          JarReflectUtil.callSpecifiedStaticMethod("com.tencent.rtmp.TXLiveBase", "setLibraryPath", false, JarReflectUtil.getParamsClass(new Class[] { String.class }), new Object[] { this.mEngine.engineDir });
        }
        return bool1;
      }
      boolean bool3 = false;
    }
  }
  
  public boolean loadLameMp3So()
  {
    return loadLibSo("mini_lamemp3");
  }
  
  protected boolean loadLibSo(String paramString)
  {
    if ((this.mEngine == null) || (TextUtils.isEmpty(paramString))) {
      QMLog.e("MiniAppSoLoader", "[MiniEng]load so " + paramString + " from " + this.mEngine);
    }
    String str2;
    String str1;
    do
    {
      return false;
      str2 = getBaseEnginePath(this.mEngine);
      str1 = str2 + File.separator + "lib" + paramString + ".so";
      QMLog.i("MiniAppSoLoader", "[MiniEng]load so " + paramString + " from " + str1);
    } while (TextUtils.isEmpty(str2));
    try
    {
      System.load(str1);
      if (this.mEngine.loadStatus == 1) {
        this.mEngine.loadStatus = 3;
      }
      QMLog.i("MiniAppSoLoader", "[MiniEng] load " + str1 + " success.");
      return true;
    }
    catch (Throwable paramString)
    {
      QMLog.e("MiniAppSoLoader", "[MiniEng] load " + str1 + " fail: " + DebugUtil.getPrintableStackTrace(paramString), paramString);
      this.mEngine.loadStatus = 2;
    }
    return false;
  }
  
  public void setEngine(InstalledEngine paramInstalledEngine)
  {
    this.mEngine = paramInstalledEngine;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.MiniAppSoLoader
 * JD-Core Version:    0.7.0.1
 */