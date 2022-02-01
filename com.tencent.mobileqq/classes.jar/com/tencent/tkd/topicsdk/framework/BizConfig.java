package com.tencent.tkd.topicsdk.framework;

import com.tencent.tkd.topicsdk.interfaces.IBizConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/BizConfig;", "", "()V", "mBizConfigImpl", "Lcom/tencent/tkd/topicsdk/interfaces/IBizConfig;", "init", "", "bizConfig", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public final class BizConfig
{
  public static final BizConfig a;
  private static IBizConfig a;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkFrameworkBizConfig = new BizConfig();
  }
  
  public final void a(@NotNull IBizConfig paramIBizConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramIBizConfig, "bizConfig");
    jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIBizConfig = paramIBizConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.BizConfig
 * JD-Core Version:    0.7.0.1
 */