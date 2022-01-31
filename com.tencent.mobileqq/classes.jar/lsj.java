import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class lsj
{
  private int jdField_a_of_type_Int;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final lsk jdField_a_of_type_Lsk;
  private final boolean jdField_a_of_type_Boolean;
  private final lsk b;
  
  public lsj(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public lsj(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public lsj(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Lsk = new lsk();
    this.b = new lsk();
    lsk.a(paramContext);
  }
  
  public final int a()
  {
    return lsk.a(this.jdField_a_of_type_Lsk);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Lsk.a();
    this.b.a();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Lsk.a(paramInt1, paramInt3, paramInt5);
    this.b.a(paramInt2, paramInt4, paramInt5);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    if ((this.jdField_a_of_type_Boolean) && (!a()))
    {
      float f1 = lsk.a(this.jdField_a_of_type_Lsk);
      float f2 = lsk.a(this.b);
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Lsk.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
      this.b.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    lsk.a(this.jdField_a_of_type_Lsk, lsk.a(this.b, paramBoolean));
  }
  
  public final boolean a()
  {
    return (lsk.a(this.jdField_a_of_type_Lsk)) && (lsk.a(this.b));
  }
  
  public final int b()
  {
    return lsk.b(this.jdField_a_of_type_Lsk);
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
      long l = AnimationUtils.currentAnimationTimeMillis() - lsk.a(this.jdField_a_of_type_Lsk);
      int i = lsk.c(this.jdField_a_of_type_Lsk);
      if (l < i)
      {
        float f = (float)l / i;
        if (this.jdField_a_of_type_AndroidViewAnimationInterpolator == null) {}
        for (f = lsl.a(f);; f = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f))
        {
          this.jdField_a_of_type_Lsk.a(f);
          this.b.a(f);
          break;
        }
      }
      a();
      continue;
      if ((!lsk.a(this.jdField_a_of_type_Lsk)) && (!this.jdField_a_of_type_Lsk.b()) && (!this.jdField_a_of_type_Lsk.a())) {
        this.jdField_a_of_type_Lsk.a();
      }
      if ((!lsk.a(this.b)) && (!this.b.b()) && (!this.b.a())) {
        this.b.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lsj
 * JD-Core Version:    0.7.0.1
 */