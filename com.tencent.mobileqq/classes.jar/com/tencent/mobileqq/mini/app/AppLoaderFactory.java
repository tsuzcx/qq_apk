package com.tencent.mobileqq.mini.app;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.MiniAppInterface;
import java.io.File;

public class AppLoaderFactory
{
  public static final String BASE_LIB_PATH_DIR = PATH_WXAPKG_ROOT + ".baseLib";
  public static final String PATH_WXAPKG_ROOT = BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/mini/";
  public static final String TAG = "miniapp-start";
  public static final String TAG_CHROMIUM = "miniapp-chromium";
  public static final String TAG_JS = "miniapp-JS";
  public static final String TAG_PROCESSOR = "miniapp-process";
  public static MiniAppInterface miniAppInterface;
  
  public static MiniAppInterface getMiniAppInterface()
  {
    return miniAppInterface;
  }
  
  public static void setMiniAppInterface(MiniAppInterface paramMiniAppInterface)
  {
    miniAppInterface = paramMiniAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppLoaderFactory
 * JD-Core Version:    0.7.0.1
 */