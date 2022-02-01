package com.tencent.timi.game.component.qqlive.impl;

import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomStatusInfo;
import com.tencent.timi.game.component.qqlive.impl.common.TgLiveRoomUIData;
import com.tencent.timi.game.utils.livedata.LiveDataExtKt;

class TgLiveRoomServiceImpl$4
  implements ITgLiveRoomStatusInfo
{
  TgLiveRoomServiceImpl$4(TgLiveRoomServiceImpl paramTgLiveRoomServiceImpl) {}
  
  public boolean a()
  {
    return ((Boolean)LiveDataExtKt.a(TgLiveRoomUIData.a().c(), Boolean.valueOf(false))).booleanValue();
  }
  
  public boolean b()
  {
    return this.a.c(0L) != null;
  }
  
  public boolean c()
  {
    return ((Boolean)LiveDataExtKt.a(TgLiveRoomUIData.a().b(), Boolean.valueOf(false))).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.TgLiveRoomServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */