package com.tencent.trtc;

import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.renderer.e;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.RenderInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserInfo;

class WXTRTCCloud$21
  implements Runnable
{
  WXTRTCCloud$21(WXTRTCCloud paramWXTRTCCloud, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seRemoteSurfaceSize: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    WXTRTCCloud.access$2400((WXTRTCCloud)localObject, localStringBuilder.toString());
    localObject = WXTRTCCloud.access$2500(this.d).getUser(this.a);
    if (localObject != null)
    {
      localObject = ((TRTCRoomInfo.UserInfo)localObject).mainRender.render;
      if (localObject != null)
      {
        localObject = ((TXCRenderAndDec)localObject).getVideoRender();
        if (localObject != null)
        {
          ((e)localObject).c(this.b, this.c);
          return;
        }
        WXTRTCCloud.access$2600(this.d, "videoRender no exist");
        return;
      }
      WXTRTCCloud.access$2700(this.d, "render no exist");
      return;
    }
    WXTRTCCloud.access$2800(this.d, "user no exist");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.WXTRTCCloud.21
 * JD-Core Version:    0.7.0.1
 */