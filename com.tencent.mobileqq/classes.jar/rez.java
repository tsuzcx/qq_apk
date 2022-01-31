import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class rez
{
  private static rez jdField_a_of_type_Rez;
  private Integer jdField_a_of_type_JavaLangInteger;
  private sib jdField_a_of_type_Sib;
  private Integer b;
  
  public static rez a(Activity paramActivity)
  {
    if (jdField_a_of_type_Rez == null)
    {
      jdField_a_of_type_Rez = new rez();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      int i = localDisplayMetrics.widthPixels;
      int j = localDisplayMetrics.heightPixels;
      jdField_a_of_type_Rez.jdField_a_of_type_Sib = new sib(paramActivity, i, j);
      jdField_a_of_type_Rez.jdField_a_of_type_Sib.a(new rfa());
    }
    return jdField_a_of_type_Rez;
  }
  
  public void a()
  {
    if (jdField_a_of_type_Rez != null)
    {
      jdField_a_of_type_Rez.jdField_a_of_type_JavaLangInteger = null;
      jdField_a_of_type_Rez.b = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Rez != null)
    {
      jdField_a_of_type_Rez.jdField_a_of_type_JavaLangInteger = new Integer(paramInt2);
      jdField_a_of_type_Rez.b = new Integer(paramInt1);
    }
  }
  
  public void b()
  {
    if ((jdField_a_of_type_Rez != null) && (jdField_a_of_type_Rez.jdField_a_of_type_Sib != null))
    {
      jdField_a_of_type_Rez.jdField_a_of_type_Sib.a();
      jdField_a_of_type_Rez.jdField_a_of_type_Sib = null;
    }
    jdField_a_of_type_Rez = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rez
 * JD-Core Version:    0.7.0.1
 */