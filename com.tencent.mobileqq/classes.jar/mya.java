import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class mya
{
  private static float jdField_a_of_type_Float = 0.4F;
  private static final float[] jdField_a_of_type_ArrayOfFloat;
  private static float jdField_b_of_type_Float = 1.0F - jdField_a_of_type_Float;
  private static float c;
  private static float d = 1.0F / a(1.0F);
  private int jdField_a_of_type_Int;
  private final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final myb jdField_a_of_type_Myb;
  private final boolean jdField_a_of_type_Boolean;
  private final myb jdField_b_of_type_Myb;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[101];
    float f1 = 0.0F;
    int i = 0;
    if (i <= 100)
    {
      float f4 = i / 100.0F;
      float f2 = 1.0F;
      for (;;)
      {
        float f3 = (f2 - f1) / 2.0F + f1;
        float f5 = 3.0F * f3 * (1.0F - f3);
        float f6 = ((1.0F - f3) * jdField_a_of_type_Float + jdField_b_of_type_Float * f3) * f5 + f3 * f3 * f3;
        if (Math.abs(f6 - f4) < 1.E-005D)
        {
          jdField_a_of_type_ArrayOfFloat[i] = (f3 * f3 * f3 + f5);
          i += 1;
          break;
        }
        if (f6 > f4) {
          f2 = f3;
        } else {
          f1 = f3;
        }
      }
    }
    jdField_a_of_type_ArrayOfFloat[100] = 1.0F;
    c = 8.0F;
    d = 1.0F;
  }
  
  public mya(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public mya(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public mya(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Myb = new myb();
    this.jdField_b_of_type_Myb = new myb();
    myb.a(paramContext);
  }
  
  public static float a(float paramFloat)
  {
    paramFloat = c * paramFloat;
    if (paramFloat < 1.0F) {}
    for (paramFloat -= 1.0F - (float)Math.exp(-paramFloat);; paramFloat = (1.0F - (float)Math.exp(1.0F - paramFloat)) * (1.0F - 0.3678795F) + 0.3678795F) {
      return paramFloat * d;
    }
  }
  
  public final int a()
  {
    return myb.a(this.jdField_a_of_type_Myb);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Myb.a();
    this.jdField_b_of_type_Myb.a();
  }
  
  public final void a(float paramFloat)
  {
    this.jdField_a_of_type_Myb.a(paramFloat);
    this.jdField_b_of_type_Myb.a(paramFloat);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    if ((this.jdField_a_of_type_Boolean) && (!a()))
    {
      float f1 = myb.a(this.jdField_a_of_type_Myb);
      float f2 = myb.a(this.jdField_b_of_type_Myb);
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Myb.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9, paramInt11);
      this.jdField_b_of_type_Myb.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10, paramInt12);
      return;
    }
  }
  
  public final boolean a()
  {
    return (myb.a(this.jdField_a_of_type_Myb)) && (myb.a(this.jdField_b_of_type_Myb));
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
      long l = AnimationUtils.currentAnimationTimeMillis() - myb.a(this.jdField_a_of_type_Myb);
      int i = myb.b(this.jdField_a_of_type_Myb);
      if (l < i)
      {
        float f = (float)l / i;
        if (this.jdField_a_of_type_AndroidViewAnimationInterpolator == null) {}
        for (f = a(f);; f = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f))
        {
          if (!myb.a(this.jdField_a_of_type_Myb)) {
            this.jdField_a_of_type_Myb.b(f);
          }
          if (myb.a(this.jdField_b_of_type_Myb)) {
            break;
          }
          this.jdField_b_of_type_Myb.b(f);
          break;
        }
      }
      a();
      continue;
      if ((!myb.a(this.jdField_a_of_type_Myb)) && (!this.jdField_a_of_type_Myb.b()) && (!this.jdField_a_of_type_Myb.a())) {
        this.jdField_a_of_type_Myb.a();
      }
      if ((!myb.a(this.jdField_b_of_type_Myb)) && (!this.jdField_b_of_type_Myb.b()) && (!this.jdField_b_of_type_Myb.a())) {
        this.jdField_b_of_type_Myb.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mya
 * JD-Core Version:    0.7.0.1
 */