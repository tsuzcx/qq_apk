package com.tencent.qqmini.proxyimpl;

import bgnt;
import bgrq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.appbrand.page.embedded.VideoEmbeddedWidgetClient;
import com.tencent.oskplayer.OskPlayerCore;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProviderProxy;

public class VideoPlayerProviderProxyImpl
  implements VideoPlayerProviderProxy
{
  private boolean inited;
  
  public String getUrl(String paramString)
  {
    return OskPlayerCore.getInstance().getUrl(bgnt.a().a(paramString));
  }
  
  public bgrq getVideoPlayer()
  {
    if (!this.inited)
    {
      VideoEmbeddedWidgetClient.initOskOnce(BaseApplicationImpl.getContext());
      this.inited = true;
    }
    return new OskReliableVideoPlayerImpl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoPlayerProviderProxyImpl
 * JD-Core Version:    0.7.0.1
 */