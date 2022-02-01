package com.tencent.mobileqq.gamecenter.api.impl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.sso.GameCenterUnissoObserver;

class GameMsgManagerServiceImpl$1
  extends GameCenterUnissoObserver
{
  GameMsgManagerServiceImpl$1(GameMsgManagerServiceImpl paramGameMsgManagerServiceImpl, int paramInt)
  {
    super(paramInt);
  }
  
  public void b(Object paramObject)
  {
    super.b(paramObject);
    GameMsgManagerServiceImpl.access$000(this.a, paramObject);
    ThreadManager.excute(new GameMsgManagerServiceImpl.1.1(this, paramObject), 32, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.impl.GameMsgManagerServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */