package com.tencent.mobileqq.kandian.biz.viola.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/IReadInJoyWebRenderSoLoader;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getSoLibPath", "", "unzip", "", "filepath", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyWebRenderSoLoader
  extends QRouteApi
{
  @Nullable
  public abstract String getSoLibPath();
  
  public abstract boolean unzip(@Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.IReadInJoyWebRenderSoLoader
 * JD-Core Version:    0.7.0.1
 */