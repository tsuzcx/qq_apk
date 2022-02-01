package com.tencent.timi.game.component.qqlive.impl;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.component.qqlive.impl.anchor.TgLiveAnchorRoomManager;
import com.tencent.timi.game.utils.Logger;

class TgLiveRoomServiceImpl$1$1$1
  implements Observer<Boolean>
{
  TgLiveRoomServiceImpl$1$1$1(TgLiveRoomServiceImpl.1.1 param1, LiveData paramLiveData) {}
  
  public void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      TgLiveAnchorRoomManager.a().a(TimiGameActivityManager.a());
      this.a.removeObserver(this);
      return;
    }
    Logger.c("TgLiveTag_TgLiveRoomServiceImpl", "createRetLiveData onChanged false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.TgLiveRoomServiceImpl.1.1.1
 * JD-Core Version:    0.7.0.1
 */