package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.FavoritesProxy;

@ProxyService(proxy=FavoritesProxy.class)
public class FavoritesProxyDefault
  implements FavoritesProxy
{
  public void onJsAddToFavorites(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.FavoritesProxyDefault
 * JD-Core Version:    0.7.0.1
 */