package com.tencent.mobileqq.qzonevip.gift.particle;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ParticleDropView
  extends ParticleTextureView
{
  private Bitmap n;
  private int o = 0;
  
  public ParticleDropView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ParticleDropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ParticleDropView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(ParticleObject paramParticleObject)
  {
    long l1 = System.currentTimeMillis() - paramParticleObject.g;
    long l2 = paramParticleObject.j;
    if (l1 <= paramParticleObject.j / 4L) {
      l2 /= 4L;
    }
    for (l1 -= l2;; l1 = l2 - l1)
    {
      j = (int)((float)l1 * 255.0F / (float)l2 + 255.0F);
      break;
      if ((l1 >= paramParticleObject.j / 4L) && (l1 < paramParticleObject.j * 3L / 4L))
      {
        j = 255;
        break;
      }
      l2 = l2 * 3L / 4L;
    }
    int i = j;
    if (j > 255) {
      i = 255;
    }
    int j = i;
    if (i < 0) {
      j = 0;
    }
    paramParticleObject.e = j;
  }
  
  protected void a(Bitmap[] paramArrayOfBitmap)
  {
    if ((paramArrayOfBitmap != null) && (paramArrayOfBitmap.length != 0) && (this.f != 0) && (this.g != 0))
    {
      Bitmap localBitmap = paramArrayOfBitmap[0];
      this.o += 1;
      int i;
      if (this.o < 3) {
        i = a(2, 4);
      } else {
        i = 4;
      }
      paramArrayOfBitmap = this.k;
      int j = 0;
      for (;;)
      {
        if (j < i) {}
        ParticleObject localParticleObject;
        try
        {
          localParticleObject = new ParticleObject();
          localParticleObject.f = localBitmap;
          localParticleObject.j = a(2000, 3500);
          localParticleObject.a = (a(0, this.f + 100) - 100);
          localParticleObject.b = (a(0, this.g * 4 / 5) - 200);
          localParticleObject.e = 0;
          localParticleObject.d = a(0.15F, 0.75F);
          localParticleObject.b -= 300.0F;
          localParticleObject.c = a(0, 360);
          this.d.add(localParticleObject);
          j += 1;
        }
        finally {}
      }
      if (this.o % 2 == 0)
      {
        localParticleObject = new ParticleObject();
        localParticleObject.f = localBitmap;
        localParticleObject.j = a(2000, 3500);
        localParticleObject.a = (a(0, this.f + 100) - 100);
        localParticleObject.b = (a(0, 100) - 300);
        localParticleObject.e = 0;
        localParticleObject.c = a(0, 360);
        this.d.add(localParticleObject);
      }
      return;
    }
    QLog.e("ParticleDropView", 1, "addData: bitmap = null error");
  }
  
  protected Bitmap[] a()
  {
    return new Bitmap[] { this.n };
  }
  
  protected void b()
  {
    synchronized (this.k)
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        ParticleObject localParticleObject = (ParticleObject)localIterator.next();
        if (localParticleObject != null)
        {
          if (localParticleObject.d > 0.75F) {
            localParticleObject.b += 13.0F;
          } else {
            localParticleObject.b += 8.0F;
          }
          if (!localParticleObject.h)
          {
            localParticleObject.i = a(-1, 1);
            localParticleObject.h = true;
          }
          if (localParticleObject.i == 0) {
            localParticleObject.i = 1;
          }
          localParticleObject.a += localParticleObject.i;
          a(localParticleObject);
          if ((localParticleObject.e == 0) || (localParticleObject.b >= this.g)) {
            localIterator.remove();
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  protected boolean c()
  {
    return (this.l % 40 == 0) && (!this.j);
  }
  
  public void d()
  {
    super.d();
    setAlpha(1.0F);
  }
  
  public void e()
  {
    super.e();
    synchronized (this.k)
    {
      this.d.clear();
      return;
    }
  }
  
  protected int getRefreshTime()
  {
    return 0;
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.n = paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.particle.ParticleDropView
 * JD-Core Version:    0.7.0.1
 */