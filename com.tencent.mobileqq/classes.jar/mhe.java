import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class mhe
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private final ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private final HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private long b;
  private long c;
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.c = 0L;
  }
  
  public void a(long paramLong)
  {
    long l = SystemClock.elapsedRealtime() - this.b;
    this.jdField_a_of_type_Int += 1;
    this.c += l;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(500);
      localStringBuilder.append("frameEnd, frameIndex: ").append(paramLong).append(", curFrameCost: ").append(l).append(", frameCount: ").append(this.jdField_a_of_type_Int).append(", frameTotalCost: ").append(this.c).append(", stepCost{");
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Long localLong = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(str);
        localStringBuilder.append(str).append(" : ").append(localLong).append(", ");
      }
      localStringBuilder.append("}, ");
      QLog.i("PerfRecorder", 2, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Long = 0L;
    this.b = SystemClock.elapsedRealtime();
  }
  
  public void b(String paramString)
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramString))) {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mhe
 * JD-Core Version:    0.7.0.1
 */