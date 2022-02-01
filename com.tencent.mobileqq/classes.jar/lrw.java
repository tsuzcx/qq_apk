import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class lrw
{
  private int jdField_a_of_type_Int;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final lrx jdField_a_of_type_Lrx;
  private final boolean jdField_a_of_type_Boolean;
  private final lrx b;
  
  public lrw(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public lrw(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public lrw(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Lrx = new lrx();
    this.b = new lrx();
    lrx.a(paramContext);
  }
  
  public final int a()
  {
    return lrx.a(this.jdField_a_of_type_Lrx);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Lrx.a();
    this.b.a();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Lrx.a(paramInt1, paramInt3, paramInt5);
    this.b.a(paramInt2, paramInt4, paramInt5);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    if ((this.jdField_a_of_type_Boolean) && (!a()))
    {
      float f1 = lrx.a(this.jdField_a_of_type_Lrx);
      float f2 = lrx.a(this.b);
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Lrx.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
      this.b.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    lrx.a(this.jdField_a_of_type_Lrx, lrx.a(this.b, paramBoolean));
  }
  
  public final boolean a()
  {
    return (lrx.a(this.jdField_a_of_type_Lrx)) && (lrx.a(this.b));
  }
  
  public final int b()
  {
    return lrx.b(this.jdField_a_of_type_Lrx);
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
      long l = AnimationUtils.currentAnimationTimeMillis() - lrx.a(this.jdField_a_of_type_Lrx);
      int i = lrx.c(this.jdField_a_of_type_Lrx);
      if (l < i)
      {
        float f = (float)l / i;
        if (this.jdField_a_of_type_AndroidViewAnimationInterpolator == null) {}
        for (f = lry.a(f);; f = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f))
        {
          this.jdField_a_of_type_Lrx.a(f);
          this.b.a(f);
          break;
        }
      }
      a();
      continue;
      if ((!lrx.a(this.jdField_a_of_type_Lrx)) && (!this.jdField_a_of_type_Lrx.b()) && (!this.jdField_a_of_type_Lrx.a())) {
        this.jdField_a_of_type_Lrx.a();
      }
      if ((!lrx.a(this.b)) && (!this.b.b()) && (!this.b.a())) {
        this.b.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lrw
 * JD-Core Version:    0.7.0.1
 */