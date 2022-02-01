package com.tencent.mobileqq.kandian.biz.video.playfeeds.api.impl;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsResourceLoader;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsResourceLoader;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/impl/VideoFeedsResourceLoaderImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsResourceLoader;", "()V", "inflate", "Landroid/view/View;", "resid", "", "faultTolerant", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsResourceLoaderImpl
  implements IVideoFeedsResourceLoader
{
  @Nullable
  public View inflate(int paramInt, boolean paramBoolean, @Nullable ViewGroup.LayoutParams paramLayoutParams)
  {
    return VideoFeedsResourceLoader.a(paramInt, paramBoolean, paramLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.api.impl.VideoFeedsResourceLoaderImpl
 * JD-Core Version:    0.7.0.1
 */