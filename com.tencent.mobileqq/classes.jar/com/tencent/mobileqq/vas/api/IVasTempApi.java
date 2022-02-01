package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/api/IVasTempApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "initPagSo", "", "requestPagDownload", "", "block", "Lkotlin/Function0;", "Companion", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVasTempApi
  extends QRouteApi
{
  public static final IVasTempApi.Companion Companion = IVasTempApi.Companion.a;
  
  public abstract boolean initPagSo();
  
  public abstract void requestPagDownload(@NotNull Function0<Unit> paramFunction0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.IVasTempApi
 * JD-Core Version:    0.7.0.1
 */