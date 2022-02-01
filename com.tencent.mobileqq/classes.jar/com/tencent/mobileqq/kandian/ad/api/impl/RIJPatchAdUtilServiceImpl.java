package com.tencent.mobileqq.kandian.ad.api.impl;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.OnPatchPlayListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyPatchAdUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJPatchAdUtilService;
import com.tencent.mobileqq.kandian.biz.feeds.api.CountDownCallback;
import com.tencent.mobileqq.kandian.biz.feeds.api.IVideoUIManager;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFullPlayController;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import org.json.JSONObject;

public class RIJPatchAdUtilServiceImpl
  implements IRIJPatchAdUtilService
{
  public AdvertisementInfo getPatchAd(int paramInt)
  {
    return ReadInJoyPatchAdUtils.a(paramInt);
  }
  
  public int getPatchAdDisplaySeconds(JSONObject paramJSONObject)
  {
    return ReadInJoyPatchAdUtils.a(paramJSONObject);
  }
  
  public void hidePathAd(IVideoUIManager paramIVideoUIManager)
  {
    ReadInJoyPatchAdUtils.a(paramIVideoUIManager);
  }
  
  public boolean inFrequentController(String paramString, int paramInt)
  {
    return ReadInJoyPatchAdUtils.a(paramString, paramInt);
  }
  
  public void initPatchAdViewListener(Activity paramActivity, IVideoUIManager paramIVideoUIManager, IVideoPlayManager paramIVideoPlayManager, Object paramObject, CountDownCallback paramCountDownCallback, OnPatchPlayListener paramOnPatchPlayListener)
  {
    ReadInJoyPatchAdUtils.a(paramActivity, paramIVideoUIManager, paramIVideoPlayManager, (IVideoFullPlayController)paramObject, paramCountDownCallback, paramOnPatchPlayListener);
  }
  
  public boolean isPatchPlaying(IVideoUIManager paramIVideoUIManager)
  {
    return ReadInJoyPatchAdUtils.a(paramIVideoUIManager);
  }
  
  public void playPostPatchAd(VideoPlayParam paramVideoPlayParam, IVideoUIManager paramIVideoUIManager, boolean paramBoolean1, boolean paramBoolean2, CountDownCallback paramCountDownCallback, Object paramObject, OnPatchPlayListener paramOnPatchPlayListener)
  {
    ReadInJoyPatchAdUtils.a(paramVideoPlayParam, paramIVideoUIManager, paramBoolean1, paramBoolean2, paramCountDownCallback, (IVideoFullPlayController)paramObject, paramOnPatchPlayListener);
  }
  
  public void playPrePatchAd(VideoPlayParam paramVideoPlayParam, IVideoUIManager paramIVideoUIManager, boolean paramBoolean, OnPatchPlayListener paramOnPatchPlayListener)
  {
    ReadInJoyPatchAdUtils.a(paramVideoPlayParam, paramIVideoUIManager, paramBoolean, paramOnPatchPlayListener);
  }
  
  public void preRequestPatchAd() {}
  
  public void requestPatchAd(int paramInt)
  {
    ReadInJoyPatchAdUtils.a(paramInt);
  }
  
  public boolean resumeFromPosPatchClickBack(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyPatchAdUtils.b(paramAbsBaseArticleInfo);
  }
  
  public boolean resumeFromPosPatchHomeBack(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyPatchAdUtils.d(paramAbsBaseArticleInfo);
  }
  
  public boolean resumeFromPrePatchClickBack(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyPatchAdUtils.a(paramAbsBaseArticleInfo);
  }
  
  public boolean resumeFromPrePatchHomeBack(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyPatchAdUtils.c(paramAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJPatchAdUtilServiceImpl
 * JD-Core Version:    0.7.0.1
 */