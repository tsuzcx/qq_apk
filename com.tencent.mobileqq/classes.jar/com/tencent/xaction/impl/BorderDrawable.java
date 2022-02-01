package com.tencent.xaction.impl;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.tencent.xaction.api.style.BorderStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/impl/BorderDrawable;", "Landroid/graphics/drawable/Drawable;", "border", "Lcom/tencent/xaction/api/style/BorderStyle;", "(Lcom/tencent/xaction/api/style/BorderStyle;)V", "borderStyle", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class BorderDrawable
  extends Drawable
{
  private final BorderStyle a;
  
  public BorderDrawable(@NotNull BorderStyle paramBorderStyle)
  {
    this.a = paramBorderStyle;
  }
  
  public void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    this.a.draw(paramCanvas);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.impl.BorderDrawable
 * JD-Core Version:    0.7.0.1
 */