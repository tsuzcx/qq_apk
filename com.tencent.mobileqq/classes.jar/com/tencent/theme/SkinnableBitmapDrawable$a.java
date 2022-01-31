package com.tencent.theme;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

final class SkinnableBitmapDrawable$a
  extends a
{
  Bitmap l;
  int m;
  int n = 119;
  Paint o = new Paint(6);
  Shader.TileMode p;
  Shader.TileMode q;
  int r = 160;
  boolean s = false;
  
  SkinnableBitmapDrawable$a(Bitmap paramBitmap)
  {
    this.l = paramBitmap;
  }
  
  SkinnableBitmapDrawable$a(a parama)
  {
    this(parama.l);
    this.m = parama.m;
    this.n = parama.n;
    this.p = parama.p;
    this.q = parama.q;
    this.r = parama.r;
    this.o = new Paint(parama.o);
  }
  
  public int getChangingConfigurations()
  {
    return this.m;
  }
  
  public Drawable newDrawable()
  {
    return new SkinnableBitmapDrawable(this, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new SkinnableBitmapDrawable(this, paramResources);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.theme.SkinnableBitmapDrawable.a
 * JD-Core Version:    0.7.0.1
 */