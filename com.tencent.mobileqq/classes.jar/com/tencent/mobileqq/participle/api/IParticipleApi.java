package com.tencent.mobileqq.participle.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IParticipleApi
  extends QRouteApi
{
  public abstract void participleTheContent(AppInterface paramAppInterface, String paramString);
  
  public abstract void participleTheContent(AppInterface paramAppInterface, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.participle.api.IParticipleApi
 * JD-Core Version:    0.7.0.1
 */