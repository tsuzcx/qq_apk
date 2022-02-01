package com.tencent.qapmsdk.common.util;

import kotlin.Lazy;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/SystemProduct$Companion;", "", "()V", "TAG", "", "is64Bit", "", "is64Bit$annotations", "()Z", "is64Bit$delegate", "Lkotlin/Lazy;", "isDalvikVm", "isDalvikVm$annotations", "isDalvikVm$delegate", "isX86CPU", "isX86CPU$annotations", "isX86CPU$delegate", "isYunOS", "isYunOS$annotations", "isYunOS$delegate", "common_release"}, k=1, mv={1, 1, 15})
public final class SystemProduct$Companion
{
  public final boolean is64Bit()
  {
    Lazy localLazy = SystemProduct.access$is64Bit$cp();
    Object localObject = SystemProduct.Companion;
    localObject = $$delegatedProperties[3];
    return ((Boolean)localLazy.getValue()).booleanValue();
  }
  
  public final boolean isDalvikVm()
  {
    Lazy localLazy = SystemProduct.access$isDalvikVm$cp();
    Object localObject = SystemProduct.Companion;
    localObject = $$delegatedProperties[0];
    return ((Boolean)localLazy.getValue()).booleanValue();
  }
  
  public final boolean isX86CPU()
  {
    Lazy localLazy = SystemProduct.access$isX86CPU$cp();
    Object localObject = SystemProduct.Companion;
    localObject = $$delegatedProperties[1];
    return ((Boolean)localLazy.getValue()).booleanValue();
  }
  
  public final boolean isYunOS()
  {
    Lazy localLazy = SystemProduct.access$isYunOS$cp();
    Object localObject = SystemProduct.Companion;
    localObject = $$delegatedProperties[2];
    return ((Boolean)localLazy.getValue()).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.SystemProduct.Companion
 * JD-Core Version:    0.7.0.1
 */