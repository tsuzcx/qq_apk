package com.tencent.mobileqq.kandian.biz.video.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/IReadInJoyPlayerFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createPlayer", "Lcom/tencent/mobileqq/kandian/biz/video/api/IReadInJoyPlayer;", "sceneType", "", "token", "", "autoAttachVideoView", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyPlayerFactory
  extends QRouteApi
{
  @NotNull
  public abstract IReadInJoyPlayer createPlayer(int paramInt);
  
  @NotNull
  public abstract IReadInJoyPlayer createPlayer(int paramInt, @Nullable String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayerFactory
 * JD-Core Version:    0.7.0.1
 */