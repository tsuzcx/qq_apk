package com.tencent.mobileqq.kandian.glue.report.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/report/api/IReadInJoySessionManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getSceneSeriesNum", "", "getSceneTraceID", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoySessionManager
  extends QRouteApi
{
  public abstract int getSceneSeriesNum();
  
  @Nullable
  public abstract String getSceneTraceID();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.api.IReadInJoySessionManager
 * JD-Core Version:    0.7.0.1
 */