import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class lrs
{
  private int jdField_a_of_type_Int;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final lrt jdField_a_of_type_Lrt;
  private final boolean jdField_a_of_type_Boolean;
  private final lrt b;
  
  public lrs(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public lrs(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public lrs(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Lrt = new lrt();
    this.b = new lrt();
    lrt.a(paramContext);
  }
  
  public final int a()
  {
    return lrt.a(this.jdField_a_of_type_Lrt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Lrt.a();
    this.b.a();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Lrt.a(paramInt1, paramInt3, paramInt5);
    this.b.a(paramInt2, paramInt4, paramInt5);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    if ((this.jdField_a_of_type_Boolean) && (!a()))
    {
      float f1 = lrt.a(this.jdField_a_of_type_Lrt);
      float f2 = lrt.a(this.b);
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Lrt.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
      this.b.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    lrt.a(this.jdField_a_of_type_Lrt, lrt.a(this.b, paramBoolean));
  }
  
  public final boolean a()
  {
    return (lrt.a(this.jdField_a_of_type_Lrt)) && (lrt.a(this.b));
  }
  
  public final int b()
  {
    return lrt.b(this.jdField_a_of_type_Lrt);
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
      long l = AnimationUtils.currentAnimationTimeMillis() - lrt.a(this.jdField_a_of_type_Lrt);
      int i = lrt.c(this.jdField_a_of_type_Lrt);
      if (l < i)
      {
        float f = (float)l / i;
        if (this.jdField_a_of_type_AndroidViewAnimationInterpolator == null) {}
        for (f = lru.a(f);; f = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f))
        {
          this.jdField_a_of_type_Lrt.a(f);
          this.b.a(f);
          break;
        }
      }
      a();
      continue;
      if ((!lrt.a(this.jdField_a_of_type_Lrt)) && (!this.jdField_a_of_type_Lrt.b()) && (!this.jdField_a_of_type_Lrt.a())) {
        this.jdField_a_of_type_Lrt.a();
      }
      if ((!lrt.a(this.b)) && (!this.b.b()) && (!this.b.a())) {
        this.b.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lrs
 * JD-Core Version:    0.7.0.1
 */