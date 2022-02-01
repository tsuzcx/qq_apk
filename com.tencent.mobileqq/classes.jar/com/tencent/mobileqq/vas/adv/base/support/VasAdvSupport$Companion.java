package com.tencent.mobileqq.vas.adv.base.support;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/base/support/VasAdvSupport$Companion;", "", "()V", "instance", "Lcom/tencent/mobileqq/vas/adv/base/support/VasAdvSupport;", "getInstance", "()Lcom/tencent/mobileqq/vas/adv/base/support/VasAdvSupport;", "instance$delegate", "Lkotlin/Lazy;", "get", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdvSupport$Companion
{
  private final VasAdvSupport b()
  {
    Lazy localLazy = VasAdvSupport.g();
    Companion localCompanion = VasAdvSupport.a;
    return (VasAdvSupport)localLazy.getValue();
  }
  
  @JvmStatic
  @NotNull
  public final VasAdvSupport a()
  {
    return ((Companion)this).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport.Companion
 * JD-Core Version:    0.7.0.1
 */