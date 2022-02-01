package com.tencent.mobileqq.hotchat.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IHotChatInfo
  extends QRouteApi
{
  public abstract String getJoinUrl();
  
  public abstract String getName();
  
  public abstract String getOwnerUin();
  
  public abstract String getTroopUin();
  
  public abstract int getUserCreate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.api.IHotChatInfo
 * JD-Core Version:    0.7.0.1
 */