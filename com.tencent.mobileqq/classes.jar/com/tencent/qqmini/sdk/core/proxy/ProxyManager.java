package com.tencent.qqmini.sdk.core.proxy;

import com.tencent.qqmini.sdk.core.proxy.engine.ProxyServiceEngine;

public class ProxyManager
{
  public static <T> T get(Class paramClass)
  {
    return ProxyServiceEngine.g().getProxyService(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.ProxyManager
 * JD-Core Version:    0.7.0.1
 */