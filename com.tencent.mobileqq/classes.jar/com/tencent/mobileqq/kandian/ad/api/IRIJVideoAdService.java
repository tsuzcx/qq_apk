package com.tencent.mobileqq.kandian.ad.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBubbleNativeView;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.AdTagInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ArticleSummary;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.RspBody;
import tencent.im.oidb.cmd0x885.oidb_0x885.AdTagInfo;

@QAPI(process={"all"})
public abstract interface IRIJVideoAdService
  extends QRouteApi
{
  public abstract ReadInJoyAdBubbleNativeView addFeedsBubbleView(Context paramContext, RelativeLayout paramRelativeLayout);
  
  public abstract boolean containsAdClick(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract ArrayList<oidb_0x885.AdTagInfo> convertAdTagInfos(ArrayList<VideoInfo.AdTagInfo> paramArrayList);
  
  public abstract void dealRedPacketMVResult(Activity paramActivity, int paramInt, Intent paramIntent);
  
  public abstract void destroyFromVideoFeeds();
  
  public abstract void doOnVideoPause(Activity paramActivity);
  
  public abstract void doOnVideoResume();
  
  public abstract void fillVideoBeforeEndGuide(Object paramObject1, Object paramObject2);
  
  public abstract int getAdStrategy();
  
  public abstract AdvertisementInfo getAdvertisementInfo(VideoInfo paramVideoInfo);
  
  public abstract void handleCompleteState(Object paramObject);
  
  public abstract boolean isMixStrategy();
  
  public abstract boolean isNotMixStrategy();
  
  public abstract boolean isNotTimeStrategy();
  
  public abstract boolean isNotVVStrategy();
  
  public abstract boolean isVVStrategy();
  
  public abstract void logAdConfig(Object paramObject);
  
  public abstract void onProgressUpdate(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract void parseKdTagInfo(oidb_0x6cf.ArticleSummary paramArticleSummary, VideoInfo paramVideoInfo);
  
  public abstract void parseTagInfoResult(oidb_0x6cf.RspBody paramRspBody, Bundle paramBundle, long paramLong);
  
  public abstract void putAdTagIntoBundle(Bundle paramBundle, ArrayList paramArrayList);
  
  public abstract void recordAdVideoClick(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract void recordVideoFeeds(Activity paramActivity, RecyclerView.ViewHolder paramViewHolder);
  
  public abstract void recordVideoFeeds1px(Activity paramActivity, RecyclerView.ViewHolder paramViewHolder);
  
  public abstract void removeAdVideoClick(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract void reportVideoFeeds(Activity paramActivity, int paramInt, boolean paramBoolean);
  
  public abstract void reportVideoPlayC2sBasedTimeFilter(int paramInt, IVideoPlayManager paramIVideoPlayManager);
  
  public abstract void reportVideoReplayOnLoop(VideoPlayParam paramVideoPlayParam, Context paramContext, IVideoPlayerWrapper paramIVideoPlayerWrapper);
  
  public abstract void setAdvertisementInfo(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo);
  
  public abstract void setMixStrategy(boolean paramBoolean);
  
  public abstract boolean shouldRemoveAdReqParam();
  
  public abstract void updateGuideBtnText(Object paramObject1, Object paramObject2);
  
  public abstract void updateLightBarText(Object paramObject1, Object paramObject2);
  
  public abstract void videoAdStrategyManagerOnDestroy();
  
  public abstract void videoAdTimeLoadManagerOnDestroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService
 * JD-Core Version:    0.7.0.1
 */