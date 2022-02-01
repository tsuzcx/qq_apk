package com.tencent.mobileqq.nearby.api.impl;

import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;
import com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher;
import com.tencent.mobileqq.intervideo.huayang.impl.HuayangPluginNewDownloaderImpl;
import com.tencent.mobileqq.intervideo.litelive_kandian.config.KandianLiveConfProcessor;
import com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager;
import com.tencent.mobileqq.intervideo.now.dynamic.channelImpl.NowChannerHandlerV2;
import com.tencent.mobileqq.nearby.NearByGeneralManager;
import com.tencent.mobileqq.nearby.NearbyAlumniServlet;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyFaceScoreManager;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager;
import com.tencent.mobileqq.nearby.NearbyReceiver;
import com.tencent.mobileqq.nearby.NearbyRelevantHandler;
import com.tencent.mobileqq.nearby.api.INearbyService;
import com.tencent.mobileqq.nearby.api.NearbyProxy;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.gameroom.RecentInviteUser;
import com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager;
import com.tencent.mobileqq.nearby.now.SmallVideoFragment;
import com.tencent.mobileqq.nearby.profilecard.MiniCardManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;

public class NearbyServiceImpl
  implements INearbyService
{
  public Class getDynamicNowManagerClass()
  {
    return DynamicNowManager.class;
  }
  
  public Class getGroupVideoManagerClass()
  {
    return GroupVideoManager.class;
  }
  
  public String getHuayangPluginLauncherClassName()
  {
    return HuayangPluginLauncher.class.getName();
  }
  
  public String getHuayangPluginNewDownloaderClassName()
  {
    return HuayangPluginNewDownloaderImpl.class.getName();
  }
  
  public Class getKandianLiveConfProcessorClass()
  {
    return KandianLiveConfProcessor.class;
  }
  
  public Class getLocalRedTouchManagerClass()
  {
    return LocalRedTouchManager.class;
  }
  
  public Class getMiniCardManagerClass()
  {
    return MiniCardManager.class;
  }
  
  public Class getNearbyAlumniServletClass()
  {
    return NearbyAlumniServlet.class;
  }
  
  public String getNearbyCardHandlerClassName()
  {
    return NearbyCardHandler.a;
  }
  
  public Class getNearbyCardManagerClass()
  {
    return NearbyCardManager.class;
  }
  
  public Class getNearbyFaceScoreManagerClass()
  {
    return NearbyFaceScoreManager.class;
  }
  
  public Class getNearbyGeneralManagerClass()
  {
    return NearByGeneralManager.class;
  }
  
  public Class getNearbyHandlerClass()
  {
    return NearbyHandler.class;
  }
  
  public Class getNearbyLikeLimitManagerClass()
  {
    return NearbyLikeLimitManager.class;
  }
  
  public Class getNearbyMomentManagerClass()
  {
    return NearbyMomentManager.class;
  }
  
  public Class getNearbyPeopleProfileActivityClass()
  {
    return NearbyPeopleProfileActivity.class;
  }
  
  public Class getNearbyProxyClass()
  {
    return NearbyProxy.class;
  }
  
  public Class getNearbyReceiverClass()
  {
    return NearbyReceiver.class;
  }
  
  public String getNearbyRelevantHandlerClassName()
  {
    return NearbyRelevantHandler.a;
  }
  
  public String getNowChannerHandlerV2ClassName()
  {
    return NowChannerHandlerV2.class.getName();
  }
  
  public int getQQNearbyFactoryCountManager()
  {
    return QQManagerFactory.COUNT_MANAGER;
  }
  
  public Class getRecentInviteUserClass()
  {
    return RecentInviteUser.class;
  }
  
  public Class getSmallVideoFragmentClass()
  {
    return SmallVideoFragment.class;
  }
  
  public Class getWerewolvesDataManagerClass()
  {
    return WerewolvesDataManager.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.NearbyServiceImpl
 * JD-Core Version:    0.7.0.1
 */