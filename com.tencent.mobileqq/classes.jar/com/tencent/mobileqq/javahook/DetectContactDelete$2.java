package com.tencent.mobileqq.javahook;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

final class DetectContactDelete$2
  implements HookMethodCallback
{
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    long l = Thread.currentThread().getId();
    if (DetectContactDelete.a().containsKey(Long.valueOf(l)))
    {
      l = SystemClock.uptimeMillis() - ((Long)DetectContactDelete.a().remove(Long.valueOf(l))).longValue();
      HashMap localHashMap = new HashMap(10);
      if (Looper.myLooper() == Looper.getMainLooper()) {
        paramMethodHookParam = "1";
      } else {
        paramMethodHookParam = "0";
      }
      localHashMap.put("param_IsMainThread", paramMethodHookParam);
      localHashMap.put("param_OptType", "connection");
      localHashMap.put("param_bustag", "Friends");
      localHashMap.put("param_OptTotalCost", String.valueOf(l));
      localHashMap.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(null, "actFriendSqliteOpt", true, l, 0L, localHashMap, null, false);
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    long l = Thread.currentThread().getId();
    if (DetectContactDelete.a().containsKey(Long.valueOf(l))) {
      DetectContactDelete.a().put(Long.valueOf(l), Long.valueOf(SystemClock.uptimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.DetectContactDelete.2
 * JD-Core Version:    0.7.0.1
 */