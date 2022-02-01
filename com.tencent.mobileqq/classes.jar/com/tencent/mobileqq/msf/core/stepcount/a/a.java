package com.tencent.mobileqq.msf.core.stepcount.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.stepcount.c;
import com.tencent.mobileqq.msf.core.stepcount.g;
import com.tencent.mobileqq.msf.core.v;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  implements c
{
  private static final String a = "StepDataStoreImpl";
  private static final String b = "health_step_count_data";
  private static final String c = "recent_step_records";
  private static final String d = "migration_completed";
  private static final String e = "device_shutdown";
  private static final String f = "last_sensor_value";
  private static final String g = "last_sensor_timestamp";
  private static final String h = "init_sensor_values";
  private static final String i = "shutdown_sensor_value";
  private static final int j = 86400;
  private int k;
  private long l;
  private final Map m = new HashMap();
  private final Map n = new HashMap();
  private final Map o = new HashMap();
  private boolean p = false;
  private final Context q;
  
  public a(Context paramContext)
  {
    this.q = paramContext;
  }
  
  private String a(Map paramMap)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localJSONObject.put(String.valueOf(localEntry.getKey()), localEntry.getValue());
      }
      paramMap = localJSONObject.toString();
      return paramMap;
    }
    catch (JSONException paramMap)
    {
      QLog.e("StepDataStoreImpl", 1, "fail to convert map to json", paramMap);
    }
    return "";
  }
  
  private void a(String paramString, Map paramMap, int paramInt, long paramLong)
  {
    try
    {
      paramString = new JSONObject(paramString);
      paramLong = e(paramLong);
      int i1 = 0;
      while (i1 < paramInt)
      {
        int i2 = paramString.optInt(String.valueOf(paramLong), 0);
        if (i2 > 0) {
          paramMap.put(Long.valueOf(paramLong), Integer.valueOf(i2));
        }
        i1 += 1;
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("StepDataStoreImpl", 1, "read map from json sp fail.", paramString);
    }
  }
  
  private void d(int paramInt, long paramLong)
  {
    long l1 = e(paramLong);
    if (!this.n.containsKey(Long.valueOf(l1)))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tryRecordInitSensorValue, today's init value inserted, sensorValue:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" , timestamp:");
        localStringBuilder.append(paramLong);
        QLog.d("StepDataStoreImpl", 2, localStringBuilder.toString());
      }
      this.n.put(Long.valueOf(l1), Integer.valueOf(paramInt));
    }
  }
  
  private long e(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong * 1000L);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    return localCalendar.getTimeInMillis() / 1000L;
  }
  
  public HashMap a(long paramLong1, long paramLong2)
  {
    paramLong1 = e(paramLong1);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.m.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      long l1 = ((Long)localEntry.getKey()).longValue();
      int i1 = ((Integer)localEntry.getValue()).intValue();
      if (l1 == paramLong1) {
        localHashMap.put(Long.valueOf(this.l), Integer.valueOf(i1));
      } else if (l1 >= paramLong2) {
        localHashMap.put(Long.valueOf(l1), Integer.valueOf(i1));
      }
    }
    return localHashMap;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StepDataStoreImpl", 2, "write in memory last step and recent records to sp");
    }
    this.q.getSharedPreferences("health_step_count_data", 0).edit().putInt("last_sensor_value", this.k).putLong("last_sensor_timestamp", this.l).putString("recent_step_records", a(this.m)).putString("init_sensor_values", a(this.n)).putString("shutdown_sensor_value", a(this.o)).apply();
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recordLastEvent, sensorValue:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" , timestamp:");
      localStringBuilder.append(paramLong);
      QLog.d("StepDataStoreImpl", 2, localStringBuilder.toString());
    }
    this.k = paramInt;
    this.l = paramLong;
    d(paramInt, paramLong);
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("calibrateLastTimestamp, new timestamp:");
      localStringBuilder.append(paramLong);
      QLog.d("StepDataStoreImpl", 2, localStringBuilder.toString());
    }
    this.l = paramLong;
    paramLong = e(paramLong);
    this.m.put(Long.valueOf(paramLong), Integer.valueOf(0));
    this.n.put(Long.valueOf(paramLong), Integer.valueOf(this.k));
    this.p = false;
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = this.q.getSharedPreferences("health_step_count_data", 0);
    boolean bool = ((SharedPreferences)localObject1).getBoolean("migration_completed", false);
    long l1 = NetConnInfoCenter.getServerTime();
    if (bool)
    {
      this.p = ((SharedPreferences)localObject1).getBoolean("device_shutdown", false);
      ((SharedPreferences)localObject1).edit().remove("device_shutdown").apply();
      if ((!paramBoolean) && (!this.p))
      {
        this.k = ((SharedPreferences)localObject1).getInt("last_sensor_value", 0);
        this.l = ((SharedPreferences)localObject1).getLong("last_sensor_timestamp", NetConnInfoCenter.getServerTime());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" read last sensor info from sp to memory, lastSensorValue:");
        ((StringBuilder)localObject2).append(this.k);
        ((StringBuilder)localObject2).append(" , lastSensorTime:");
        ((StringBuilder)localObject2).append(this.l);
        QLog.d("StepDataStoreImpl", 1, ((StringBuilder)localObject2).toString());
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("reboot happened: autoBoot:");
        ((StringBuilder)localObject2).append(paramBoolean);
        ((StringBuilder)localObject2).append(" , hasShutdown:");
        ((StringBuilder)localObject2).append(this.p);
        QLog.d("StepDataStoreImpl", 1, ((StringBuilder)localObject2).toString());
        this.k = 0;
        this.l = NetConnInfoCenter.getServerTime();
      }
      int i1 = g.a().g();
      Object localObject2 = ((SharedPreferences)localObject1).getString("recent_step_records", "");
      String str = ((SharedPreferences)localObject1).getString("init_sensor_values", "");
      localObject1 = ((SharedPreferences)localObject1).getString("shutdown_sensor_value", "");
      a((String)localObject2, this.m, i1, l1);
      a(str, this.n, i1, l1);
      a((String)localObject1, this.o, i1, l1);
      return;
    }
    QLog.d("StepDataStoreImpl", 1, "migrate old step data to refactored logic");
    this.k = v.X;
    this.l = (v.ab / 1000L);
    this.m.put(Long.valueOf(e(l1)), Integer.valueOf(v.f()));
    g.a().a(v.M);
    ((SharedPreferences)localObject1).edit().putBoolean("migration_completed", true).apply();
  }
  
  public Pair b()
  {
    return Pair.create(Long.valueOf(this.l), Integer.valueOf(this.k));
  }
  
  public void b(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addStepOffset, offset:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" , timestamp:");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("StepDataStoreImpl", 2, ((StringBuilder)localObject).toString());
    }
    long l1 = e(paramLong);
    Object localObject = (Integer)this.m.get(Long.valueOf(l1));
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("today's step not found in step history, add offset as new step count, offset:");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" , timestamp:");
        ((StringBuilder)localObject).append(paramLong);
        QLog.d("StepDataStoreImpl", 2, ((StringBuilder)localObject).toString());
      }
      this.m.put(Long.valueOf(l1), Integer.valueOf(paramInt));
      return;
    }
    this.m.put(Long.valueOf(l1), Integer.valueOf(((Integer)localObject).intValue() + paramInt));
  }
  
  public void b(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("shutdown flag is set, timestamp ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.d("StepDataStoreImpl", 1, ((StringBuilder)localObject).toString());
    this.p = true;
    this.q.getSharedPreferences("health_step_count_data", 0).edit().putBoolean("device_shutdown", true).apply();
    paramLong = e(paramLong);
    localObject = (Integer)this.m.get(Long.valueOf(paramLong));
    if (localObject != null) {
      this.o.put(Long.valueOf(paramLong), localObject);
    }
  }
  
  public int c(long paramLong)
  {
    paramLong = e(paramLong);
    Integer localInteger = (Integer)this.m.get(Long.valueOf(paramLong));
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return 0;
  }
  
  public void c(int paramInt, long paramLong)
  {
    long l1 = e(paramLong);
    Integer localInteger = (Integer)this.m.get(Long.valueOf(l1));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resetByServer, old step from step history:");
      localStringBuilder.append(localInteger);
      localStringBuilder.append(" , step from server:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" , timestamp:");
      localStringBuilder.append(paramLong);
      QLog.d("StepDataStoreImpl", 2, localStringBuilder.toString());
    }
    if ((localInteger == null) || (paramInt > localInteger.intValue())) {
      this.m.put(Long.valueOf(l1), Integer.valueOf(paramInt));
    }
  }
  
  public boolean c()
  {
    return this.p;
  }
  
  public Map d(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    paramLong = e(paramLong);
    Integer localInteger = (Integer)this.m.get(Long.valueOf(paramLong));
    int i2 = 0;
    if (localInteger != null) {
      i1 = localInteger.intValue();
    } else {
      i1 = 0;
    }
    localHashMap.put("data2", String.valueOf(i1));
    localInteger = (Integer)this.n.get(Long.valueOf(paramLong));
    if (localInteger != null) {
      i1 = localInteger.intValue();
    } else {
      i1 = 0;
    }
    localHashMap.put("ext0", String.valueOf(i1));
    localHashMap.put("ext1", String.valueOf(this.k));
    localInteger = (Integer)this.o.get(Long.valueOf(paramLong));
    int i1 = i2;
    if (localInteger != null) {
      i1 = localInteger.intValue();
    }
    localHashMap.put("ext2", String.valueOf(i1));
    return localHashMap;
  }
  
  public void d()
  {
    this.p = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.stepcount.a.a
 * JD-Core Version:    0.7.0.1
 */