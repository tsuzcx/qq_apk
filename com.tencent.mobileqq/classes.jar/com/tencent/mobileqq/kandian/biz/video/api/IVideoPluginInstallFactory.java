package com.tencent.mobileqq.kandian.biz.video.api;

import com.tencent.mobileqq.kandian.base.video.plugin.api.IVideoPluginInstall;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoPluginInstallFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "create", "Lcom/tencent/mobileqq/kandian/base/video/plugin/api/IVideoPluginInstall;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoPluginInstallFactory
  extends QRouteApi
{
  @NotNull
  public abstract IVideoPluginInstall create();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.IVideoPluginInstallFactory
 * JD-Core Version:    0.7.0.1
 */