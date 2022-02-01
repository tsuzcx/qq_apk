import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class qdz
{
  public static qdz a;
  private long jdField_a_of_type_Long;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public qea a;
  public qeb a;
  public boolean a;
  
  private qdz()
  {
    this.jdField_a_of_type_Qea = new qea();
    this.jdField_a_of_type_Qeb = new qeb();
    if (a(BaseApplicationImpl.getApplication().getRuntime()))
    {
      this.jdField_a_of_type_Boolean = true;
      a(BaseApplicationImpl.getApplication().getRuntime(), false);
    }
  }
  
  public static qdz a()
  {
    if (jdField_a_of_type_Qdz == null) {}
    try
    {
      if (jdField_a_of_type_Qdz == null) {
        jdField_a_of_type_Qdz = new qdz();
      }
      return jdField_a_of_type_Qdz;
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
      localObject = bmhv.a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("readinjoy_ex_last_update_time", paramLong);
    bmhv.a((SharedPreferences.Editor)localObject, true);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = bmhv.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("simple_force_report_once", paramBoolean);
    bmhv.a(paramAppRuntime, true);
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = bmhv.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("simple_force_report_once", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qdz
 * JD-Core Version:    0.7.0.1
 */