package com.tencent.mobileqq.vas.adv.base.support;

import com.tencent.mobileqq.vas.adv.base.support.gdt.VasAdvGdtImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/vas/adv/base/support/gdt/VasAdvGdtImpl;", "invoke"}, k=3, mv={1, 1, 16})
final class VasAdvInterfaceBinder$Companion$gdt$2
  extends Lambda
  implements Function0<VasAdvGdtImpl>
{
  public static final 2 INSTANCE = new 2();
  
  VasAdvInterfaceBinder$Companion$gdt$2()
  {
    super(0);
  }
  
  @NotNull
  public final VasAdvGdtImpl invoke()
  {
    return new VasAdvGdtImpl(VasAdvInterfaceBinder.Companion.a(VasAdvInterfaceBinder.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.support.VasAdvInterfaceBinder.Companion.gdt.2
 * JD-Core Version:    0.7.0.1
 */