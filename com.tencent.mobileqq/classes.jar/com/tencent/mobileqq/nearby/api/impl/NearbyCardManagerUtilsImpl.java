package com.tencent.mobileqq.nearby.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.api.INearbyCardManagerUtils;

public class NearbyCardManagerUtilsImpl
  implements INearbyCardManagerUtils
{
  public boolean isTinyId(String paramString)
  {
    return NearbyCardManager.a(paramString);
  }
  
  public boolean showDowndTribeAppDialg(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    return NearbyCardManager.a(paramActivity, paramString1, paramString2, paramInt);
  }
  
  public void updateNearbyPeopleCard(Object paramObject1, String paramString, Object paramObject2, Object paramObject3)
  {
    NearbyCardManager.a(paramObject1, paramString, paramObject2, paramObject3);
  }
  
  public void updateNearbyProfileCardHead(Object paramObject)
  {
    NearbyCardManager.b(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.NearbyCardManagerUtilsImpl
 * JD-Core Version:    0.7.0.1
 */