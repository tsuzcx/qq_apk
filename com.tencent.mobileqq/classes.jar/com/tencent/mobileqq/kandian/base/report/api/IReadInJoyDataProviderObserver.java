package com.tencent.mobileqq.kandian.base.report.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/report/api/IReadInJoyDataProviderObserver;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "doReport", "", "subAction", "", "detail", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyDataProviderObserver
  extends QRouteApi
{
  public abstract void doReport(@Nullable String paramString1, @Nullable String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.report.api.IReadInJoyDataProviderObserver
 * JD-Core Version:    0.7.0.1
 */