package com.tencent.mobileqq.kandian.biz.video.api;

import android.content.Context;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoPlayerWrapperFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createPlayer", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IVideoPlayerWrapper;", "context", "Landroid/content/Context;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoPlayerWrapperFactory
  extends QRouteApi
{
  @NotNull
  public abstract IVideoPlayerWrapper createPlayer(@NotNull Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.IVideoPlayerWrapperFactory
 * JD-Core Version:    0.7.0.1
 */