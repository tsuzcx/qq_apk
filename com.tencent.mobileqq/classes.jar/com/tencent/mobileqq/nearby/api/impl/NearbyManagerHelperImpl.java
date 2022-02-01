package com.tencent.mobileqq.nearby.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.INearByGeneralManager;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager;
import com.tencent.mobileqq.nearby.api.INearbyManagerHelper;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;

public class NearbyManagerHelperImpl
  implements INearbyManagerHelper
{
  public LocalRedTouchManager getLocalRedTouchManager(Object paramObject)
  {
    return (LocalRedTouchManager)((QQAppInterface)paramObject).getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
  }
  
  public INearbyCardManager getNearbyCardManager(Object paramObject)
  {
    return (INearbyCardManager)((QQAppInterface)paramObject).getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
  }
  
  public INearByGeneralManager getNearbyGeneralManager(Object paramObject)
  {
    return (INearByGeneralManager)((QQAppInterface)paramObject).getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER);
  }
  
  public INearbyLikeLimitManager getNearbyLikeLimitManager(Object paramObject)
  {
    return (INearbyLikeLimitManager)((QQAppInterface)paramObject).getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER);
  }
  
  public INearbyProxy getNearbyProxy(Object paramObject)
  {
    return (INearbyProxy)((QQAppInterface)paramObject).getManager(QQManagerFactory.NEARBY_PROXY_MANAGER);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.NearbyManagerHelperImpl
 * JD-Core Version:    0.7.0.1
 */