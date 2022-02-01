package com.tencent.mobileqq.kandian.glue.viola.so;

import kotlin.Lazy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/so/ViolaSoLoaderManager$Companion;", "", "()V", "SP_KEY_VIOLA_USE_V8", "", "TAG", "VIOLA_LEGACY_SO", "", "VIOLA_USE_V8", "VIOLA_USE_V8_MULTI_INSTANCE", "instance", "Lcom/tencent/mobileqq/kandian/glue/viola/so/ViolaSoLoaderManager;", "getInstance", "()Lcom/tencent/mobileqq/kandian/glue/viola/so/ViolaSoLoaderManager;", "instance$delegate", "Lkotlin/Lazy;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViolaSoLoaderManager$Companion
{
  @NotNull
  public final ViolaSoLoaderManager a()
  {
    Lazy localLazy = ViolaSoLoaderManager.k();
    Companion localCompanion = ViolaSoLoaderManager.a;
    return (ViolaSoLoaderManager)localLazy.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager.Companion
 * JD-Core Version:    0.7.0.1
 */