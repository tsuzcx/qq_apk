import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;

public class ruv
{
  private static ruv jdField_a_of_type_Ruv;
  private Integer jdField_a_of_type_JavaLangInteger;
  private szw jdField_a_of_type_Szw;
  private Integer b;
  
  public static ruv a(Activity paramActivity)
  {
    int i;
    int j;
    if (jdField_a_of_type_Ruv == null)
    {
      jdField_a_of_type_Ruv = new ruv();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      i = localDisplayMetrics.widthPixels;
      j = localDisplayMetrics.heightPixels;
    }
    try
    {
      jdField_a_of_type_Ruv.jdField_a_of_type_Szw = new szw(paramActivity, i, j);
      jdField_a_of_type_Ruv.jdField_a_of_type_Szw.a(new ruw());
      return jdField_a_of_type_Ruv;
    }
    catch (SecurityException paramActivity)
    {
      for (;;)
      {
        QLog.e("ReadInJoyScreenShotReporter", 1, "SecurityException error = " + paramActivity.toString());
        jdField_a_of_type_Ruv.jdField_a_of_type_Szw = null;
      }
    }
  }
  
  public void a()
  {
    if (jdField_a_of_type_Ruv != null)
    {
      jdField_a_of_type_Ruv.jdField_a_of_type_JavaLangInteger = null;
      jdField_a_of_type_Ruv.b = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Ruv != null)
    {
      jdField_a_of_type_Ruv.jdField_a_of_type_JavaLangInteger = new Integer(paramInt2);
      jdField_a_of_type_Ruv.b = new Integer(paramInt1);
    }
  }
  
  public void b()
  {
    if ((jdField_a_of_type_Ruv != null) && (jdField_a_of_type_Ruv.jdField_a_of_type_Szw != null))
    {
      jdField_a_of_type_Ruv.jdField_a_of_type_Szw.a();
      jdField_a_of_type_Ruv.jdField_a_of_type_Szw = null;
    }
    jdField_a_of_type_Ruv = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ruv
 * JD-Core Version:    0.7.0.1
 */