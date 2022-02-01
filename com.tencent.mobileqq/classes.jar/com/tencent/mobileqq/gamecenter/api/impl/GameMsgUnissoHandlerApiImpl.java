package com.tencent.mobileqq.gamecenter.api.impl;

import com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;

public class GameMsgUnissoHandlerApiImpl
  implements IGameMsgUnissoHandlerApi
{
  public void addOrShieldFriend(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    GameCenterUnissoHandler.a().a(paramInt1, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public void getAioPopInfo(int paramInt, String paramString1, String paramString2)
  {
    GameCenterUnissoHandler.a().a(paramInt, paramString1, paramString2);
  }
  
  public void getGameMsgTabConfig()
  {
    GameCenterUnissoHandler.a().c();
  }
  
  public void getGameStartPriority(int paramInt, String paramString)
  {
    GameCenterUnissoHandler.a().a(paramInt, paramString);
  }
  
  public void getGameSwitch(int paramInt)
  {
    GameCenterUnissoHandler.a().a(paramInt);
  }
  
  public void setGameSwitch(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    GameCenterUnissoHandler.a().a(paramInt1, paramString, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.impl.GameMsgUnissoHandlerApiImpl
 * JD-Core Version:    0.7.0.1
 */