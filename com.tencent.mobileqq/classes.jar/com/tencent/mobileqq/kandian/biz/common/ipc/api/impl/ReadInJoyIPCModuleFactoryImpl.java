package com.tencent.mobileqq.kandian.biz.common.ipc.api.impl;

import com.tencent.mobileqq.kandian.biz.common.ReadInJoyIPCModule;
import com.tencent.mobileqq.kandian.biz.common.ipc.api.IReadInJoyIPCModuleFactory;
import com.tencent.mobileqq.qipc.QIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/ipc/api/impl/ReadInJoyIPCModuleFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/ipc/api/IReadInJoyIPCModuleFactory;", "()V", "getReadInJoyIPCModule", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyIPCModuleFactoryImpl
  implements IReadInJoyIPCModuleFactory
{
  @NotNull
  public QIPCModule getReadInJoyIPCModule()
  {
    ReadInJoyIPCModule localReadInJoyIPCModule = ReadInJoyIPCModule.a();
    Intrinsics.checkExpressionValueIsNotNull(localReadInJoyIPCModule, "ReadInJoyIPCModule.getInstance()");
    return (QIPCModule)localReadInJoyIPCModule;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ipc.api.impl.ReadInJoyIPCModuleFactoryImpl
 * JD-Core Version:    0.7.0.1
 */