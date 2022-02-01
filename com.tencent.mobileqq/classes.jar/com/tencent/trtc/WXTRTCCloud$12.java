package com.tencent.trtc;

import android.view.Surface;
import com.tencent.liteav.d;

class WXTRTCCloud$12
  implements Runnable
{
  WXTRTCCloud$12(WXTRTCCloud paramWXTRTCCloud, Surface paramSurface) {}
  
  public void run()
  {
    WXTRTCCloud localWXTRTCCloud = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLocalSurface ");
    localStringBuilder.append(this.a);
    WXTRTCCloud.access$400(localWXTRTCCloud, localStringBuilder.toString());
    WXTRTCCloud.access$500(this.b).a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.WXTRTCCloud.12
 * JD-Core Version:    0.7.0.1
 */