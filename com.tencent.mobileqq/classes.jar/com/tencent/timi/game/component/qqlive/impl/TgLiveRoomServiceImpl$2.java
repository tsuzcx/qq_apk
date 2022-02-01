package com.tencent.timi.game.component.qqlive.impl;

import com.tencent.timi.game.component.qqlive.api.SimpleTgLiveAnchorStartListener;
import com.tencent.timi.game.component.qqlive.impl.anchor.TgLiveAnchorRoomManager;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;

class TgLiveRoomServiceImpl$2
  implements IResultListener<Boolean>
{
  TgLiveRoomServiceImpl$2(TgLiveRoomServiceImpl paramTgLiveRoomServiceImpl, SimpleTgLiveAnchorStartListener paramSimpleTgLiveAnchorStartListener, long paramLong, String paramString) {}
  
  public void a(int paramInt, String paramString)
  {
    CustomToastView.a("直播始化出错，请稍后重试");
    SimpleTgLiveAnchorStartListener localSimpleTgLiveAnchorStartListener = this.a;
    if (localSimpleTgLiveAnchorStartListener != null)
    {
      localSimpleTgLiveAnchorStartListener.a(false);
      this.a.a(2, paramInt, paramString);
    }
  }
  
  public void a(Boolean paramBoolean)
  {
    paramBoolean = this.a;
    if (paramBoolean != null) {
      paramBoolean.a(true);
    }
    TgLiveAnchorRoomManager.a().a(this.b, this.c, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.TgLiveRoomServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */