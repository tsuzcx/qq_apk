package com.tencent.mobileqq.kandian.ad.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.NativeAd.report.VideoAdClickRecorder;
import com.tencent.biz.pubaccount.NativeAd.util.VideoFeedsAdTagHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.RecommendADVideoFeedsManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.ReadInjoyADVideoC2sManger;
import com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdTest;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideo185UIStateUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ExposureSupplementManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.VideoFeedsAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdStrategyManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdTimeLoadManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBubbleNativeView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyVideoAdHighLightBar;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.AdTagInfo;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ArticleSummary;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.RspBody;
import tencent.im.oidb.cmd0x885.oidb_0x885.AdTagInfo;

public class RIJVideoAdServiceImpl
  implements IRIJVideoAdService
{
  public ReadInJoyAdBubbleNativeView addFeedsBubbleView(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    if (paramRelativeLayout == null) {
      return null;
    }
    ReadInJoyAdBubbleNativeView localReadInJoyAdBubbleNativeView = new ReadInJoyAdBubbleNativeView(paramContext);
    paramRelativeLayout.addView(localReadInJoyAdBubbleNativeView);
    paramRelativeLayout = (RelativeLayout.LayoutParams)localReadInJoyAdBubbleNativeView.getLayoutParams();
    paramRelativeLayout.width = AIOUtils.b(178.5F, paramContext.getResources());
    paramRelativeLayout.height = AIOUtils.b(62.0F, paramContext.getResources());
    paramRelativeLayout.leftMargin = AIOUtils.b(8.0F, paramContext.getResources());
    paramRelativeLayout.addRule(12);
    paramRelativeLayout.addRule(9);
    localReadInJoyAdBubbleNativeView.setLayoutParams(paramRelativeLayout);
    localReadInJoyAdBubbleNativeView.setVisibility(8);
    return localReadInJoyAdBubbleNativeView;
  }
  
  public boolean containsAdClick(AdvertisementInfo paramAdvertisementInfo)
  {
    return VideoAdClickRecorder.c(paramAdvertisementInfo);
  }
  
  public ArrayList<oidb_0x885.AdTagInfo> convertAdTagInfos(ArrayList<VideoInfo.AdTagInfo> paramArrayList)
  {
    return VideoFeedsAdTagHelper.a(paramArrayList);
  }
  
  public void dealRedPacketMVResult(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    VideoFeedsSoftAdTest.a(paramActivity, paramInt, paramIntent);
  }
  
  public void destroyFromVideoFeeds() {}
  
  public void doOnVideoPause(Activity paramActivity)
  {
    ExposureSupplementManager.c(paramActivity);
  }
  
  public void doOnVideoResume() {}
  
  public void fillVideoBeforeEndGuide(Object paramObject1, Object paramObject2)
  {
    AdVideo185UIStateUtil.a.a((com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam)paramObject1, (ReadInJoyAdVideoGuide)paramObject2);
  }
  
  public int getAdStrategy()
  {
    return VideoAdStrategyManager.b;
  }
  
  public AdvertisementInfo getAdvertisementInfo(VideoInfo paramVideoInfo)
  {
    return (AdvertisementInfo)paramVideoInfo.aT;
  }
  
  public void handleCompleteState(Object paramObject)
  {
    AdVideo185UIStateUtil.a.a((IVideoPlayManager)paramObject);
  }
  
  public boolean isMixStrategy()
  {
    return VideoAdStrategyManager.c();
  }
  
  public boolean isNotMixStrategy()
  {
    return VideoAdStrategyManager.d();
  }
  
  public boolean isNotTimeStrategy()
  {
    return VideoAdStrategyManager.e();
  }
  
  public boolean isNotVVStrategy()
  {
    return VideoAdStrategyManager.b();
  }
  
  public boolean isVVStrategy()
  {
    return VideoAdStrategyManager.a();
  }
  
  public void logAdConfig(Object paramObject)
  {
    AdVideo185UIStateUtil.a.a((com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam)paramObject);
  }
  
  public void onProgressUpdate(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AdVideo185UIStateUtil.a.a((com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam)paramObject1, (IVideoPlayManager)paramObject2, (RecommendADVideoFeedsManager)paramObject3);
  }
  
  public void parseKdTagInfo(oidb_0x6cf.ArticleSummary paramArticleSummary, VideoInfo paramVideoInfo)
  {
    VideoFeedsAdTagHelper.a(paramArticleSummary, paramVideoInfo);
  }
  
  public void parseTagInfoResult(oidb_0x6cf.RspBody paramRspBody, Bundle paramBundle, long paramLong)
  {
    VideoFeedsAdTagHelper.a(paramRspBody, paramBundle, paramLong);
  }
  
  public void putAdTagIntoBundle(Bundle paramBundle, ArrayList paramArrayList)
  {
    VideoFeedsAdTagHelper.a(paramBundle, paramArrayList);
  }
  
  public void recordAdVideoClick(AdvertisementInfo paramAdvertisementInfo)
  {
    VideoAdClickRecorder.a(paramAdvertisementInfo);
  }
  
  public void recordVideoFeeds(Activity paramActivity, RecyclerView.ViewHolder paramViewHolder)
  {
    ExposureSupplementManager.a(paramActivity, paramViewHolder);
  }
  
  public void recordVideoFeeds1px(Activity paramActivity, RecyclerView.ViewHolder paramViewHolder)
  {
    ExposureSupplementManager.b(paramActivity, paramViewHolder);
  }
  
  public void removeAdVideoClick(AdvertisementInfo paramAdvertisementInfo)
  {
    VideoAdClickRecorder.b(paramAdvertisementInfo);
  }
  
  public void reportVideoFeeds(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    ExposureSupplementManager.a(paramActivity, paramInt, paramBoolean);
  }
  
  public void reportVideoPlayC2sBasedTimeFilter(int paramInt, IVideoPlayManager paramIVideoPlayManager)
  {
    ReadInjoyADVideoC2sManger.a(paramInt, paramIVideoPlayManager);
  }
  
  public void reportVideoReplayOnLoop(com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam paramVideoPlayParam, Context paramContext, IVideoPlayerWrapper paramIVideoPlayerWrapper)
  {
    VideoFeedsAdReportUtils.a(paramVideoPlayParam, paramContext, paramIVideoPlayerWrapper);
  }
  
  public void setAdvertisementInfo(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    paramVideoInfo.aT = paramAdvertisementInfo;
  }
  
  public void setMixStrategy(boolean paramBoolean)
  {
    VideoAdStrategyManager.m = paramBoolean;
  }
  
  public boolean shouldRemoveAdReqParam()
  {
    return VideoAdStrategyManager.f();
  }
  
  public void updateGuideBtnText(Object paramObject1, Object paramObject2)
  {
    AdVideo185UIStateUtil.a.b((com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam)paramObject1, (ReadInJoyAdVideoGuide)paramObject2);
  }
  
  public void updateLightBarText(Object paramObject1, Object paramObject2)
  {
    AdVideo185UIStateUtil.a.a((com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam)paramObject1, (ReadInJoyVideoAdHighLightBar)paramObject2);
  }
  
  public void videoAdStrategyManagerOnDestroy() {}
  
  public void videoAdTimeLoadManagerOnDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJVideoAdServiceImpl
 * JD-Core Version:    0.7.0.1
 */