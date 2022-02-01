package com.tencent.mobileqq.kandian.biz.viola.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaLibHandlerFactory;
import com.tencent.mobileqq.kandian.glue.viola.ViolaLibHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/impl/ViolaLibHandlerFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaLibHandlerFactory;", "()V", "createViolaLibHandler", "Lcom/tencent/mobileqq/earlydownload/handler/EarlyHandler;", "app", "Lmqq/app/AppRuntime;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViolaLibHandlerFactoryImpl
  implements IViolaLibHandlerFactory
{
  @NotNull
  public EarlyHandler createViolaLibHandler(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    return (EarlyHandler)new ViolaLibHandler((QQAppInterface)paramAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.impl.ViolaLibHandlerFactoryImpl
 * JD-Core Version:    0.7.0.1
 */