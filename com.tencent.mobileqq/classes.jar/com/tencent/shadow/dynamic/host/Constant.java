package com.tencent.shadow.dynamic.host;

import android.content.Context;
import java.io.File;

public class Constant
{
  public static final long FROM_ID_INSTALL_PLUGIN = 1001L;
  public static final long FROM_ID_NOOP = 1000L;
  public static final long FROM_ID_START_ACTIVITY = 1003L;
  public static final long FROM_ID_START_SERVICE = 1004L;
  public static final long FROM_ID_STOP_SERVICE = 1005L;
  public static final long FROM_ID_UNINSTALL_PLUGIN = 1002L;
  public static final String KEY_CLASSNAME = "KEY_ACTIVITY_CLASSNAME";
  public static final String KEY_EXTRAS = "KEY_EXTRAS";
  public static final String KEY_PLUGIN_PART_KEY = "KEY_PLUGIN_PART_KEY";
  public static final String KEY_PLUGIN_UUID = "KEY_PLUGIN_UUID";
  public static final String KEY_PLUGIN_ZIP_PATH = "pluginZipPath";
  
  public static String getPluginInstalledPath(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("ShadowPluginManager");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("UnpackedPlugin");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.Constant
 * JD-Core Version:    0.7.0.1
 */