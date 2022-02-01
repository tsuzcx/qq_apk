package com.tencent.mobileqq.kandian.glue.businesshandler.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/businesshandler/api/IRIJHandlerNameApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getBarrageHandlerName", "", "getDanmakuHandlerName", "getReadInJoyHandlerName", "getReadInJoySkinHandlerName", "getVideoColumnSubscribeHandlerCmd", "getVideoColumnSubscribeHandlerName", "getVideoFeedsLikeAnimateHandlerName", "getVideoPlayCountHandlerCmd", "getVideoPlayCountHandlerName", "getVideoPlayDianZanHandler", "getVideoPlayRecommendHandlerCmd", "getVideoPlayRecommendHandlerName", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJHandlerNameApi
  extends QRouteApi
{
  @NotNull
  public abstract String getBarrageHandlerName();
  
  @NotNull
  public abstract String getDanmakuHandlerName();
  
  @NotNull
  public abstract String getReadInJoyHandlerName();
  
  @NotNull
  public abstract String getReadInJoySkinHandlerName();
  
  @NotNull
  public abstract String getVideoColumnSubscribeHandlerCmd();
  
  @NotNull
  public abstract String getVideoColumnSubscribeHandlerName();
  
  @NotNull
  public abstract String getVideoFeedsLikeAnimateHandlerName();
  
  @NotNull
  public abstract String getVideoPlayCountHandlerCmd();
  
  @NotNull
  public abstract String getVideoPlayCountHandlerName();
  
  @NotNull
  public abstract String getVideoPlayDianZanHandler();
  
  @NotNull
  public abstract String getVideoPlayRecommendHandlerCmd();
  
  @NotNull
  public abstract String getVideoPlayRecommendHandlerName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.api.IRIJHandlerNameApi
 * JD-Core Version:    0.7.0.1
 */