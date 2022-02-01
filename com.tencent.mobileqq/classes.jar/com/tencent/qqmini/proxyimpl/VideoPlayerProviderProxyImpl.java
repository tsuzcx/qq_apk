package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.oskplayer.OskPlayerCore;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoPlayerProviderProxy;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer;

@ProxyService(proxy=VideoPlayerProviderProxy.class)
public class VideoPlayerProviderProxyImpl
  implements VideoPlayerProviderProxy
{
  public String getUrl(String paramString)
  {
    return OskPlayerCore.getInstance().getUrl(MiniAppFileManager.getInstance().getAbsolutePath(paramString));
  }
  
  public ReliableVideoPlayer getVideoPlayer()
  {
    return new OskReliableVideoPlayerImpl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoPlayerProviderProxyImpl
 * JD-Core Version:    0.7.0.1
 */