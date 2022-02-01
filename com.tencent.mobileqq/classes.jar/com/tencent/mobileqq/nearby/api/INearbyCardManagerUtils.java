package com.tencent.mobileqq.nearby.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface INearbyCardManagerUtils
  extends QRouteApi
{
  public abstract boolean isTinyId(String paramString);
  
  public abstract boolean showDowndTribeAppDialg(Activity paramActivity, String paramString1, String paramString2, int paramInt);
  
  public abstract void updateNearbyPeopleCard(Object paramObject1, String paramString, Object paramObject2, Object paramObject3);
  
  public abstract void updateNearbyProfileCardHead(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.INearbyCardManagerUtils
 * JD-Core Version:    0.7.0.1
 */