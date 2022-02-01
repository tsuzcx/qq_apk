package com.tencent.mobileqq.utils.palette;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Arrays;

public final class Palette$Swatch
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private boolean f;
  private int g;
  private int h;
  @Nullable
  private float[] i;
  
  public Palette$Swatch(@ColorInt int paramInt1, int paramInt2)
  {
    this.a = Color.red(paramInt1);
    this.b = Color.green(paramInt1);
    this.c = Color.blue(paramInt1);
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  private void f()
  {
    if (!this.f)
    {
      int j = ColorUtils.a(-1, this.d, 4.5F);
      int k = ColorUtils.a(-1, this.d, 3.0F);
      if ((j != -1) && (k != -1))
      {
        this.h = ColorUtils.c(-1, j);
        this.g = ColorUtils.c(-1, k);
        this.f = true;
        return;
      }
      int n = ColorUtils.a(-16777216, this.d, 4.5F);
      int m = ColorUtils.a(-16777216, this.d, 3.0F);
      if ((n != -1) && (m != -1))
      {
        this.h = ColorUtils.c(-16777216, n);
        this.g = ColorUtils.c(-16777216, m);
        this.f = true;
        return;
      }
      if (j != -1) {
        j = ColorUtils.c(-1, j);
      } else {
        j = ColorUtils.c(-16777216, n);
      }
      this.h = j;
      if (k != -1) {
        j = ColorUtils.c(-1, k);
      } else {
        j = ColorUtils.c(-16777216, m);
      }
      this.g = j;
      this.f = true;
    }
  }
  
  @ColorInt
  public int a()
  {
    return this.d;
  }
  
  @NonNull
  public float[] b()
  {
    if (this.i == null) {
      this.i = new float[3];
    }
    ColorUtils.a(this.a, this.b, this.c, this.i);
    return this.i;
  }
  
  public int c()
  {
    return this.e;
  }
  
  @ColorInt
  public int d()
  {
    f();
    return this.g;
  }
  
  @ColorInt
  public int e()
  {
    f();
    return this.h;
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
    localStringBuilder.append(Arrays.toString(b()));
    localStringBuilder.append(']');
    localStringBuilder.append(" [Population: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(']');
    localStringBuilder.append(" [Title Text: #");
    localStringBuilder.append(Integer.toHexString(d()));
    localStringBuilder.append(']');
    localStringBuilder.append(" [Body Text: #");
    localStringBuilder.append(Integer.toHexString(e()));
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.palette.Palette.Swatch
 * JD-Core Version:    0.7.0.1
 */