package com.tencent.xaction.gldrawable;

import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.openapi.api.IPublicDecorDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/gldrawable/XAGLDrawable;", "Lcom/tencent/xaction/api/IDrawable;", "()V", "decor", "Lcom/tencent/xaction/openapi/api/IPublicDecorDrawable;", "getDecor", "setDecor", "", "decorDrawable", "XAGLDrawable_release"}, k=1, mv={1, 1, 16})
public final class XAGLDrawable
  implements IDrawable
{
  private IPublicDecorDrawable a;
  
  @Nullable
  public IPublicDecorDrawable getDecor()
  {
    return this.a;
  }
  
  public void setDecor(@NotNull IPublicDecorDrawable paramIPublicDecorDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramIPublicDecorDrawable, "decorDrawable");
    this.a = paramIPublicDecorDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.gldrawable.XAGLDrawable
 * JD-Core Version:    0.7.0.1
 */