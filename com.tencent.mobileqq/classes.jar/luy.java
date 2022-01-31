import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.perfstat.MemoryPerfStat.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class luy
  implements Handler.Callback
{
  private static luy jdField_a_of_type_Luy;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = bdgk.d() / 124L;
  private final bhtd jdField_a_of_type_Bhtd = new bhtd(Looper.getMainLooper(), this);
  private String jdField_a_of_type_JavaLangString;
  private final HashMap<String, luz> jdField_a_of_type_JavaUtilHashMap = new HashMap(5);
  private final int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private int c;
  
  public static luy a()
  {
    if (jdField_a_of_type_Luy == null) {
      jdField_a_of_type_Luy = new luy();
    }
    return jdField_a_of_type_Luy;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramInt1 != 0);
      a().a();
      return;
    } while (paramInt1 == 0);
    a().b();
  }
  
  @TargetApi(23)
  private void a(Context paramContext)
  {
    long l2 = SystemClock.elapsedRealtime();
    if (paramContext == null) {}
    for (;;)
    {
      return;
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext == null) {
        continue;
      }
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_ArrayOfInt[0] = Process.myPid();
      try
      {
        paramContext = paramContext.getProcessMemoryInfo(this.jdField_a_of_type_ArrayOfInt);
        if ((paramContext != null) && (paramContext.length > 0))
        {
          paramContext = paramContext[0];
          if (paramContext == null) {
            continue;
          }
          if (Build.VERSION.SDK_INT >= 23)
          {
            paramContext = paramContext.getMemoryStats();
            localIterator = paramContext.keySet().iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              str1 = (String)localIterator.next();
              str2 = (String)paramContext.get(str1);
            } while ((str2 == null) || (str2.length() == 0));
          }
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          Iterator localIterator;
          String str1;
          try
          {
            String str2;
            l1 = Long.parseLong(str2);
            if (l1 == 0L) {
              continue;
            }
            a(str1, l1);
            continue;
            paramContext = paramContext;
            paramContext = null;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            l1 = 0L;
            continue;
          }
          a("summary.total-pss", paramContext.getTotalPss());
          a("summary.java-heap", paramContext.dalvikPrivateDirty);
          a("summary.native-heap", paramContext.nativePrivateDirty);
          long l1 = Math.abs(SystemClock.elapsedRealtime() - l2);
          if (this.jdField_b_of_type_Long == 0L) {
            this.jdField_b_of_type_Long = l1;
          }
          while (QLog.isColorLevel())
          {
            paramContext = new StringBuilder(200);
            paramContext.append("getMemoryInfoFromAM, cost[").append(l1).append("], avgCost[").append(this.jdField_b_of_type_Long).append("], cnt[").append(this.jdField_a_of_type_Int).append("], flag[").append(this.c).append("], \n{");
            try
            {
              localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
              while (localIterator.hasNext())
              {
                str1 = (String)localIterator.next();
                luz localluz = (luz)this.jdField_a_of_type_JavaUtilHashMap.get(str1);
                if (localluz != null) {
                  paramContext.append(String.format("%s : [avg:%s, max: %s, min: %s]  KB \n", new Object[] { str1, Long.valueOf(localluz.c), Long.valueOf(localluz.jdField_a_of_type_Long), Long.valueOf(localluz.jdField_b_of_type_Long) }));
                }
              }
              this.jdField_b_of_type_Long = ((this.jdField_b_of_type_Long + l1) / 2L);
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
              paramContext.append("}");
              QLog.i("MemoryPerfStat", 2, paramContext.toString());
              return;
            }
          }
          paramContext = null;
        }
      }
    }
  }
  
  private void a(String paramString, long paramLong)
  {
    if ((paramLong == 0L) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    luz localluz = (luz)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localluz == null)
    {
      localluz = new luz(paramString, paramLong);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localluz);
      return;
    }
    localluz.a(paramLong);
  }
  
  private void c()
  {
    String str = lfb.a().a().d;
    this.jdField_a_of_type_JavaLangString = a();
    if (QLog.isColorLevel()) {
      QLog.i("MemoryPerfStat", 2, String.format("updatePerfInfo, peer[%s], key[%s], value[%s]", new Object[] { str, "PerfInfo", this.jdField_a_of_type_JavaLangString }));
    }
    if (!TextUtils.isEmpty(str)) {
      VideoController.a().a(str, "PerfInfo", this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(this.jdField_a_of_type_Long);
    luz localluz = (luz)this.jdField_a_of_type_JavaUtilHashMap.get("summary.total-pss");
    if (localluz != null) {
      localStringBuilder.append(';').append(localluz.c).append(';').append(localluz.jdField_a_of_type_Long).append(';').append(localluz.jdField_b_of_type_Long).append(';').append(this.c);
    }
    if (QLog.isColorLevel()) {
      QLog.i("MemoryPerfStat", 2, "getStatsInfo, [" + localStringBuilder.toString() + "]");
    }
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Int == 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MemoryPerfStat", 2, "start");
    }
    this.jdField_b_of_type_Int = 1;
    this.c = 0;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_Bhtd.sendEmptyMessageDelayed(1, 200L);
  }
  
  public void a(int paramInt)
  {
    if ((this.c & 0x1) == 0) {
      this.c |= 0x1;
    }
    if ((paramInt & 0x8) == 8)
    {
      if (!AEFilterSupport.a()) {
        break label146;
      }
      if ((this.c & 0x4) == 0) {
        this.c |= 0x4;
      }
    }
    for (;;)
    {
      if (((paramInt & 0x10) == 16) && ((this.c & 0x8) == 0)) {
        this.c |= 0x8;
      }
      if (((paramInt & 0x20) == 32) && ((this.c & 0x10) == 0)) {
        this.c |= 0x10;
      }
      if (((paramInt & 0x100) == 256) && ((this.c & 0x20) == 0)) {
        this.c |= 0x20;
      }
      return;
      label146:
      if ((this.c & 0x2) == 0) {
        this.c |= 0x2;
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Int != 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MemoryPerfStat", 2, "stop");
    }
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Bhtd.removeMessages(1);
    this.jdField_a_of_type_JavaLangString = a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (this.jdField_b_of_type_Int == 1)) {
      ThreadManager.excute(new MemoryPerfStat.1(this), 16, null, false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     luy
 * JD-Core Version:    0.7.0.1
 */