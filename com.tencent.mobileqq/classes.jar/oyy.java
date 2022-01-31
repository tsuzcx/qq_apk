import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class oyy
{
  public static oyy a;
  private long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString = "readinjoy_ex_last_update_time";
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public oyz a;
  public oza a;
  public boolean a;
  
  private oyy()
  {
    this.jdField_a_of_type_Oyz = new oyz();
    this.jdField_a_of_type_Oza = new oza();
    if (a(BaseApplicationImpl.getApplication().getRuntime()))
    {
      this.jdField_a_of_type_Boolean = true;
      a(BaseApplicationImpl.getApplication().getRuntime(), false);
    }
  }
  
  public static oyy a()
  {
    if (jdField_a_of_type_Oyy == null) {}
    try
    {
      if (jdField_a_of_type_Oyy == null) {
        jdField_a_of_type_Oyy = new oyy();
      }
      return jdField_a_of_type_Oyy;
    }
    finally {}
  }
  
  private void a(long paramLong)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      return;
      localObject = bhvy.a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("readinjoy_ex_last_update_time", paramLong);
    bhvy.a((SharedPreferences.Editor)localObject, true);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = bhvy.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("simple_force_report_once", paramBoolean);
    bhvy.a(paramAppRuntime, true);
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = bhvy.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("simple_force_report_once", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyy
 * JD-Core Version:    0.7.0.1
 */