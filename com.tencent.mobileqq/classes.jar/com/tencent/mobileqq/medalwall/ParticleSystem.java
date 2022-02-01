package com.tencent.mobileqq.medalwall;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ParticleSystem
  implements ValueAnimator.AnimatorUpdateListener
{
  protected float a;
  private final int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  protected Paint a;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private View jdField_a_of_type_AndroidViewView;
  private final ArrayList<ParticleSystem.Particle> jdField_a_of_type_JavaUtilArrayList;
  private Bitmap[] jdField_a_of_type_ArrayOfAndroidGraphicsBitmap;
  private float jdField_b_of_type_Float = 0.0005F;
  private final int jdField_b_of_type_Int;
  private final ArrayList<ParticleSystem.Particle> jdField_b_of_type_JavaUtilArrayList;
  private int jdField_c_of_type_Int;
  private final ArrayList<ParticleSystem.Particle> jdField_c_of_type_JavaUtilArrayList;
  private int d;
  private int e;
  private int f = 60;
  private int g = 35;
  private int h = 160;
  private int i = 20;
  private int j = 150;
  
  public ParticleSystem(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    paramView = this.jdField_a_of_type_AndroidViewView.getResources();
    float f1 = paramView.getDisplayMetrics().density;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_b_of_type_Int / 2);
    if ((this.jdField_a_of_type_Int & 0x1) == 1) {
      this.jdField_c_of_type_JavaUtilArrayList = new ArrayList(150);
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_b_of_type_Int / 3);
      this.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = new Bitmap[paramArrayOfInt.length];
      paramInt1 = k;
      label180:
      if (paramInt1 < this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length) {
        try
        {
          this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[paramInt1] = BitmapFactory.decodeResource(paramView, paramArrayOfInt[paramInt1]);
          paramInt1 += 1;
          break label180;
          this.jdField_c_of_type_JavaUtilArrayList = new ArrayList(1);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            localOutOfMemoryError.printStackTrace();
          }
        }
      }
    }
    this.f = ((int)(this.f * f1));
    this.g = ((int)(this.g * f1));
    this.h = ((int)(this.h * f1));
    this.i = ((int)(this.i * f1));
    this.j = ((int)(this.j * f1));
  }
  
  public static double a(double paramDouble1, double paramDouble2)
  {
    return (paramDouble2 - paramDouble1) * Math.random() + paramDouble1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1000L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2, ParticleSystem.Particle paramParticle)
  {
    if (paramParticle != null)
    {
      double d1 = a(this.i, this.j);
      double d3 = a(0.0D, 6.283185307179586D);
      double d2 = Math.cos(d3);
      d3 = Math.sin(d3);
      int k = (int)(Math.random() * this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length);
      paramParticle.jdField_a_of_type_Float = ((float)(d2 * d1 + paramFloat1));
      paramParticle.jdField_b_of_type_Float = ((float)(d1 * d3 + paramFloat2));
      paramParticle.jdField_c_of_type_Float = ((float)(a(5.0D, 10.0D) * d2));
      paramParticle.jdField_d_of_type_Float = ((float)(a(5.0D, 10.0D) * d3));
      paramParticle.jdField_c_of_type_Int = k;
      paramParticle.jdField_d_of_type_Int = ((int)a(this.g, this.f));
      paramParticle.e = ((float)a(0.9800000190734863D, 0.9900000095367432D));
      paramParticle.f = ((float)a(0.5D, 1.0D));
      paramParticle.g = ((float)a(0.9800000190734863D, 0.9900000095367432D));
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int k = 0;
    this.jdField_d_of_type_Int = paramInt1;
    this.e = paramInt2;
    this.h = ((int)(Math.min(this.jdField_d_of_type_Int, this.e) * 0.4F));
    this.i = ((int)(this.h * 0.6F));
    this.j = ((int)(this.h * 0.8F));
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    if ((this.jdField_a_of_type_Int & 0x1) == 1)
    {
      float f1 = this.jdField_d_of_type_Int;
      float f2 = this.e;
      paramInt1 = 0;
      while (paramInt1 < 150)
      {
        ParticleSystem.Particle localParticle = new ParticleSystem.Particle();
        a(0.5F * f1, 0.4F * f2, localParticle);
        this.jdField_c_of_type_JavaUtilArrayList.add(localParticle);
        paramInt1 += 1;
      }
    }
    if ((this.jdField_a_of_type_Int & 0x2) == 2)
    {
      paramInt1 = k;
      while (paramInt1 < 40)
      {
        d();
        paramInt1 += 1;
      }
    }
    a();
  }
  
  public void a(Canvas paramCanvas)
  {
    int k = this.jdField_c_of_type_JavaUtilArrayList.size() - 1;
    while (k >= 0)
    {
      localObject = (ParticleSystem.Particle)this.jdField_c_of_type_JavaUtilArrayList.get(k);
      if (!a((ParticleSystem.Particle)localObject))
      {
        this.jdField_c_of_type_JavaUtilArrayList.remove(k);
        if ((localObject != null) && (this.jdField_c_of_type_Int < this.jdField_b_of_type_Int))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          this.jdField_c_of_type_Int += 1;
        }
      }
      k -= 1;
    }
    Object localObject = this.jdField_a_of_type_AndroidGraphicsRect;
    k = 0;
    if (k < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      ParticleSystem.Particle localParticle = (ParticleSystem.Particle)this.jdField_c_of_type_JavaUtilArrayList.get(k);
      if (localParticle == null) {}
      for (;;)
      {
        k += 1;
        break;
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(this.jdField_a_of_type_Float * localParticle.f * 2.0F * 255.0F) % 256);
        ((Rect)localObject).left = ((int)(localParticle.jdField_a_of_type_Float - localParticle.jdField_d_of_type_Int * 0.5F));
        ((Rect)localObject).top = ((int)(localParticle.jdField_b_of_type_Float - localParticle.jdField_d_of_type_Int * 0.5F));
        ((Rect)localObject).bottom = (((Rect)localObject).top + localParticle.jdField_d_of_type_Int);
        ((Rect)localObject).right = (((Rect)localObject).left + localParticle.jdField_d_of_type_Int);
        paramCanvas.drawBitmap(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[localParticle.jdField_c_of_type_Int], null, (Rect)localObject, this.jdField_a_of_type_AndroidGraphicsPaint);
        localParticle.jdField_a_of_type_Float += localParticle.jdField_c_of_type_Float;
        localParticle.jdField_b_of_type_Float += localParticle.jdField_d_of_type_Float;
        localParticle.jdField_c_of_type_Float *= 0.98F;
        localParticle.jdField_d_of_type_Float = (localParticle.jdField_d_of_type_Float * 0.98F + this.jdField_b_of_type_Float);
        localParticle.f *= localParticle.g;
      }
    }
  }
  
  public void a(Canvas paramCanvas, int paramInt)
  {
    if (this.jdField_a_of_type_Float <= 0.05F) {}
    do
    {
      return;
      if ((paramInt == 1) && ((this.jdField_a_of_type_Int & 0x1) == 1) && (this.jdField_c_of_type_JavaUtilArrayList.size() > 0)) {
        a(paramCanvas);
      }
    } while ((paramInt != 2) || ((this.jdField_a_of_type_Int & 0x2) != 2));
    b(paramCanvas);
  }
  
  public boolean a(ParticleSystem.Particle paramParticle)
  {
    if (paramParticle == null) {}
    while ((paramParticle.jdField_d_of_type_Int < 1) || (paramParticle.f <= 0.05F) || (paramParticle.jdField_a_of_type_Float + paramParticle.jdField_d_of_type_Int * 0.5F < 0.0F) || (paramParticle.jdField_b_of_type_Float + paramParticle.jdField_d_of_type_Int * 0.5F < 0.0F) || (paramParticle.jdField_a_of_type_Float - paramParticle.jdField_d_of_type_Int * 0.5F > this.jdField_d_of_type_Int) || (paramParticle.jdField_b_of_type_Float - paramParticle.jdField_d_of_type_Int * 0.5F > this.e)) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeUpdateListener(this);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
    }
  }
  
  public void b(Canvas paramCanvas)
  {
    int k = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
    while (k >= 0)
    {
      localObject = (ParticleSystem.Particle)this.jdField_b_of_type_JavaUtilArrayList.get(k);
      if (!a((ParticleSystem.Particle)localObject))
      {
        this.jdField_b_of_type_JavaUtilArrayList.remove(k);
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
      }
      k -= 1;
    }
    if (Math.abs(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long) > 64L)
    {
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      d();
    }
    Object localObject = this.jdField_a_of_type_AndroidGraphicsRect;
    k = 0;
    while (k < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      ParticleSystem.Particle localParticle = (ParticleSystem.Particle)this.jdField_b_of_type_JavaUtilArrayList.get(k);
      if (localParticle != null)
      {
        float f1 = (float)Math.abs(Math.cos(localParticle.h) * localParticle.f);
        if (f1 >= 0.01F)
        {
          this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(f1 * this.jdField_a_of_type_Float * 255.0F));
          ((Rect)localObject).left = ((int)(Math.cos(localParticle.k) * localParticle.j + (localParticle.jdField_a_of_type_Float - localParticle.jdField_d_of_type_Int * 0.5F)));
          ((Rect)localObject).top = ((int)(localParticle.jdField_b_of_type_Float - localParticle.jdField_d_of_type_Int * 0.5F));
          ((Rect)localObject).bottom = (((Rect)localObject).top + localParticle.jdField_d_of_type_Int);
          ((Rect)localObject).right = (((Rect)localObject).left + localParticle.jdField_d_of_type_Int);
          paramCanvas.drawBitmap(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[localParticle.jdField_c_of_type_Int], null, (Rect)localObject, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        localParticle.jdField_a_of_type_Float += localParticle.jdField_c_of_type_Float;
        localParticle.jdField_b_of_type_Float += localParticle.jdField_d_of_type_Float;
        localParticle.f *= localParticle.g;
        localParticle.h += localParticle.i;
        localParticle.k += localParticle.l;
      }
      k += 1;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ParticleSystem", 2, "destroy");
    }
    b();
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void d()
  {
    ParticleSystem.Particle localParticle = null;
    double d1 = a(this.h, -this.h);
    double d2 = a(this.h, -this.h);
    int k = (int)(Math.random() * this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length);
    float f1 = this.jdField_d_of_type_Int;
    float f2 = this.e;
    if (this.jdField_c_of_type_Int < this.jdField_b_of_type_Int)
    {
      localParticle = new ParticleSystem.Particle();
      this.jdField_c_of_type_Int += 1;
    }
    for (;;)
    {
      if (localParticle != null)
      {
        localParticle.jdField_a_of_type_Float = ((float)(d1 + f1 * 0.5F));
        localParticle.jdField_b_of_type_Float = ((float)(f2 * 0.4F + d2));
        localParticle.jdField_c_of_type_Float = 0.0F;
        localParticle.jdField_d_of_type_Float = ((float)a(-1.0D, -2.0D));
        localParticle.jdField_c_of_type_Int = k;
        localParticle.jdField_d_of_type_Int = ((int)a(this.g, this.f));
        localParticle.e = ((float)a(0.9950000047683716D, 0.9980000257492065D));
        localParticle.f = ((float)a(1.0D, 1.0D));
        localParticle.g = ((float)a(0.9900000095367432D, 0.9800000190734863D));
        localParticle.h = ((float)a(0.0D, 3.141592653589793D));
        localParticle.i = ((float)a(0.01D, 0.001D));
        localParticle.j = ((float)a(20.0D, 5.0D));
        localParticle.k = ((float)a(0.0D, 3.141592653589793D));
        localParticle.l = ((float)a(0.01D, 0.1D));
        localParticle.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
        this.jdField_b_of_type_JavaUtilArrayList.add(localParticle);
      }
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        localParticle = (ParticleSystem.Particle)this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      }
    }
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.ParticleSystem
 * JD-Core Version:    0.7.0.1
 */