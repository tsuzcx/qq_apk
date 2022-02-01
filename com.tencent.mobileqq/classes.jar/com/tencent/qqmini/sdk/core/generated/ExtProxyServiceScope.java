package com.tencent.qqmini.sdk.core.generated;

import com.tencent.qqmini.proxyimpl.AdProxyImpl;
import com.tencent.qqmini.proxyimpl.ChannelProxyImpl;
import com.tencent.qqmini.proxyimpl.DownloaderProxyImpl;
import com.tencent.qqmini.proxyimpl.ExternalElementProxyImpl;
import com.tencent.qqmini.proxyimpl.FavoritesProxyImpl;
import com.tencent.qqmini.proxyimpl.KingCardProxyImpl;
import com.tencent.qqmini.proxyimpl.LogProxyImpl;
import com.tencent.qqmini.proxyimpl.MediaChooseJsProxyImpl;
import com.tencent.qqmini.proxyimpl.MiniAppCacheProxyImpl;
import com.tencent.qqmini.proxyimpl.MiniAppNotifyProxyImpl;
import com.tencent.qqmini.proxyimpl.MiniAppProxyImpl;
import com.tencent.qqmini.proxyimpl.MiniReportProxyImpl;
import com.tencent.qqmini.proxyimpl.MusicPlayerProxyImpl;
import com.tencent.qqmini.proxyimpl.NavigationProxyImpl;
import com.tencent.qqmini.proxyimpl.PageGestureProxyImpl;
import com.tencent.qqmini.proxyimpl.PayProxyImpl;
import com.tencent.qqmini.proxyimpl.RequestProxyImpl;
import com.tencent.qqmini.proxyimpl.RequestStrategyProxyImpl;
import com.tencent.qqmini.proxyimpl.ShareProxyImpl;
import com.tencent.qqmini.proxyimpl.SpecialProxyImpl;
import com.tencent.qqmini.proxyimpl.ThirdAppProxyImpl;
import com.tencent.qqmini.proxyimpl.UploaderProxyImpl;
import com.tencent.qqmini.proxyimpl.VideoJsProxyImpl;
import com.tencent.qqmini.proxyimpl.VideoPlayerProviderProxyImpl;
import com.tencent.qqmini.proxyimpl.VoIPProxyImpl;
import com.tencent.qqmini.proxyimpl.WebSocketProxyImpl;
import com.tencent.qqmini.proxyimpl.WnsConfigProxyImpl;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.FavoritesProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMiniAppNotifyProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMiniReportProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.KingCardProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.LogProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MediaChooseJsProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.NavigationProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoPlayerProviderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import java.util.HashMap;
import java.util.Map;

public final class ExtProxyServiceScope
{
  public static final Map PROXY_SERVICES = new HashMap();
  
  static
  {
    PROXY_SERVICES.put(WebSocketProxy.class, WebSocketProxyImpl.class);
    PROXY_SERVICES.put(UploaderProxy.class, UploaderProxyImpl.class);
    PROXY_SERVICES.put(MiniAppProxy.class, MiniAppProxyImpl.class);
    PROXY_SERVICES.put(DownloaderProxy.class, DownloaderProxyImpl.class);
    PROXY_SERVICES.put(RequestProxy.class, RequestProxyImpl.class);
    PROXY_SERVICES.put(ChannelProxy.class, ChannelProxyImpl.class);
    PROXY_SERVICES.put(WnsConfigProxy.class, WnsConfigProxyImpl.class);
    PROXY_SERVICES.put(AdProxy.class, AdProxyImpl.class);
    PROXY_SERVICES.put(PayProxy.class, PayProxyImpl.class);
    PROXY_SERVICES.put(VideoPlayerProviderProxy.class, VideoPlayerProviderProxyImpl.class);
    PROXY_SERVICES.put(ShareProxy.class, ShareProxyImpl.class);
    PROXY_SERVICES.put(FavoritesProxy.class, FavoritesProxyImpl.class);
    PROXY_SERVICES.put(KingCardProxy.class, KingCardProxyImpl.class);
    PROXY_SERVICES.put(ThirdAppProxy.class, ThirdAppProxyImpl.class);
    PROXY_SERVICES.put(VoIPProxy.class, VoIPProxyImpl.class);
    PROXY_SERVICES.put(VideoJsProxy.class, VideoJsProxyImpl.class);
    PROXY_SERVICES.put(MediaChooseJsProxy.class, MediaChooseJsProxyImpl.class);
    PROXY_SERVICES.put(NavigationProxy.class, NavigationProxyImpl.class);
    PROXY_SERVICES.put(PageGestureProxy.class, PageGestureProxyImpl.class);
    PROXY_SERVICES.put(MusicPlayerProxy.class, MusicPlayerProxyImpl.class);
    PROXY_SERVICES.put(RequestStrategyProxy.class, RequestStrategyProxyImpl.class);
    PROXY_SERVICES.put(LogProxy.class, LogProxyImpl.class);
    PROXY_SERVICES.put(SpecialProxy.class, SpecialProxyImpl.class);
    PROXY_SERVICES.put(ExternalElementProxy.class, ExternalElementProxyImpl.class);
    PROXY_SERVICES.put(IMiniAppNotifyProxy.class, MiniAppNotifyProxyImpl.class);
    PROXY_SERVICES.put(MiniAppCacheProxy.class, MiniAppCacheProxyImpl.class);
    PROXY_SERVICES.put(IMiniReportProxy.class, MiniReportProxyImpl.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.ExtProxyServiceScope
 * JD-Core Version:    0.7.0.1
 */