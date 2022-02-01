package com.tencent.mobileqq.gamecenter.api.impl;

import com.tencent.mobileqq.gamecenter.api.IGameMsgHandlerNameApi;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;

public class GameMsgHandlerNameApiImpl
  implements IGameMsgHandlerNameApi
{
  public String getGameMsgHandlerName()
  {
    return GameCenterUnissoHandler.class.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.impl.GameMsgHandlerNameApiImpl
 * JD-Core Version:    0.7.0.1
 */