package com.tencent.qapmsdk.common.util;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/SystemProduct;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class SystemProduct
{
  public static final SystemProduct.Companion Companion = new SystemProduct.Companion(null);
  private static final String TAG = "QAPM_common_SystemProduct";
  
  @JvmStatic
  public static final boolean is64Bit()
  {
    return Companion.is64Bit();
  }
  
  @JvmStatic
  public static final boolean isX86CPU()
  {
    return Companion.isX86CPU();
  }
  
  @JvmStatic
  public static final boolean isYunOS()
  {
    return Companion.isYunOS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.SystemProduct
 * JD-Core Version:    0.7.0.1
 */