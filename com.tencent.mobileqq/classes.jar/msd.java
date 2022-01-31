import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class msd
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private final ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private final HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private boolean jdField_a_of_type_Boolean;
  private final long[] jdField_a_of_type_ArrayOfLong = new long[20];
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private long d;
  private final long e;
  
  public msd()
  {
    if (AudioHelper.a(34) == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      while (i < this.jdField_a_of_type_ArrayOfLong.length)
      {
        this.jdField_a_of_type_ArrayOfLong[i] = 0L;
        i += 1;
      }
      bool = false;
    }
    i = AEFilterSupport.a();
    if (i >= 7) {
      this.e = 30L;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PerfRecorder", 2, "logPerfData[" + this.jdField_a_of_type_Boolean + "], machineLevel[" + i + "], frameCostLine[" + this.e + "]");
      }
      return;
      if (i >= 4) {
        this.e = 48L;
      } else {
        this.e = 66L;
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject = localStringBuilder.append("endOfOneChat, frameAvgCost[").append(this.d).append("], frameCount[").append(this.jdField_a_of_type_Int).append("], frameTotalCost[").append(this.jdField_c_of_type_Long).append("], frameAvgCost2[");
      long l;
      if (this.jdField_a_of_type_Int > 0)
      {
        l = this.jdField_c_of_type_Long / this.jdField_a_of_type_Int;
        localObject = ((StringBuilder)localObject).append(l).append("], frameCostLine[").append(this.e).append("], frameCostOverLineCnt[").append(this.jdField_b_of_type_Int).append("], frameCostOverLine[");
        if (this.jdField_a_of_type_Int <= 0) {
          break label193;
        }
      }
      label193:
      for (float f = this.jdField_b_of_type_Int / this.jdField_a_of_type_Int;; f = 0.0F)
      {
        ((StringBuilder)localObject).append(f).append("], {");
        localObject = this.jdField_a_of_type_ArrayOfLong;
        int j = localObject.length;
        i = 0;
        while (i < j)
        {
          localStringBuilder.append(localObject[i]).append(",");
          i += 1;
        }
        l = 0L;
        break;
      }
      localStringBuilder.append("}");
      QLog.i("PerfRecorder", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Long = 0L;
    this.d = 0L;
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfLong.length)
    {
      this.jdField_a_of_type_ArrayOfLong[i] = 0L;
      i += 1;
    }
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(long paramLong)
  {
    long l3 = SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long;
    this.jdField_a_of_type_Int += 1;
    this.jdField_c_of_type_Long += l3;
    if (this.d == 0L) {}
    for (this.d = l3;; this.d = ((this.d + l3) / 2L))
    {
      if (l3 > this.jdField_a_of_type_ArrayOfLong[this.jdField_c_of_type_Int]) {
        this.jdField_a_of_type_ArrayOfLong[this.jdField_c_of_type_Int] = l3;
      }
      long l1 = this.jdField_a_of_type_ArrayOfLong[this.jdField_c_of_type_Int];
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLong.length)
      {
        long l2 = l1;
        if (this.jdField_a_of_type_ArrayOfLong[i] < l1)
        {
          l2 = this.jdField_a_of_type_ArrayOfLong[i];
          this.jdField_c_of_type_Int = i;
        }
        i += 1;
        l1 = l2;
      }
    }
    if (l3 > this.e) {
      this.jdField_b_of_type_Int += 1;
    }
    if ((this.jdField_a_of_type_Boolean) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder(500);
      localStringBuilder.append("frameEnd, frameIndex: ").append(paramLong).append(", curFrameCost: ").append(l3).append(", frameCount: ").append(this.jdField_a_of_type_Int).append(", frameTotalCost: ").append(this.jdField_c_of_type_Long).append(", stepCost{");
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
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  public void b(String paramString)
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramString))) {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     msd
 * JD-Core Version:    0.7.0.1
 */