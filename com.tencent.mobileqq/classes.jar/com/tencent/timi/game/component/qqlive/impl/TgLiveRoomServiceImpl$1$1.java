package com.tencent.timi.game.component.qqlive.impl;

import androidx.lifecycle.LiveData;
import com.tencent.timi.game.component.qqlive.api.TgLiveAnchorStartListener;
import com.tencent.timi.game.component.qqlive.impl.anchor.TgLiveAnchorRoomManager;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;

class TgLiveRoomServiceImpl$1$1
  implements IResultListener<Boolean>
{
  TgLiveRoomServiceImpl$1$1(TgLiveRoomServiceImpl.1 param1) {}
  
  public void a(int paramInt, String paramString)
  {
    CustomToastView.a("直播始化出错，请稍后重试");
    if (this.a.a != null)
    {
      this.a.a.a(false);
      this.a.a.a(2, paramInt, paramString);
    }
  }
  
  public void a(Boolean paramBoolean)
  {
    if (this.a.a != null) {
      this.a.a.a(true);
    }
    paramBoolean = TgLiveAnchorRoomManager.a().a(this.a.b, this.a.c, this.a.a);
    paramBoolean.observeForever(new TgLiveRoomServiceImpl.1.1.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.TgLiveRoomServiceImpl.1.1
 * JD-Core Version:    0.7.0.1
 */