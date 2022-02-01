package com.tencent.mobileqq.kandian.biz.video.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoExtractFrameManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "onEnterBackground", "", "onEnterForeground", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoExtractFrameManager
  extends QRouteApi
{
  public abstract void onEnterBackground();
  
  public abstract void onEnterForeground();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.IVideoExtractFrameManager
 * JD-Core Version:    0.7.0.1
 */