package com.tencent.xaction.openapi.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/openapi/api/IPublicRuleManager;", "", "getRuleValue", "rule", "", "registerRuleLine", "", "key", "value", "XAApi_release"}, k=1, mv={1, 1, 16})
public abstract interface IPublicRuleManager
{
  @Nullable
  public abstract Object getRuleValue(@NotNull String paramString);
  
  public abstract void registerRuleLine(@NotNull String paramString, @NotNull Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.openapi.api.IPublicRuleManager
 * JD-Core Version:    0.7.0.1
 */