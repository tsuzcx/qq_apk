import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class hv
{
  public static int a;
  private static ConcurrentHashMap<String, AtomicInteger> a;
  public static AtomicBoolean a;
  public static AtomicInteger a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, double paramDouble)
  {
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      if (QLog.isColorLevel()) {
        QLog.d("VasFont.Report", 2, "report not enable");
      }
    }
    AtomicInteger localAtomicInteger1;
    long l3;
    int i;
    do
    {
      return;
      AtomicInteger localAtomicInteger2 = (AtomicInteger)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      localAtomicInteger1 = localAtomicInteger2;
      if (localAtomicInteger2 == null)
      {
        localAtomicInteger1 = new AtomicInteger();
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localAtomicInteger1);
      }
      long l1 = BaseApplicationImpl.getApplication().getSharedPreferences("font_report_sp", 0).getLong(paramString, 0L);
      long l2 = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() * 60 * 60 * 1000;
      l3 = System.currentTimeMillis();
      if (l3 - l1 <= l2) {
        break;
      }
      i = localAtomicInteger1.incrementAndGet();
    } while (i != jdField_a_of_type_Int);
    VasWebviewUtil.reportFontPerformance(paramString, paramInt1, paramInt2, paramInt3, paramDouble, i);
    BaseApplicationImpl.getApplication().getSharedPreferences("font_report_sp", 0).edit().putLong(paramString, l3).commit();
    return;
    localAtomicInteger1.set(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     hv
 * JD-Core Version:    0.7.0.1
 */