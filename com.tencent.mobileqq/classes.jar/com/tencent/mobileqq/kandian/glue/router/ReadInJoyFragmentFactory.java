package com.tencent.mobileqq.kandian.glue.router;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdHippyService;
import com.tencent.mobileqq.kandian.biz.common.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.DynamicChannelConfig;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.compat.ReadInJoyDynamicChannelFragment;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyRecommendFeedsFragment;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoySubChannelFragment;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyTribeChannelFragment;
import com.tencent.mobileqq.kandian.biz.follow.ReadInJoyBBCircleFragment;
import com.tencent.mobileqq.kandian.biz.follow.ReadInJoyFollowFragment;
import com.tencent.mobileqq.kandian.biz.playfeeds.MultiVideoHelper;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyVideoChannelFragment;
import com.tencent.mobileqq.kandian.biz.viola.ReadInJoySelfCenterViolaFragment;
import com.tencent.mobileqq.kandian.biz.viola.ReadInJoyViolaChannelFragment;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class ReadInJoyFragmentFactory
{
  static ReadInJoyFragmentFactory jdField_a_of_type_ComTencentMobileqqKandianGlueRouterReadInJoyFragmentFactory;
  WeakReference<ReadInJoyNewFeedsActivity> jdField_a_of_type_MqqUtilWeakReference = null;
  
  private QBaseFragment a(TemplateFactory paramTemplateFactory, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    paramTemplateFactory = paramTemplateFactory.a();
    if (paramTemplateFactory != null)
    {
      if (!TextUtils.isEmpty(paramTemplateFactory.b("cgi"))) {
        return ReadInJoyCGIDynamicChannelFragment.a(paramTabChannelCoverInfo.mChannelCoverId, 0, paramTabChannelCoverInfo.mChannelCoverName);
      }
      return ReadInJoyDynamicChannelFragment.a(paramTabChannelCoverInfo.mChannelCoverId, 0, paramTabChannelCoverInfo.mChannelCoverName);
    }
    return null;
  }
  
  public static ReadInJoyBaseFragment a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return null;
          }
          return ReadInJoySelfCenterViolaFragment.a("https://viola.qq.com/js/usercenter.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&v_tid=6&v_bundleName=usercenter&v_bid=3740&jump_source=2");
        }
        return ReadInJoyFollowFragment.a();
      }
      ReadInJoyVideoChannelFragment localReadInJoyVideoChannelFragment = new ReadInJoyVideoChannelFragment();
      localReadInJoyVideoChannelFragment.c(1002);
      return localReadInJoyVideoChannelFragment;
    }
    return ReadInJoyRecommendFeedsFragment.a();
  }
  
  public static ReadInJoyFragmentFactory a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqKandianGlueRouterReadInJoyFragmentFactory == null) {
        jdField_a_of_type_ComTencentMobileqqKandianGlueRouterReadInJoyFragmentFactory = new ReadInJoyFragmentFactory();
      }
      return jdField_a_of_type_ComTencentMobileqqKandianGlueRouterReadInJoyFragmentFactory;
    }
    finally {}
  }
  
  private QBaseFragment b(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo.mChannelCoverId == ChannelCoverInfoModule.a()) {
      return c(paramTabChannelCoverInfo);
    }
    if (ViolaAccessHelper.a(paramTabChannelCoverInfo.mChannelCoverId)) {
      return MultiVideoHelper.a(BaseApplicationImpl.getContext(), paramTabChannelCoverInfo);
    }
    if (ViolaAccessHelper.b(paramTabChannelCoverInfo.mChannelCoverId)) {
      return MultiVideoHelper.a(BaseApplicationImpl.getContext(), paramTabChannelCoverInfo);
    }
    if (ViolaAccessHelper.a(paramTabChannelCoverInfo.mChannelJumpUrl)) {
      return f(paramTabChannelCoverInfo);
    }
    return d(paramTabChannelCoverInfo);
  }
  
  private QBaseFragment c(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (ViolaAccessHelper.a(paramTabChannelCoverInfo.mChannelJumpUrl)) {
      return f(paramTabChannelCoverInfo);
    }
    return ReadInJoyRecommendFeedsFragment.a();
  }
  
  private QBaseFragment d(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    switch (paramTabChannelCoverInfo.mChannelCoverId)
    {
    default: 
      return e(paramTabChannelCoverInfo);
    case 41726: 
      return MultiVideoHelper.a(BaseApplicationImpl.getContext(), paramTabChannelCoverInfo);
    case 41725: 
      return MultiVideoHelper.a(BaseApplicationImpl.getContext(), paramTabChannelCoverInfo);
    case 41708: 
      Object localObject = ((IRIJAdHippyService)QRoute.api(IRIJAdHippyService.class)).createReadinjoyAdHippyFragment(paramTabChannelCoverInfo.mChannelCoverId, paramTabChannelCoverInfo.mChannelCoverName, paramTabChannelCoverInfo.mChannelVersion);
      ((IRIJAdHippyService)QRoute.api(IRIJAdHippyService.class)).setHippyUrl(localObject, paramTabChannelCoverInfo.mChannelJumpUrl);
      return (QBaseFragment)localObject;
    case 41522: 
      return new ReadInJoyPicWaterFallFragment();
    case 41450: 
      return new ReadInJoyTribeChannelFragment();
    case 70: 
      return new ReadInJoyBBCircleFragment();
    case 56: 
      paramTabChannelCoverInfo = new ReadInJoyVideoChannelFragment();
      paramTabChannelCoverInfo.c(1003);
      return paramTabChannelCoverInfo;
    }
    return ReadInJoyRecommendFeedsFragment.a();
  }
  
  private QBaseFragment e(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (ViolaAccessHelper.a(paramTabChannelCoverInfo.mChannelJumpUrl)) {
      return f(paramTabChannelCoverInfo);
    }
    if (paramTabChannelCoverInfo.bid > 0L)
    {
      Object localObject = ReadInJoyDynamicChannelBaseFragment.a(ReadInJoyDynamicChannelBaseFragment.a(paramTabChannelCoverInfo.mChannelCoverId));
      if (localObject != null)
      {
        localObject = a((TemplateFactory)localObject, paramTabChannelCoverInfo);
        if (localObject != null) {
          return localObject;
        }
      }
    }
    return ReadInJoySubChannelFragment.a(paramTabChannelCoverInfo.mChannelCoverId, paramTabChannelCoverInfo.mChannelType, paramTabChannelCoverInfo.mChannelCoverName);
  }
  
  private QBaseFragment f(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    ReadInJoyViolaChannelFragment localReadInJoyViolaChannelFragment = ReadInJoyViolaChannelFragment.a(paramTabChannelCoverInfo.mChannelCoverId, paramTabChannelCoverInfo.mChannelCoverName, paramTabChannelCoverInfo.mChannelVersion);
    if (paramTabChannelCoverInfo.mChannelCoverId == 41655)
    {
      Bundle localBundle = MultiVideoHelper.a();
      localBundle.putAll(localReadInJoyViolaChannelFragment.getArguments());
      localReadInJoyViolaChannelFragment.setArguments(localBundle);
    }
    localReadInJoyViolaChannelFragment.a(paramTabChannelCoverInfo.mChannelJumpUrl);
    return localReadInJoyViolaChannelFragment;
  }
  
  public QBaseFragment a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo == null)
    {
      QLog.d("ReadInJoyFragmentFactory", 1, "tabChannelCoverInfo is null.");
      return null;
    }
    QLog.d("ReadInJoyFragmentFactory", 1, new Object[] { "new Fragment, channelName = ", paramTabChannelCoverInfo.mChannelCoverName, ", channelID = ", Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId) });
    QBaseFragment localQBaseFragment = b(paramTabChannelCoverInfo);
    if ((localQBaseFragment instanceof ReadInJoyBaseFragment)) {
      ((ReadInJoyBaseFragment)localQBaseFragment).a(true);
    }
    RIJXTabFrameUtils.INSTANCE.addFragment2Info(paramTabChannelCoverInfo, localQBaseFragment);
    return localQBaseFragment;
  }
  
  public void a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_MqqUtilWeakReference;
    if (localWeakReference != null)
    {
      localWeakReference.clear();
      this.jdField_a_of_type_MqqUtilWeakReference = null;
    }
  }
  
  public void a(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramReadInJoyNewFeedsActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.router.ReadInJoyFragmentFactory
 * JD-Core Version:    0.7.0.1
 */