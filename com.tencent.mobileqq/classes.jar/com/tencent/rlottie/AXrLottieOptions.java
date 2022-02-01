package com.tencent.rlottie;

import android.text.TextUtils;

public class AXrLottieOptions
{
  String a;
  int b = -100;
  int c = -100;
  boolean d = true;
  boolean e = false;
  boolean f = true;
  int g = -100;
  int h = -100;
  int i = -100;
  int j = -100;
  AXrLottieDrawable.OnFrameChangedListener k = null;
  AXrLottieDrawable.OnFrameRenderListener l = null;
  AXrLottieDrawable.OnLottieLoaderListener m = null;
  boolean n;
  float o = -1.0F;
  
  public AXrLottieOptions()
  {
    a(AXrLottie.a());
  }
  
  public AXrLottieDrawable a()
  {
    throw new RuntimeException("Can't build an AXrLottieDrawable from AXrLottieOptions!");
  }
  
  public AXrLottieOptions a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.b = paramInt1;
      this.c = paramInt2;
      return this;
    }
    throw new RuntimeException("lottie width and height must be > 0");
  }
  
  public AXrLottieOptions a(AXrLottieOptions paramAXrLottieOptions)
  {
    if (paramAXrLottieOptions != null)
    {
      if (paramAXrLottieOptions == this) {
        return this;
      }
      this.a = paramAXrLottieOptions.a;
      this.b = paramAXrLottieOptions.b;
      this.c = paramAXrLottieOptions.c;
      this.d = paramAXrLottieOptions.d;
      this.e = paramAXrLottieOptions.e;
      this.f = paramAXrLottieOptions.f;
      this.g = paramAXrLottieOptions.g;
      this.h = paramAXrLottieOptions.h;
      this.i = paramAXrLottieOptions.i;
      this.j = paramAXrLottieOptions.j;
      this.k = paramAXrLottieOptions.k;
      this.l = paramAXrLottieOptions.l;
      this.m = paramAXrLottieOptions.m;
      this.n = paramAXrLottieOptions.n;
      this.o = paramAXrLottieOptions.o;
    }
    return this;
  }
  
  public AXrLottieOptions a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (!TextUtils.isEmpty(paramString)) {
        return this;
      }
      throw new NullPointerException("lottie name (cacheName) can not be null!");
    }
    this.a = paramString;
    return this;
  }
  
  public AXrLottieOptions a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public AXrLottieOptions b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rlottie.AXrLottieOptions
 * JD-Core Version:    0.7.0.1
 */