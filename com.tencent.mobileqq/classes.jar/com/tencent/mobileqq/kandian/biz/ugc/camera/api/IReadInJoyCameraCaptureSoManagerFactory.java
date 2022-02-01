package com.tencent.mobileqq.kandian.biz.ugc.camera.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/camera/api/IReadInJoyCameraCaptureSoManagerFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createManager", "Lcom/tencent/mobileqq/kandian/biz/ugc/camera/api/IReadInJoyCameraCaptureSoManager;", "context", "Landroid/content/Context;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyCameraCaptureSoManagerFactory
  extends QRouteApi
{
  @NotNull
  public abstract IReadInJoyCameraCaptureSoManager createManager(@NotNull Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.camera.api.IReadInJoyCameraCaptureSoManagerFactory
 * JD-Core Version:    0.7.0.1
 */