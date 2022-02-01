package com.tencent.mobileqq.utils.palette;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public final class Palette$Builder
{
  private int jdField_a_of_type_Int = 16;
  @Nullable
  private final Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  @Nullable
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  @Nullable
  private final List<Palette.Swatch> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int = 12544;
  private final List<Target> jdField_b_of_type_JavaUtilList = new ArrayList();
  private int jdField_c_of_type_Int = -1;
  private final List<Palette.Filter> jdField_c_of_type_JavaUtilList = new ArrayList();
  
  public Palette$Builder(@NonNull Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.jdField_c_of_type_JavaUtilList.add(Palette.a);
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      this.jdField_a_of_type_JavaUtilList = null;
      this.jdField_b_of_type_JavaUtilList.add(Target.a);
      this.jdField_b_of_type_JavaUtilList.add(Target.b);
      this.jdField_b_of_type_JavaUtilList.add(Target.c);
      this.jdField_b_of_type_JavaUtilList.add(Target.d);
      this.jdField_b_of_type_JavaUtilList.add(Target.e);
      this.jdField_b_of_type_JavaUtilList.add(Target.f);
      return;
    }
    throw new IllegalArgumentException("Bitmap is not valid");
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    int i = this.jdField_b_of_type_Int;
    double d2 = -1.0D;
    int j;
    double d1;
    if (i > 0)
    {
      i = paramBitmap.getWidth() * paramBitmap.getHeight();
      j = this.jdField_b_of_type_Int;
      d1 = d2;
      if (i > j)
      {
        d1 = j;
        d2 = i;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 = Math.sqrt(d1 / d2);
      }
    }
    else
    {
      d1 = d2;
      if (this.jdField_c_of_type_Int > 0)
      {
        i = Math.max(paramBitmap.getWidth(), paramBitmap.getHeight());
        j = this.jdField_c_of_type_Int;
        d1 = d2;
        if (i > j)
        {
          d1 = j;
          d2 = i;
          Double.isNaN(d1);
          Double.isNaN(d2);
          d1 /= d2;
        }
      }
    }
    if (d1 <= 0.0D) {
      return paramBitmap;
    }
    d2 = paramBitmap.getWidth();
    Double.isNaN(d2);
    i = (int)Math.ceil(d2 * d1);
    d2 = paramBitmap.getHeight();
    Double.isNaN(d2);
    return Bitmap.createScaledBitmap(paramBitmap, i, (int)Math.ceil(d2 * d1), false);
  }
  
  private int[] a(Bitmap paramBitmap)
  {
    int j = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    int[] arrayOfInt = new int[j * i];
    paramBitmap.getPixels(arrayOfInt, 0, j, 0, 0, j, i);
    paramBitmap = this.jdField_a_of_type_AndroidGraphicsRect;
    if (paramBitmap == null) {
      return arrayOfInt;
    }
    int k = paramBitmap.width();
    int m = this.jdField_a_of_type_AndroidGraphicsRect.height();
    paramBitmap = new int[k * m];
    i = 0;
    while (i < m)
    {
      System.arraycopy(arrayOfInt, (this.jdField_a_of_type_AndroidGraphicsRect.top + i) * j + this.jdField_a_of_type_AndroidGraphicsRect.left, paramBitmap, i * k, k);
      i += 1;
    }
    return paramBitmap;
  }
  
  @NonNull
  public Palette a()
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject != null)
    {
      Bitmap localBitmap = a((Bitmap)localObject);
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      if ((localBitmap != this.jdField_a_of_type_AndroidGraphicsBitmap) && (localObject != null))
      {
        double d1 = localBitmap.getWidth();
        double d2 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        d2 = ((Rect)localObject).left;
        Double.isNaN(d2);
        ((Rect)localObject).left = ((int)Math.floor(d2 * d1));
        d2 = ((Rect)localObject).top;
        Double.isNaN(d2);
        ((Rect)localObject).top = ((int)Math.floor(d2 * d1));
        d2 = ((Rect)localObject).right;
        Double.isNaN(d2);
        ((Rect)localObject).right = Math.min((int)Math.ceil(d2 * d1), localBitmap.getWidth());
        d2 = ((Rect)localObject).bottom;
        Double.isNaN(d2);
        ((Rect)localObject).bottom = Math.min((int)Math.ceil(d2 * d1), localBitmap.getHeight());
      }
      int[] arrayOfInt = a(localBitmap);
      int i = this.jdField_a_of_type_Int;
      if (this.jdField_c_of_type_JavaUtilList.isEmpty())
      {
        localObject = null;
      }
      else
      {
        localObject = this.jdField_c_of_type_JavaUtilList;
        localObject = (Palette.Filter[])((List)localObject).toArray(new Palette.Filter[((List)localObject).size()]);
      }
      localObject = new ColorCutQuantizer(arrayOfInt, i, (Palette.Filter[])localObject);
      if (localBitmap != this.jdField_a_of_type_AndroidGraphicsBitmap) {
        localBitmap.recycle();
      }
      localObject = ((ColorCutQuantizer)localObject).a();
    }
    else
    {
      localObject = this.jdField_a_of_type_JavaUtilList;
      if (localObject == null) {
        break label314;
      }
    }
    localObject = new Palette((List)localObject, this.jdField_b_of_type_JavaUtilList);
    ((Palette)localObject).a();
    return localObject;
    label314:
    throw new AssertionError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.palette.Palette.Builder
 * JD-Core Version:    0.7.0.1
 */