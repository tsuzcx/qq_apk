package com.tencent.xaction.api;

import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.base.BaseRule;
import com.tencent.xaction.api.data.ViewData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/IRuleManager;", "", "getRuleValue", "rule", "", "refreshAnimRuleValue", "", "anim", "Lcom/tencent/xaction/api/base/BaseAnim;", "key", "value", "refreshRuleValue", "viewData", "Lcom/tencent/xaction/api/data/ViewData;", "registerGlobalRuleLine", "ruleName", "registerRule", "", "Lcom/tencent/xaction/api/base/BaseRule;", "registerRuleLine", "unregisterRule", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public abstract interface IRuleManager
{
  @Nullable
  public abstract Object a(@NotNull String paramString);
  
  public abstract void a(@NotNull BaseAnim paramBaseAnim, @NotNull String paramString1, @NotNull String paramString2);
  
  public abstract void a(@NotNull ViewData paramViewData, @NotNull String paramString1, @NotNull String paramString2);
  
  public abstract void a(@NotNull String paramString, @NotNull Object paramObject);
  
  public abstract boolean a(@NotNull BaseRule paramBaseRule);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.IRuleManager
 * JD-Core Version:    0.7.0.1
 */