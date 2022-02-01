package com.tencent.rmonitor.common.util;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/util/SystemProduct;", "", "()V", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class SystemProduct
{
  public static final SystemProduct.Companion a = new SystemProduct.Companion(null);
  @NotNull
  private static final Lazy b = LazyKt.lazy((Function0)SystemProduct.Companion.isDalvikVm.2.INSTANCE);
  @NotNull
  private static final Lazy c = LazyKt.lazy((Function0)SystemProduct.Companion.isX86CPU.2.INSTANCE);
  @NotNull
  private static final Lazy d = LazyKt.lazy((Function0)SystemProduct.Companion.isYunOS.2.INSTANCE);
  @NotNull
  private static final Lazy e = LazyKt.lazy((Function0)SystemProduct.Companion.is64Bit.2.INSTANCE);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.SystemProduct
 * JD-Core Version:    0.7.0.1
 */