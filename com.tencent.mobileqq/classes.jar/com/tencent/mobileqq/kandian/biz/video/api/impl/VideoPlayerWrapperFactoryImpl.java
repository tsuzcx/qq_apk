package com.tencent.mobileqq.kandian.biz.video.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPlayerWrapperFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/VideoPlayerWrapperFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoPlayerWrapperFactory;", "()V", "createPlayer", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IVideoPlayerWrapper;", "context", "Landroid/content/Context;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoPlayerWrapperFactoryImpl
  implements IVideoPlayerWrapperFactory
{
  @NotNull
  public IVideoPlayerWrapper createPlayer(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return (IVideoPlayerWrapper)new VideoPlayerWrapper(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.impl.VideoPlayerWrapperFactoryImpl
 * JD-Core Version:    0.7.0.1
 */