package com.tencent.qg.sdk.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class LocalStorageManager
{
  private static final String FILE_NAME = "qgraphics_config";
  
  public static void clear(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("qgraphics_config", 0).edit();
    paramContext.clear();
    SharedPreferencesCompat.EditorCompat.getInstance().apply(paramContext);
  }
  
  public static String getItem(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("qgraphics_config", 0).getString(paramString1, paramString2);
  }
  
  public static void removeItem(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("qgraphics_config", 0).edit();
    paramContext.remove(paramString);
    SharedPreferencesCompat.EditorCompat.getInstance().apply(paramContext);
  }
  
  public static void setItem(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("qgraphics_config", 0).edit();
    paramContext.putString(paramString1, paramString2);
    SharedPreferencesCompat.EditorCompat.getInstance().apply(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qg.sdk.storage.LocalStorageManager
 * JD-Core Version:    0.7.0.1
 */