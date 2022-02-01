package com.tencent.mobileqq.utils.palette;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseBooleanArray;
import java.util.List;

public final class Palette
{
  static final Palette.Filter a = new Palette.1();
  private final List<Palette.Swatch> b;
  private final List<Target> c;
  private final SimpleArrayMap<Target, Palette.Swatch> d;
  private final SparseBooleanArray e;
  @Nullable
  private final Palette.Swatch f;
  
  Palette(List<Palette.Swatch> paramList, List<Target> paramList1)
  {
    this.b = paramList;
    this.c = paramList1;
    this.e = new SparseBooleanArray();
    this.d = new SimpleArrayMap();
    this.f = c();
  }
  
  @NonNull
  public static Palette.Builder a(@NonNull Bitmap paramBitmap)
  {
    return new Palette.Builder(paramBitmap);
  }
  
  @Nullable
  private Palette.Swatch a(Target paramTarget)
  {
    Palette.Swatch localSwatch = b(paramTarget);
    if ((localSwatch != null) && (paramTarget.j())) {
      this.e.append(localSwatch.a(), true);
    }
    return localSwatch;
  }
  
  private boolean a(Palette.Swatch paramSwatch, Target paramTarget)
  {
    float[] arrayOfFloat = paramSwatch.b();
    return (arrayOfFloat[1] >= paramTarget.a()) && (arrayOfFloat[1] <= paramTarget.c()) && (arrayOfFloat[2] >= paramTarget.d()) && (arrayOfFloat[2] <= paramTarget.f()) && (!this.e.get(paramSwatch.a()));
  }
  
  private float b(Palette.Swatch paramSwatch, Target paramTarget)
  {
    float[] arrayOfFloat = paramSwatch.b();
    Palette.Swatch localSwatch = this.f;
    int i;
    if (localSwatch != null) {
      i = localSwatch.c();
    } else {
      i = 1;
    }
    float f1 = paramTarget.g();
    float f3 = 0.0F;
    if (f1 > 0.0F)
    {
      f1 = paramTarget.g();
      f1 = (1.0F - Math.abs(arrayOfFloat[1] - paramTarget.b())) * f1;
    }
    else
    {
      f1 = 0.0F;
    }
    float f2;
    if (paramTarget.h() > 0.0F) {
      f2 = paramTarget.h() * (1.0F - Math.abs(arrayOfFloat[2] - paramTarget.e()));
    } else {
      f2 = 0.0F;
    }
    if (paramTarget.i() > 0.0F) {
      f3 = paramTarget.i() * (paramSwatch.c() / i);
    }
    return f1 + f2 + f3;
  }
  
  @Nullable
  private Palette.Swatch b(Target paramTarget)
  {
    int j = this.b.size();
    float f1 = 0.0F;
    Object localObject1 = null;
    int i = 0;
    while (i < j)
    {
      Palette.Swatch localSwatch = (Palette.Swatch)this.b.get(i);
      float f2 = f1;
      Object localObject2 = localObject1;
      if (a(localSwatch, paramTarget))
      {
        float f3 = b(localSwatch, paramTarget);
        if (localObject1 != null)
        {
          f2 = f1;
          localObject2 = localObject1;
          if (f3 <= f1) {}
        }
        else
        {
          localObject2 = localSwatch;
          f2 = f3;
        }
      }
      i += 1;
      f1 = f2;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  @Nullable
  private Palette.Swatch c()
  {
    int m = this.b.size();
    int j = -2147483648;
    Object localObject = null;
    int i = 0;
    while (i < m)
    {
      Palette.Swatch localSwatch = (Palette.Swatch)this.b.get(i);
      int k = j;
      if (localSwatch.c() > j)
      {
        k = localSwatch.c();
        localObject = localSwatch;
      }
      i += 1;
      j = k;
    }
    return localObject;
  }
  
  @Nullable
  public Palette.Swatch a()
  {
    return this.f;
  }
  
  void b()
  {
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      Target localTarget = (Target)this.c.get(i);
      localTarget.k();
      this.d.b(localTarget, a(localTarget));
      i += 1;
    }
    this.e.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.palette.Palette
 * JD-Core Version:    0.7.0.1
 */