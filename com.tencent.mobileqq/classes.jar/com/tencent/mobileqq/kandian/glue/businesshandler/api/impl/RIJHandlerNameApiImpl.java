package com.tencent.mobileqq.kandian.glue.businesshandler.api.impl;

import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHandler;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoColumnSubscribeHandler;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLikeAnimateHandler;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoPlayCountHandler;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoPlayRecommendHandler;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinHandler;
import com.tencent.mobileqq.kandian.biz.video.danmaku.model.RIJDanmakuHandler;
import com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageHandler;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IRIJHandlerNameApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/businesshandler/api/impl/RIJHandlerNameApiImpl;", "Lcom/tencent/mobileqq/kandian/glue/businesshandler/api/IRIJHandlerNameApi;", "()V", "getBarrageHandlerName", "", "getDanmakuHandlerName", "getReadInJoyHandlerName", "getReadInJoySkinHandlerName", "getVideoColumnSubscribeHandlerCmd", "getVideoColumnSubscribeHandlerName", "getVideoFeedsLikeAnimateHandlerName", "getVideoPlayCountHandlerCmd", "getVideoPlayCountHandlerName", "getVideoPlayRecommendHandlerCmd", "getVideoPlayRecommendHandlerName", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJHandlerNameApiImpl
  implements IRIJHandlerNameApi
{
  @NotNull
  public String getBarrageHandlerName()
  {
    String str = BarrageHandler.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(str, "BarrageHandler::class.java.name");
    return str;
  }
  
  @NotNull
  public String getDanmakuHandlerName()
  {
    String str = RIJDanmakuHandler.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(str, "RIJDanmakuHandler::class.java.name");
    return str;
  }
  
  @NotNull
  public String getReadInJoyHandlerName()
  {
    String str = ReadInJoyHandler.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(str, "ReadInJoyHandler::class.java.name");
    return str;
  }
  
  @NotNull
  public String getReadInJoySkinHandlerName()
  {
    String str = ReadInJoySkinHandler.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(str, "ReadInJoySkinHandler::class.java.name");
    return str;
  }
  
  @NotNull
  public String getVideoColumnSubscribeHandlerCmd()
  {
    return "OidbSvc.0xd4b";
  }
  
  @NotNull
  public String getVideoColumnSubscribeHandlerName()
  {
    String str = VideoColumnSubscribeHandler.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(str, "VideoColumnSubscribeHandler::class.java.name");
    return str;
  }
  
  @NotNull
  public String getVideoFeedsLikeAnimateHandlerName()
  {
    String str = VideoFeedsLikeAnimateHandler.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(str, "VideoFeedsLikeAnimateHandler::class.java.name");
    return str;
  }
  
  @NotNull
  public String getVideoPlayCountHandlerCmd()
  {
    return "OidbSvc.0x6a6";
  }
  
  @NotNull
  public String getVideoPlayCountHandlerName()
  {
    String str = VideoPlayCountHandler.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(str, "VideoPlayCountHandler::class.java.name");
    return str;
  }
  
  @NotNull
  public String getVideoPlayRecommendHandlerCmd()
  {
    return "OidbSvc.0x6cf";
  }
  
  @NotNull
  public String getVideoPlayRecommendHandlerName()
  {
    String str = VideoPlayRecommendHandler.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(str, "VideoPlayRecommendHandler::class.java.name");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.api.impl.RIJHandlerNameApiImpl
 * JD-Core Version:    0.7.0.1
 */