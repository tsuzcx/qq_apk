package com.tencent.mobileqq.relation.api;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={""})
public abstract interface IProfileCardUtil
  extends QRouteApi
{
  public abstract Card findFriendCardByUin(AppRuntime paramAppRuntime);
  
  public abstract Card initCard(AppRuntime paramAppRuntime, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relation.api.IProfileCardUtil
 * JD-Core Version:    0.7.0.1
 */