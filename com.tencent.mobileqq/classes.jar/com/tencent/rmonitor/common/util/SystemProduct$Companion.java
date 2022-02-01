package com.tencent.rmonitor.common.util;

import kotlin.Lazy;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/util/SystemProduct$Companion;", "", "()V", "TAG", "", "is64Bit", "", "is64Bit$annotations", "()Z", "is64Bit$delegate", "Lkotlin/Lazy;", "isDalvikVm", "isDalvikVm$annotations", "isDalvikVm$delegate", "isX86CPU", "isX86CPU$annotations", "isX86CPU$delegate", "isYunOS", "isYunOS$annotations", "isYunOS$delegate", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class SystemProduct$Companion
{
  public final boolean a()
  {
    Lazy localLazy = SystemProduct.a();
    Object localObject = SystemProduct.a;
    localObject = a[1];
    return ((Boolean)localLazy.getValue()).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.SystemProduct.Companion
 * JD-Core Version:    0.7.0.1
 */