package com.tencent.qqmini.sdk.core.generated;

import bjvo;
import bjwh;
import bjwk;
import bjwm;
import bjww;
import bjxo;
import bjxw;
import bjyg;
import bjyl;
import bjyn;
import bjyo;
import bjzf;
import bjzi;
import bjzk;
import bjzr;
import bjzs;
import bjzv;
import bjzy;
import com.tencent.qqmini.proxyimpl.AdProxyImpl;
import com.tencent.qqmini.proxyimpl.PayProxyImpl;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.KingCardProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.LogProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.NavigationProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
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
    PROXY_SERVICES.put(WebSocketProxy.class, bjzv.class);
    PROXY_SERVICES.put(UploaderProxy.class, bjzi.class);
    PROXY_SERVICES.put(MiniAppProxy.class, bjww.class);
    PROXY_SERVICES.put(DownloaderProxy.class, bjwh.class);
    PROXY_SERVICES.put(RequestProxy.class, bjyl.class);
    PROXY_SERVICES.put(ChannelProxy.class, bjvo.class);
    PROXY_SERVICES.put(WnsConfigProxy.class, bjzy.class);
    PROXY_SERVICES.put(AdProxy.class, AdProxyImpl.class);
    PROXY_SERVICES.put(PayProxy.class, PayProxyImpl.class);
    PROXY_SERVICES.put(VideoPlayerProviderProxy.class, bjzr.class);
    PROXY_SERVICES.put(ShareProxy.class, bjyo.class);
    PROXY_SERVICES.put(KingCardProxy.class, bjwk.class);
    PROXY_SERVICES.put(ThirdAppProxy.class, bjzf.class);
    PROXY_SERVICES.put(VoIPProxy.class, bjzs.class);
    PROXY_SERVICES.put(VideoJsProxy.class, bjzk.class);
    PROXY_SERVICES.put(NavigationProxy.class, bjxw.class);
    PROXY_SERVICES.put(PageGestureProxy.class, bjyg.class);
    PROXY_SERVICES.put(MusicPlayerProxy.class, bjxo.class);
    PROXY_SERVICES.put(RequestStrategyProxy.class, bjyn.class);
    PROXY_SERVICES.put(LogProxy.class, bjwm.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.ExtProxyServiceScope
 * JD-Core Version:    0.7.0.1
 */