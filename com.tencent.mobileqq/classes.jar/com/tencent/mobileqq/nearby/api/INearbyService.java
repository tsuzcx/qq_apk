package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface INearbyService
  extends QRouteApi
{
  public abstract Class getDynamicNowManagerClass();
  
  public abstract Class getGroupVideoManagerClass();
  
  public abstract String getHuayangPluginLauncherClassName();
  
  public abstract String getHuayangPluginNewDownloaderClassName();
  
  public abstract Class getKandianLiveConfProcessorClass();
  
  public abstract Class getLocalRedTouchManagerClass();
  
  public abstract Class getMiniCardManagerClass();
  
  public abstract Class getNearbyAlumniServletClass();
  
  public abstract String getNearbyCardHandlerClassName();
  
  public abstract Class getNearbyCardManagerClass();
  
  public abstract Class getNearbyFaceScoreManagerClass();
  
  public abstract Class getNearbyGeneralManagerClass();
  
  public abstract Class getNearbyHandlerClass();
  
  public abstract Class getNearbyLikeLimitManagerClass();
  
  public abstract Class getNearbyMomentManagerClass();
  
  public abstract Class getNearbyPeopleProfileActivityClass();
  
  public abstract Class getNearbyProxyClass();
  
  public abstract Class getNearbyReceiverClass();
  
  public abstract String getNearbyRelevantHandlerClassName();
  
  public abstract String getNowChannerHandlerV2ClassName();
  
  public abstract int getQQNearbyFactoryCountManager();
  
  public abstract Class getRecentInviteUserClass();
  
  public abstract Class getSmallVideoFragmentClass();
  
  public abstract Class getWerewolvesDataManagerClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.INearbyService
 * JD-Core Version:    0.7.0.1
 */