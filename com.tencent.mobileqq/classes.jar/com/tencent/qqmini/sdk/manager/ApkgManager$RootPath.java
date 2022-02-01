package com.tencent.qqmini.sdk.manager;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import java.io.File;

public class ApkgManager$RootPath
{
  private static String PATH_APKG_TISSUE_ROOT = null;
  private static String PATH_GAMEPKG_ROOT = null;
  private static String PATH_WXAPKG_ROOT = null;
  
  public static String getAppPkgRoot()
  {
    if (PATH_WXAPKG_ROOT == null) {
      PATH_WXAPKG_ROOT = getRoot() + "/mini/";
    }
    return PATH_WXAPKG_ROOT;
  }
  
  public static String getGamePkgRoot()
  {
    if (PATH_GAMEPKG_ROOT == null) {
      PATH_GAMEPKG_ROOT = getRoot() + "/minigame/";
    }
    return PATH_GAMEPKG_ROOT;
  }
  
  public static String getRoot()
  {
    return AppLoaderFactory.g().getContext().getFilesDir().getPath();
  }
  
  public static String getTissuePkgRoot()
  {
    if (PATH_APKG_TISSUE_ROOT == null) {
      PATH_APKG_TISSUE_ROOT = getRoot() + "/mini_tissue/";
    }
    return PATH_APKG_TISSUE_ROOT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.ApkgManager.RootPath
 * JD-Core Version:    0.7.0.1
 */