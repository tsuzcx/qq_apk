package com.tencent.mobileqq.kandian.biz.video.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsWeiShiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/VideoFeedsWeiShiUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoFeedsWeiShiUtils;", "()V", "gotoWeishiDownload", "", "context", "Landroid/content/Context;", "videoType", "", "isWeishi", "", "type", "openWeishi", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsWeiShiUtilsImpl
  implements IVideoFeedsWeiShiUtils
{
  public void gotoWeishiDownload(@Nullable Context paramContext, @Nullable String paramString)
  {
    VideoFeedsWeiShiUtils.b(paramContext, paramString);
  }
  
  public boolean isWeishi(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "type");
    return Intrinsics.areEqual("video_type_videopublic", paramString);
  }
  
  public void openWeishi(@Nullable Context paramContext, @Nullable String paramString)
  {
    VideoFeedsWeiShiUtils.a(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.impl.VideoFeedsWeiShiUtilsImpl
 * JD-Core Version:    0.7.0.1
 */