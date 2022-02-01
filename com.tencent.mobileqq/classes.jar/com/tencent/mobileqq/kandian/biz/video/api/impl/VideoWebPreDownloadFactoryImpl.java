package com.tencent.mobileqq.kandian.biz.video.api.impl;

import com.tencent.mobileqq.kandian.biz.video.api.IVideoWebPreDownload;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoWebPreDownloadFactory;
import com.tencent.mobileqq.kandian.glue.video.VideoWebPreDownload;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/VideoWebPreDownloadFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoWebPreDownloadFactory;", "()V", "create", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoWebPreDownload;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoWebPreDownloadFactoryImpl
  implements IVideoWebPreDownloadFactory
{
  @NotNull
  public IVideoWebPreDownload create()
  {
    return (IVideoWebPreDownload)new VideoWebPreDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.impl.VideoWebPreDownloadFactoryImpl
 * JD-Core Version:    0.7.0.1
 */