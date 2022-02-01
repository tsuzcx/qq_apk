package com.tencent.tkd.topicsdk.framework;

import com.tencent.tkd.topicsdk.interfaces.IBizConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/BizConfig;", "", "()V", "mBizConfigImpl", "Lcom/tencent/tkd/topicsdk/interfaces/IBizConfig;", "init", "", "bizConfig", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public final class BizConfig
{
  public static final BizConfig a = new BizConfig();
  private static IBizConfig b;
  
  public final void a(@NotNull IBizConfig paramIBizConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramIBizConfig, "bizConfig");
    b = paramIBizConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.BizConfig
 * JD-Core Version:    0.7.0.1
 */