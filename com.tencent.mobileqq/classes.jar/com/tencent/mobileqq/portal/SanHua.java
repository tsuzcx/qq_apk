package com.tencent.mobileqq.portal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.HashMap;

public class SanHua
{
  static HashMap<Integer, Bitmap> j = new HashMap();
  int a;
  int b;
  float[] c;
  float d;
  Bitmap e;
  double f;
  float g;
  float h;
  float i;
  
  static SanHua a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, Resources paramResources)
  {
    SanHua localSanHua = new SanHua();
    float f1 = paramBitmap.getHeight() / paramBitmap.getWidth();
    localSanHua.a = ((int)(AIOUtils.b(8.0F, paramResources) + (float)Math.random() * AIOUtils.b(3.0F, paramResources)));
    localSanHua.b = ((int)(f1 * localSanHua.a));
    localSanHua.c = new float[2];
    float[] arrayOfFloat = localSanHua.c;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    localSanHua.d = ((float)Math.random() * AIOUtils.b(90.0F, paramResources) - AIOUtils.b(45.0F, paramResources));
    localSanHua.f = (Math.random() * 2.0D * 3.141592653589793D - 3.141592653589793D);
    if (localSanHua.f >= 0.0D) {
      localSanHua.g = (AIOUtils.b(10.0F, paramResources) + (float)Math.random() * AIOUtils.b(200.0F, paramResources));
    } else {
      localSanHua.g = (-AIOUtils.b(10.0F, paramResources) - (float)Math.random() * AIOUtils.b(200.0F, paramResources));
    }
    double d1 = localSanHua.g;
    double d2 = Math.cos(localSanHua.f);
    Double.isNaN(d1);
    localSanHua.h = ((float)(d1 * d2));
    d1 = localSanHua.g;
    d2 = Math.sin(localSanHua.f);
    Double.isNaN(d1);
    localSanHua.i = ((float)(d1 * d2));
    localSanHua.e = ((Bitmap)j.get(Integer.valueOf(localSanHua.a)));
    if (localSanHua.e == null)
    {
      localSanHua.e = Bitmap.createScaledBitmap(paramBitmap, localSanHua.a, localSanHua.b, true);
      j.put(Integer.valueOf(localSanHua.a), localSanHua.e);
    }
    return localSanHua;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.SanHua
 * JD-Core Version:    0.7.0.1
 */