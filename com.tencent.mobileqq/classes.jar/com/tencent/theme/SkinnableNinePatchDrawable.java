package com.tencent.theme;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;

public class SkinnableNinePatchDrawable
  extends Drawable
{
  private static final boolean a = true;
  private SkinnableNinePatchDrawable.a b;
  private NinePatch c;
  private Rect d;
  private boolean e;
  private int f = 160;
  private int g;
  private int h;
  
  SkinnableNinePatchDrawable() {}
  
  public SkinnableNinePatchDrawable(Resources paramResources, Bitmap paramBitmap, byte[] paramArrayOfByte, Rect paramRect, String paramString)
  {
    this(new SkinnableNinePatchDrawable.a(new NinePatch(paramBitmap, paramArrayOfByte, paramString), paramBitmap, paramRect), paramResources);
    this.b.q = this.f;
  }
  
  @Deprecated
  public SkinnableNinePatchDrawable(Bitmap paramBitmap, byte[] paramArrayOfByte, Rect paramRect, String paramString)
  {
    this(new SkinnableNinePatchDrawable.a(new NinePatch(paramBitmap, paramArrayOfByte, paramString), paramBitmap, paramRect), null);
  }
  
  SkinnableNinePatchDrawable(SkinnableNinePatchDrawable.a parama, Resources paramResources)
  {
    a(parama, paramResources);
  }
  
  private void a()
  {
    b();
    if (this.b.k != null)
    {
      localObject = this.b.k;
      this.g = a.a(localObject[0], localObject[2], this.f);
      this.g = a.a(localObject[1], localObject[2], this.f);
      this.d.set(0, 0, 0, 0);
      return;
    }
    int i = this.c.getDensity();
    int j = this.f;
    if (i == j)
    {
      this.g = this.c.getWidth();
      this.h = this.c.getHeight();
      return;
    }
    this.g = a.a(this.c.getWidth(), i, j);
    this.h = a.a(this.c.getHeight(), i, j);
    Rect localRect1 = this.d;
    Rect localRect2 = this.b.m;
    Object localObject = localRect1;
    if (localRect1 == localRect2)
    {
      localObject = new Rect(localRect2);
      this.d = ((Rect)localObject);
    }
    ((Rect)localObject).left = a.a(localRect2.left, i, j);
    ((Rect)localObject).top = a.a(localRect2.top, i, j);
    ((Rect)localObject).right = a.a(localRect2.right, i, j);
    ((Rect)localObject).bottom = a.a(localRect2.bottom, i, j);
  }
  
  private void a(SkinnableNinePatchDrawable.a parama, Resources paramResources)
  {
    this.b = parama;
    this.c = parama.l;
    this.d = parama.m;
    if (paramResources != null) {}
    for (int i = paramResources.getDisplayMetrics().densityDpi;; i = parama.q)
    {
      this.f = i;
      if (true != parama.o) {
        setDither(parama.o);
      }
      if (this.c != null) {
        a();
      }
      return;
    }
  }
  
  private void b()
  {
    if (this.c != this.b.l)
    {
      this.c = this.b.l;
      this.d = this.b.m;
      if (this.b.k != null)
      {
        localObject = this.b.k;
        this.g = a.a(localObject[0], localObject[2], this.f);
        this.g = a.a(localObject[1], localObject[2], this.f);
        this.d.set(0, 0, 0, 0);
      }
    }
    else
    {
      return;
    }
    int i = this.c.getDensity();
    int j = this.f;
    if (i == j)
    {
      this.g = this.c.getWidth();
      this.h = this.c.getHeight();
      return;
    }
    this.g = a.a(this.c.getWidth(), i, j);
    this.h = a.a(this.c.getHeight(), i, j);
    Rect localRect1 = this.d;
    Rect localRect2 = this.b.m;
    Object localObject = localRect1;
    if (localRect1 == localRect2)
    {
      localObject = new Rect(localRect2);
      this.d = ((Rect)localObject);
    }
    ((Rect)localObject).left = a.a(localRect2.left, i, j);
    ((Rect)localObject).top = a.a(localRect2.top, i, j);
    ((Rect)localObject).right = a.a(localRect2.right, i, j);
    ((Rect)localObject).bottom = a.a(localRect2.bottom, i, j);
  }
  
  boolean a(Rect paramRect)
  {
    if (this.b.n == null) {
      return false;
    }
    paramRect.set(this.b.n);
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    b();
    if (this.b.k != null) {}
    for (;;)
    {
      return;
      Rect localRect = getBounds();
      try
      {
        this.c.draw(paramCanvas, localRect, this.b.s);
        if (!this.b.j) {
          continue;
        }
        paramCanvas.drawRect(localRect, a.b);
        paramCanvas.drawLine(localRect.left, localRect.top, localRect.right, localRect.bottom, a.a);
        paramCanvas.drawLine(localRect.right, localRect.top, localRect.left, localRect.bottom, a.a);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public Bitmap getBitmap()
  {
    return this.b.r;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.b.p;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    this.b.p = super.getChangingConfigurations();
    return this.b;
  }
  
  public int getIntrinsicHeight()
  {
    b();
    return this.h;
  }
  
  public int getIntrinsicWidth()
  {
    b();
    return this.g;
  }
  
  public int getMinimumHeight()
  {
    b();
    return this.h;
  }
  
  public int getMinimumWidth()
  {
    b();
    return this.g;
  }
  
  public int getOpacity()
  {
    b();
    if ((this.c == null) || (this.c.hasAlpha()) || (this.b.s.getAlpha() < 255)) {
      return -3;
    }
    return -1;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    b();
    paramRect.set(this.d);
    return true;
  }
  
  public Paint getPaint()
  {
    return this.b.s;
  }
  
  public Region getTransparentRegion()
  {
    b();
    if (this.c == null) {
      return null;
    }
    return this.c.getTransparentRegion(getBounds());
  }
  
  public Drawable mutate()
  {
    return this;
  }
  
  public void setAlpha(int paramInt)
  {
    getPaint().setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    getPaint().setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    getPaint().setDither(paramBoolean);
  }
  
  public void setTargetDensity(int paramInt)
  {
    b();
    int i = paramInt;
    if (paramInt == 0) {
      i = 160;
    }
    this.f = i;
    if (this.c != null) {
      a();
    }
  }
  
  public void setTargetDensity(Canvas paramCanvas)
  {
    setTargetDensity(paramCanvas.getDensity());
  }
  
  public void setTargetDensity(DisplayMetrics paramDisplayMetrics)
  {
    b();
    this.f = paramDisplayMetrics.densityDpi;
    if (this.c != null) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.theme.SkinnableNinePatchDrawable
 * JD-Core Version:    0.7.0.1
 */