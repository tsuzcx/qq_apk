package com.tencent.trtc;

import com.tencent.liteav.d;

class WXTRTCCloud$15
  implements Runnable
{
  WXTRTCCloud$15(WXTRTCCloud paramWXTRTCCloud, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WXTRTCCloud localWXTRTCCloud = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLocalSurfaceSize: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append(this.b);
    WXTRTCCloud.access$600(localWXTRTCCloud, localStringBuilder.toString());
    WXTRTCCloud.access$700(this.c).a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.WXTRTCCloud.15
 * JD-Core Version:    0.7.0.1
 */