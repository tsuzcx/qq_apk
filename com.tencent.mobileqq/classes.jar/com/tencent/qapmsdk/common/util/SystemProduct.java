package com.tencent.qapmsdk.common.util;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/SystemProduct;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class SystemProduct
{
  public static final SystemProduct.Companion Companion = new SystemProduct.Companion(null);
  private static final String TAG = "QAPM_common_SystemProduct";
  @NotNull
  private static final Lazy is64Bit$delegate = LazyKt.lazy((Function0)SystemProduct.Companion.is64Bit.2.INSTANCE);
  @NotNull
  private static final Lazy isDalvikVm$delegate = LazyKt.lazy((Function0)SystemProduct.Companion.isDalvikVm.2.INSTANCE);
  @NotNull
  private static final Lazy isX86CPU$delegate = LazyKt.lazy((Function0)SystemProduct.Companion.isX86CPU.2.INSTANCE);
  @NotNull
  private static final Lazy isYunOS$delegate = LazyKt.lazy((Function0)SystemProduct.Companion.isYunOS.2.INSTANCE);
  
  public static final boolean is64Bit()
  {
    return Companion.is64Bit();
  }
  
  public static final boolean isDalvikVm()
  {
    return Companion.isDalvikVm();
  }
  
  public static final boolean isX86CPU()
  {
    return Companion.isX86CPU();
  }
  
  public static final boolean isYunOS()
  {
    return Companion.isYunOS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.SystemProduct
 * JD-Core Version:    0.7.0.1
 */