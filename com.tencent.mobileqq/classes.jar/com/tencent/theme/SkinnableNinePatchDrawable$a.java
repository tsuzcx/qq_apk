package com.tencent.theme;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

final class SkinnableNinePatchDrawable$a
  extends a
{
  NinePatch l;
  Rect m;
  Rect n;
  final boolean o;
  int p;
  int q = 160;
  Bitmap r;
  Paint s = new Paint();
  
  SkinnableNinePatchDrawable$a(NinePatch paramNinePatch, Bitmap paramBitmap, Rect paramRect)
  {
    this(paramNinePatch, paramBitmap, paramRect, true);
  }
  
  SkinnableNinePatchDrawable$a(NinePatch paramNinePatch, Bitmap paramBitmap, Rect paramRect, boolean paramBoolean)
  {
    this.r = paramBitmap;
    this.l = paramNinePatch;
    this.m = paramRect;
    this.o = paramBoolean;
  }
  
  SkinnableNinePatchDrawable$a(a parama)
  {
    this.l = parama.l;
    this.m = parama.m;
    this.o = parama.o;
    this.p = parama.p;
    this.q = parama.q;
  }
  
  public int getChangingConfigurations()
  {
    return this.p;
  }
  
  public Drawable newDrawable()
  {
    return new SkinnableNinePatchDrawable(this, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new SkinnableNinePatchDrawable(this, paramResources);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.theme.SkinnableNinePatchDrawable.a
 * JD-Core Version:    0.7.0.1
 */