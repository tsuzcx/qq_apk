import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.av.VideoCallStateMonitor.1;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class lce
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private List<lcf> jdField_a_of_type_JavaUtilList;
  private lcg jdField_a_of_type_Lcg;
  private boolean jdField_a_of_type_Boolean;
  private volatile int jdField_b_of_type_Int;
  private volatile long jdField_b_of_type_Long;
  private int jdField_c_of_type_Int;
  private volatile long jdField_c_of_type_Long;
  private long d;
  
  public lce(@NonNull VideoAppInterface paramVideoAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCallStateMonitor", 2, "VideoCallStateMonitor <" + this + "> created");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = "0";
    }
    this.jdField_a_of_type_ComTencentAvVideoController = VideoController.a();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.d = 0L;
    this.jdField_a_of_type_Lcg = new lcg(this);
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 2;
  }
  
  private int a()
  {
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().d;
    if (i == 1) {
      return 1;
    }
    if (i == 2) {
      return 2;
    }
    if (i == 0) {
      return 0;
    }
    return 2;
  }
  
  private long a(Map<String, Integer> paramMap, String paramString)
  {
    if ((paramMap != null) && (paramMap.containsKey(paramString))) {
      return ((Integer)paramMap.get(paramString)).intValue();
    }
    return -1L;
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCallStateMonitor", 2, "begin monitor " + paramInt);
    }
    Map localMap = bhlo.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
    if (a(localMap, "summary.total-pss") <= 0L) {
      if (QLog.isColorLevel()) {
        QLog.e("VideoCallStateMonitor", 1, "getTotalPss error!");
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Long > 0L)
      {
        long l = SystemClock.uptimeMillis() - this.jdField_b_of_type_Long;
        if (l > 0L) {
          b(l);
        }
      }
      return;
      a(SystemClock.uptimeMillis(), localMap);
      a(bhlo.e() / 1000L);
    }
  }
  
  private void a(long paramLong)
  {
    if (paramLong > 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCallStateMonitor", 2, "call avail mem: " + paramLong + "kb");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_JavaLangString, "availMem2", String.valueOf(paramLong));
    }
  }
  
  private void a(long paramLong, Map<String, Integer> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    this.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_Long += a(paramMap, "summary.total-pss");
    long l = this.jdField_a_of_type_Long / this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_JavaLangString, "avgMemory", String.valueOf(l));
    if (QLog.isColorLevel()) {
      QLog.d("VideoCallStateMonitor", 2, "call avg pss: " + l + "kb");
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCallStateMonitor", 2, String.format("report memory type=%s value=%sKB, time=%s", new Object[] { Integer.valueOf(a()), paramMap.toString(), Long.valueOf(paramLong) }));
    }
    this.jdField_a_of_type_JavaUtilList.add(new lcf(a(), a(paramMap, "summary.total-pss"), a(paramMap, "summary.java-heap"), a(paramMap, "summary.native-heap"), a(paramMap, "summary.code"), a(paramMap, "summary.graphics"), paramLong));
  }
  
  private void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCallStateMonitor", 2, "call time: " + paramLong + "ms");
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_JavaLangString, "callDur", String.valueOf(paramLong));
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCallStateMonitor", 2, "postReportMemory size = " + this.jdField_a_of_type_JavaUtilList.size());
    }
    int j = this.jdField_a_of_type_JavaUtilList.size();
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    long l1;
    long l2;
    long l3;
    long l4;
    long l5;
    long l6;
    int i;
    Object localObject3;
    lcf locallcf;
    if (j >= 4)
    {
      l1 = ((lcf)this.jdField_a_of_type_JavaUtilList.get(j - 1 - 1)).jdField_a_of_type_Long;
      l2 = ((lcf)this.jdField_a_of_type_JavaUtilList.get(1)).jdField_a_of_type_Long;
      l3 = ((lcf)this.jdField_a_of_type_JavaUtilList.get(j - 1 - 1)).jdField_b_of_type_Long;
      l4 = ((lcf)this.jdField_a_of_type_JavaUtilList.get(1)).jdField_b_of_type_Long;
      l5 = ((lcf)this.jdField_a_of_type_JavaUtilList.get(j - 1 - 1)).jdField_c_of_type_Long;
      l6 = ((lcf)this.jdField_a_of_type_JavaUtilList.get(1)).jdField_c_of_type_Long;
      i = 1;
      if (i >= j - 1 - 1) {
        break label1067;
      }
      localObject3 = (lcf)this.jdField_a_of_type_JavaUtilList.get(i);
      locallcf = (lcf)this.jdField_a_of_type_JavaUtilList.get(i + 1);
      if ((((lcf)localObject3).jdField_a_of_type_Int != 0) && (((lcf)localObject3).jdField_a_of_type_Int != locallcf.jdField_a_of_type_Int))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoCallStateMonitor", 2, "postReportMemory failed, session type changed");
        }
        i = 1;
      }
    }
    for (;;)
    {
      label293:
      double d2;
      double d3;
      double d1;
      if (i == 0)
      {
        d2 = 0.0D;
        d3 = 0.0D;
        localObject3 = ((List)localObject1).iterator();
        d1 = 0.0D;
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            d1 = ((Double)((Iterator)localObject3).next()).doubleValue() + d1;
            continue;
            this.jdField_c_of_type_Int = locallcf.jdField_a_of_type_Int;
            if ((!((lcf)localObject3).a()) || (!locallcf.a())) {
              if (QLog.isColorLevel()) {
                QLog.d("VideoCallStateMonitor", 2, "postReportMemory failed, cannot get memory info");
              }
            }
          }
        }
      }
      label1009:
      do
      {
        do
        {
          return;
          d1 = locallcf.f - ((lcf)localObject3).f;
          d2 = locallcf.jdField_a_of_type_Long - ((lcf)localObject3).jdField_a_of_type_Long;
          d3 = locallcf.jdField_b_of_type_Long - ((lcf)localObject3).jdField_b_of_type_Long;
          double d4 = locallcf.jdField_c_of_type_Long - ((lcf)localObject3).jdField_c_of_type_Long;
          if (d1 <= 0.0D)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VideoCallStateMonitor", 2, "postReportMemory failed, timestamp fatal error");
            }
            i = 1;
            break label293;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoCallStateMonitor", 2, String.format("total pss grow %skb, java pss grow %skb, native pss grow %skb [in %sms]", new Object[] { Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d1) }));
          }
          ((List)localObject1).add(Double.valueOf(d2 * 1000.0D / d1));
          ((List)localObject2).add(Double.valueOf(1000.0D * d3 / d1));
          localArrayList.add(Double.valueOf(d4 * 1000.0D / d1));
          i += 1;
          break;
          localObject3 = ((List)localObject2).iterator();
          while (((Iterator)localObject3).hasNext()) {
            d2 = ((Double)((Iterator)localObject3).next()).doubleValue() + d2;
          }
          localObject3 = localArrayList.iterator();
          while (((Iterator)localObject3).hasNext()) {
            d3 = ((Double)((Iterator)localObject3).next()).doubleValue() + d3;
          }
          d1 /= ((List)localObject1).size();
          d2 /= ((List)localObject2).size();
          d3 /= localArrayList.size();
          localObject2 = new HashMap(9);
          ((HashMap)localObject2).put("selfUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
          ((HashMap)localObject2).put("peerUin", this.jdField_a_of_type_JavaLangString);
          ((HashMap)localObject2).put("sessionId", String.valueOf(this.d));
          ((HashMap)localObject2).put("startTimestamp", String.valueOf(this.jdField_c_of_type_Long));
          if (this.jdField_a_of_type_Boolean)
          {
            localObject1 = "1";
            ((HashMap)localObject2).put("firstChat", localObject1);
            ((HashMap)localObject2).put("chatType", String.valueOf(this.jdField_c_of_type_Int));
            ((HashMap)localObject2).put("device_memory", String.valueOf(bhlo.d() / 1024L));
            ((HashMap)localObject2).put("totalPss_growth", String.valueOf(l1 - l2));
            ((HashMap)localObject2).put("totalPss_growthRate", String.valueOf(d1));
            ((HashMap)localObject2).put("javaPss_growth", String.valueOf(l3 - l4));
            ((HashMap)localObject2).put("javaPss_growthRate", String.valueOf(d2));
            ((HashMap)localObject2).put("nativePss_growth", String.valueOf(l5 - l6));
            ((HashMap)localObject2).put("nativePss_growthRate", String.valueOf(d3));
            if (this.jdField_b_of_type_Long <= 0L) {
              break label1009;
            }
          }
          for (localObject1 = String.valueOf(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long);; localObject1 = "")
          {
            ((HashMap)localObject2).put("call_dur", localObject1);
            if (QLog.isColorLevel()) {
              QLog.d("VideoCallStateMonitor", 2, "postReportMemory success: " + ((HashMap)localObject2).toString());
            }
            ThreadManager.post(new VideoCallStateMonitor.1(this, (HashMap)localObject2), 5, null, false);
            return;
            localObject1 = "0";
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VideoCallStateMonitor", 2, "postReportMemory failed, skip");
        return;
      } while (!QLog.isColorLevel());
      QLog.d("VideoCallStateMonitor", 2, "postReportMemory failed, node size = " + j);
      return;
      label1067:
      i = 0;
    }
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Int == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCallStateMonitor", 2, "startCallMonitor");
      }
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.h;
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      this.d = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Lcg.a();
      this.jdField_b_of_type_Int = 1;
      return;
    }
    QLog.e("VideoCallStateMonitor", 1, "startCallMonitor state error");
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Int != 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCallStateMonitor", 2, "stopMonitor " + Log.getStackTraceString(new RuntimeException()));
      }
      this.jdField_b_of_type_Int = 2;
      this.jdField_a_of_type_Lcg.b();
      return;
    }
    QLog.e("VideoCallStateMonitor", 1, "stopMonitor state error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lce
 * JD-Core Version:    0.7.0.1
 */