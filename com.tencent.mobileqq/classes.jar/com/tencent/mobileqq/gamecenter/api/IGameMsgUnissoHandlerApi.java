package com.tencent.mobileqq.gamecenter.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IGameMsgUnissoHandlerApi
  extends QRouteApi
{
  public abstract void addOrShieldFriend(int paramInt, String paramString1, String paramString2, String paramString3);
  
  public abstract void getAioPopInfo(String paramString1, String paramString2);
  
  public abstract void getGameMsgTabConfig();
  
  public abstract void getGameStartPriority(String paramString);
  
  public abstract void getGameSwitch();
  
  public abstract void setGameSwitch(String paramString, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi
 * JD-Core Version:    0.7.0.1
 */