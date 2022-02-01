package com.tencent.trtc;

import java.util.HashMap;

class WXTRTCCloud$8
  implements Runnable
{
  WXTRTCCloud$8(WXTRTCCloud paramWXTRTCCloud, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.a)
    {
      WXTRTCCloud.access$300(this.c).remove(this.b);
      return;
    }
    WXTRTCCloud.access$200(this.c).remove(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.WXTRTCCloud.8
 * JD-Core Version:    0.7.0.1
 */