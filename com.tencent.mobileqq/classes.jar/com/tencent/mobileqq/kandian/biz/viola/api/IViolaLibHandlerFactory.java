package com.tencent.mobileqq.kandian.biz.viola.api;

import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaLibHandlerFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createViolaLibHandler", "Lcom/tencent/mobileqq/earlydownload/handler/EarlyHandler;", "app", "Lmqq/app/AppRuntime;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IViolaLibHandlerFactory
  extends QRouteApi
{
  @NotNull
  public abstract EarlyHandler createViolaLibHandler(@NotNull AppRuntime paramAppRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.IViolaLibHandlerFactory
 * JD-Core Version:    0.7.0.1
 */