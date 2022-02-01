package com.tencent.xaction.drawable.partical;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.openapi.api.IPublicDecorDrawable;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/drawable/partical/ParticalDrawable;", "Landroid/graphics/drawable/Drawable;", "Lcom/tencent/xaction/api/IDrawable;", "()V", "decor", "Lcom/tencent/xaction/openapi/api/IPublicDecorDrawable;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getDecor", "getOpacity", "", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setDecor", "decorDrawable", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class ParticalDrawable
  extends Drawable
  implements IDrawable
{
  private IPublicDecorDrawable a;
  
  public void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    IPublicDecorDrawable localIPublicDecorDrawable = this.a;
    if ((localIPublicDecorDrawable instanceof IParticalDecor))
    {
      if (localIPublicDecorDrawable != null)
      {
        ((IParticalDecor)localIPublicDecorDrawable).a(paramCanvas);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.drawable.partical.IParticalDecor");
    }
  }
  
  @Nullable
  public IPublicDecorDrawable getDecor()
  {
    return this.a;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
  
  public void setDecor(@NotNull IPublicDecorDrawable paramIPublicDecorDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramIPublicDecorDrawable, "decorDrawable");
    this.a = paramIPublicDecorDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.drawable.partical.ParticalDrawable
 * JD-Core Version:    0.7.0.1
 */