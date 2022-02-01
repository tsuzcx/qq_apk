package com.tencent.mobileqq.kandian.biz.video.playfeeds.api.impl;

import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAccessibilityHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAccessibilityHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAccessibilityHelperFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/impl/VideoFeedsAccessibilityHelperFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsAccessibilityHelperFactory;", "()V", "get", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsAccessibilityHelper;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsAccessibilityHelperFactoryImpl
  implements IVideoFeedsAccessibilityHelperFactory
{
  @NotNull
  public IVideoFeedsAccessibilityHelper get()
  {
    return (IVideoFeedsAccessibilityHelper)VideoFeedsAccessibilityHelper.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.api.impl.VideoFeedsAccessibilityHelperFactoryImpl
 * JD-Core Version:    0.7.0.1
 */