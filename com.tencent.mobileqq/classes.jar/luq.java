import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class luq
{
  private int jdField_a_of_type_Int;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final lur jdField_a_of_type_Lur;
  private final boolean jdField_a_of_type_Boolean;
  private final lur b;
  
  public luq(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public luq(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public luq(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Lur = new lur();
    this.b = new lur();
    lur.a(paramContext);
  }
  
  public final int a()
  {
    return lur.a(this.jdField_a_of_type_Lur);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Lur.a();
    this.b.a();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Lur.a(paramInt1, paramInt3, paramInt5);
    this.b.a(paramInt2, paramInt4, paramInt5);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    if ((this.jdField_a_of_type_Boolean) && (!a()))
    {
      float f1 = lur.a(this.jdField_a_of_type_Lur);
      float f2 = lur.a(this.b);
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Lur.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
      this.b.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    lur.a(this.jdField_a_of_type_Lur, lur.a(this.b, paramBoolean));
  }
  
  public final boolean a()
  {
    return (lur.a(this.jdField_a_of_type_Lur)) && (lur.a(this.b));
  }
  
  public final int b()
  {
    return lur.b(this.jdField_a_of_type_Lur);
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
      long l = AnimationUtils.currentAnimationTimeMillis() - lur.a(this.jdField_a_of_type_Lur);
      int i = lur.c(this.jdField_a_of_type_Lur);
      if (l < i)
      {
        float f = (float)l / i;
        if (this.jdField_a_of_type_AndroidViewAnimationInterpolator == null) {}
        for (f = lus.a(f);; f = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f))
        {
          this.jdField_a_of_type_Lur.a(f);
          this.b.a(f);
          break;
        }
      }
      a();
      continue;
      if ((!lur.a(this.jdField_a_of_type_Lur)) && (!this.jdField_a_of_type_Lur.b()) && (!this.jdField_a_of_type_Lur.a())) {
        this.jdField_a_of_type_Lur.a();
      }
      if ((!lur.a(this.b)) && (!this.b.b()) && (!this.b.a())) {
        this.b.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     luq
 * JD-Core Version:    0.7.0.1
 */