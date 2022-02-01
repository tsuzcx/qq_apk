package com.tencent.util;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class ProfilePerformanceReport
{
  public static ProfilePerformanceReport a;
  private static final String[] b = { "param_click2create", "param_first_draw", "param_first_show", "param_open", "param_run_delay", "param_init_data", "param_fetch_data", "param_prepare_res", "param_refresh_from_cache", "param_refresh_from_net" };
  private final String c;
  private final long[] d;
  private final long[] e;
  private int f;
  private long g;
  private StringBuilder h;
  
  public static void b() {}
  
  public void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt > 9) {
        return;
      }
      Object localObject = this.d;
      if (localObject[paramInt] == 0L)
      {
        localObject[paramInt] = SystemClock.elapsedRealtime();
        if (paramInt == 0)
        {
          this.f = 2;
          localObject = this.d;
          localObject[3] = localObject[paramInt];
        }
        if (QLog.isDevelopLevel())
        {
          this.h.setLength(0);
          localObject = this.h;
          ((StringBuilder)localObject).append("markStart, [");
          ((StringBuilder)localObject).append(b[paramInt]);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(this.d[paramInt]);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(this.f);
          ((StringBuilder)localObject).append("]");
          QLog.i("ProfilePerformanceReport", 4, this.h.toString());
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    long l1 = 0L;
    long l2 = l1;
    int i = 0;
    Object localObject;
    while (i <= 9)
    {
      localObject = this.e;
      if (localObject[i] != 0L)
      {
        long[] arrayOfLong = this.d;
        if (arrayOfLong[i] != 0L)
        {
          l1 = localObject[i] - arrayOfLong[i];
          break label67;
        }
      }
      l1 = 0L;
      label67:
      if (i == 3) {
        l2 = l1;
      }
      localObject = b[i];
      long l3;
      if (l1 > 0L) {
        l3 = l1;
      } else {
        l3 = 0L;
      }
      localHashMap.put(localObject, String.valueOf(l3));
      i += 1;
    }
    this.g = SystemClock.elapsedRealtime();
    this.f = 1;
    if (QLog.isDevelopLevel())
    {
      this.h.setLength(0);
      localObject = this.h;
      ((StringBuilder)localObject).append("reportPerformance, [");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(localHashMap.toString());
      ((StringBuilder)localObject).append("]");
      QLog.i("ProfilePerformanceReport", 4, this.h.toString());
    }
    ThreadManager.getSubThreadHandler().post(new ProfilePerformanceReport.1(this, paramString, l2, localHashMap));
  }
  
  public boolean a()
  {
    int i = this.f;
    return (i == 2) || (i == 3);
  }
  
  public boolean a(boolean paramBoolean)
  {
    int i = this.f;
    if (i < 3) {
      return false;
    }
    return (i == 4) || (paramBoolean);
  }
  
  public void b(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt > 9) {
        return;
      }
      if (this.d[paramInt] != 0L)
      {
        Object localObject = this.e;
        if (localObject[paramInt] == 0L)
        {
          localObject[paramInt] = SystemClock.elapsedRealtime();
          if (paramInt == 1)
          {
            localObject = this.e;
            localObject[3] = localObject[paramInt];
            this.f = 3;
          }
          else if (paramInt == 9)
          {
            this.f = 4;
          }
          if (QLog.isDevelopLevel())
          {
            this.h.setLength(0);
            localObject = this.h;
            ((StringBuilder)localObject).append("markEnd, [");
            ((StringBuilder)localObject).append(b[paramInt]);
            ((StringBuilder)localObject).append(",");
            ((StringBuilder)localObject).append(this.e[paramInt]);
            ((StringBuilder)localObject).append(",");
            ((StringBuilder)localObject).append(this.e[paramInt] - this.d[paramInt]);
            ((StringBuilder)localObject).append(",");
            ((StringBuilder)localObject).append(this.f);
            ((StringBuilder)localObject).append("]");
            QLog.i("ProfilePerformanceReport", 4, this.h.toString());
          }
        }
      }
    }
  }
  
  public boolean c(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      if (paramInt > 9) {
        return false;
      }
      bool1 = bool2;
      if (this.d[paramInt] != 0L)
      {
        bool1 = bool2;
        if (this.e[paramInt] != 0L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.ProfilePerformanceReport
 * JD-Core Version:    0.7.0.1
 */