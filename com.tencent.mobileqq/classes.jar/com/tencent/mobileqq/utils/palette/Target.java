package com.tencent.mobileqq.utils.palette;

import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;

public final class Target
{
  @NonNull
  public static final Target a = new Target();
  @NonNull
  public static final Target b;
  @NonNull
  public static final Target c;
  @NonNull
  public static final Target d;
  @NonNull
  public static final Target e;
  @NonNull
  public static final Target f;
  final float[] g = new float[3];
  final float[] h = new float[3];
  final float[] i = new float[3];
  boolean j = true;
  
  static
  {
    c(a);
    d(a);
    b = new Target();
    b(b);
    d(b);
    c = new Target();
    a(c);
    d(c);
    d = new Target();
    c(d);
    e(d);
    e = new Target();
    b(e);
    e(e);
    f = new Target();
    a(f);
    e(f);
  }
  
  Target()
  {
    a(this.g);
    a(this.h);
    l();
  }
  
  private static void a(Target paramTarget)
  {
    paramTarget = paramTarget.h;
    paramTarget[1] = 0.26F;
    paramTarget[2] = 0.45F;
  }
  
  private static void a(float[] paramArrayOfFloat)
  {
    paramArrayOfFloat[0] = 0.0F;
    paramArrayOfFloat[1] = 0.5F;
    paramArrayOfFloat[2] = 1.0F;
  }
  
  private static void b(Target paramTarget)
  {
    paramTarget = paramTarget.h;
    paramTarget[0] = 0.3F;
    paramTarget[1] = 0.5F;
    paramTarget[2] = 0.7F;
  }
  
  private static void c(Target paramTarget)
  {
    paramTarget = paramTarget.h;
    paramTarget[0] = 0.55F;
    paramTarget[1] = 0.74F;
  }
  
  private static void d(Target paramTarget)
  {
    paramTarget = paramTarget.g;
    paramTarget[0] = 0.35F;
    paramTarget[1] = 1.0F;
  }
  
  private static void e(Target paramTarget)
  {
    paramTarget = paramTarget.g;
    paramTarget[1] = 0.3F;
    paramTarget[2] = 0.4F;
  }
  
  private void l()
  {
    float[] arrayOfFloat = this.i;
    arrayOfFloat[0] = 0.24F;
    arrayOfFloat[1] = 0.52F;
    arrayOfFloat[2] = 0.24F;
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float a()
  {
    return this.g[0];
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float b()
  {
    return this.g[1];
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float c()
  {
    return this.g[2];
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float d()
  {
    return this.h[0];
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float e()
  {
    return this.h[1];
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float f()
  {
    return this.h[2];
  }
  
  public float g()
  {
    return this.i[0];
  }
  
  public float h()
  {
    return this.i[1];
  }
  
  public float i()
  {
    return this.i[2];
  }
  
  public boolean j()
  {
    return this.j;
  }
  
  void k()
  {
    int n = this.i.length;
    int m = 0;
    int k = 0;
    float f2;
    for (float f1 = 0.0F; k < n; f1 = f2)
    {
      float f3 = this.i[k];
      f2 = f1;
      if (f3 > 0.0F) {
        f2 = f1 + f3;
      }
      k += 1;
    }
    if (f1 != 0.0F)
    {
      n = this.i.length;
      k = m;
      while (k < n)
      {
        float[] arrayOfFloat = this.i;
        if (arrayOfFloat[k] > 0.0F) {
          arrayOfFloat[k] /= f1;
        }
        k += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.palette.Target
 * JD-Core Version:    0.7.0.1
 */