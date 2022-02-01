package com.tencent.rmonitor.base.reporter;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.util.SparseIntArray;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.thread.ThreadManager;
import com.tencent.rmonitor.sla.AttaParam;
import org.json.JSONObject;

public class DataReportSla
  implements Runnable
{
  private static final DataReportSla a = new DataReportSla();
  private final SparseIntArray b = new SparseIntArray();
  private int c = 0;
  private long d = 0L;
  private int e = 0;
  private long f = 0L;
  private Runnable g = null;
  private boolean h = false;
  private AttaParam i = null;
  
  public static DataReportSla a()
  {
    return a;
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (paramBoolean)
    {
      this.c += 1;
      this.d += paramLong;
    }
    else
    {
      this.e += 1;
      this.f += paramLong;
      int j = this.b.get(paramInt);
      this.b.put(paramInt, j + 1);
    }
    if (this.g == null)
    {
      this.g = this;
      new Handler(ThreadManager.f()).postDelayed(this.g, b());
    }
  }
  
  public long b()
  {
    return 5000L;
  }
  
  public AttaParam c()
  {
    if (this.h) {
      return this.i;
    }
    for (;;)
    {
      try
      {
        localObject2 = BaseInfo.sharePreference;
        Object localObject1 = "";
        if (localObject2 != null)
        {
          localObject1 = ((SharedPreferences)localObject2).getString("data_report_sla", "");
          ((SharedPreferences)localObject2).edit().putString("data_report_sla", "").apply();
        }
        localObject1 = new JSONObject((String)localObject1);
        if (!((JSONObject)localObject1).has("successCount")) {
          break label337;
        }
        j = ((JSONObject)localObject1).getInt("successCount");
        boolean bool = ((JSONObject)localObject1).has("successCostInMs");
        long l2 = 0L;
        if (!bool) {
          break label342;
        }
        l1 = ((JSONObject)localObject1).getLong("successCostInMs");
        if (!((JSONObject)localObject1).has("failCount")) {
          break label348;
        }
        k = ((JSONObject)localObject1).getInt("failCount");
        if (((JSONObject)localObject1).has("failCostInMs")) {
          l2 = ((JSONObject)localObject1).getLong("failCostInMs");
        }
        if (!((JSONObject)localObject1).has("errorCode")) {
          break label353;
        }
        m = ((JSONObject)localObject1).getInt("errorCode");
        if (k + j > 0)
        {
          this.i = new AttaParam("RMReportDataEvent");
          this.i.g = m;
          this.i.f = 1;
          this.i.a(0, String.valueOf(j));
          this.i.a(1, String.valueOf(l1));
          this.i.a(2, String.valueOf(k));
          this.i.a(3, String.valueOf(l2));
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject2 = Logger.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getAttaParam, exception: ");
        localStringBuilder.append(localThrowable.getMessage());
        ((Logger)localObject2).e(new String[] { "RMonitor_report_DataReportSla", localStringBuilder.toString() });
      }
      this.h = true;
      return this.i;
      label337:
      int j = 0;
      continue;
      label342:
      long l1 = 0L;
      continue;
      label348:
      int k = 0;
      continue;
      label353:
      int m = 0;
    }
  }
  
  public void run()
  {
    int k = 0;
    int m = 0;
    int j = 0;
    while (k < this.b.size())
    {
      int i2 = this.b.keyAt(k);
      int i1 = this.b.get(i2);
      int n = m;
      if (i1 > m)
      {
        j = i2;
        n = i1;
      }
      k += 1;
      m = n;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("successCount", this.c);
      k = this.c;
      if (k == 0) {
        localJSONObject.put("successCostInMs", 0L);
      } else {
        localJSONObject.put("successCostInMs", this.d / this.c);
      }
      localJSONObject.put("failCount", this.e);
      k = this.e;
      if (k == 0) {
        localJSONObject.put("failCostInMs", 0L);
      } else {
        localJSONObject.put("failCostInMs", this.f / this.e);
      }
      localJSONObject.put("errorCode", j);
      if (!this.h) {
        c();
      }
      localObject = BaseInfo.sharePreference;
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putString("data_report_sla", localJSONObject.toString()).apply();
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject = Logger.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveSample, exception: ");
      localStringBuilder.append(localThrowable.getMessage());
      ((Logger)localObject).e(new String[] { "RMonitor_report_DataReportSla", localStringBuilder.toString() });
    }
    this.g = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.DataReportSla
 * JD-Core Version:    0.7.0.1
 */