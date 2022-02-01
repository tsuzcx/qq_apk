package com.tencent.mobileqq.pluginsdk;

import android.content.Context;

public class SkinEngineInitBridge
{
  public static void init(Context paramContext)
  {
    IPluginAdapterProxy.getProxy().initSkinEngine(paramContext);
  }
  
  public static void initSkin(Context paramContext)
  {
    IPluginAdapterProxy.getProxy().initSkin(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.SkinEngineInitBridge
 * JD-Core Version:    0.7.0.1
 */