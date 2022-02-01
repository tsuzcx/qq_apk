package com.tencent.mobileqq.mini.app;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.MiniAppInterface;
import java.io.File;

public class AppLoaderFactory
{
  public static final String BASE_LIB_PATH_DIR;
  public static final String PATH_WXAPKG_ROOT;
  public static final String TAG = "miniapp-start";
  public static final String TAG_CHROMIUM = "miniapp-chromium";
  public static final String TAG_JS = "miniapp-JS";
  public static final String TAG_PROCESSOR = "miniapp-process";
  public static MiniAppInterface miniAppInterface;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir().getPath());
    localStringBuilder.append("/mini/");
    PATH_WXAPKG_ROOT = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(PATH_WXAPKG_ROOT);
    localStringBuilder.append(".baseLib");
    BASE_LIB_PATH_DIR = localStringBuilder.toString();
  }
  
  public static MiniAppInterface getMiniAppInterface()
  {
    return miniAppInterface;
  }
  
  public static void setMiniAppInterface(MiniAppInterface paramMiniAppInterface)
  {
    miniAppInterface = paramMiniAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppLoaderFactory
 * JD-Core Version:    0.7.0.1
 */