package com.tencent.mobileqq.msf.core.stepcount;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class g
{
  private static final String a = "health_step_counter_config";
  private static final String b = "enable_helper";
  private static final boolean c = true;
  private final AtomicInteger d = new AtomicInteger(0);
  private final AtomicInteger e = new AtomicInteger(300);
  private final AtomicInteger f = new AtomicInteger(600);
  private final AtomicInteger g = new AtomicInteger(1200);
  private final AtomicInteger h = new AtomicInteger(7);
  private final AtomicBoolean i = new AtomicBoolean(true);
  
  private g()
  {
    h();
  }
  
  public static g a()
  {
    return g.a.a();
  }
  
  private void h()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("health_step_counter_config", 4);
    this.d.set(localSharedPreferences.getInt("stepCounterMode", 0));
    this.e.set(localSharedPreferences.getInt("stepCadence", 300));
    this.f.set(localSharedPreferences.getInt("activeReportInterval", 600));
    this.g.set(localSharedPreferences.getInt("passiveReportInterval", 1200));
    this.h.set(localSharedPreferences.getInt("maxRecordDays", 7));
    this.i.set(localSharedPreferences.getBoolean("enable_helper", true));
  }
  
  private void i()
  {
    BaseApplication.getContext().getSharedPreferences("health_step_counter_config", 4).edit().putInt("stepCounterMode", this.d.get()).putInt("stepCadence", this.e.get()).putInt("activeReportInterval", this.f.get()).putInt("passiveReportInterval", this.g.get()).putInt("maxRecordDays", this.h.get()).putBoolean("enable_helper", this.i.get()).apply();
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    Object localObject = paramToServiceMsg.getAttribute("stepCounterMode");
    if ((localObject instanceof Integer)) {
      this.d.set(((Integer)localObject).intValue());
    }
    localObject = paramToServiceMsg.getAttribute("stepCadence");
    if ((localObject instanceof Integer)) {
      this.e.set(((Integer)localObject).intValue());
    }
    localObject = paramToServiceMsg.getAttribute("activeReportInterval");
    if ((localObject instanceof Integer)) {
      this.f.set(((Integer)localObject).intValue());
    }
    localObject = paramToServiceMsg.getAttribute("passiveReportInterval");
    if ((localObject instanceof Integer)) {
      this.g.set(((Integer)localObject).intValue());
    }
    paramToServiceMsg = paramToServiceMsg.getAttribute("maxRecordDays");
    if ((paramToServiceMsg instanceof Integer)) {
      this.h.set(((Integer)paramToServiceMsg).intValue());
    }
    i();
  }
  
  public void a(boolean paramBoolean)
  {
    this.i.set(paramBoolean);
    BaseApplication.getContext().getSharedPreferences("health_step_counter_config", 4).edit().putBoolean("enable_helper", paramBoolean).apply();
  }
  
  public boolean b()
  {
    return this.i.get();
  }
  
  public int c()
  {
    return this.d.get();
  }
  
  public int d()
  {
    return this.e.get();
  }
  
  public int e()
  {
    return this.f.get();
  }
  
  public int f()
  {
    return this.g.get();
  }
  
  public int g()
  {
    return this.h.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.stepcount.g
 * JD-Core Version:    0.7.0.1
 */