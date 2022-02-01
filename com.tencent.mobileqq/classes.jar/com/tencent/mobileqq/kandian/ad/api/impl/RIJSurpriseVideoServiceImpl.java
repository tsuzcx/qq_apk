package com.tencent.mobileqq.kandian.ad.api.impl;

import com.tencent.mobileqq.kandian.ad.api.IRIJSurpriseVideoService;
import com.tencent.mobileqq.kandian.ad.api.IRIJSurpriseVideoService.DisLikeEvent;
import com.tencent.mobileqq.kandian.ad.api.IRIJSurpriseVideoService.VideoSearchCallback;
import com.tencent.mobileqq.kandian.biz.video.PlayableItem;

public class RIJSurpriseVideoServiceImpl
  implements IRIJSurpriseVideoService
{
  IRIJSurpriseVideoService.DisLikeEvent mDisLikeEvent;
  IRIJSurpriseVideoService.VideoSearchCallback mVideoSearchCallback;
  
  public void handleDislikeWindowDissMiss()
  {
    IRIJSurpriseVideoService.DisLikeEvent localDisLikeEvent = this.mDisLikeEvent;
    if (localDisLikeEvent != null) {
      localDisLikeEvent.b();
    }
  }
  
  public void handleDislikeWindowShow()
  {
    IRIJSurpriseVideoService.DisLikeEvent localDisLikeEvent = this.mDisLikeEvent;
    if (localDisLikeEvent != null) {
      localDisLikeEvent.a();
    }
  }
  
  public boolean handleSearchResult(PlayableItem paramPlayableItem)
  {
    IRIJSurpriseVideoService.VideoSearchCallback localVideoSearchCallback = this.mVideoSearchCallback;
    if (localVideoSearchCallback != null) {
      return localVideoSearchCallback.handleResult(paramPlayableItem);
    }
    return false;
  }
  
  public void setDisLikeListener(IRIJSurpriseVideoService.DisLikeEvent paramDisLikeEvent)
  {
    this.mDisLikeEvent = paramDisLikeEvent;
  }
  
  public void setVideoSearchCallback(IRIJSurpriseVideoService.VideoSearchCallback paramVideoSearchCallback)
  {
    this.mVideoSearchCallback = paramVideoSearchCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJSurpriseVideoServiceImpl
 * JD-Core Version:    0.7.0.1
 */