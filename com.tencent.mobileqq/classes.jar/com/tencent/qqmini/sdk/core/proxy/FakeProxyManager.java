package com.tencent.qqmini.sdk.core.proxy;

import bghr;

public class FakeProxyManager
  implements bghr
{
  public <T> T get(Class paramClass)
  {
    return ProxyManager.get(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.FakeProxyManager
 * JD-Core Version:    0.7.0.1
 */