import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class peg
{
  public static peg a;
  private long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString = "readinjoy_ex_last_update_time";
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public peh a;
  public pei a;
  public boolean a;
  
  private peg()
  {
    this.jdField_a_of_type_Peh = new peh();
    this.jdField_a_of_type_Pei = new pei();
    if (a(BaseApplicationImpl.getApplication().getRuntime()))
    {
      this.jdField_a_of_type_Boolean = true;
      a(BaseApplicationImpl.getApplication().getRuntime(), false);
    }
  }
  
  public static peg a()
  {
    if (jdField_a_of_type_Peg == null) {}
    try
    {
      if (jdField_a_of_type_Peg == null) {
        jdField_a_of_type_Peg = new peg();
      }
      return jdField_a_of_type_Peg;
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
      localObject = bjxj.a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("readinjoy_ex_last_update_time", paramLong);
    bjxj.a((SharedPreferences.Editor)localObject, true);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = bjxj.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("simple_force_report_once", paramBoolean);
    bjxj.a(paramAppRuntime, true);
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = bjxj.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("simple_force_report_once", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     peg
 * JD-Core Version:    0.7.0.1
 */