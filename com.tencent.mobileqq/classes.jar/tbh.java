import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;

public class tbh
{
  private static tbh jdField_a_of_type_Tbh;
  private Integer jdField_a_of_type_JavaLangInteger;
  private uvz jdField_a_of_type_Uvz;
  private Integer b;
  
  public static tbh a(Activity paramActivity)
  {
    int i;
    int j;
    if (jdField_a_of_type_Tbh == null)
    {
      jdField_a_of_type_Tbh = new tbh();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      i = localDisplayMetrics.widthPixels;
      j = localDisplayMetrics.heightPixels;
    }
    try
    {
      jdField_a_of_type_Tbh.jdField_a_of_type_Uvz = new uvz(paramActivity, i, j);
      jdField_a_of_type_Tbh.jdField_a_of_type_Uvz.a(new tbi());
      return jdField_a_of_type_Tbh;
    }
    catch (SecurityException paramActivity)
    {
      for (;;)
      {
        QLog.e("ReadInJoyScreenShotReporter", 1, "SecurityException error = " + paramActivity.toString());
        jdField_a_of_type_Tbh.jdField_a_of_type_Uvz = null;
      }
    }
  }
  
  public void a()
  {
    if (jdField_a_of_type_Tbh != null)
    {
      jdField_a_of_type_Tbh.jdField_a_of_type_JavaLangInteger = null;
      jdField_a_of_type_Tbh.b = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Tbh != null)
    {
      jdField_a_of_type_Tbh.jdField_a_of_type_JavaLangInteger = new Integer(paramInt2);
      jdField_a_of_type_Tbh.b = new Integer(paramInt1);
    }
  }
  
  public void b()
  {
    if ((jdField_a_of_type_Tbh != null) && (jdField_a_of_type_Tbh.jdField_a_of_type_Uvz != null))
    {
      jdField_a_of_type_Tbh.jdField_a_of_type_Uvz.a();
      jdField_a_of_type_Tbh.jdField_a_of_type_Uvz = null;
    }
    jdField_a_of_type_Tbh = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tbh
 * JD-Core Version:    0.7.0.1
 */