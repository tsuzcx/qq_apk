package com.tencent.mobileqq.mini.app;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.util.MiniAppDexLoader;
import java.io.File;

public class AppLoaderFactory
{
  public static final String BASE_LIB_PATH_DIR = PATH_WXAPKG_ROOT + ".baseLib";
  public static final String PATH_WXAPKG_ROOT = BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/mini/";
  public static final String TAG = "miniapp-start";
  public static final String TAG_CHROMIUM = "miniapp-chromium";
  public static final String TAG_JS = "miniapp-JS";
  public static final String TAG_PROCESSOR = "miniapp-process";
  private static volatile BaseAppLoaderManager sAppLoaderManager;
  private static volatile IAppUIProxy sAppUIProxy;
  
  public static IAppUIProxy createAppUIProxy()
  {
    if (sAppUIProxy == null) {}
    try
    {
      if (sAppUIProxy == null) {
        sAppUIProxy = MiniAppDexLoader.getInstance().createAppUIProxy("com.tencent.mobileqq.mini.app.AppUIProxy");
      }
      return sAppUIProxy;
    }
    finally {}
  }
  
  public static IAppUIProxy createInternalAppUIProxy()
  {
    if (sAppUIProxy == null) {}
    try
    {
      if (sAppUIProxy == null) {
        sAppUIProxy = MiniAppDexLoader.getInstance().createAppUIProxy("com.tencent.mobileqq.mini.app.InternalAppUIProxy");
      }
      return sAppUIProxy;
    }
    finally {}
  }
  
  public static BaseAppLoaderManager getAppLoaderManager()
  {
    if (sAppLoaderManager == null) {}
    try
    {
      if (sAppLoaderManager == null) {
        sAppLoaderManager = MiniAppDexLoader.getInstance().createAppLoaderManager("com.tencent.mobileqq.mini.app.AppLoaderManager");
      }
      return sAppLoaderManager;
    }
    finally {}
  }
  
  public static IAppUIProxy getAppUIProxy()
  {
    return sAppUIProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppLoaderFactory
 * JD-Core Version:    0.7.0.1
 */