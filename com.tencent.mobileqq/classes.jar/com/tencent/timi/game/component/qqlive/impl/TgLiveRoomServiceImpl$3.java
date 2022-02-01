package com.tencent.timi.game.component.qqlive.impl;

import com.tencent.timi.game.component.qqlive.impl.audience.TgLiveAudienceRoomManager;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;

class TgLiveRoomServiceImpl$3
  implements IResultListener<Boolean>
{
  TgLiveRoomServiceImpl$3(TgLiveRoomServiceImpl paramTgLiveRoomServiceImpl, long paramLong, boolean paramBoolean, IResultListener paramIResultListener) {}
  
  public void a(int paramInt, String paramString)
  {
    CustomToastView.a("直播始化出错，请稍后重试");
  }
  
  public void a(Boolean paramBoolean)
  {
    TgLiveAudienceRoomManager.a().a(this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.TgLiveRoomServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */