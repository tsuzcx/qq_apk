package com.tencent.xaction.api;

import com.tencent.xaction.api.base.BaseRule;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.openapi.api.IPublicRuleManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/IRuleManager;", "Lcom/tencent/xaction/openapi/api/IPublicRuleManager;", "refreshAnimRuleValue", "", "anim", "", "key", "", "value", "refreshRuleValue", "viewData", "Lcom/tencent/xaction/api/data/ViewData;", "registerRule", "", "rule", "Lcom/tencent/xaction/api/base/BaseRule;", "unregisterRule", "XActionCore_release"}, k=1, mv={1, 1, 16})
public abstract interface IRuleManager
  extends IPublicRuleManager
{
  public abstract void refreshAnimRuleValue(@NotNull Object paramObject, @NotNull String paramString1, @NotNull String paramString2);
  
  public abstract void refreshRuleValue(@NotNull ViewData paramViewData, @NotNull String paramString1, @NotNull String paramString2);
  
  public abstract boolean registerRule(@NotNull BaseRule paramBaseRule);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.api.IRuleManager
 * JD-Core Version:    0.7.0.1
 */