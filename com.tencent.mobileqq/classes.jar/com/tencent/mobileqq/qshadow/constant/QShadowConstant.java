package com.tencent.mobileqq.qshadow.constant;

import android.content.Context;
import java.io.File;

public class QShadowConstant
{
  public static final String KEY_LOAD_INFO = "QShadowLoadInfo";
  public static final String PLUGINS_CONFIG_FILE = "plugins";
  public static final String PLUGIN_ASSET_ROOT_PATH = "qshadow-plugins";
  public static final String PLUGIN_CONFIG_FILE = "config.json";
  
  public static String getAssetRootPath(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qshadow-plugins");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("Release");
    return localStringBuilder.toString();
  }
  
  public static String getPluginRootPath(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qshadow-plugins");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qshadow.constant.QShadowConstant
 * JD-Core Version:    0.7.0.1
 */