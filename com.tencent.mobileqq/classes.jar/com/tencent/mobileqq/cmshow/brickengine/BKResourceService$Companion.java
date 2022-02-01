package com.tencent.mobileqq.cmshow.brickengine;

import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/brickengine/BKResourceService$Companion;", "", "()V", "SCRIPT_NAME_PREFIX", "", "SCRIPT_NAME_SUFFIX", "TAG_PRE", "toScriptName", "", "toScriptPath", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
final class BKResourceService$Companion
{
  private final String a(int paramInt)
  {
    Object localObject = new StringBuilder();
    BKResourceService.c();
    ((StringBuilder)localObject).append("cmshow_script_");
    ((StringBuilder)localObject).append(paramInt);
    BKResourceService.c();
    ((StringBuilder)localObject).append(".js");
    localObject = ((StringBuilder)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "StringBuilder().apply(builderAction).toString()");
    return localObject;
  }
  
  private final String b(int paramInt)
  {
    Object localObject = new StringBuilder();
    String str = ApolloConstant.U;
    ((StringBuilder)localObject).append(ApolloConstant.V);
    ((StringBuilder)localObject).append(BKResourceService.c().a(paramInt));
    localObject = ((StringBuilder)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "StringBuilder().apply(builderAction).toString()");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.BKResourceService.Companion
 * JD-Core Version:    0.7.0.1
 */