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
  private int jdField_a_of_type_Int = 255;
  @Nullable
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(2);
  private int b;
  private int c;
  
  @Nullable
  public final Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public final void a(@Nullable Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.b = paramBitmap.getWidth();
      this.c = paramBitmap.getHeight();
    }
    else
    {
      this.c = 0;
      this.b = this.c;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localBitmap != null) && (localBitmap != null) && (!localBitmap.isRecycled())) {
      paramCanvas.drawBitmap(localBitmap, null, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public int getAlpha()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int getIntrinsicHeight()
  {
    return this.c;
  }
  
  public int getIntrinsicWidth()
  {
    return this.b;
  }
  
  public int getMinimumHeight()
  {
    return this.c;
  }
  
  public int getMinimumWidth()
  {
    return this.b;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(@NotNull ColorFilter paramColorFilter)
  {
    Intrinsics.checkParameterIsNotNull(paramColorFilter, "cf");
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.util.FastBitmapDrawable
 * JD-Core Version:    0.7.0.1
 */