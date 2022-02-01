package com.tencent.mobileqq.teamwork.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IDocDrawerConfig
  extends QRouteApi
{
  public abstract String getAndroidDrawerIconURL();
  
  public abstract String getAndroidDrawerJumpURL();
  
  public abstract String getAndroidDrawerText();
  
  public abstract Boolean getIsShowInDrawer();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.IDocDrawerConfig
 * JD-Core Version:    0.7.0.1
 */