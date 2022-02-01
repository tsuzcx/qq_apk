package com.tencent.trtc;

import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.renderer.e;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.RenderInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserInfo;

class WXTRTCCloud$3
  implements Runnable
{
  WXTRTCCloud$3(WXTRTCCloud paramWXTRTCCloud, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seRemoteSubStreamSurfaceSize: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    WXTRTCCloud.access$3400((WXTRTCCloud)localObject, localStringBuilder.toString());
    localObject = WXTRTCCloud.access$3500(this.d).getUser(this.a);
    if (localObject != null)
    {
      localObject = ((TRTCRoomInfo.UserInfo)localObject).subRender.render;
      if (localObject != null)
      {
        localObject = ((TXCRenderAndDec)localObject).getVideoRender();
        if (localObject != null)
        {
          ((e)localObject).c(this.b, this.c);
          return;
        }
        WXTRTCCloud.access$3600(this.d, "videoRender no exist");
        return;
      }
      WXTRTCCloud.access$3700(this.d, "render no exist");
      return;
    }
    WXTRTCCloud.access$3800(this.d, "user no exist");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.WXTRTCCloud.3
 * JD-Core Version:    0.7.0.1
 */