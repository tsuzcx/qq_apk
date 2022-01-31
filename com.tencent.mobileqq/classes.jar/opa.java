import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;

public class opa
  extends Thread
{
  private opa(AutoStartProgressBar paramAutoStartProgressBar) {}
  
  private boolean a()
  {
    boolean bool = false;
    if (this.a.jdField_a_of_type_Boolean) {
      bool = a(this.a.c, 400, 0.3300000131130219D, false);
    }
    return bool;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2, 1.0D, true);
  }
  
  private boolean a(int paramInt1, int paramInt2, double paramDouble)
  {
    return a(paramInt1, paramInt2, paramDouble, true);
  }
  
  private boolean a(int paramInt1, int paramInt2, double paramDouble, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      bool1 = false;
    }
    do
    {
      return bool1;
      if (this.a.e >= paramInt1) {
        break;
      }
      int i = (paramInt1 - this.a.e) / (paramInt2 / AutoStartProgressBar.jdField_a_of_type_Int);
      paramInt2 = i;
      if (i == 0) {
        paramInt2 = 1;
      }
      bool1 = bool2;
    } while (this.a.e > paramInt1);
    if ((paramBoolean) && (a())) {
      return false;
    }
    AutoStartProgressBar localAutoStartProgressBar = this.a;
    localAutoStartProgressBar.e += paramInt2;
    this.a.setAnimProgress(this.a.e, this.a.jdField_a_of_type_JavaLangString);
    this.a.postInvalidate();
    for (;;)
    {
      try
      {
        double d2 = AutoStartProgressBar.jdField_a_of_type_Int;
        if (paramDouble >= 0.0D) {
          break label170;
        }
        d1 = AutoStartProgressBar.a(this.a, (int)paramDouble);
        Thread.sleep((d1 * d2));
      }
      catch (InterruptedException localInterruptedException) {}
      break;
      label170:
      double d1 = paramDouble;
    }
    return false;
  }
  
  public void run()
  {
    if (!a((int)(40.0D + Math.random() * 31.0D) * this.a.c / 100, 1500)) {}
    while (!a(this.a.c * 90 / 100, 1500)) {
      return;
    }
    a(this.a.c * 99 / 100, AutoStartProgressBar.jdField_a_of_type_Int * 10, AutoStartProgressBar.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     opa
 * JD-Core Version:    0.7.0.1
 */