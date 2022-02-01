package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.os.Bundle;

public abstract interface SpecialProxy
{
  public static final int EVENT_OPEN_MINIAPP = 1;
  
  public abstract boolean sendEventToHost(int paramInt, Bundle paramBundle, SpecialProxy.EventCallback paramEventCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy
 * JD-Core Version:    0.7.0.1
 */