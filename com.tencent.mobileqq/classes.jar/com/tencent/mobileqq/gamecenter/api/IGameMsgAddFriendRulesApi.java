package com.tencent.mobileqq.gamecenter.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={""})
@QRouteFactory(singleton=false)
public abstract interface IGameMsgAddFriendRulesApi
  extends QRouteApi
{
  public abstract void doInit(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt);
  
  public abstract boolean isAbleToAction();
  
  public abstract void recordAction();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.IGameMsgAddFriendRulesApi
 * JD-Core Version:    0.7.0.1
 */