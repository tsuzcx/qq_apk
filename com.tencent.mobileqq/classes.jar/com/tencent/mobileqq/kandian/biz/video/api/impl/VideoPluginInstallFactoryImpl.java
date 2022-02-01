package com.tencent.mobileqq.kandian.biz.video.api.impl;

import com.tencent.mobileqq.kandian.base.video.plugin.VideoPluginInstall;
import com.tencent.mobileqq.kandian.base.video.plugin.api.IVideoPluginInstall;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPluginInstallFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/VideoPluginInstallFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoPluginInstallFactory;", "()V", "create", "Lcom/tencent/mobileqq/kandian/base/video/plugin/api/IVideoPluginInstall;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoPluginInstallFactoryImpl
  implements IVideoPluginInstallFactory
{
  @NotNull
  public IVideoPluginInstall create()
  {
    return (IVideoPluginInstall)new VideoPluginInstall();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.impl.VideoPluginInstallFactoryImpl
 * JD-Core Version:    0.7.0.1
 */