package com.tencent.mobileqq.kandian.biz.viola.api.impl;

import com.tencent.mobileqq.kandian.biz.viola.api.IBridgeModule;
import com.tencent.mobileqq.kandian.biz.viola.api.IBridgeModuleProxyFactory;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/impl/BridgeModuleProxyFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IBridgeModuleProxyFactory;", "()V", "create", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IBridgeModule;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BridgeModuleProxyFactoryImpl
  implements IBridgeModuleProxyFactory
{
  @NotNull
  public IBridgeModule create()
  {
    return (IBridgeModule)new BridgeModule();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.impl.BridgeModuleProxyFactoryImpl
 * JD-Core Version:    0.7.0.1
 */