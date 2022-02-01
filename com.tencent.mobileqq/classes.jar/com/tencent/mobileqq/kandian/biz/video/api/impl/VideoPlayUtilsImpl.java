package com.tencent.mobileqq.kandian.biz.video.api.impl;

import com.tencent.mobileqq.kandian.base.video.VideoPlayUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPlayUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.net.URL;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/VideoPlayUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoPlayUtils;", "()V", "calculateVideoPartSize", "", "timeSec", "", "duration", "fileSize", "getThumbUrl", "Ljava/net/URL;", "thumbPath", "", "makeErrorText", "model", "what", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoPlayUtilsImpl
  implements IVideoPlayUtils
{
  public long calculateVideoPartSize(int paramInt1, int paramInt2, int paramInt3)
  {
    return VideoPlayUtils.a(paramInt1, paramInt2, paramInt3);
  }
  
  @Nullable
  public URL getThumbUrl(@Nullable String paramString)
  {
    return ShortVideoUtils.getThumbUrl(paramString);
  }
  
  @Nullable
  public String makeErrorText(int paramInt1, int paramInt2)
  {
    return VideoPlayUtils.b(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.impl.VideoPlayUtilsImpl
 * JD-Core Version:    0.7.0.1
 */