package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.os.Bundle;

public abstract interface SpecialProxy
{
  public static final int EVENT_FOLLOW_MINIGAME_PA = 4;
  public static final int EVENT_GET_MINIGAME_PA_SUBMSG = 3;
  public static final int EVENT_INIT_NETWORKINFO = 2;
  public static final int EVENT_OPEN_MINIAPP = 1;
  public static final String KEY_DATA = "key_bundle_data";
  public static final String KEY_NETWORK_TIMEOUT_INFO = "NetworkTimeOutInfo";
  
  public abstract boolean sendEventToHost(int paramInt, Bundle paramBundle, SpecialProxy.EventCallback paramEventCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy
 * JD-Core Version:    0.7.0.1
 */