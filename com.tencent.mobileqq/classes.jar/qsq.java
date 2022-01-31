import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class qsq
{
  private static qsq jdField_a_of_type_Qsq;
  private Integer jdField_a_of_type_JavaLangInteger;
  private rvm jdField_a_of_type_Rvm;
  private Integer b;
  
  public static qsq a(Activity paramActivity)
  {
    if (jdField_a_of_type_Qsq == null)
    {
      jdField_a_of_type_Qsq = new qsq();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      int i = localDisplayMetrics.widthPixels;
      int j = localDisplayMetrics.heightPixels;
      jdField_a_of_type_Qsq.jdField_a_of_type_Rvm = new rvm(paramActivity, i, j);
      jdField_a_of_type_Qsq.jdField_a_of_type_Rvm.a(new qsr());
    }
    return jdField_a_of_type_Qsq;
  }
  
  public void a()
  {
    if (jdField_a_of_type_Qsq != null)
    {
      jdField_a_of_type_Qsq.jdField_a_of_type_JavaLangInteger = null;
      jdField_a_of_type_Qsq.b = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Qsq != null)
    {
      jdField_a_of_type_Qsq.jdField_a_of_type_JavaLangInteger = new Integer(paramInt2);
      jdField_a_of_type_Qsq.b = new Integer(paramInt1);
    }
  }
  
  public void b()
  {
    if ((jdField_a_of_type_Qsq != null) && (jdField_a_of_type_Qsq.jdField_a_of_type_Rvm != null))
    {
      jdField_a_of_type_Qsq.jdField_a_of_type_Rvm.a();
      jdField_a_of_type_Qsq.jdField_a_of_type_Rvm = null;
    }
    jdField_a_of_type_Qsq = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qsq
 * JD-Core Version:    0.7.0.1
 */