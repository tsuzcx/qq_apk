package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.os.Bundle;

public abstract interface SpecialProxy
{
  public static final int EVENT_INIT_NETWORKINFO = 2;
  public static final int EVENT_OPEN_MINIAPP = 1;
  public static final String KEY_NETWORK_TIMEOUT_INFO = "NetworkTimeOutInfo";
  
  public abstract boolean sendEventToHost(int paramInt, Bundle paramBundle, SpecialProxy.EventCallback paramEventCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy
 * JD-Core Version:    0.7.0.1
 */