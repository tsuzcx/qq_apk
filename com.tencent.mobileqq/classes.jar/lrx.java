import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;

class lrx
{
  private static final float[] jdField_a_of_type_ArrayOfFloat;
  private static final float[] jdField_b_of_type_ArrayOfFloat;
  private static float jdField_d_of_type_Float;
  private static float jdField_e_of_type_Float;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float jdField_c_of_type_Float = ViewConfiguration.getScrollFriction();
  private int jdField_c_of_type_Int;
  private int jdField_d_of_type_Int;
  private int jdField_e_of_type_Int;
  private int f;
  private int g;
  private int h;
  private int i = 0;
  
  static
  {
    float f2 = 0.0F;
    jdField_e_of_type_Float = (float)(Math.log(0.78D) / Math.log(0.9D));
    jdField_a_of_type_ArrayOfFloat = new float[101];
    jdField_b_of_type_ArrayOfFloat = new float[101];
    int j = 0;
    float f1 = 0.0F;
    if (j < 100)
    {
      float f5 = j / 100.0F;
      float f3 = 1.0F;
      label55:
      float f4 = (f3 - f1) / 2.0F + f1;
      float f6 = 3.0F * f4 * (1.0F - f4);
      float f7 = ((1.0F - f4) * 0.175F + 0.35F * f4) * f6 + f4 * f4 * f4;
      if (Math.abs(f7 - f5) < 1.E-005D)
      {
        jdField_a_of_type_ArrayOfFloat[j] = (f4 * (f4 * f4) + f6 * ((1.0F - f4) * 0.5F + f4));
        f3 = 1.0F;
      }
      for (;;)
      {
        f4 = (f3 - f2) / 2.0F + f2;
        f6 = 3.0F * f4 * (1.0F - f4);
        f7 = ((1.0F - f4) * 0.5F + f4) * f6 + f4 * f4 * f4;
        if (Math.abs(f7 - f5) < 1.E-005D)
        {
          jdField_b_of_type_ArrayOfFloat[j] = (f4 * (f4 * f4) + ((1.0F - f4) * 0.175F + 0.35F * f4) * f6);
          j += 1;
          break;
          if (f7 > f5)
          {
            f3 = f4;
            break label55;
          }
          f1 = f4;
          break label55;
        }
        if (f7 > f5) {
          f3 = f4;
        } else {
          f2 = f4;
        }
      }
    }
    float[] arrayOfFloat = jdField_a_of_type_ArrayOfFloat;
    jdField_b_of_type_ArrayOfFloat[100] = 1.0F;
    arrayOfFloat[100] = 1.0F;
  }
  
  private double a(int paramInt)
  {
    return Math.log(0.35F * Math.abs(paramInt) / (this.jdField_c_of_type_Float * jdField_d_of_type_Float));
  }
  
  private static float a(int paramInt)
  {
    if (paramInt > 0) {
      return -2000.0F;
    }
    return 2000.0F;
  }
  
