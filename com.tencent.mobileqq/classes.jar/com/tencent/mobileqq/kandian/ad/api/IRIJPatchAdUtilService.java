package com.tencent.mobileqq.kandian.ad.api;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.OnPatchPlayListener;
import com.tencent.mobileqq.kandian.biz.feeds.api.CountDownCallback;
import com.tencent.mobileqq.kandian.biz.feeds.api.IVideoUIManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface IRIJPatchAdUtilService
  extends QRouteApi
{
  public abstract AdvertisementInfo getPatchAd(int paramInt);
  
  public abstract int getPatchAdDisplaySeconds(JSONObject paramJSONObject);
  
  public abstract void hidePathAd(IVideoUIManager paramIVideoUIManager);
  
  public abstract boolean inFrequentController(String paramString, int paramInt);
  
  public abstract void initPatchAdViewListener(Activity paramActivity, IVideoUIManager paramIVideoUIManager, IVideoPlayManager paramIVideoPlayManager, Object paramObject, CountDownCallback paramCountDownCallback, OnPatchPlayListener paramOnPatchPlayListener);
  
  public abstract boolean isPatchPlaying(IVideoUIManager paramIVideoUIManager);
  
  public abstract void playPostPatchAd(VideoPlayParam paramVideoPlayParam, IVideoUIManager paramIVideoUIManager, boolean paramBoolean1, boolean paramBoolean2, CountDownCallback paramCountDownCallback, Object paramObject, OnPatchPlayListener paramOnPatchPlayListener);
  
  public abstract void playPrePatchAd(VideoPlayParam paramVideoPlayParam, IVideoUIManager paramIVideoUIManager, boolean paramBoolean, OnPatchPlayListener paramOnPatchPlayListener);
  
  public abstract void preRequestPatchAd();
  
  public abstract void requestPatchAd(int paramInt);
  
  public abstract boolean resumeFromPosPatchClickBack(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean resumeFromPosPatchHomeBack(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean resumeFromPrePatchClickBack(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean resumeFromPrePatchHomeBack(AbsBaseArticleInfo paramAbsBaseArticleInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJPatchAdUtilService
 * JD-Core Version:    0.7.0.1
 */