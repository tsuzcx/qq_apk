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
  public long mFirstTime = 0L;
  public int sceneId = 0;
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
    Object localObject = map;
    if (localObject == null) {
      return;
    }
    localObject = (TimeCostTrace)((HashMap)localObject).get(paramString);
    if (localObject != null)
    {
      ((TimeCostTrace)localObject).destroy();
      map.remove(paramString);
    }
  }
  
  public void destroy()
  {
    Map localMap = this.timeMap;
    if (localMap != null)
    {
      localMap.clear();
      this.mFirstTime = 0L;
      this.sceneId = 0;
      this.isColdBoot = false;
    }
  }
  
  public String dumpStepCost()
  {
    Object localObject1 = this.timeMap;
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      localObject1 = new StringBuilder();
      Object localObject2 = this.timeMap.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        long[] arrayOfLong = (long[])this.timeMap.get(localObject3);
        if (arrayOfLong != null)
        {
          ((StringBuilder)localObject1).append((String)localObject3);
          ((StringBuilder)localObject1).append(":");
          if (arrayOfLong.length > 0)
          {
            ((StringBuilder)localObject1).append(arrayOfLong[0] - this.mFirstTime);
            ((StringBuilder)localObject1).append(",");
          }
          if (arrayOfLong.length > 1) {
            ((StringBuilder)localObject1).append(arrayOfLong[1] - this.mFirstTime);
          }
          ((StringBuilder)localObject1).append(";");
        }
      }
      localObject1 = ((StringBuilder)localObject1).substring(0, ((StringBuilder)localObject1).length() - 1);
      localObject2 = this.tag;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("dump step cost detail:");
      ((StringBuilder)localObject3).append((String)localObject1);
      QLog.i((String)localObject2, 1, ((StringBuilder)localObject3).toString());
      return localObject1;
    }
    return "";
  }
  
  public String dumpStepCostV2()
  {
    Object localObject = this.timeMap;
    if (localObject != null)
    {
      if (((Map)localObject).size() <= 0) {
        return "";
      }
      localObject = new JSONObject();
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
            ((JSONObject)localObject).put(str, arrayOfLong[1] - arrayOfLong[0]);
          }
        }
        return ((JSONObject)localObject).toString();
      }
      catch (Exception localException)
      {
        QZLog.d("qzone_launch", 4, "", localException);
      }
    }
    return "";
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
    if ((this.timeMap != null) && (this.mFirstTime > 0L) && (this.sceneId >= 0))
    {
      long l = currentTime() - this.mFirstTime;
      if (QLog.isColorLevel())
      {
        String str = this.tag;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTimeCost:");
        localStringBuilder.append(l);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      return l;
    }
    return -1L;
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
    if (this.sceneId < 0) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    long l = paramLong;
    if (paramLong <= 0L) {
      l = currentTime();
    }
    Object localObject2 = (long[])this.timeMap.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new long[5];
      this.timeMap.put(paramString, localObject1);
    }
    localObject1[0] = l;
    localObject1[2] = Thread.currentThread().getId();
    localObject1[3] = Debug.threadCpuTimeNanos();
    if (!QLog.isColorLevel()) {
      return;
    }
    localObject1 = this.tag;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" start");
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
  }
  
  public void stopStep(String paramString)
  {
    if (this.sceneId < 0) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    long l2 = currentTime();
    Object localObject2 = (long[])this.timeMap.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new long[5];
      this.timeMap.put(paramString, localObject1);
    }
    localObject1[1] = l2;
    localObject1[4] = Debug.threadCpuTimeNanos();
    long l1;
    if (Thread.currentThread().getId() == localObject1[2]) {
      l1 = localObject1[4] - localObject1[3];
    } else {
      l1 = -1L;
    }
    long l3 = localObject1[0];
    if (!QLog.isColorLevel()) {
      return;
    }
    if (l3 > 0L)
    {
      localObject1 = this.tag;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" stop, cpuTime(ns):");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append(" ,cost:");
      ((StringBuilder)localObject2).append(l2 - l3);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.util.TimeCostTrace
 * JD-Core Version:    0.7.0.1
 */