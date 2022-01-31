package cooperation.qzone.util;

import android.os.Debug;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class TimeCostTrace
{
  public static final String TAG_QZONE_LAUNCH = "qzone_launch";
  public static final String TAG_QZONE_REFRESH = "qzone_refresh";
  public static final String TAG_QZONE_REFRESH_MORE = "qzone_refresh_more";
  public static final String TRACE_CODE_REFRESH = "100";
  public static final String TRACE_CODE_REFRESH_MORE = "101";
  public static HashMap<String, TimeCostTrace> map;
  public boolean isColdBoot;
  public long mFirstTime;
  public int sceneId;
  private String tag;
  private Map<String, long[]> timeMap = new ConcurrentHashMap();
  
  private TimeCostTrace(String paramString)
  {
    this.tag = paramString;
  }
  
  private static long currentTime()
  {
    return System.currentTimeMillis();
  }
  
  public static TimeCostTrace getTrace(String paramString)
  {
    if (map == null) {
      map = new HashMap();
    }
    TimeCostTrace localTimeCostTrace2 = (TimeCostTrace)map.get(paramString);
    TimeCostTrace localTimeCostTrace1 = localTimeCostTrace2;
    if (localTimeCostTrace2 == null)
    {
      localTimeCostTrace1 = new TimeCostTrace(paramString);
      map.put(paramString, localTimeCostTrace1);
    }
    return localTimeCostTrace1;
  }
  
  public static void removeTrace(String paramString)
  {
    if (map == null) {}
    TimeCostTrace localTimeCostTrace;
    do
    {
      return;
      localTimeCostTrace = (TimeCostTrace)map.get(paramString);
    } while (localTimeCostTrace == null);
    localTimeCostTrace.destroy();
    map.remove(paramString);
  }
  
  public void destroy()
  {
    if (this.timeMap != null)
    {
      this.timeMap.clear();
      this.mFirstTime = 0L;
      this.sceneId = 0;
      this.isColdBoot = false;
    }
  }
  
  public String dumpStepCost()
  {
    if ((this.timeMap == null) || (this.timeMap.size() <= 0)) {
      return "";
    }
    Object localObject = new StringBuilder();
    Iterator localIterator = this.timeMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      long[] arrayOfLong = (long[])this.timeMap.get(str);
      if (arrayOfLong != null)
      {
        ((StringBuilder)localObject).append(str).append(":");
        if (arrayOfLong.length > 0)
        {
          ((StringBuilder)localObject).append(arrayOfLong[0] - this.mFirstTime);
          ((StringBuilder)localObject).append(",");
        }
        if (arrayOfLong.length > 1) {
          ((StringBuilder)localObject).append(arrayOfLong[1] - this.mFirstTime);
        }
        ((StringBuilder)localObject).append(";");
      }
    }
    localObject = ((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).length() - 1);
    QLog.i(this.tag, 1, "dump step cost detail:" + (String)localObject);
    return localObject;
  }
  
  public String dumpStepCostV2()
  {
    if ((this.timeMap == null) || (this.timeMap.size() <= 0)) {
      return "";
    }
    localJSONObject = new JSONObject();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.timeMap);
    try
    {
      Iterator localIterator = localHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        long[] arrayOfLong = (long[])localHashMap.get(str);
        if ((arrayOfLong != null) && (arrayOfLong.length > 1)) {
          localJSONObject.put(str, arrayOfLong[1] - arrayOfLong[0]);
        }
      }
      return localJSONObject.toString();
    }
    catch (Exception localException)
    {
      QZLog.d("qzone_launch", 4, "", localException);
    }
  }
  
  public long getStepCost(String paramString)
  {
    if (this.sceneId < 0)
    {
      QLog.e(this.tag, 2, "TimeCostTrace getStepCost sceneId<0");
      return -1L;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e(this.tag, 2, "TimeCostTrace getStepCost code 是空字符串");
      return -1L;
    }
    if (!this.timeMap.containsKey(paramString))
    {
      QLog.e(this.tag, 2, new Object[] { paramString, "没有被记录" });
      return -1L;
    }
    paramString = (long[])this.timeMap.get(paramString);
    if ((paramString != null) && (paramString.length > 1)) {
      return paramString[1] - paramString[0];
    }
    QLog.e(this.tag, 2, "TimeCostTrace getStepCost arr不合法");
    return -1L;
  }
  
  public long getTimeCost()
  {
    long l1;
    if ((this.timeMap == null) || (this.mFirstTime <= 0L) || (this.sceneId < 0)) {
      l1 = -1L;
    }
    long l2;
    do
    {
      return l1;
      l2 = currentTime() - this.mFirstTime;
      l1 = l2;
    } while (!QLog.isColorLevel());
    QLog.d(this.tag, 2, "getTimeCost:" + l2);
    return l2;
  }
  
  public Map<String, long[]> getTimeMap()
  {
    return this.timeMap;
  }
  
  public void markFirst()
  {
    markFirst(currentTime(), 0, false);
  }
  
  public void markFirst(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.mFirstTime = paramLong;
    this.sceneId = paramInt;
    this.isColdBoot = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "TimeCostTrace--markFirst");
    }
  }
  
  public void startStep(String paramString)
  {
    startStep(paramString, -1L);
  }
  
  public void startStep(String paramString, long paramLong)
  {
    if (this.sceneId < 0) {}
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramString));
      long l = paramLong;
      if (paramLong <= 0L) {
        l = currentTime();
      }
      long[] arrayOfLong2 = (long[])this.timeMap.get(paramString);
      long[] arrayOfLong1 = arrayOfLong2;
      if (arrayOfLong2 == null)
      {
        arrayOfLong1 = new long[5];
        this.timeMap.put(paramString, arrayOfLong1);
      }
      arrayOfLong1[0] = l;
      arrayOfLong1[2] = Thread.currentThread().getId();
      arrayOfLong1[3] = Debug.threadCpuTimeNanos();
    } while (!QLog.isColorLevel());
    QLog.i(this.tag, 1, paramString + " start");
  }
  
  public void stopStep(String paramString)
  {
    if (this.sceneId < 0) {}
    long l2;
    long l3;
    long l1;
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramString));
      l2 = currentTime();
      long[] arrayOfLong2 = (long[])this.timeMap.get(paramString);
      long[] arrayOfLong1 = arrayOfLong2;
      if (arrayOfLong2 == null)
      {
        arrayOfLong1 = new long[5];
        this.timeMap.put(paramString, arrayOfLong1);
      }
      arrayOfLong1[1] = l2;
      arrayOfLong1[4] = Debug.threadCpuTimeNanos();
      l3 = Thread.currentThread().getId();
      l1 = -1L;
      if (l3 == arrayOfLong1[2]) {
        l1 = arrayOfLong1[4] - arrayOfLong1[3];
      }
      l3 = arrayOfLong1[0];
    } while ((!QLog.isColorLevel()) || (l3 <= 0L));
    QLog.d(this.tag, 1, paramString + " stop, cpuTime(ns):" + l1 + " ,cost:" + (l2 - l3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qzone.util.TimeCostTrace
 * JD-Core Version:    0.7.0.1
 */