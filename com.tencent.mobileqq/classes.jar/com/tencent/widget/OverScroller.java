package com.tencent.widget;

import amcv;
import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.tencent.util.AnimateUtils;

public class OverScroller
{
  public static int b;
  private int jdField_a_of_type_Int;
  private final amcv jdField_a_of_type_Amcv;
  private final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final boolean jdField_a_of_type_Boolean;
  private final amcv b;
  
  static
  {
    jdField_b_of_type_Int = 400;
  }
  
  public OverScroller(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OverScroller(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public OverScroller(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Amcv = new amcv();
    this.jdField_b_of_type_Amcv = new amcv();
    amcv.a(paramContext);
  }
  
  public float a()
  {
    return (float)Math.sqrt(amcv.a(this.jdField_a_of_type_Amcv) * amcv.a(this.jdField_a_of_type_Amcv) + amcv.a(this.jdField_b_of_type_Amcv) * amcv.a(this.jdField_b_of_type_Amcv));
  }
  
  public final int a()
  {
    return amcv.a(this.jdField_a_of_type_Amcv);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Amcv.a();
    this.jdField_b_of_type_Amcv.a();
  }
  
  public final void a(float paramFloat)
  {
    this.jdField_a_of_type_Amcv.a(paramFloat);
    this.jdField_b_of_type_Amcv.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Amcv.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Amcv.b(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, 250);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Amcv.a(paramInt1, paramInt3, paramInt5);
    this.jdField_b_of_type_Amcv.a(paramInt2, paramInt4, paramInt5);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, 0, 0);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    if ((this.jdField_a_of_type_Boolean) && (!a()))
    {
      float f1 = amcv.a(this.jdField_a_of_type_Amcv);
      float f2 = amcv.a(this.jdField_b_of_type_Amcv);
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Amcv.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
      this.jdField_b_of_type_Amcv.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
    amcv.a(this.jdField_a_of_type_Amcv, paramLong);
    amcv.a(this.jdField_b_of_type_Amcv, paramLong);
  }
  
  public final void a(boolean paramBoolean)
  {
    amcv.a(this.jdField_a_of_type_Amcv, amcv.a(this.jdField_b_of_type_Amcv, paramBoolean));
  }
  
  public final boolean a()
  {
    return (amcv.a(this.jdField_a_of_type_Amcv)) && (amcv.a(this.jdField_b_of_type_Amcv));
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    int i = amcv.c(this.jdField_a_of_type_Amcv);
    int j = amcv.b(this.jdField_a_of_type_Amcv);
    int k = amcv.c(this.jdField_b_of_type_Amcv);
    int m = amcv.b(this.jdField_b_of_type_Amcv);
    return (!a()) && (Math.signum(paramFloat1) == Math.signum(i - j)) && (Math.signum(paramFloat2) == Math.signum(k - m));
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_a_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Amcv.a(paramInt1, paramInt3, paramInt4);
    boolean bool2 = this.jdField_b_of_type_Amcv.a(paramInt2, paramInt5, paramInt6);
    return (bool1) || (bool2);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.jdField_a_of_type_Int = 1;
    boolean bool1 = this.jdField_a_of_type_Amcv.a(paramInt1, paramInt3, paramInt4, paramInt7);
    boolean bool2 = this.jdField_b_of_type_Amcv.a(paramInt2, paramInt5, paramInt6, paramInt7);
    return (bool1) || (bool2);
  }
  
  public final int b()
  {
    return amcv.a(this.jdField_b_of_type_Amcv);
  }
  
  public boolean b()
  {
    if (a()) {
      return false;
    }
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return true;
      long l = AnimationUtils.currentAnimationTimeMillis() - amcv.a(this.jdField_a_of_type_Amcv);
      int i = amcv.d(this.jdField_a_of_type_Amcv);
      if (l < i)
      {
        float f = (float)l / i;
        if (this.jdField_a_of_type_AndroidViewAnimationInterpolator == null) {}
        for (f = AnimateUtils.a(f);; f = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f))
        {
          if (!amcv.a(this.jdField_a_of_type_Amcv)) {
            this.jdField_a_of_type_Amcv.b(f);
          }
          if (amcv.a(this.jdField_b_of_type_Amcv)) {
            break;
          }
          this.jdField_b_of_type_Amcv.b(f);
          break;
        }
      }
      a();
      continue;
      if ((!amcv.a(this.jdField_a_of_type_Amcv)) && (!this.jdField_a_of_type_Amcv.b()) && (!this.jdField_a_of_type_Amcv.a())) {
        this.jdField_a_of_type_Amcv.a();
      }
      if ((!amcv.a(this.jdField_b_of_type_Amcv)) && (!this.jdField_b_of_type_Amcv.b()) && (!this.jdField_b_of_type_Amcv.a())) {
        this.jdField_b_of_type_Amcv.a();
      }
    }
  }
  
  public final int c()
  {
    return amcv.c(this.jdField_a_of_type_Amcv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.OverScroller
 * JD-Core Version:    0.7.0.1
 */