package com.tencent.mobileqq.qcircle.api;

import android.content.SharedPreferences;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQCircleConfigApi
  extends QRouteApi
{
  public abstract String getPluginMark();
  
  public abstract String getPluginQUA();
  
  public abstract SharedPreferences getQCircleSp();
  
  public abstract long getQQCircleFollowTabUpdateNotificationShowInterval();
  
  public abstract boolean isShowQCircleEnter(boolean paramBoolean);
  
  public abstract boolean isShowQQCircleMainTabEntrance(boolean paramBoolean);
  
  public abstract void tryGetSplashVideoAsync();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.IQCircleConfigApi
 * JD-Core Version:    0.7.0.1
 */