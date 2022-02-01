package com.tencent.mobileqq.pluginsdk;

import android.content.Context;

public abstract interface IPluginAdapter
{
  public static final int CMD_GET_THREAD_LOOPER = 2;
  public static final int CMD_IS_NIGHT_MODE = 1;
  public static final int CMD_IS_SUPPORT_IMMERSIVE = 5;
  public static final int CMD_IS_SUPPORT_MUTILDEX = 4;
  public static final int CMD_IS_THEME_DEFAULT_MODE = 3;
  
  public abstract void initSkin(Context paramContext);
  
  public abstract void initSkinEngine(Context paramContext);
  
  public abstract Object invoke(int paramInt, Object paramObject);
  
  public abstract boolean isBuiltinPluginAndUpToDay(String paramString, PluginBaseInfo paramPluginBaseInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.IPluginAdapter
 * JD-Core Version:    0.7.0.1
 */