package com.tencent.mobileqq.utils.palette;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public final class Palette$Builder
{
  @Nullable
  private final List<Palette.Swatch> a;
  @Nullable
  private final Bitmap b;
  private final List<Target> c = new ArrayList();
  private int d = 16;
  private int e = 12544;
  private int f = -1;
  private final List<Palette.Filter> g = new ArrayList();
  @Nullable
  private Rect h;
  
  public Palette$Builder(@NonNull Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.g.add(Palette.a);
      this.b = paramBitmap;
      this.a = null;
      this.c.add(Target.a);
      this.c.add(Target.b);
      this.c.add(Target.c);
      this.c.add(Target.d);
      this.c.add(Target.e);
      this.c.add(Target.f);
      return;
    }
    throw new IllegalArgumentException("Bitmap is not valid");
  }
  
  private int[] a(Bitmap paramBitmap)
  {
    int j = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    int[] arrayOfInt = new int[j * i];
    paramBitmap.getPixels(arrayOfInt, 0, j, 0, 0, j, i);
    paramBitmap = this.h;
    if (paramBitmap == null) {
      return arrayOfInt;
    }
    int k = paramBitmap.width();
    int m = this.h.height();
    paramBitmap = new int[k * m];
    i = 0;
    while (i < m)
    {
      System.arraycopy(arrayOfInt, (this.h.top + i) * j + this.h.left, paramBitmap, i * k, k);
      i += 1;
    }
    return paramBitmap;
  }
  
  private Bitmap b(Bitmap paramBitmap)
  {
    int i = this.e;
    double d2 = -1.0D;
    int j;
    double d1;
    if (i > 0)
    {
      i = paramBitmap.getWidth() * paramBitmap.getHeight();
      j = this.e;
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
      if (this.f > 0)
      {
        i = Math.max(paramBitmap.getWidth(), paramBitmap.getHeight());
        j = this.f;
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
  
  @NonNull
  public Palette a()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      Bitmap localBitmap = b((Bitmap)localObject);
      localObject = this.h;
      if ((localBitmap != this.b) && (localObject != null))
      {
        double d1 = localBitmap.getWidth();
        double d2 = this.b.getWidth();
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
      int i = this.d;
      if (this.g.isEmpty())
      {
        localObject = null;
      }
      else
      {
        localObject = this.g;
        localObject = (Palette.Filter[])((List)localObject).toArray(new Palette.Filter[((List)localObject).size()]);
      }
      localObject = new ColorCutQuantizer(arrayOfInt, i, (Palette.Filter[])localObject);
      if (localBitmap != this.b) {
        localBitmap.recycle();
      }
      localObject = ((ColorCutQuantizer)localObject).a();
    }
    else
    {
      localObject = this.a;
      if (localObject == null) {
        break label314;
      }
    }
    localObject = new Palette((List)localObject, this.c);
    ((Palette)localObject).b();
    return localObject;
    label314:
    throw new AssertionError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.palette.Palette.Builder
 * JD-Core Version:    0.7.0.1
 */