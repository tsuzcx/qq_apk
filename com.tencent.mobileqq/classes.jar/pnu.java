import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class pnu
{
  public static pnu a;
  private long jdField_a_of_type_Long;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public pnv a;
  public pnw a;
  public boolean a;
  
  private pnu()
  {
    this.jdField_a_of_type_Pnv = new pnv();
    this.jdField_a_of_type_Pnw = new pnw();
    if (a(BaseApplicationImpl.getApplication().getRuntime()))
    {
      this.jdField_a_of_type_Boolean = true;
      a(BaseApplicationImpl.getApplication().getRuntime(), false);
    }
  }
  
  public static pnu a()
  {
    if (jdField_a_of_type_Pnu == null) {}
    try
    {
      if (jdField_a_of_type_Pnu == null) {
        jdField_a_of_type_Pnu = new pnu();
      }
      return jdField_a_of_type_Pnu;
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
      localObject = bnrf.a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("readinjoy_ex_last_update_time", paramLong);
    bnrf.a((SharedPreferences.Editor)localObject, true);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = bnrf.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("simple_force_report_once", paramBoolean);
    bnrf.a(paramAppRuntime, true);
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = bnrf.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("simple_force_report_once", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pnu
 * JD-Core Version:    0.7.0.1
 */