  private int a(int paramInt)
  {
    return (int)(Math.exp(a(paramInt) / (jdField_e_of_type_Float - 1.0D)) * 1000.0D);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m = 1;
    if ((paramInt1 > paramInt2) && (paramInt1 < paramInt3))
    {
      Log.e("OverScroller", "startAfterEdge called from a valid position");
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    int j;
    int k;
    label43:
    int n;
    if (paramInt1 > paramInt3)
    {
      j = 1;
      if (j == 0) {
        break label78;
      }
      k = paramInt3;
      n = paramInt1 - k;
      if (n * paramInt4 < 0) {
        break label84;
      }
    }
    for (;;)
    {
      if (m == 0) {
        break label90;
      }
      e(paramInt1, k, paramInt4);
      return;
      j = 0;
      break;
      label78:
      k = paramInt2;
      break label43;
      label84:
      m = 0;
    }
    label90:
    if (b(paramInt4) > Math.abs(n))
    {
      if (j != 0)
      {
        if (j == 0) {
          break label137;
        }
        paramInt3 = paramInt1;
      }
      for (;;)
      {
        a(paramInt1, paramInt4, paramInt2, paramInt3, this.h);
        return;
        paramInt2 = paramInt1;
        break;
      }
    }
    label137:
    c(paramInt1, k, paramInt4);
  }
  
  static void a(Context paramContext)
  {
    jdField_d_of_type_Float = paramContext.getResources().getDisplayMetrics().density * 160.0F * 386.0878F * 0.84F;
  }
  
  private double b(int paramInt)
  {
    double d1 = a(paramInt);
    double d2 = jdField_e_of_type_Float;
    double d3 = this.jdField_c_of_type_Float * jdField_d_of_type_Float;
    return Math.exp(d1 * (jdField_e_of_type_Float / (d2 - 1.0D))) * d3;
  }
  
  private void b()
  {
    float f2 = this.jdField_d_of_type_Int * this.jdField_d_of_type_Int / (Math.abs(this.jdField_b_of_type_Float) * 2.0F);
    float f3 = Math.signum(this.jdField_d_of_type_Int);
    float f1 = f2;
    if (f2 > this.h)
    {
      this.jdField_b_of_type_Float = (-f3 * this.jdField_d_of_type_Int * this.jdField_d_of_type_Int / (this.h * 2.0F));
      f1 = this.h;
    }
    this.h = ((int)f1);
    this.i = 2;
    int j = this.jdField_a_of_type_Int;
    if (this.jdField_d_of_type_Int > 0) {}
    for (;;)
    {
      this.jdField_c_of_type_Int = ((int)f1 + j);
      this.jdField_e_of_type_Int = (-(int)(1000.0F * this.jdField_d_of_type_Int / this.jdField_b_of_type_Float));
      return;
      f1 = -f1;
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = Math.abs((paramInt3 - paramInt1) / (paramInt2 - paramInt1));
    paramInt1 = (int)(100.0F * f1);
    if (paramInt1 < 100)
    {
      float f2 = paramInt1 / 100.0F;
      float f3 = (paramInt1 + 1) / 100.0F;
      float f4 = jdField_b_of_type_ArrayOfFloat[paramInt1];
      float f5 = jdField_b_of_type_ArrayOfFloat[(paramInt1 + 1)];
      this.jdField_e_of_type_Int = ((int)(((f1 - f2) / (f3 - f2) * (f5 - f4) + f4) * this.jdField_e_of_type_Int));
    }
  }
  
  private void c(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Boolean = false;
    this.i = 1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    paramInt1 -= paramInt2;
    this.jdField_b_of_type_Float = a(paramInt1);
    this.jdField_d_of_type_Int = (-paramInt1);
    this.h = Math.abs(paramInt1);
    this.jdField_e_of_type_Int = ((int)(Math.sqrt(paramInt1 * -2.0D / this.jdField_b_of_type_Float) * 1000.0D));
  }
  
  private void d(int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = -paramInt3 / this.jdField_b_of_type_Float;
    float f2 = (float)Math.sqrt((paramInt3 * paramInt3 / 2.0F / Math.abs(this.jdField_b_of_type_Float) + Math.abs(paramInt2 - paramInt1)) * 2.0D / Math.abs(this.jdField_b_of_type_Float));
    this.jdField_a_of_type_Long -= (int)((f2 - f1) * 1000.0F);
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_d_of_type_Int = ((int)(-this.jdField_b_of_type_Float * f2));
  }
  
  private void e(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0) {}
    for (int j = paramInt1 - paramInt2;; j = paramInt3)
    {
      this.jdField_b_of_type_Float = a(j);
      d(paramInt1, paramInt2, paramInt3);
      b();
      return;
    }
  }
  
  void a()
  {
    this.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
    this.jdField_a_of_type_Boolean = true;
  }
  
  void a(float paramFloat)
  {
    this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int + Math.round((this.jdField_c_of_type_Int - this.jdField_a_of_type_Int) * paramFloat));
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = (paramInt1 + paramInt2);
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.jdField_e_of_type_Int = paramInt3;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_d_of_type_Int = 0;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.h = paramInt5;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_a_of_type_Float = paramInt2;
    this.f = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt1;
    if ((paramInt1 > paramInt4) || (paramInt1 < paramInt3)) {
      a(paramInt1, paramInt3, paramInt4, paramInt2);
    }
    do
    {
      return;
      this.i = 0;
      double d1 = 0.0D;
      if (paramInt2 != 0)
      {
        paramInt5 = a(paramInt2);
        this.f = paramInt5;
        this.jdField_e_of_type_Int = paramInt5;
        d1 = b(paramInt2);
      }
      this.g = ((int)(d1 * Math.signum(paramInt2)));
      this.jdField_c_of_type_Int = (this.g + paramInt1);
      if (this.jdField_c_of_type_Int < paramInt3)
      {
        b(this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, paramInt3);
        this.jdField_c_of_type_Int = paramInt3;
      }
    } while (this.jdField_c_of_type_Int <= paramInt4);
    b(this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, paramInt4);
    this.jdField_c_of_type_Int = paramInt4;
  }
  
  boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    switch (this.i)
    {
    }
    for (;;)
    {
      b();
      bool1 = true;
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.jdField_e_of_type_Int >= this.f);
      this.jdField_a_of_type_Int = this.jdField_c_of_type_Int;
      this.jdField_d_of_type_Int = ((int)this.jdField_a_of_type_Float);
      this.jdField_b_of_type_Float = a(this.jdField_d_of_type_Int);
      this.jdField_a_of_type_Long += this.jdField_e_of_type_Int;
      b();
      continue;
      this.jdField_a_of_type_Long += this.jdField_e_of_type_Int;
      c(this.jdField_c_of_type_Int, this.jdField_a_of_type_Int, 0);
    }
  }
  
  boolean b()
  {
    long l = AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long;
    if (l > this.jdField_e_of_type_Int) {
      return false;
    }
    double d1 = 0.0D;
    switch (this.i)
    {
    }
    for (;;)
    {
      int j = this.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = ((int)Math.round(d1) + j);
      return true;
      float f3 = (float)l / this.f;
      j = (int)(100.0F * f3);
      float f2 = 1.0F;
      float f1 = 0.0F;
      if (j < 100)
      {
        f2 = j / 100.0F;
        f1 = (j + 1) / 100.0F;
        f4 = jdField_a_of_type_ArrayOfFloat[j];
        f1 = (jdField_a_of_type_ArrayOfFloat[(j + 1)] - f4) / (f1 - f2);
        f2 = (f3 - f2) * f1 + f4;
      }
      d1 = f2 * this.g;
      this.jdField_a_of_type_Float = (f1 * this.g / this.f * 1000.0F);
      continue;
      f1 = (float)l / 1000.0F;
      this.jdField_a_of_type_Float = (this.jdField_d_of_type_Int + this.jdField_b_of_type_Float * f1);
      f2 = this.jdField_d_of_type_Int;
      d1 = f1 * (this.jdField_b_of_type_Float * f1) / 2.0F + f2 * f1;
      continue;
      f1 = (float)l / this.jdField_e_of_type_Int;
      f2 = f1 * f1;
      f3 = Math.signum(this.jdField_d_of_type_Int);
      d1 = this.h * f3 * (3.0F * f2 - 2.0F * f1 * f2);
      float f4 = this.h;
      this.jdField_a_of_type_Float = ((-f1 + f2) * (f3 * f4 * 6.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lrx
 * JD-Core Version:    0.7.0.1
 */