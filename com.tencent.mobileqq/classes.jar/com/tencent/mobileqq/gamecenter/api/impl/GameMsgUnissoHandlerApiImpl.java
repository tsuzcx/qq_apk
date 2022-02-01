package com.tencent.mobileqq.gamecenter.api.impl;

import com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;

public class GameMsgUnissoHandlerApiImpl
  implements IGameMsgUnissoHandlerApi
{
  public void addOrShieldFriend(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    GameCenterUnissoHandler.a().a(paramInt, paramString1, paramString2, paramString3);
  }
  
  public void getAioPopInfo(String paramString1, String paramString2)
  {
    GameCenterUnissoHandler.a().a(paramString1, paramString2);
  }
  
  public void getGameMsgTabConfig()
  {
    GameCenterUnissoHandler.a().b();
  }
  
  public void getGameStartPriority(String paramString)
  {
    GameCenterUnissoHandler.a().a(paramString);
  }
  
  public void getGameSwitch()
  {
    GameCenterUnissoHandler.a().a();
  }
  
  public void setGameSwitch(String paramString, int paramInt1, int paramInt2)
  {
    GameCenterUnissoHandler.a().a(paramString, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.impl.GameMsgUnissoHandlerApiImpl
 * JD-Core Version:    0.7.0.1
 */