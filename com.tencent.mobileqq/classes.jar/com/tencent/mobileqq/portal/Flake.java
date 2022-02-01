package com.tencent.mobileqq.portal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.Random;

public class Flake
{
  private static Random l = new Random();
  public float a;
  public float b;
  public float c = 0.0F;
  public float d = 0.0F;
  public int e;
  public int f;
  public Bitmap g;
  public float h;
  public float i;
  public float j;
  public int k;
  
  public static Flake a(float paramFloat, Bitmap paramBitmap, int paramInt, Resources paramResources)
  {
    Flake localFlake = new Flake();
    float f1 = paramBitmap.getHeight() / paramBitmap.getWidth();
    localFlake.k = paramInt;
    if (paramInt == 0)
    {
      localFlake.c = (l.nextFloat() * 30.0F - 15.0F);
      localFlake.e = ((int)(AIOUtils.b(25.0F, paramResources) + l.nextFloat() * AIOUtils.b(15.0F, paramResources)));
      localFlake.f = ((int)(localFlake.e * f1));
      localFlake.i = (AIOUtils.b(240.0F, paramResources) + l.nextFloat() * AIOUtils.b(100.0F, paramResources));
      localFlake.b = (l.nextFloat() * -4.0F * localFlake.f);
    }
    else if (paramInt == 2)
    {
      localFlake.c = (l.nextFloat() * 60.0F - 30.0F);
      localFlake.d = (l.nextFloat() * 120.0F - 60.0F);
      localFlake.e = ((int)(AIOUtils.b(25.0F, paramResources) + l.nextFloat() * AIOUtils.b(15.0F, paramResources)));
      localFlake.f = ((int)(localFlake.e * f1));
      localFlake.i = (AIOUtils.b(240.0F, paramResources) + l.nextFloat() * AIOUtils.b(100.0F, paramResources));
      localFlake.b = (l.nextFloat() * -4.0F * localFlake.f);
    }
    else if (paramInt == 3)
    {
      localFlake.c = (l.nextFloat() * 90.0F - 45.0F);
      localFlake.d = ((float)l.nextGaussian() * AIOUtils.b(300.0F, paramResources));
      localFlake.e = ((int)(AIOUtils.b(25.0F, paramResources) + l.nextFloat() * AIOUtils.b(15.0F, paramResources)));
      localFlake.f = ((int)(localFlake.e * f1));
      localFlake.b = (l.nextFloat() * -4.0F * localFlake.f);
      localFlake.i = (AIOUtils.b(180.0F, paramResources) * (float)l.nextGaussian());
      localFlake.h = (AIOUtils.b(150.0F, paramResources) * (float)l.nextGaussian());
      localFlake.j = AIOUtils.b(300.0F, paramResources);
    }
    else
    {
      localFlake.c = 0.0F;
      localFlake.i = (AIOUtils.b(85.0F, paramResources) + l.nextFloat() * AIOUtils.b(55.0F, paramResources));
      localFlake.e = ((int)(AIOUtils.b(30.0F, paramResources) + l.nextFloat() * AIOUtils.b(6.0F, paramResources)));
      localFlake.f = ((int)(localFlake.e * f1));
      localFlake.b = (l.nextFloat() * -6.0F * localFlake.f);
    }
    localFlake.a = (l.nextFloat() * (paramFloat - localFlake.e));
    localFlake.g = paramBitmap;
    return localFlake;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.Flake
 * JD-Core Version:    0.7.0.1
 */