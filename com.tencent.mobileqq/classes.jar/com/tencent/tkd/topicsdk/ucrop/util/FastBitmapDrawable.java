package com.tencent.tkd.topicsdk.ucrop.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/ucrop/util/FastBitmapDrawable;", "Landroid/graphics/drawable/Drawable;", "()V", "value", "Landroid/graphics/Bitmap;", "bitmap", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "mAlpha", "", "mHeight", "mPaint", "Landroid/graphics/Paint;", "mWidth", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getAlpha", "getIntrinsicHeight", "getIntrinsicWidth", "getMinimumHeight", "getMinimumWidth", "getOpacity", "setAlpha", "alpha", "setColorFilter", "cf", "Landroid/graphics/ColorFilter;", "setFilterBitmap", "filterBitmap", "", "topicsdk-ucrop_release"}, k=1, mv={1, 1, 16})
public final class FastBitmapDrawable
  extends Drawable
{
  @Nullable
  private Bitmap a;
  private final Paint b = new Paint(2);
  private int c = 255;
  private int d;
  private int e;
  
  @Nullable
  public final Bitmap a()
  {
    return this.a;
  }
  
  public final void a(@Nullable Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.d = paramBitmap.getWidth();
      this.e = paramBitmap.getHeight();
    }
    else
    {
      this.e = 0;
      this.d = this.e;
    }
    this.a = paramBitmap;
  }
  
  public void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Bitmap localBitmap = this.a;
    if ((localBitmap != null) && (localBitmap != null) && (!localBitmap.isRecycled())) {
      paramCanvas.drawBitmap(localBitmap, null, getBounds(), this.b);
    }
  }
  
  public int getAlpha()
  {
    return this.c;
  }
  
  public int getIntrinsicHeight()
  {
    return this.e;
  }
  
  public int getIntrinsicWidth()
  {
    return this.d;
  }
  
  public int getMinimumHeight()
  {
    return this.e;
  }
  
  public int getMinimumWidth()
  {
    return this.d;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    this.c = paramInt;
    this.b.setAlpha(paramInt);
  }
  
  public void setColorFilter(@NotNull ColorFilter paramColorFilter)
  {
    Intrinsics.checkParameterIsNotNull(paramColorFilter, "cf");
    this.b.setColorFilter(paramColorFilter);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.b.setFilterBitmap(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.util.FastBitmapDrawable
 * JD-Core Version:    0.7.0.1
 */