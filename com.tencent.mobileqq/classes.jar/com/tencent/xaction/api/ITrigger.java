package com.tencent.xaction.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/ITrigger;", "", "action", "", "view", "Landroid/view/View;", "addAnim", "baseAnim", "Lcom/tencent/xaction/api/base/BaseAnim;", "monitor", "data", "Lcom/tencent/xaction/api/data/ViewData;", "iview", "Lcom/tencent/xaction/api/IView;", "notifyState", "", "key", "", "value", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public abstract interface ITrigger
{
  public abstract boolean notifyState(@NotNull String paramString, @NotNull Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.ITrigger
 * JD-Core Version:    0.7.0.1
 */