package com.tencent.theme;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

final class SkinnableBitmapDrawable$a
  extends BaseConstantState
{
  Bitmap a;
  int b;
  int c = 119;
  Paint d = new Paint(6);
  Shader.TileMode e;
  Shader.TileMode f;
  int g = 160;
  boolean h = false;
  
  SkinnableBitmapDrawable$a(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
  }
  
  SkinnableBitmapDrawable$a(a parama)
  {
    this(parama.a);
    this.b = parama.b;
    this.c = parama.c;
    this.e = parama.e;
    this.f = parama.f;
    this.g = parama.g;
    this.d = new Paint(parama.d);
  }
  
  public int getChangingConfigurations()
  {
    return this.b;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.theme.SkinnableBitmapDrawable.a
 * JD-Core Version:    0.7.0.1
 */