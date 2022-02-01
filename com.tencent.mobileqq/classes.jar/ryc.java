import android.annotation.SuppressLint;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

class ryc
  implements rye
{
  private long jdField_a_of_type_Long;
  private Method jdField_a_of_type_JavaLangReflectMethod;
  private long jdField_b_of_type_Long;
  private Method jdField_b_of_type_JavaLangReflectMethod;
  private long c;
  
  @SuppressLint({"DiscouragedPrivateApi"})
  private final long b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaLangReflectMethod == null)
      {
        this.jdField_a_of_type_JavaLangReflectMethod = TrafficStats.class.getDeclaredMethod("getLoopbackRxBytes", new Class[0]);
        this.jdField_a_of_type_JavaLangReflectMethod.setAccessible(true);
      }
      long l = ((Long)this.jdField_a_of_type_JavaLangReflectMethod.invoke(null, new Object[0])).longValue();
      return l;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DefaultBandwidthObtainer", 2, "getLoopbackRxBytesIn28: ", localException);
      }
    }
    return 0L;
  }
  
  @SuppressLint({"DiscouragedPrivateApi"})
  private final long c()
  {
    try
    {
      if (this.jdField_b_of_type_JavaLangReflectMethod == null)
      {
        this.jdField_b_of_type_JavaLangReflectMethod = TrafficStats.class.getDeclaredMethod("getRxBytes", new Class[] { String.class });
        this.jdField_b_of_type_JavaLangReflectMethod.setAccessible(true);
      }
      long l = ((Long)this.jdField_b_of_type_JavaLangReflectMethod.invoke(null, new Object[] { "lo" })).longValue();
      return l;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DefaultBandwidthObtainer", 2, "getLoopbackRxBytesIn14: ", localException);
      }
    }
    return 0L;
  }
  
  public long a()
  {
    int i = Build.VERSION.SDK_INT;
    long l4 = SystemClock.elapsedRealtime();
    long l5 = TrafficStats.getTotalRxBytes();
    long l1;
    long l3;
    if (i >= 28)
    {
      l1 = b();
      if ((this.jdField_a_of_type_Long <= 0L) || (this.jdField_b_of_type_Long <= 0L)) {
        break label236;
      }
      long l6 = l5 - this.jdField_a_of_type_Long;
      long l7 = l1 - this.jdField_b_of_type_Long;
      i = (int)Math.max((l4 - this.c) / 1000L, 1L);
      l3 = Math.max(0L, (l6 - l7) / 1024L) / i;
      l2 = l3;
      if (QLog.isColorLevel()) {
        QLog.d("DefaultBandwidthObtainer", 2, "calculateBandwidth: totalBytes=" + l6 + ", loopbackBytes=" + l7 + ", bandwidth=" + l3 + "kb/s");
      }
    }
    label236:
    for (long l2 = l3;; l2 = 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DefaultBandwidthObtainer", 2, "getCurrentBandwidth: bandwidth=" + l2 + "kb/s");
      }
      this.jdField_a_of_type_Long = l5;
      this.jdField_b_of_type_Long = l1;
      this.c = l4;
      return l2;
      if (i >= 14)
      {
        l1 = c();
        break;
      }
      l1 = 0L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ryc
 * JD-Core Version:    0.7.0.1
 */