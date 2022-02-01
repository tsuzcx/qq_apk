import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;

public class snw
{
  private static snw jdField_a_of_type_Snw;
  private Integer jdField_a_of_type_JavaLangInteger;
  private uic jdField_a_of_type_Uic;
  private Integer b;
  
  public static snw a(Activity paramActivity)
  {
    int i;
    int j;
    if (jdField_a_of_type_Snw == null)
    {
      jdField_a_of_type_Snw = new snw();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      i = localDisplayMetrics.widthPixels;
      j = localDisplayMetrics.heightPixels;
    }
    try
    {
      jdField_a_of_type_Snw.jdField_a_of_type_Uic = new uic(paramActivity, i, j);
      jdField_a_of_type_Snw.jdField_a_of_type_Uic.a(new snx());
      return jdField_a_of_type_Snw;
    }
    catch (SecurityException paramActivity)
    {
      for (;;)
      {
        QLog.e("ReadInJoyScreenShotReporter", 1, "SecurityException error = " + paramActivity.toString());
        jdField_a_of_type_Snw.jdField_a_of_type_Uic = null;
      }
    }
  }
  
  public void a()
  {
    if (jdField_a_of_type_Snw != null)
    {
      jdField_a_of_type_Snw.jdField_a_of_type_JavaLangInteger = null;
      jdField_a_of_type_Snw.b = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Snw != null)
    {
      jdField_a_of_type_Snw.jdField_a_of_type_JavaLangInteger = new Integer(paramInt2);
      jdField_a_of_type_Snw.b = new Integer(paramInt1);
    }
  }
  
  public void b()
  {
    if ((jdField_a_of_type_Snw != null) && (jdField_a_of_type_Snw.jdField_a_of_type_Uic != null))
    {
      jdField_a_of_type_Snw.jdField_a_of_type_Uic.a();
      jdField_a_of_type_Snw.jdField_a_of_type_Uic = null;
    }
    jdField_a_of_type_Snw = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     snw
 * JD-Core Version:    0.7.0.1
 */