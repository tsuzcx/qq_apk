package com.tencent.qqmini.proxyimpl;

import com.tencent.oskplayer.OskPlayerCore;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayerUtil;

class ChannelProxyImpl$11
  implements IMediaPlayerUtil
{
  ChannelProxyImpl$11(ChannelProxyImpl paramChannelProxyImpl) {}
  
  public int getContentFlag(String paramString)
  {
    return VideoManager.getInstance().probeContentFlag(paramString);
  }
  
  public String getUrl(String paramString)
  {
    return OskPlayerCore.getInstance().getUrl(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.11
 * JD-Core Version:    0.7.0.1
 */