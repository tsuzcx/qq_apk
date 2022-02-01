package com.tencent.mobileqq.nearby.home;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface INearbyTabInfo
  extends QRouteApi
{
  public static final int TAB_NEARBY = 1;
  
  public abstract int getNeedLoc();
  
  public abstract int getTabIndex();
  
  public abstract String getTabName();
  
  public abstract int getTabType();
  
  public abstract String getTabUrl();
  
  public abstract boolean isShowRedRot();
  
  public abstract String toJson();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.home.INearbyTabInfo
 * JD-Core Version:    0.7.0.1
 */