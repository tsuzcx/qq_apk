package com.tencent.mobileqq.kandian.biz.detail.web.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/detail/web/api/IReadInJoyWebRenderEngine;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "loadLibrary", "", "from", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyWebRenderEngine
  extends QRouteApi
{
  public abstract void loadLibrary(@Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.web.api.IReadInJoyWebRenderEngine
 * JD-Core Version:    0.7.0.1
 */