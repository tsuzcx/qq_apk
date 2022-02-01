package com.tencent.mobileqq.portal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;

public class SanHuaView
  extends View
{
  int a;
  ArrayList<SanHua> b = new ArrayList();
  Resources c;
  boolean d;
  long e;
  Matrix f;
  float g;
  float h;
  int i;
  int j;
  private int[] k = { 2130846775, 2130846776, 2130846777, 2130846778, 2130846779, 2130846780, 2130846781, 2130846782 };
  private Bitmap[] l = new Bitmap[this.k.length];
  
  public SanHuaView(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    int m = 0;
    this.d = false;
    this.f = new Matrix();
    this.c = getResources();
    this.g = paramInt1;
    this.h = paramInt2;
    paramInt1 = m;
    try
    {
      while (paramInt1 < this.l.length)
      {
        this.l[paramInt1] = BitmapFactory.decodeResource(this.c, this.k[paramInt1]);
        paramInt1 += 1;
      }
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a()
  {
    this.d = true;
    this.e = System.currentTimeMillis();
    invalidate();
  }
  
  public void a(int paramInt)
  {
    int m = 0;
    while (m < paramInt)
    {
      double d1 = this.l.length;
      double d2 = Math.random();
      Double.isNaN(d1);
      int n = (int)(d1 * d2);
      Bitmap[] arrayOfBitmap = this.l;
      if (arrayOfBitmap[n] != null) {
        this.b.add(SanHua.a(arrayOfBitmap[n], this.g, this.h, this.c));
      }
      m += 1;
    }
    this.a += paramInt;
  }
  
  public void b()
  {
    this.d = false;
    this.b.clear();
    this.a = 0;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.d) {
      return;
    }
    super.onDraw(paramCanvas);
    float f1 = (float)(System.currentTimeMillis() - this.e) / 1000.0F;
    int m = 0;
    SanHua localSanHua;
    while (m < this.a)
    {
      localSanHua = (SanHua)this.b.get(m);
      if (localSanHua != null)
      {
        float f2;
        float f3;
        float f4;
        if (localSanHua.f < 0.0D)
        {
          f2 = localSanHua.h;
          f3 = localSanHua.i;
          f4 = AIOUtils.b(270.0F, this.c);
          localSanHua.c[0] = (this.g - f2 * f1);
          localSanHua.c[1] = (this.h + (f3 * f1 + f4 * 0.5F * f1 * f1));
        }
        else
        {
          f2 = localSanHua.h;
          f3 = localSanHua.i;
          f4 = AIOUtils.b(270.0F, this.c);
          localSanHua.c[0] = (this.g + f2 * f1);
          localSanHua.c[1] = (this.h - (f3 * f1 - f4 * 0.5F * f1 * f1));
        }
      }
      m += 1;
    }
    m = 0;
    int i1;
    for (int n = 0; m < this.a; n = i1)
    {
      localSanHua = (SanHua)this.b.get(m);
      if (localSanHua == null)
      {
        i1 = n;
      }
      else
      {
        i1 = n;
        if (localSanHua.c[0] < this.i)
        {
          i1 = n;
          if (localSanHua.c[0] > 0.0F)
          {
            i1 = n;
            if (localSanHua.c[1] < this.j)
            {
              i1 = n;
              if (localSanHua.c[1] > 0.0F)
              {
                this.f.setTranslate(-localSanHua.a / 2, -localSanHua.b / 2);
                this.f.postRotate(localSanHua.d);
                this.f.postTranslate(localSanHua.a / 2 + localSanHua.c[0], localSanHua.b / 2 + localSanHua.c[1]);
                paramCanvas.drawBitmap(localSanHua.e, this.f, null);
                i1 = n + 1;
              }
            }
          }
        }
      }
      m += 1;
    }
    if (n == 0) {
      b();
    }
    if (this.d) {
      invalidate();
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.i = paramInt1;
    this.j = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.SanHuaView
 * JD-Core Version:    0.7.0.1
 */