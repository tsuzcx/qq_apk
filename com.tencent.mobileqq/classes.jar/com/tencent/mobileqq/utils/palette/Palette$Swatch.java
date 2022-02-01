package com.tencent.mobileqq.utils.palette;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Arrays;

public final class Palette$Swatch
{
  private final int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  @Nullable
  private float[] jdField_a_of_type_ArrayOfFloat;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private int f;
  private int g;
  
  public Palette$Swatch(@ColorInt int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = Color.red(paramInt1);
    this.b = Color.green(paramInt1);
    this.c = Color.blue(paramInt1);
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  private void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      int i = ColorUtils.a(-1, this.d, 4.5F);
      int j = ColorUtils.a(-1, this.d, 3.0F);
      if ((i != -1) && (j != -1))
      {
        this.g = ColorUtils.b(-1, i);
        this.f = ColorUtils.b(-1, j);
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      int m = ColorUtils.a(-16777216, this.d, 4.5F);
      int k = ColorUtils.a(-16777216, this.d, 3.0F);
      if ((m != -1) && (k != -1))
      {
        this.g = ColorUtils.b(-16777216, m);
        this.f = ColorUtils.b(-16777216, k);
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      if (i != -1) {
        i = ColorUtils.b(-1, i);
      } else {
        i = ColorUtils.b(-16777216, m);
      }
      this.g = i;
      if (j != -1) {
        i = ColorUtils.b(-1, j);
      } else {
        i = ColorUtils.b(-16777216, k);
      }
      this.f = i;
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  @ColorInt
  public int a()
  {
    return this.d;
  }
  
  @NonNull
  public float[] a()
  {
    if (this.jdField_a_of_type_ArrayOfFloat == null) {
      this.jdField_a_of_type_ArrayOfFloat = new float[3];
    }
    ColorUtils.a(this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_ArrayOfFloat);
    return this.jdField_a_of_type_ArrayOfFloat;
  }
  
  public int b()
  {
    return this.e;
  }
  
  @ColorInt
  public int c()
  {
    a();
    return this.f;
  }
  
  @ColorInt
  public int d()
  {
    a();
    return this.g;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (Swatch)paramObject;
      return (this.e == paramObject.e) && (this.d == paramObject.d);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.d * 31 + this.e;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(getClass().getSimpleName());
    localStringBuilder.append(" [RGB: #");
    localStringBuilder.append(Integer.toHexString(a()));
    localStringBuilder.append(']');
    localStringBuilder.append(" [HSL: ");
    localStringBuilder.append(Arrays.toString(a()));
    localStringBuilder.append(']');
    localStringBuilder.append(" [Population: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(']');
    localStringBuilder.append(" [Title Text: #");
    localStringBuilder.append(Integer.toHexString(c()));
    localStringBuilder.append(']');
    localStringBuilder.append(" [Body Text: #");
    localStringBuilder.append(Integer.toHexString(d()));
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.palette.Palette.Swatch
 * JD-Core Version:    0.7.0.1
 */