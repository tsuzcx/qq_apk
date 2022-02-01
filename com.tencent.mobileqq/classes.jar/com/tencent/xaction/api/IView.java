package com.tencent.xaction.api;

import com.tencent.xaction.openapi.api.IPublicView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/IView;", "Lcom/tencent/xaction/openapi/api/IPublicView;", "decor", "Lcom/tencent/xaction/api/IDecorView;", "getDecor", "()Lcom/tencent/xaction/api/IDecorView;", "XActionCore_release"}, k=1, mv={1, 1, 16})
public abstract interface IView
  extends IPublicView
{
  @NotNull
  public abstract IDecorView getDecor();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.api.IView
 * JD-Core Version:    0.7.0.1
 */