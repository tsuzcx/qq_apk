package com.tencent.mobileqq.cmshow.crossengine;

import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/CEResourceService$Companion;", "", "()V", "SCRIPT_NAME_PREFIX", "", "SCRIPT_NAME_SUFFIX", "SCRIPT_RELATIVE_PATH", "TAG_PRE", "toAbsolutePath", "", "toRelativePath", "toScriptName", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CEResourceService$Companion
{
  private final String a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cmshow_script_");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("_ce.js");
    localObject = ((StringBuilder)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "StringBuilder().apply(builderAction).toString()");
    return localObject;
  }
  
  private final String b(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Contents/JS/");
    ((StringBuilder)localObject).append(CEResourceService.a.a(paramInt));
    localObject = ((StringBuilder)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "StringBuilder().apply(builderAction).toString()");
    return localObject;
  }
  
  private final String c(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ApolloConstant.j);
    ((StringBuilder)localObject).append(CEResourceService.a.b(paramInt));
    localObject = ((StringBuilder)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "StringBuilder().apply(builderAction).toString()");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CEResourceService.Companion
 * JD-Core Version:    0.7.0.1
 */