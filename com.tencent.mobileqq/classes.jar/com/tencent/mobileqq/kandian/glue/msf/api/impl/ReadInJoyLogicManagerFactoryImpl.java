package com.tencent.mobileqq.kandian.glue.msf.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicManagerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/msf/api/impl/ReadInJoyLogicManagerFactoryImpl;", "Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyLogicManagerFactory;", "()V", "createReadInJoyLogicManager", "Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyLogicManager;", "app", "Lcom/tencent/common/app/AppInterface;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyLogicManagerFactoryImpl
  implements IReadInJoyLogicManagerFactory
{
  @NotNull
  public IReadInJoyLogicManager createReadInJoyLogicManager(@NotNull AppInterface paramAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "app");
    return (IReadInJoyLogicManager)new ReadInJoyLogicManager(paramAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.msf.api.impl.ReadInJoyLogicManagerFactoryImpl
 * JD-Core Version:    0.7.0.1
 */