package com.tencent.trtc;

import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.audio.a;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.RenderInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserInfo;

class TRTCSubCloud$4
  implements TRTCRoomInfo.UserAction
{
  TRTCSubCloud$4(TRTCSubCloud paramTRTCSubCloud) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    TRTCSubCloud.access$5300(this.a, paramUserInfo);
    a.a().a(String.valueOf(paramUserInfo.tinyID), this.a.hashCode());
    if (paramUserInfo.mainRender.render != null) {
      paramUserInfo.mainRender.render.setVideoFrameListener(null, b.a);
    }
    if (paramUserInfo.subRender.render != null) {
      paramUserInfo.subRender.render.setVideoFrameListener(null, b.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCSubCloud.4
 * JD-Core Version:    0.7.0.1
 */