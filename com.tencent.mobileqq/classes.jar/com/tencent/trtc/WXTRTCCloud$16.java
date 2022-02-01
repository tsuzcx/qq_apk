package com.tencent.trtc;

import com.tencent.liteav.d;

class WXTRTCCloud$16
  implements Runnable
{
  WXTRTCCloud$16(WXTRTCCloud paramWXTRTCCloud) {}
  
  public void run()
  {
    WXTRTCCloud.access$800(this.a, "pausePusher");
    if (WXTRTCCloud.access$900(this.a) != null) {
      WXTRTCCloud.access$1000(this.a).h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.WXTRTCCloud.16
 * JD-Core Version:    0.7.0.1
 */