package com.tencent.mobileqq.qshadow.constant;

import android.content.Context;
import java.io.File;

public class Constant
{
  public static final long FROM_ID_BIND_SERVICE = 1005L;
  public static final long FROM_ID_INSTALL_PLUGIN = 1001L;
  public static final long FROM_ID_NOOP = 1000L;
  public static final long FROM_ID_START_ACTIVITY = 1003L;
  public static final long FROM_ID_START_SERVICE = 1004L;
  public static final long FROM_ID_UNINSTALL_PLUGIN = 1002L;
  public static final String KEY_CLASSNAME = "KEY_ACTIVITY_CLASSNAME";
  public static final String KEY_EXTRAS = "KEY_EXTRAS";
  public static final String KEY_PLUGIN_PART_KEY = "KEY_PLUGIN_PART_KEY";
  public static final String KEY_PLUGIN_UUID = "KEY_PLUGIN_UUID";
  public static final String KEY_PLUGIN_ZIP_PATH = "pluginZipPath";
  public static final String PLUGINS_CONFIG_FILE = "plugins";
  public static final String PLUGIN_ASSET_ROOT_PATH = "qshadow-plugins";
  public static final String PLUGIN_CONFIG_FILE = "config.json";
  
  public static String getAssetRootPath(String paramString)
  {
    return "qshadow-plugins" + File.separator + paramString + File.separator + "Release";
  }
  
  public static String getPluginInstalledPath(Context paramContext, String paramString)
  {
    return paramContext.getFilesDir().getAbsolutePath() + File.separator + "ShadowPluginManager" + File.separator + "UnpackedPlugin" + File.separator + paramString;
  }
  
  public static String getPluginRootPath(Context paramContext, String paramString)
  {
    return paramContext.getFilesDir().getAbsolutePath() + File.separator + "qshadow-plugins" + File.separator + paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qshadow.constant.Constant
 * JD-Core Version:    0.7.0.1
 */