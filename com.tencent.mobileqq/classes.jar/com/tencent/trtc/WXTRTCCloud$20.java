package com.tencent.trtc;

import android.view.Surface;
import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.renderer.e;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.RenderInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserInfo;

class WXTRTCCloud$20
  implements Runnable
{
  WXTRTCCloud$20(WXTRTCCloud paramWXTRTCCloud, String paramString, Surface paramSurface) {}
  
  public void run()
  {
    Object localObject = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRemoteSurface ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.b);
    WXTRTCCloud.access$1900((WXTRTCCloud)localObject, localStringBuilder.toString());
    localObject = WXTRTCCloud.access$2000(this.c).getUser(this.a);
    if (localObject != null)
    {
      localObject = ((TRTCRoomInfo.UserInfo)localObject).mainRender.render;
      if (localObject != null)
      {
        localObject = ((TXCRenderAndDec)localObject).getVideoRender();
        if (localObject != null)
        {
          ((e)localObject).a(this.b);
          return;
        }
        WXTRTCCloud.access$2100(this.c, "videoRender no exist");
        return;
      }
      WXTRTCCloud.access$2200(this.c, "render no exist");
      return;
    }
    WXTRTCCloud.access$2300(this.c, "user no exist");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.WXTRTCCloud.20
 * JD-Core Version:    0.7.0.1
 */