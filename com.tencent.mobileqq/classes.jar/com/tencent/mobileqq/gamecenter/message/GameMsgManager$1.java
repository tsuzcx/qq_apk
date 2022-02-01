package com.tencent.mobileqq.gamecenter.message;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.protocol.GameCenterUnissoObserver;

class GameMsgManager$1
  extends GameCenterUnissoObserver
{
  GameMsgManager$1(GameMsgManager paramGameMsgManager) {}
  
  public void b(Object paramObject)
  {
    super.b(paramObject);
    ThreadManager.excute(new GameMsgManager.1.1(this, paramObject), 32, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgManager.1
 * JD-Core Version:    0.7.0.1
 */