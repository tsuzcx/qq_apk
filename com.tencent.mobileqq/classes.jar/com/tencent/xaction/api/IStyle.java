package com.tencent.xaction.api;

import com.tencent.xaction.api.data.ViewData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/IStyle;", "", "getStyle", "Lcom/tencent/xaction/api/data/ViewData;", "setStyle", "", "viewData", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public abstract interface IStyle
{
  @Nullable
  public abstract ViewData getStyle();
  
  public abstract void setStyle(@NotNull ViewData paramViewData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.IStyle
 * JD-Core Version:    0.7.0.1
 */