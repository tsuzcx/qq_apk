package com.tencent.trtc;

import com.tencent.liteav.d;

class WXTRTCCloud$17
  implements Runnable
{
  WXTRTCCloud$17(WXTRTCCloud paramWXTRTCCloud) {}
  
  public void run()
  {
    WXTRTCCloud.access$1100(this.a, "resumePusher");
    if (WXTRTCCloud.access$1200(this.a) != null) {
      WXTRTCCloud.access$1300(this.a).h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.WXTRTCCloud.17
 * JD-Core Version:    0.7.0.1
 */