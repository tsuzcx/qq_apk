package com.tencent.qqmini.sdk.core.generated;

import bkwo;
import bkxh;
import bkxk;
import bkxm;
import bkxx;
import bkys;
import bkza;
import bkzk;
import bkzp;
import bkzr;
import bkzs;
import blaj;
import blam;
import blao;
import blav;
import blaw;
import blaz;
import blbc;
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
    PROXY_SERVICES.put(WebSocketProxy.class, blaz.class);
    PROXY_SERVICES.put(UploaderProxy.class, blam.class);
    PROXY_SERVICES.put(MiniAppProxy.class, bkxx.class);
    PROXY_SERVICES.put(DownloaderProxy.class, bkxh.class);
    PROXY_SERVICES.put(RequestProxy.class, bkzp.class);
    PROXY_SERVICES.put(ChannelProxy.class, bkwo.class);
    PROXY_SERVICES.put(WnsConfigProxy.class, blbc.class);
    PROXY_SERVICES.put(AdProxy.class, AdProxyImpl.class);
    PROXY_SERVICES.put(PayProxy.class, PayProxyImpl.class);
    PROXY_SERVICES.put(VideoPlayerProviderProxy.class, blav.class);
    PROXY_SERVICES.put(ShareProxy.class, bkzs.class);
    PROXY_SERVICES.put(KingCardProxy.class, bkxk.class);
    PROXY_SERVICES.put(ThirdAppProxy.class, blaj.class);
    PROXY_SERVICES.put(VoIPProxy.class, blaw.class);
    PROXY_SERVICES.put(VideoJsProxy.class, blao.class);
    PROXY_SERVICES.put(NavigationProxy.class, bkza.class);
    PROXY_SERVICES.put(PageGestureProxy.class, bkzk.class);
    PROXY_SERVICES.put(MusicPlayerProxy.class, bkys.class);
    PROXY_SERVICES.put(RequestStrategyProxy.class, bkzr.class);
    PROXY_SERVICES.put(LogProxy.class, bkxm.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.ExtProxyServiceScope
 * JD-Core Version:    0.7.0.1
 */