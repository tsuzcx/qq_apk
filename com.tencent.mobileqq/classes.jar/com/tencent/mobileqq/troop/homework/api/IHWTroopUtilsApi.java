package com.tencent.mobileqq.troop.homework.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IHWTroopUtilsApi
  extends QRouteApi
{
  public static final Integer HOMEWORK_SCHOOL_EDIT_FROM = Integer.valueOf(3);
  public static final String HOMEWORK_TROOP_JOIN_SOURCE = "join";
  public static final String HOMEWORK_TROOP_PROFILE_SOURCE = "troopProfile";
  public static final String HOMEWORK_TROOP_SCHOOL_MODIFY_URL = "https://admin.qun.qq.com/mcreatev4/classinfo?gc=%1$s&from=%2$s";
  public static final String HW_TROOP_IDENTITY_CHANGED_EVENT = "onHomeworkTroopIdentityChanged";
  
  public abstract void clearHomeworkTroopRedPoint(AppInterface paramAppInterface, String paramString);
  
  public abstract int getAIOHomeworkBtnRedPoint(AppRuntime paramAppRuntime, String paramString);
  
  public abstract boolean hasHomeworkTroopIdentity(int paramInt);
  
  public abstract void setAIOHomeworkBtnRedPoint(AppRuntime paramAppRuntime, String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi
 * JD-Core Version:    0.7.0.1
 */