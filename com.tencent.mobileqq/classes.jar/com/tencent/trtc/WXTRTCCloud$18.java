package com.tencent.trtc;

import com.tencent.liteav.d;

class WXTRTCCloud$18
  implements Runnable
{
  WXTRTCCloud$18(WXTRTCCloud paramWXTRTCCloud, boolean paramBoolean) {}
  
  public void run()
  {
    WXTRTCCloud localWXTRTCCloud = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableBlackStream ");
    localStringBuilder.append(this.a);
    WXTRTCCloud.access$1400(localWXTRTCCloud, localStringBuilder.toString());
    if (WXTRTCCloud.access$1500(this.b) != null) {
      WXTRTCCloud.access$1600(this.b).c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.WXTRTCCloud.18
 * JD-Core Version:    0.7.0.1
 */