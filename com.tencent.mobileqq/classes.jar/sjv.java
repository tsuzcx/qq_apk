import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;

public class sjv
{
  private static sjv jdField_a_of_type_Sjv;
  private Integer jdField_a_of_type_JavaLangInteger;
  private ubn jdField_a_of_type_Ubn;
  private Integer b;
  
  public static sjv a(Activity paramActivity)
  {
    int i;
    int j;
    if (jdField_a_of_type_Sjv == null)
    {
      jdField_a_of_type_Sjv = new sjv();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      i = localDisplayMetrics.widthPixels;
      j = localDisplayMetrics.heightPixels;
    }
    try
    {
      jdField_a_of_type_Sjv.jdField_a_of_type_Ubn = new ubn(paramActivity, i, j);
      jdField_a_of_type_Sjv.jdField_a_of_type_Ubn.a(new sjw());
      return jdField_a_of_type_Sjv;
    }
    catch (SecurityException paramActivity)
    {
      for (;;)
      {
        QLog.e("ReadInJoyScreenShotReporter", 1, "SecurityException error = " + paramActivity.toString());
        jdField_a_of_type_Sjv.jdField_a_of_type_Ubn = null;
      }
    }
  }
  
  public void a()
  {
    if (jdField_a_of_type_Sjv != null)
    {
      jdField_a_of_type_Sjv.jdField_a_of_type_JavaLangInteger = null;
      jdField_a_of_type_Sjv.b = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Sjv != null)
    {
      jdField_a_of_type_Sjv.jdField_a_of_type_JavaLangInteger = new Integer(paramInt2);
      jdField_a_of_type_Sjv.b = new Integer(paramInt1);
    }
  }
  
  public void b()
  {
    if ((jdField_a_of_type_Sjv != null) && (jdField_a_of_type_Sjv.jdField_a_of_type_Ubn != null))
    {
      jdField_a_of_type_Sjv.jdField_a_of_type_Ubn.a();
      jdField_a_of_type_Sjv.jdField_a_of_type_Ubn = null;
    }
    jdField_a_of_type_Sjv = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sjv
 * JD-Core Version:    0.7.0.1
 */