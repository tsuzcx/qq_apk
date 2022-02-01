package com.tencent.mobileqq.utils.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IContactUtils
  extends QRouteApi
{
  public abstract String getAccountNickName(AppInterface paramAppInterface, String paramString);
  
  public abstract String getBuddyNickName(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean);
  
  public abstract String getFriendNickName(AppInterface paramAppInterface, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.api.IContactUtils
 * JD-Core Version:    0.7.0.1
 */