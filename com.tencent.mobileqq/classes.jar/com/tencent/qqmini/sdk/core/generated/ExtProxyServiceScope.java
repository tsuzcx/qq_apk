package com.tencent.qqmini.sdk.core.generated;

import bjce;
import bjcx;
import bjcy;
import bjdb;
import bjdd;
import bjde;
import bjdt;
import bjep;
import bjex;
import bjfh;
import bjfm;
import bjfo;
import bjfp;
import bjgg;
import bjgj;
import bjgl;
import bjgs;
import bjgt;
import bjgw;
import bjgz;
import com.tencent.qqmini.proxyimpl.AdProxyImpl;
import com.tencent.qqmini.proxyimpl.PayProxyImpl;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.FavoritesProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.KingCardProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.LogProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MediaChooseJsProxy;
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
    PROXY_SERVICES.put(WebSocketProxy.class, bjgw.class);
    PROXY_SERVICES.put(UploaderProxy.class, bjgj.class);
    PROXY_SERVICES.put(MiniAppProxy.class, bjdt.class);
    PROXY_SERVICES.put(DownloaderProxy.class, bjcx.class);
    PROXY_SERVICES.put(RequestProxy.class, bjfm.class);
    PROXY_SERVICES.put(ChannelProxy.class, bjce.class);
    PROXY_SERVICES.put(WnsConfigProxy.class, bjgz.class);
    PROXY_SERVICES.put(AdProxy.class, AdProxyImpl.class);
    PROXY_SERVICES.put(PayProxy.class, PayProxyImpl.class);
    PROXY_SERVICES.put(VideoPlayerProviderProxy.class, bjgs.class);
    PROXY_SERVICES.put(ShareProxy.class, bjfp.class);
    PROXY_SERVICES.put(FavoritesProxy.class, bjcy.class);
    PROXY_SERVICES.put(KingCardProxy.class, bjdb.class);
    PROXY_SERVICES.put(ThirdAppProxy.class, bjgg.class);
    PROXY_SERVICES.put(VoIPProxy.class, bjgt.class);
    PROXY_SERVICES.put(VideoJsProxy.class, bjgl.class);
    PROXY_SERVICES.put(MediaChooseJsProxy.class, bjde.class);
    PROXY_SERVICES.put(NavigationProxy.class, bjex.class);
    PROXY_SERVICES.put(PageGestureProxy.class, bjfh.class);
    PROXY_SERVICES.put(MusicPlayerProxy.class, bjep.class);
    PROXY_SERVICES.put(RequestStrategyProxy.class, bjfo.class);
    PROXY_SERVICES.put(LogProxy.class, bjdd.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.ExtProxyServiceScope
 * JD-Core Version:    0.7.0.1
 */