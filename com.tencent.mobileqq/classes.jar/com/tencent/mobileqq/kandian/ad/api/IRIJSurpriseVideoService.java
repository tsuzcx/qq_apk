package com.tencent.mobileqq.kandian.ad.api;

import com.tencent.mobileqq.kandian.biz.video.PlayableItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IRIJSurpriseVideoService
  extends QRouteApi
{
  public abstract void handleDislikeWindowDissMiss();
  
  public abstract void handleDislikeWindowShow();
  
  public abstract boolean handleSearchResult(PlayableItem paramPlayableItem);
  
  public abstract void setDisLikeListener(IRIJSurpriseVideoService.DisLikeEvent paramDisLikeEvent);
  
  public abstract void setVideoSearchCallback(IRIJSurpriseVideoService.VideoSearchCallback paramVideoSearchCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJSurpriseVideoService
 * JD-Core Version:    0.7.0.1
 */