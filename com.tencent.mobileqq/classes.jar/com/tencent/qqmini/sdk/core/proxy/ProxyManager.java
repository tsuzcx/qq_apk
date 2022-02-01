package com.tencent.qqmini.sdk.core.proxy;

import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.engine.ProxyServiceEngine;

@MiniKeep
public class ProxyManager
{
  public static <T> T get(Class<T> paramClass)
  {
    return ProxyServiceEngine.g().getProxyService(paramClass);
  }
  
  public static <T> T getNew(Class<T> paramClass)
  {
    return ProxyServiceEngine.g().newProxyService(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.ProxyManager
 * JD-Core Version:    0.7.0.1
 */