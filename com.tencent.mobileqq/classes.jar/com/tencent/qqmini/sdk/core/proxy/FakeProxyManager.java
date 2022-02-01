package com.tencent.qqmini.sdk.core.proxy;

import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;

@MiniKeep
public class FakeProxyManager
  implements IProxyManager
{
  public <T> T get(Class paramClass)
  {
    return ProxyManager.get(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.FakeProxyManager
 * JD-Core Version:    0.7.0.1
 */