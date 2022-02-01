package com.tencent.mobileqq.qqgamepub.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;

@QAPI(process={"all"})
public abstract interface IQQGameHippyApi
  extends QRouteApi
{
  public abstract HippyAPIProvider getQQGameHippyAPIProvider();
  
  public abstract void preloadNewQQGamePaHippy();
  
  public abstract void setGetHippysManagerConfig(boolean paramBoolean);
  
  public abstract void setReadyToPreloadHippy(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi
 * JD-Core Version:    0.7.0.1
 */