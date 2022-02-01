package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;

public class FlakeView
  extends View
{
  Bitmap a;
  Bitmap[] b = { null, null, null, null };
  int[] c = { 2130846891, 2130846892, 2130846889, 2130846890 };
  int d = this.c.length;
  int e = 0;
  int f = 0;
  int g = 0;
  int h = 0;
  boolean i = false;
  ArrayList<Flake> j = new ArrayList();
  long k;
  long l;
  float m;
  Matrix n = new Matrix();
  boolean o = false;
  boolean p = true;
  boolean q = true;
  boolean r = false;
  long s = 0L;
  long t = 0L;
  boolean u = true;
  private long v = 1200L;
  
  public FlakeView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.p = true;
    this.v = 1000L;
  }
  
  public void a(int paramInt)
  {
    int i1 = 0;
    while (i1 < paramInt)
    {
      if (this.a != null)
      {
        Flake localFlake = Flake.a(getWidth(), this.a, 2, getResources());
        this.j.add(localFlake);
        this.g += 1;
        if (!this.u)
        {
          localFlake.c = 0.0F;
          localFlake.d = 0.0F;
        }
      }
      i1 += 1;
    }
  }
  
  public void a(int paramInt, Bitmap... paramVarArgs)
  {
    ThreadManager.post(new FlakeView.2(this, paramInt, paramVarArgs), 5, null, false);
  }
  
  public void a(int paramInt, String... paramVarArgs)
  {
    ThreadManager.post(new FlakeView.1(this, paramVarArgs, paramInt), 5, null, false);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.p)
    {
      this.p = false;
      long l1 = System.currentTimeMillis();
      this.k = l1;
      this.l = l1;
      invalidate();
    }
    this.o = paramBoolean;
  }
  
  public void b()
  {
    this.k = (System.currentTimeMillis() - (this.m * 1000.0F));
  }
  
  public void b(int paramInt)
  {
    int i1 = 0;
    while (i1 < paramInt)
    {
      int i2 = (int)(Math.random() * 4.0D);
      Bitmap[] arrayOfBitmap = this.b;
      i2 %= arrayOfBitmap.length;
      if (arrayOfBitmap[i2] == null) {
        try
        {
          arrayOfBitmap[i2] = BitmapFactory.decodeResource(getResources(), this.c[i2]);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          this.b[i2] = null;
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.b[i2] != null)
      {
        this.j.add(Flake.a(getWidth(), this.b[i2], 1, getResources()));
        this.e += 1;
      }
      i1 += 1;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.p) {
      return;
    }
    super.onDraw(paramCanvas);
    long l1 = System.currentTimeMillis();
    boolean bool = this.r;
    int i3 = 0;
    if ((bool) && (l1 - this.t > this.s)) {
      this.r = false;
    }
    if (l1 - this.l > this.v)
    {
      this.l = l1;
      if ((this.r) && (this.g < 10)) {
        a(4);
      }
      if ((!this.r) && (this.q) && (this.e < 13)) {
        b(3);
      }
    }
    int i4 = getHeight();
    int i5 = getWidth();
    this.m = ((float)(l1 - this.k) / 1000.0F);
    this.k = l1;
    int i1 = 0;
    int i2;
    Flake localFlake;
    float f1;
    float f2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= this.j.size()) {
        break;
      }
      localFlake = (Flake)this.j.get(i1);
      if (localFlake.k == 3)
      {
        localFlake.a += localFlake.h * this.m;
        if ((localFlake.a >= -localFlake.e) && (localFlake.a <= localFlake.e + i5))
        {
          f1 = localFlake.b;
          f2 = localFlake.i;
          float f3 = this.m;
          float f4 = localFlake.j;
          float f5 = this.m;
          localFlake.b = (f1 + (f2 * f3 + f4 * f5 * f5 / 2.0F));
          localFlake.i += localFlake.j * this.m;
        }
        else
        {
          this.h -= 1;
          this.j.remove(i1);
          break label572;
        }
      }
      else
      {
        localFlake.b += localFlake.i * this.m;
      }
      localFlake.c += localFlake.d * this.m;
      if (localFlake.b > localFlake.f + i4)
      {
        localFlake.a = ((float)Math.random() * (i5 - localFlake.e));
        if (localFlake.k == 1)
        {
          localFlake.b = (0 - localFlake.f);
          localFlake.a = ((float)Math.random() * (getWidth() - localFlake.e));
        }
        else if (localFlake.k == 2)
        {
          this.g -= 1;
          this.j.remove(i1);
        }
        else if (localFlake.k == 3)
        {
          this.h -= 1;
          this.j.remove(i1);
        }
        else if (localFlake.k == 0)
        {
          this.j.remove(i1);
          this.f -= 1;
        }
      }
      label572:
      i1 += 1;
    }
    while (i2 < this.j.size())
    {
      localFlake = (Flake)this.j.get(i2);
      f1 = localFlake.e * 1.0F / localFlake.g.getWidth();
      f2 = localFlake.f * 1.0F / localFlake.g.getHeight();
      this.n.setTranslate(-localFlake.e / 2 / f1, -localFlake.f / 2 / f2);
      this.n.postRotate(localFlake.c);
      this.n.postTranslate((localFlake.e / 2 + localFlake.a) / f1, (localFlake.f / 2 + localFlake.b) / f2);
      this.n.postScale(f1, f2);
      paramCanvas.drawBitmap(localFlake.g, this.n, null);
      i2 += 1;
    }
    if (this.h <= 0) {
      this.q = true;
    }
    invalidate();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.j.clear();
    this.e = 0;
    this.f = 0;
    this.g = 0;
  }
  
  public void setHonhBaoSpeed(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.j.size())
    {
      Flake localFlake = (Flake)this.j.get(i1);
      if (localFlake != null)
      {
        if ((localFlake.k != 0) && (localFlake.k != 2))
        {
          if (localFlake.k == 1) {
            if (paramInt != 1)
            {
              if (paramInt != 2)
              {
                if (paramInt != 3) {
                  localFlake.i = (AIOUtils.b(230.0F, getResources()) + (float)Math.random() * AIOUtils.b(130.0F, getResources()));
                } else {
                  localFlake.i = (AIOUtils.b(295.0F, getResources()) + (float)Math.random() * AIOUtils.b(130.0F, getResources()));
                }
              }
              else {
                localFlake.i = (AIOUtils.b(280.0F, getResources()) + (float)Math.random() * AIOUtils.b(130.0F, getResources()));
              }
            }
            else {
              localFlake.i = (AIOUtils.b(230.0F, getResources()) + (float)Math.random() * AIOUtils.b(130.0F, getResources()));
            }
          }
        }
        else if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3) {
              localFlake.i = (AIOUtils.b(240.0F, getResources()) + (float)Math.random() * AIOUtils.b(100.0F, getResources()));
            } else {
              localFlake.i = (AIOUtils.b(340.0F, getResources()) + (float)Math.random() * AIOUtils.b(100.0F, getResources()));
            }
          }
          else {
            localFlake.i = (AIOUtils.b(290.0F, getResources()) + (float)Math.random() * AIOUtils.b(100.0F, getResources()));
          }
        }
        else {
          localFlake.i = (AIOUtils.b(240.0F, getResources()) + (float)Math.random() * AIOUtils.b(100.0F, getResources()));
        }
        this.v = (1200 - (paramInt - 1) * 200);
      }
      i1 += 1;
    }
  }
  
  public void setImagePath(String paramString, long paramLong)
  {
    ThreadManager.post(new FlakeView.3(this, paramString), 5, null, false);
    this.t = System.currentTimeMillis();
    this.s = paramLong;
  }
  
  public void setRotateCaiDan(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public void setShowBgHbAnim(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void setShowCaiDan(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public void setShowFullScreenCaidan(long paramLong1, long paramLong2)
  {
    this.t = paramLong1;
    this.s = paramLong2;
    this.r = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.FlakeView
 * JD-Core Version:    0.7.0.1
 */