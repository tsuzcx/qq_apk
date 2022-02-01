package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class ImageSwitchAnim
{
  public static int[] t = { 2130846752, 2130846753, 2130846754, 2130846755, 2130846756, 2130846757, 2130846758, 2130846759, 2130846760, 2130846761, 2130846762, 2130846763, 2130846764, 2130846765, 2130846766, 2130846767, 2130846768, 2130846769, 2130846770, 2130846771, 2130846772, 2130846773 };
  public static Bitmap[] u = null;
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public float i = 1.0F;
  public float j = 1.0F;
  public Bitmap k;
  public Bitmap l;
  Bitmap m = null;
  public int n;
  public int o;
  public int p = 0;
  public int q = 0;
  boolean r = false;
  int s = 0;
  long v;
  private Rect w = new Rect();
  private RectF x = new RectF();
  private Paint y = new Paint();
  
  public ImageSwitchAnim(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.h = paramInt8;
    this.g = paramInt7;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
    a(paramContext);
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.h = paramInt8;
    this.g = paramInt7;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
  }
  
  public void a(Context paramContext)
  {
    if (u == null)
    {
      u = new Bitmap[t.length];
      int i1 = 0;
      try
      {
        for (;;)
        {
          int i2 = t.length;
          if (i1 >= i2) {
            break;
          }
          try
          {
            u[i1] = BitmapFactory.decodeResource(paramContext.getResources(), t[i1]);
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            localOutOfMemoryError.printStackTrace();
          }
          i1 += 1;
        }
        return;
      }
      catch (OutOfMemoryError paramContext)
      {
        paramContext.printStackTrace();
        this.y.setAntiAlias(true);
      }
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.k == null)
    {
      this.k = paramBitmap;
      this.l = paramBitmap;
      return;
    }
    this.l = paramBitmap;
  }
  
  public boolean a(Canvas paramCanvas)
  {
    if (this.k == null) {
      return false;
    }
    paramCanvas.save();
    paramCanvas.translate(this.c, this.d);
    paramCanvas.scale(this.i, this.j, this.a / 2, this.b / 2);
    Object localObject = this.x;
    int i1 = this.e;
    float f1 = i1;
    int i2 = this.f;
    ((RectF)localObject).set(f1, i2, i1 + this.g, i2 + this.h);
    this.w.set(0, 0, this.k.getWidth(), this.k.getHeight());
    paramCanvas.drawBitmap(this.k, this.w, this.x, null);
    int i3;
    int i4;
    int i5;
    if (this.m != null)
    {
      localObject = this.w;
      i1 = this.a;
      i2 = this.p;
      i3 = this.n;
      i4 = this.b;
      i5 = this.q;
      ((Rect)localObject).set(i1 - i2 - i3, i4 - i5 - this.o, i1 - i2, i4 - i5);
      paramCanvas.drawBitmap(this.m, null, this.w, null);
    }
    if (this.r)
    {
      long l2 = System.currentTimeMillis() - this.v;
      if (l2 >= 440L) {
        this.k = this.l;
      }
      long l1 = l2;
      if (l2 >= 880L)
      {
        c();
        l1 = 880L;
      }
      this.s = ((int)(l1 / 40L));
      i1 = this.s;
      localObject = t;
      if (i1 >= localObject.length) {
        this.s = (i1 % localObject.length);
      }
      i1 = this.g;
      i2 = (int)(i1 * 0.35F / 2.0F);
      i3 = this.h;
      i4 = (int)(i3 * 0.35F / 2.0F);
      localObject = this.x;
      i5 = this.e;
      f1 = i5 - i2;
      int i6 = this.f;
      ((RectF)localObject).set(f1, i6 - i4, i5 + i2 + i1, i6 + i3 + i4);
      localObject = u;
      i1 = this.s;
      if (localObject[i1] != null)
      {
        this.w.set(0, 0, localObject[i1].getWidth(), u[this.s].getHeight());
        paramCanvas.drawBitmap(u[this.s], this.w, this.x, null);
      }
      paramCanvas.restore();
      return true;
    }
    paramCanvas.restore();
    return false;
  }
  
  public void b()
  {
    this.r = true;
    this.s = 0;
    this.v = System.currentTimeMillis();
  }
  
  public void b(Bitmap paramBitmap)
  {
    this.k = paramBitmap;
    this.l = paramBitmap;
  }
  
  public void c()
  {
    this.r = false;
  }
  
  public void c(Bitmap paramBitmap)
  {
    this.m = paramBitmap;
  }
  
  public Bitmap d()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ImageSwitchAnim
 * JD-Core Version:    0.7.0.1
 */