package com.tencent.mobileqq.kandian.ad.api;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdMiniGuide;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IRIJAdShakeManager
  extends QRouteApi
{
  public abstract boolean hasEggReport();
  
  public abstract boolean hasShake();
  
  public abstract boolean isComplainBackToFeeds();
  
  public abstract boolean isSurpriseVideoPlaying();
  
  public abstract void onComplainBackToFeeds();
  
  public abstract void onDestory();
  
  public abstract void registerListener(Context paramContext, VideoPlayParam paramVideoPlayParam);
  
  public abstract void reportAdClick();
  
  public abstract void reportBigGuideShow();
  
  public abstract void reportExposeLoose();
  
  public abstract void reportExposeStrict();
  
  public abstract void reportMiniGuideShow();
  
  public abstract void reportNegative();
  
  public abstract void resetShake();
  
  public abstract void setEggVideoState(boolean paramBoolean);
  
  public abstract void setGuideView(ReadInJoyAdMiniGuide paramReadInJoyAdMiniGuide);
  
  public abstract void setSurpriseVideoPlayingState(boolean paramBoolean);
  
  public abstract void setVideoPlayerManager(IVideoPlayManager paramIVideoPlayManager);
  
  public abstract void unRegisterListener();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJAdShakeManager
 * JD-Core Version:    0.7.0.1
 */