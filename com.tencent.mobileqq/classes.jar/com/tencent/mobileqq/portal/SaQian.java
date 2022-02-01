package com.tencent.mobileqq.portal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class SaQian
{
  public int a;
  public int b;
  public float[] c;
  public float d;
  public Bitmap e;
  public double f;
  public float g;
  public float h;
  public float i;
  public int j;
  public int k;
  public float l;
  public long m;
  
  public static Bitmap a(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    return paramBitmap;
  }
  
  public static SaQian a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, int paramInt, Resources paramResources)
  {
    SaQian localSaQian = new SaQian();
    localSaQian.k = paramInt;
    float f1 = paramBitmap.getHeight() / paramBitmap.getWidth();
    if (paramInt == 0) {
      localSaQian.a = AIOUtils.b(20.0F, paramResources);
    } else {
      localSaQian.a = AIOUtils.b(14.0F, paramResources);
    }
    localSaQian.b = ((int)(f1 * localSaQian.a));
    localSaQian.c = new float[2];
    float[] arrayOfFloat = localSaQian.c;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    localSaQian.d = ((float)Math.random() * AIOUtils.b(18.0F, paramResources) - AIOUtils.b(9.0F, paramResources));
    localSaQian.f = (Math.random() * 3.141592653589793D / 6.0D + 2.879793265790644D);
    localSaQian.g = (AIOUtils.b(40.0F, paramResources) + (float)Math.random() * AIOUtils.b(50.0F, paramResources));
    double d1 = localSaQian.g;
    double d2 = Math.cos(localSaQian.f);
    Double.isNaN(d1);
    localSaQian.h = ((float)(d1 * d2));
    d1 = localSaQian.g;
    d2 = Math.sin(localSaQian.f);
    Double.isNaN(d1);
    localSaQian.i = ((float)(d1 * d2));
    localSaQian.j = 256;
    localSaQian.e = paramBitmap;
    return localSaQian;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.SaQian
 * JD-Core Version:    0.7.0.1
 */