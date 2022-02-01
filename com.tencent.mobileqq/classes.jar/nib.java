import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class nib
{
  private static nib jdField_a_of_type_Nib;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public static nib a()
  {
    if (jdField_a_of_type_Nib == null) {}
    try
    {
      jdField_a_of_type_Nib = new nib();
      return jdField_a_of_type_Nib;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(String paramString, Intent paramIntent)
  {
    if ((paramIntent != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = paramIntent.getLongExtra("key_start_time", 0L);
      if (l2 != 0L) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, paramString + "[" + (l1 - l2) + "]");
      }
    }
  }
  
  public void b(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString)))
    {
      long l = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(l));
    }
  }
  
  public void c(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString)))
    {
      long l1 = SystemClock.elapsedRealtime();
      Long localLong = (Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localLong != null)
      {
        long l2 = localLong.longValue();
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, paramString + "[" + (l1 - l2) + "]");
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nib
 * JD-Core Version:    0.7.0.1
 */