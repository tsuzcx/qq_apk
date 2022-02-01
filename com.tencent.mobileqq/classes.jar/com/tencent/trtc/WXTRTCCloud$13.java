package com.tencent.trtc;

import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.RenderInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserInfo;

class WXTRTCCloud$13
  implements TRTCRoomInfo.UserAction
{
  WXTRTCCloud$13(WXTRTCCloud paramWXTRTCCloud) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    if ((paramUserInfo.mainRender.render != null) && (paramUserInfo.mainRender.render.isRendering())) {
      paramUserInfo.mainRender.render.updateLoadInfo();
    }
    if ((paramUserInfo.subRender.render != null) && (paramUserInfo.subRender.render.isRendering())) {
      paramUserInfo.subRender.render.updateLoadInfo();
    }
    WXTRTCCloud.access$4800(this.a, paramUserInfo.mainRender.view, paramUserInfo.mainRender.render, paramUserInfo);
    WXTRTCCloud.access$4900(this.a, paramUserInfo.subRender.view, paramUserInfo.subRender.render, paramUserInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.WXTRTCCloud.13
 * JD-Core Version:    0.7.0.1
 */