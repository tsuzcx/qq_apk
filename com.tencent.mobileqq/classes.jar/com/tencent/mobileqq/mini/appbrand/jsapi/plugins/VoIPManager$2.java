package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import bfvj;
import bfvp;

class VoIPManager$2
  implements bfvj
{
  VoIPManager$2(VoIPManager paramVoIPManager) {}
  
  public boolean isMultiVideoMsgSupport(int paramInt)
  {
    if (paramInt - 32 == 1) {}
    for (boolean bool = true;; bool = false)
    {
      bfvp.c("VoIPManager", String.format("isMultiVideoMsgSupport type=0x%X support=%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) }));
      return bool;
    }
  }
  
  public boolean isSharpVideoMsgSupport(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VoIPManager.2
 * JD-Core Version:    0.7.0.1
 */