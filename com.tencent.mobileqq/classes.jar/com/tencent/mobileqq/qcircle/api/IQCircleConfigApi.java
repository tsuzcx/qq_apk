package com.tencent.mobileqq.qcircle.api;

import android.content.SharedPreferences;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IQCircleConfigApi
  extends QRouteApi
{
  public abstract SharedPreferences getQCircleSp();
  
  public abstract long getQQCircleFollowTabUpdateNotificationShowInterval();
  
  public abstract void tryGetSplashVideoAsync();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.IQCircleConfigApi
 * JD-Core Version:    0.7.0.1
 */