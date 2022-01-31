package com.tencent.widget;

import amcl;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
public class LayerImageView
  extends ImageView
{
  private int jdField_a_of_type_Int;
  private Bitmap.Config jdField_a_of_type_AndroidGraphicsBitmap$Config;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private boolean jdField_a_of_type_Boolean;
  private amcl[] jdField_a_of_type_ArrayOfAmcl;
  private boolean b;
  
  public LayerImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LayerImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LayerImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_Int = getResources().getDisplayMetrics().densityDpi;
    this.b = false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setBitmaps(Bitmap[] paramArrayOfBitmap, boolean paramBoolean)
  {
    int j = 0;
    if ((paramBoolean) && (this.jdField_a_of_type_ArrayOfAmcl != null))
    {
      amcl[] arrayOfamcl = this.jdField_a_of_type_ArrayOfAmcl;
      int k = arrayOfamcl.length;
      i = 0;
      while (i < k)
      {
        amcl localamcl = arrayOfamcl[i];
        if (amcl.a(localamcl) != null) {
          amcl.a(localamcl).recycle();
        }
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfAmcl = new amcl[paramArrayOfBitmap.length];
    int i = j;
    while (i < paramArrayOfBitmap.length)
    {
      this.jdField_a_of_type_ArrayOfAmcl[i] = new amcl(paramArrayOfBitmap[i], this.jdField_a_of_type_Int, null);
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap$Config == null) || ((amcl.a(this.jdField_a_of_type_ArrayOfAmcl[i]) != null) && (amcl.a(this.jdField_a_of_type_ArrayOfAmcl[i]).ordinal() > this.jdField_a_of_type_AndroidGraphicsBitmap$Config.ordinal()))) {
        this.jdField_a_of_type_AndroidGraphicsBitmap$Config = amcl.a(this.jdField_a_of_type_ArrayOfAmcl[i]);
      }
      i += 1;
    }
    b();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void setLayerBitmap(int paramInt, Bitmap paramBitmap, boolean paramBoolean)
  {
    amcl localamcl = this.jdField_a_of_type_ArrayOfAmcl[paramInt];
    this.jdField_a_of_type_ArrayOfAmcl[paramInt] = new amcl(paramBitmap, this.jdField_a_of_type_Int, null);
    if ((paramBoolean) && (amcl.a(localamcl) != null)) {
      amcl.a(localamcl).recycle();
    }
  }
  
  public void setLayerPadding(int paramInt, Rect paramRect)
  {
    amcl.a(this.jdField_a_of_type_ArrayOfAmcl[paramInt], paramRect);
    b();
  }
  
  public void setLayerPadding(Rect[] paramArrayOfRect)
  {
    if (paramArrayOfRect.length != this.jdField_a_of_type_ArrayOfAmcl.length) {
      throw new IllegalArgumentException("padding must have the same size as input bitmaps");
    }
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfAmcl.length)
    {
      amcl.a(this.jdField_a_of_type_ArrayOfAmcl[i], paramArrayOfRect[i]);
      i += 1;
    }
    b();
  }
  
  public void setLayerVisibility(int paramInt1, int paramInt2)
  {
    amcl.a(this.jdField_a_of_type_ArrayOfAmcl[paramInt1], paramInt2);
    b();
  }
  
  public void setNeedTransparent(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.widget.LayerImageView
 * JD-Core Version:    0.7.0.1
 */