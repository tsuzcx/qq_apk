package com.tencent.theme;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

final class SkinnableNinePatchDrawable$a
  extends BaseConstantState
{
  NinePatch a;
  Rect b;
  Rect c;
  final boolean d;
  int e;
  int f = 160;
  Bitmap g;
  Paint h = new Paint();
  
  SkinnableNinePatchDrawable$a(NinePatch paramNinePatch, Bitmap paramBitmap, Rect paramRect)
  {
    this(paramNinePatch, paramBitmap, paramRect, true);
  }
  
  SkinnableNinePatchDrawable$a(NinePatch paramNinePatch, Bitmap paramBitmap, Rect paramRect, boolean paramBoolean)
  {
    this.g = paramBitmap;
    this.a = paramNinePatch;
    this.b = paramRect;
    this.d = paramBoolean;
  }
  
  SkinnableNinePatchDrawable$a(a parama)
  {
    this.a = parama.a;
    this.b = parama.b;
    this.d = parama.d;
    this.e = parama.e;
    this.f = parama.f;
  }
  
  public int getChangingConfigurations()
  {
    return this.e;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.theme.SkinnableNinePatchDrawable.a
 * JD-Core Version:    0.7.0.1
 */