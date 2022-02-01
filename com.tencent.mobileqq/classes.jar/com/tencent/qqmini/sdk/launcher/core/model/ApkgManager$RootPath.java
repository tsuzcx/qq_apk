package com.tencent.qqmini.sdk.launcher.core.model;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import java.io.File;

public class ApkgManager$RootPath
{
  private static String PATH_APKG_TISSUE_ROOT;
  private static String PATH_GAMEPKG_ROOT;
  private static String PATH_WXAPKG_ROOT;
  
  private static String getAppPkgRoot()
  {
    if (PATH_WXAPKG_ROOT == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getRoot());
      localStringBuilder.append("/mini/");
      PATH_WXAPKG_ROOT = localStringBuilder.toString();
    }
    return PATH_WXAPKG_ROOT;
  }
  
  private static String getGamePkgRoot()
  {
    if (PATH_GAMEPKG_ROOT == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getRoot());
      localStringBuilder.append("/minigame/");
      PATH_GAMEPKG_ROOT = localStringBuilder.toString();
    }
    return PATH_GAMEPKG_ROOT;
  }
  
  public static String getRoot()
  {
    return AppLoaderFactory.g().getContext().getFilesDir().getPath();
  }
  
  private static String getTissuePkgRoot()
  {
    if (PATH_APKG_TISSUE_ROOT == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getRoot());
      localStringBuilder.append("/mini_tissue/");
      PATH_APKG_TISSUE_ROOT = localStringBuilder.toString();
    }
    return PATH_APKG_TISSUE_ROOT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.model.ApkgManager.RootPath
 * JD-Core Version:    0.7.0.1
 */