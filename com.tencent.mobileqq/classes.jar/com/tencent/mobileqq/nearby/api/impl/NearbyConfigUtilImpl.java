package com.tencent.mobileqq.nearby.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbyConfigUtil;
import com.tencent.mobileqq.nearby.api.NearbyConfigUtil;

public class NearbyConfigUtilImpl
  implements INearbyConfigUtil
{
  private final NearbyConfigUtil mNearbyConfigUtil = new NearbyConfigUtil();
  
  public void clearRedDotInNearbyEnter(Object paramObject, int paramInt)
  {
    NearbyConfigUtil.a((QQAppInterface)paramObject, paramInt);
  }
  
  public Object getDatingConfig()
  {
    return this.mNearbyConfigUtil.a();
  }
  
  public boolean hasEnterItem(AppInterface paramAppInterface, int paramInt)
  {
    return NearbyConfigUtil.a(paramAppInterface, paramInt);
  }
  
  public boolean hasNearbyMsgTab(AppInterface paramAppInterface)
  {
    return NearbyConfigUtil.b(paramAppInterface);
  }
  
  public boolean isNewNearbyTab(AppInterface paramAppInterface)
  {
    return NearbyConfigUtil.a(paramAppInterface);
  }
  
  public boolean isOldEnterHasItem(Object paramObject, int paramInt)
  {
    return NearbyConfigUtil.a((QQAppInterface)paramObject, paramInt);
  }
  
  public void updateDatingConfig()
  {
    this.mNearbyConfigUtil.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.NearbyConfigUtilImpl
 * JD-Core Version:    0.7.0.1
 */