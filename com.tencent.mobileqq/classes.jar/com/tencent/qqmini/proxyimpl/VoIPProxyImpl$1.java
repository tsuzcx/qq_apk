package com.tencent.qqmini.proxyimpl;

import com.tencent.qav.channel.VideoChannelSupportCallback;
import com.tencent.qav.log.AVLog;

class VoIPProxyImpl$1
  implements VideoChannelSupportCallback
{
  VoIPProxyImpl$1(VoIPProxyImpl paramVoIPProxyImpl) {}
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean b(int paramInt)
  {
    boolean bool;
    if (paramInt - 32 == 1) {
      bool = true;
    } else {
      bool = false;
    }
    AVLog.c("VoIPProxyImpl", String.format("isMultiVideoMsgSupport type=0x%X support=%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) }));
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VoIPProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */