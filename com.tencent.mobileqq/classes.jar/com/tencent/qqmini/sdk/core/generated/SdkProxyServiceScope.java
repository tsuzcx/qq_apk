package com.tencent.qqmini.sdk.core.generated;

import com.tencent.qqmini.sdk.core.proxy.MusicPlayerProxyDefault;
import com.tencent.qqmini.sdk.core.proxy.service.ChannelProxyDefault;
import com.tencent.qqmini.sdk.core.proxy.service.DownloaderProxyDefault;
import com.tencent.qqmini.sdk.core.proxy.service.ExternalElementProxyDefault;
import com.tencent.qqmini.sdk.core.proxy.service.FavoritesProxyDefault;
import com.tencent.qqmini.sdk.core.proxy.service.KingCardProxyDefault;
import com.tencent.qqmini.sdk.core.proxy.service.LogProxyDefault;
import com.tencent.qqmini.sdk.core.proxy.service.MiniAppCacheProxyDefault;
import com.tencent.qqmini.sdk.core.proxy.service.MiniAppNotifyProxyDefault;
import com.tencent.qqmini.sdk.core.proxy.service.MiniAppProxyDefault;
import com.tencent.qqmini.sdk.core.proxy.service.NavigationProxyDefault;
import com.tencent.qqmini.sdk.core.proxy.service.RequestProxyDefault;
import com.tencent.qqmini.sdk.core.proxy.service.RequestStrategyProxyDefault;
import com.tencent.qqmini.sdk.core.proxy.service.ShareProxyDefault;
import com.tencent.qqmini.sdk.core.proxy.service.WXLivePlayerDefaultProxy;
import com.tencent.qqmini.sdk.core.proxy.service.WXLivePusherDefaultProxy;
import com.tencent.qqmini.sdk.core.proxy.service.WnsConfigProxyDefault;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.FavoritesProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMiniAppNotifyProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.KingCardProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.LogProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.NavigationProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import java.util.HashMap;
import java.util.Map;

public final class SdkProxyServiceScope
{
  public static final Map PROXY_SERVICES = new HashMap();
  
  static
  {
    PROXY_SERVICES.put(RequestProxy.class, RequestProxyDefault.class);
    PROXY_SERVICES.put(FavoritesProxy.class, FavoritesProxyDefault.class);
    PROXY_SERVICES.put(NavigationProxy.class, NavigationProxyDefault.class);
    PROXY_SERVICES.put(DownloaderProxy.class, DownloaderProxyDefault.class);
    PROXY_SERVICES.put(WnsConfigProxy.class, WnsConfigProxyDefault.class);
    PROXY_SERVICES.put(KingCardProxy.class, KingCardProxyDefault.class);
    PROXY_SERVICES.put(ChannelProxy.class, ChannelProxyDefault.class);
    PROXY_SERVICES.put(IMiniAppNotifyProxy.class, MiniAppNotifyProxyDefault.class);
    PROXY_SERVICES.put(IWXLivePusherProxy.class, WXLivePusherDefaultProxy.class);
    PROXY_SERVICES.put(ShareProxy.class, ShareProxyDefault.class);
    PROXY_SERVICES.put(MiniAppCacheProxy.class, MiniAppCacheProxyDefault.class);
    PROXY_SERVICES.put(MiniAppProxy.class, MiniAppProxyDefault.class);
    PROXY_SERVICES.put(IWXLivePlayerProxy.class, WXLivePlayerDefaultProxy.class);
    PROXY_SERVICES.put(ExternalElementProxy.class, ExternalElementProxyDefault.class);
    PROXY_SERVICES.put(LogProxy.class, LogProxyDefault.class);
    PROXY_SERVICES.put(RequestStrategyProxy.class, RequestStrategyProxyDefault.class);
    PROXY_SERVICES.put(MusicPlayerProxy.class, MusicPlayerProxyDefault.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.SdkProxyServiceScope
 * JD-Core Version:    0.7.0.1
 */