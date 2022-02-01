package com.tencent.xaction.api;

import com.tencent.xaction.api.data.ViewData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/ICreatRule;", "", "ruleAnimParse", "", "anim", "Lcom/tencent/xaction/api/base/BaseAnim;", "key", "", "value", "ruleParse", "viewData", "Lcom/tencent/xaction/api/data/ViewData;", "XActionCore_release"}, k=1, mv={1, 1, 16})
public abstract interface ICreatRule
{
  public abstract boolean ruleParse(@NotNull ViewData paramViewData, @NotNull String paramString1, @NotNull String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.api.ICreatRule
 * JD-Core Version:    0.7.0.1
 */