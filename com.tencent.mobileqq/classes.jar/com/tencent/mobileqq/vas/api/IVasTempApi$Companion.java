package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/api/IVasTempApi$Companion;", "", "()V", "get", "Lcom/tencent/mobileqq/vas/api/IVasTempApi;", "invoke", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public final class IVasTempApi$Companion
{
  @NotNull
  public final IVasTempApi a()
  {
    QRouteApi localQRouteApi = QRoute.api(IVasTempApi.class);
    Intrinsics.checkExpressionValueIsNotNull(localQRouteApi, "QRoute.api(IVasTempApi::class.java)");
    return (IVasTempApi)localQRouteApi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.IVasTempApi.Companion
 * JD-Core Version:    0.7.0.1
 */