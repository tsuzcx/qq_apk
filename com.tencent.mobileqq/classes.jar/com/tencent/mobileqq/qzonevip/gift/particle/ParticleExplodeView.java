package com.tencent.mobileqq.qzonevip.gift.particle;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ParticleExplodeView
  extends ParticleTextureView
{
  public ParticleExplodeView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ParticleExplodeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ParticleExplodeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private float a(float paramFloat)
  {
    return (paramFloat - this.f / 2) / 2.0F;
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = this.f / 2;
    float f2 = this.g / 2;
    paramFloat2 = (f2 - paramFloat2) / (f1 - paramFloat1);
    return (paramFloat3 + paramFloat1) * paramFloat2 + f2 - f1 * paramFloat2;
  }
  
  private Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    int i = a(0, 3);
    if (i == 0) {
      return paramBitmap1;
    }
    if (i == 1) {
      return paramBitmap2;
    }
    return paramBitmap3;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    int j = 0;
    while (j < paramInt1)
    {
      ParticleObject localParticleObject = new ParticleObject();
      localParticleObject.f = a(paramBitmap1, paramBitmap2, paramBitmap3);
      int i;
      if (paramInt3 == 0) {
        i = a(0, 360);
      }
      for (;;)
      {
        break;
        if (paramInt3 == 1) {
          i = a(0, 180);
        } else if (paramInt3 == 2) {
          i = a(180, 360);
        } else {
          i = 0;
        }
      }
      double[] arrayOfDouble = b(paramInt2, i);
      double d1 = this.f / 2;
      double d2 = arrayOfDouble[0];
      Double.isNaN(d1);
      localParticleObject.a = ((float)(d1 + d2));
      d1 = this.g / 2;
      d2 = arrayOfDouble[1];
      Double.isNaN(d1);
      localParticleObject.b = ((float)(d1 + d2));
      localParticleObject.c = a(0, 360);
      this.d.add(localParticleObject);
      j += 1;
    }
  }
  
  private double[] b(int paramInt1, int paramInt2)
  {
    double d1 = paramInt1;
    double d3 = paramInt2;
    double d2 = Math.cos(Math.toRadians(d3));
    Double.isNaN(d1);
    d3 = Math.sin(Math.toRadians(d3));
    Double.isNaN(d1);
    return new double[] { d2 * d1, d1 * d3 };
  }
  
  protected void a(Bitmap[] paramArrayOfBitmap)
  {
    if ((paramArrayOfBitmap != null) && (paramArrayOfBitmap.length != 0) && (this.f != 0) && (this.g != 0))
    {
      Object localObject = this.k;
      Bitmap localBitmap1 = paramArrayOfBitmap[0];
      Bitmap localBitmap2 = paramArrayOfBitmap[1];
      paramArrayOfBitmap = paramArrayOfBitmap[2];
      try
      {
        a(5, this.f / 40, 0, localBitmap1, localBitmap2, paramArrayOfBitmap);
        a(5, this.f / 20, 0, localBitmap1, localBitmap2, paramArrayOfBitmap);
        a(5, this.f / 10, 0, localBitmap1, localBitmap2, paramArrayOfBitmap);
        a(5, this.f / 7, 0, localBitmap1, localBitmap2, paramArrayOfBitmap);
        a(5, this.f / 5, 0, localBitmap1, localBitmap2, paramArrayOfBitmap);
        a(5, this.f / 4, 0, localBitmap1, localBitmap2, paramArrayOfBitmap);
        a(5, this.f / 3, 0, localBitmap1, localBitmap2, paramArrayOfBitmap);
        a(5, this.f / 2, 1, localBitmap1, localBitmap2, paramArrayOfBitmap);
        a(5, this.f / 2, 2, localBitmap1, localBitmap2, paramArrayOfBitmap);
        a(5, this.f * 3 / 5, 1, localBitmap1, localBitmap2, paramArrayOfBitmap);
        a(5, this.f * 3 / 5, 2, localBitmap1, localBitmap2, paramArrayOfBitmap);
        return;
      }
      finally {}
    }
    QLog.e("ParticleExplodeView", 1, "updateData: bitmap = null error");
  }
  
  protected Bitmap[] a()
  {
    return new Bitmap[] { BitmapFactory.decodeResource(this.e.getResources(), 2130850039), BitmapFactory.decodeResource(this.e.getResources(), 2130850040), BitmapFactory.decodeResource(this.e.getResources(), 2130850041) };
  }
  
  protected void b()
  {
    float f2;
    float f1;
    label183:
    synchronized (this.k)
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        ParticleObject localParticleObject = (ParticleObject)localIterator.next();
        if (localParticleObject != null)
        {
          f2 = a(localParticleObject.a);
          if ((f2 <= 0.0F) || (f2 >= 5.0F)) {
            break label183;
          }
          f1 = 5.0F;
          localParticleObject.b = a(localParticleObject.a, localParticleObject.b, f1);
          localParticleObject.a += f1;
          localParticleObject.c += 15.0F;
          if ((localParticleObject.a < 0.0F) || (localParticleObject.a > this.f) || (localParticleObject.a == this.f / 2)) {
            localIterator.remove();
          }
        }
      }
      return;
    }
  }
  
  protected boolean c()
  {
    return false;
  }
  
  public void e()
  {
    this.j = true;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.addListener(new ParticleExplodeView.1(this));
    localObjectAnimator.start();
  }
  
  protected int getRefreshTime()
  {
    return 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.particle.ParticleExplodeView
 * JD-Core Version:    0.7.0.1
 */