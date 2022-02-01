package com.tencent.mobileqq.gamecenter.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IGameMsgUnissoHandlerApi
  extends QRouteApi
{
  public abstract void addOrShieldFriend(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3);
  
  public abstract void getAioPopInfo(int paramInt, String paramString1, String paramString2);
  
  public abstract void getGameMsgTabConfig();
  
  public abstract void getGameStartPriority(int paramInt, String paramString);
  
  public abstract void getGameSwitch(int paramInt);
  
  public abstract void setGameSwitch(int paramInt1, String paramString, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi
 * JD-Core Version:    0.7.0.1
 */