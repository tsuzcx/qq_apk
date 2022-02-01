package com.tencent.tkd.topicsdk.widget.ucrop;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/ucrop/FastBitmapDrawable;", "Landroid/graphics/drawable/Drawable;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "mIntrinsicHeight", "", "mIntrinsicWidth", "<set-?>", "Landroid/graphics/Paint;", "paint", "getPaint", "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getIntrinsicHeight", "getIntrinsicWidth", "getMinimumHeight", "getMinimumWidth", "getOpacity", "setAlpha", "alpha", "setAntiAlias", "value", "", "setColorFilter", "cf", "Landroid/graphics/ColorFilter;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class FastBitmapDrawable
  extends Drawable
{
  private int jdField_a_of_type_Int;
  @Nullable
  private final Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  @NotNull
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private int b;
  
  public FastBitmapDrawable(@Nullable Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    paramBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (paramBitmap != null) {}
    for (int i = paramBitmap.getWidth();; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      paramBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      i = j;
      if (paramBitmap != null) {
        i = paramBitmap.getHeight();
      }
      this.b = i;
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      return;
    }
  }
  
  @Nullable
  public final Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.b;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int getMinimumHeight()
  {
    return this.b;
  }
  
  public int getMinimumWidth()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.ucrop.FastBitmapDrawable
 * JD-Core Version:    0.7.0.1
 */