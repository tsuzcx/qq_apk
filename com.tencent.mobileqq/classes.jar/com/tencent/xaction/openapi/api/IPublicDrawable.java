package com.tencent.xaction.openapi.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/openapi/api/IPublicDrawable;", "", "getDecor", "Lcom/tencent/xaction/openapi/api/IPublicDecorDrawable;", "setDecor", "", "decorDrawable", "XAApi_release"}, k=1, mv={1, 1, 16})
public abstract interface IPublicDrawable
{
  @Nullable
  public abstract IPublicDecorDrawable getDecor();
  
  public abstract void setDecor(@NotNull IPublicDecorDrawable paramIPublicDecorDrawable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.openapi.api.IPublicDrawable
 * JD-Core Version:    0.7.0.1
 */