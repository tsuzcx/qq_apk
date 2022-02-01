package com.tencent.mobileqq.vas.adv.base.support;

import com.tencent.mobileqq.vas.adv.base.support.app.VasAdvAppInterface;
import com.tencent.mobileqq.vas.adv.base.support.gdt.VasAdvGdtInterface;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/base/support/VasAdvInterfaceBinder$Companion;", "", "()V", "app", "Lcom/tencent/mobileqq/vas/adv/base/support/app/VasAdvAppInterface;", "getApp", "()Lcom/tencent/mobileqq/vas/adv/base/support/app/VasAdvAppInterface;", "app$delegate", "Lkotlin/Lazy;", "gdt", "Lcom/tencent/mobileqq/vas/adv/base/support/gdt/VasAdvGdtInterface;", "getGdt", "()Lcom/tencent/mobileqq/vas/adv/base/support/gdt/VasAdvGdtInterface;", "gdt$delegate", "appInterface", "gdtInterface", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdvInterfaceBinder$Companion
{
  private final VasAdvAppInterface b()
  {
    Lazy localLazy = VasAdvInterfaceBinder.a();
    Companion localCompanion = VasAdvInterfaceBinder.a;
    return (VasAdvAppInterface)localLazy.getValue();
  }
  
  private final VasAdvGdtInterface b()
  {
    Lazy localLazy = VasAdvInterfaceBinder.b();
    Companion localCompanion = VasAdvInterfaceBinder.a;
    return (VasAdvGdtInterface)localLazy.getValue();
  }
  
  @JvmStatic
  @NotNull
  public final VasAdvAppInterface a()
  {
    return ((Companion)this).b();
  }
  
  @JvmStatic
  @NotNull
  public final VasAdvGdtInterface a()
  {
    return ((Companion)this).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.support.VasAdvInterfaceBinder.Companion
 * JD-Core Version:    0.7.0.1
 */