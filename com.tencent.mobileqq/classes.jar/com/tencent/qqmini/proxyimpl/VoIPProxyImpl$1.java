package com.tencent.qqmini.proxyimpl;

import bfra;
import bfrg;

class VoIPProxyImpl$1
  implements bfra
{
  VoIPProxyImpl$1(VoIPProxyImpl paramVoIPProxyImpl) {}
  
  public boolean isMultiVideoMsgSupport(int paramInt)
  {
    if (paramInt - 32 == 1) {}
    for (boolean bool = true;; bool = false)
    {
      bfrg.c("VoIPProxyImpl", String.format("isMultiVideoMsgSupport type=0x%X support=%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) }));
      return bool;
    }
  }
  
  public boolean isSharpVideoMsgSupport(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VoIPProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */