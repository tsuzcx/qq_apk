package com.tencent.qqmini.sdk.core.generated;

import bknl;
import bkoe;
import bkog;
import bkoj;
import bkol;
import bkom;
import bkpb;
import bkpx;
import bkqf;
import bkqp;
import bkqu;
import bkqw;
import bkqz;
import bkrq;
import bkrr;
import bkru;
import bkrw;
import bksd;
import bkse;
import bksh;
import bksk;
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
    PROXY_SERVICES.put(WebSocketProxy.class, bksh.class);
    PROXY_SERVICES.put(UploaderProxy.class, bkru.class);
    PROXY_SERVICES.put(MiniAppProxy.class, bkpb.class);
    PROXY_SERVICES.put(DownloaderProxy.class, bkoe.class);
    PROXY_SERVICES.put(RequestProxy.class, bkqu.class);
    PROXY_SERVICES.put(ChannelProxy.class, bknl.class);
    PROXY_SERVICES.put(WnsConfigProxy.class, bksk.class);
    PROXY_SERVICES.put(AdProxy.class, AdProxyImpl.class);
    PROXY_SERVICES.put(PayProxy.class, PayProxyImpl.class);
    PROXY_SERVICES.put(VideoPlayerProviderProxy.class, bksd.class);
    PROXY_SERVICES.put(ShareProxy.class, bkqz.class);
    PROXY_SERVICES.put(FavoritesProxy.class, bkog.class);
    PROXY_SERVICES.put(KingCardProxy.class, bkoj.class);
    PROXY_SERVICES.put(ThirdAppProxy.class, bkrr.class);
    PROXY_SERVICES.put(VoIPProxy.class, bkse.class);
    PROXY_SERVICES.put(VideoJsProxy.class, bkrw.class);
    PROXY_SERVICES.put(MediaChooseJsProxy.class, bkom.class);
    PROXY_SERVICES.put(NavigationProxy.class, bkqf.class);
    PROXY_SERVICES.put(PageGestureProxy.class, bkqp.class);
    PROXY_SERVICES.put(MusicPlayerProxy.class, bkpx.class);
    PROXY_SERVICES.put(RequestStrategyProxy.class, bkqw.class);
    PROXY_SERVICES.put(LogProxy.class, bkol.class);
    PROXY_SERVICES.put(SpecialProxy.class, bkrq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.ExtProxyServiceScope
 * JD-Core Version:    0.7.0.1
 */