package com.tencent.mobileqq.gamecenter.api.impl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.sso.GameCenterUnissoObserver;

class GameMsgManagerServiceImpl$1
  extends GameCenterUnissoObserver
{
  GameMsgManagerServiceImpl$1(GameMsgManagerServiceImpl paramGameMsgManagerServiceImpl) {}
  
  protected void b(Object paramObject)
  {
    super.b(paramObject);
    ThreadManager.excute(new GameMsgManagerServiceImpl.1.1(this, paramObject), 32, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.impl.GameMsgManagerServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */