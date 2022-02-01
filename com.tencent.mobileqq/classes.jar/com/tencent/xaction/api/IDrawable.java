package com.tencent.xaction.api;

import com.tencent.xaction.api.base.DecorDrawable;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/IDrawable;", "", "decor", "Lcom/tencent/xaction/api/base/DecorDrawable;", "getDecor", "()Lcom/tencent/xaction/api/base/DecorDrawable;", "setDecor", "(Lcom/tencent/xaction/api/base/DecorDrawable;)V", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public abstract interface IDrawable
{
  @Nullable
  public abstract DecorDrawable a();
  
  public abstract void a(@Nullable DecorDrawable paramDecorDrawable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.IDrawable
 * JD-Core Version:    0.7.0.1
 */