package com.tencent.xaction.manager;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/manager/RuleManager$Companion;", "", "()V", "TAG", "", "globalRuleNameMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getGlobalRuleNameMap", "()Ljava/util/HashMap;", "invoke", "", "engine", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "ruleName", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "method", "T", "t", "Lkotlin/reflect/KClass;", "self", "(Lcom/tencent/xaction/openapi/api/IXAEngine;Ljava/lang/String;Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "registerGlobalRuleLine", "value", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class RuleManager$Companion
{
  @NotNull
  public final HashMap<String, Object> a()
  {
    return RuleManager.access$getGlobalRuleNameMap$cp();
  }
  
  public final void a(@NotNull String paramString, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "ruleName");
    Intrinsics.checkParameterIsNotNull(paramObject, "value");
    ((Map)((Companion)this).a()).put(paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.manager.RuleManager.Companion
 * JD-Core Version:    0.7.0.1
 */