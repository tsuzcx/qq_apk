import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class rfc
{
  private static rfc jdField_a_of_type_Rfc;
  private Integer jdField_a_of_type_JavaLangInteger;
  private sie jdField_a_of_type_Sie;
  private Integer b;
  
  public static rfc a(Activity paramActivity)
  {
    if (jdField_a_of_type_Rfc == null)
    {
      jdField_a_of_type_Rfc = new rfc();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      int i = localDisplayMetrics.widthPixels;
      int j = localDisplayMetrics.heightPixels;
      jdField_a_of_type_Rfc.jdField_a_of_type_Sie = new sie(paramActivity, i, j);
      jdField_a_of_type_Rfc.jdField_a_of_type_Sie.a(new rfd());
    }
    return jdField_a_of_type_Rfc;
  }
  
  public void a()
  {
    if (jdField_a_of_type_Rfc != null)
    {
      jdField_a_of_type_Rfc.jdField_a_of_type_JavaLangInteger = null;
      jdField_a_of_type_Rfc.b = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Rfc != null)
    {
      jdField_a_of_type_Rfc.jdField_a_of_type_JavaLangInteger = new Integer(paramInt2);
      jdField_a_of_type_Rfc.b = new Integer(paramInt1);
    }
  }
  
  public void b()
  {
    if ((jdField_a_of_type_Rfc != null) && (jdField_a_of_type_Rfc.jdField_a_of_type_Sie != null))
    {
      jdField_a_of_type_Rfc.jdField_a_of_type_Sie.a();
      jdField_a_of_type_Rfc.jdField_a_of_type_Sie = null;
    }
    jdField_a_of_type_Rfc = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rfc
 * JD-Core Version:    0.7.0.1
 */