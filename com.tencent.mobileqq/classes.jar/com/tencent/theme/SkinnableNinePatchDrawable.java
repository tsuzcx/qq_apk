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
  private a b;
  private NinePatch c;
  private Rect d;
  private Paint e;
  private boolean f;
  private int g = 160;
  private int h;
  private int i;
  
  SkinnableNinePatchDrawable() {}
  
  public SkinnableNinePatchDrawable(Resources paramResources, Bitmap paramBitmap, byte[] paramArrayOfByte, Rect paramRect, String paramString)
  {
    this(new a(new NinePatch(paramBitmap, paramArrayOfByte, paramString), paramBitmap, paramRect), paramResources);
    this.b.q = this.g;
  }
  
  @Deprecated
  public SkinnableNinePatchDrawable(Bitmap paramBitmap, byte[] paramArrayOfByte, Rect paramRect, String paramString)
  {
    this(new a(new NinePatch(paramBitmap, paramArrayOfByte, paramString), paramBitmap, paramRect), null);
  }
  
  SkinnableNinePatchDrawable(a parama, Resources paramResources)
  {
    a(parama, paramResources);
  }
  
  private void a()
  {
    b();
    if (this.b.k != null)
    {
      localObject = this.b.k;
      this.h = b.a(localObject[0], localObject[2], this.g);
      this.h = b.a(localObject[1], localObject[2], this.g);
      this.d.set(0, 0, 0, 0);
      return;
    }
    int j = this.c.getDensity();
    int k = this.g;
    if (j == k)
    {
      this.h = this.c.getWidth();
      this.i = this.c.getHeight();
      return;
    }
    this.h = b.a(this.c.getWidth(), j, k);
    this.i = b.a(this.c.getHeight(), j, k);
    Rect localRect1 = this.d;
    Rect localRect2 = this.b.m;
    Object localObject = localRect1;
    if (localRect1 == localRect2)
    {
      localObject = new Rect(localRect2);
      this.d = ((Rect)localObject);
    }
    ((Rect)localObject).left = b.a(localRect2.left, j, k);
    ((Rect)localObject).top = b.a(localRect2.top, j, k);
    ((Rect)localObject).right = b.a(localRect2.right, j, k);
    ((Rect)localObject).bottom = b.a(localRect2.bottom, j, k);
  }
  
  private void a(a parama, Resources paramResources)
  {
    this.b = parama;
    this.c = parama.l;
    this.d = parama.m;
    if (paramResources != null) {}
    for (int j = paramResources.getDisplayMetrics().densityDpi;; j = parama.q)
    {
      this.g = j;
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
        this.h = b.a(localObject[0], localObject[2], this.g);
        this.h = b.a(localObject[1], localObject[2], this.g);
        this.d.set(0, 0, 0, 0);
      }
    }
    else
    {
      return;
    }
    int j = this.c.getDensity();
    int k = this.g;
    if (j == k)
    {
      this.h = this.c.getWidth();
      this.i = this.c.getHeight();
      return;
    }
    this.h = b.a(this.c.getWidth(), j, k);
    this.i = b.a(this.c.getHeight(), j, k);
    Rect localRect1 = this.d;
    Rect localRect2 = this.b.m;
    Object localObject = localRect1;
    if (localRect1 == localRect2)
    {
      localObject = new Rect(localRect2);
      this.d = ((Rect)localObject);
    }
    ((Rect)localObject).left = b.a(localRect2.left, j, k);
    ((Rect)localObject).top = b.a(localRect2.top, j, k);
    ((Rect)localObject).right = b.a(localRect2.right, j, k);
    ((Rect)localObject).bottom = b.a(localRect2.bottom, j, k);
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
        this.c.draw(paramCanvas, localRect, this.e);
        if (!this.b.j) {
          continue;
        }
        paramCanvas.drawRect(localRect, b.b);
        paramCanvas.drawLine(localRect.left, localRect.top, localRect.right, localRect.bottom, b.a);
        paramCanvas.drawLine(localRect.right, localRect.top, localRect.left, localRect.bottom, b.a);
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
    return this.i;
  }
  
  public int getIntrinsicWidth()
  {
    b();
    return this.h;
  }
  
  public int getMinimumHeight()
  {
    b();
    return this.i;
  }
  
  public int getMinimumWidth()
  {
    b();
    return this.h;
  }
  
  public int getOpacity()
  {
    b();
    if ((this.c == null) || (this.c.hasAlpha()) || ((this.e != null) && (this.e.getAlpha() < 255))) {
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
    if (this.e == null)
    {
      this.e = new Paint();
      this.e.setDither(true);
    }
    return this.e;
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
    int j = paramInt;
    if (paramInt == 0) {
      j = 160;
    }
    this.g = j;
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
    this.g = paramDisplayMetrics.densityDpi;
    if (this.c != null) {
      a();
    }
  }
  
  static final class a
    extends b
  {
    NinePatch l;
    Rect m;
    Rect n;
    final boolean o;
    int p;
    int q = 160;
    Bitmap r;
    
    a(NinePatch paramNinePatch, Bitmap paramBitmap, Rect paramRect)
    {
      this(paramNinePatch, paramBitmap, paramRect, true);
    }
    
    a(NinePatch paramNinePatch, Bitmap paramBitmap, Rect paramRect, boolean paramBoolean)
    {
      this.r = paramBitmap;
      this.l = paramNinePatch;
      this.m = paramRect;
      this.o = paramBoolean;
    }
    
    a(a parama)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.theme.SkinnableNinePatchDrawable
 * JD-Core Version:    0.7.0.1
 */