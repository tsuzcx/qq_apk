package com.tencent.trtc;

import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.a.b;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.RenderInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserInfo;

class TRTCSubCloud$4
  implements TRTCRoomInfo.UserAction
{
  TRTCSubCloud$4(TRTCSubCloud paramTRTCSubCloud) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    TRTCSubCloud.access$5200(this.a, paramUserInfo);
    TXCAudioEngine.getInstance().stopRemoteAudio(String.valueOf(paramUserInfo.tinyID));
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