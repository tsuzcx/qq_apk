package com.tencent.mobileqq.msf.core.stepcount.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.stepcount.g;
import com.tencent.mobileqq.msf.core.v;
import com.tencent.mobileqq.msf.service.u;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class b
  implements Handler.Callback, com.tencent.mobileqq.msf.core.stepcount.d
{
  private static final String a = "StepEventHandlerImpl";
  private static final int b = 0;
  private static final int c = 360000000;
  private static final float d = 60.0F;
  private static final int e = 1;
  private static final String f = "StepEventHandlerImpl.action_time_monitor";
  private static final int g = 4;
  private static final int h = 5;
  private final Context i;
  private final com.tencent.mobileqq.msf.core.stepcount.c j;
  private SensorEventListener k = null;
  private BroadcastReceiver l = null;
  private BroadcastReceiver m = null;
  private Handler n = null;
  private long o;
  private int p;
  private volatile boolean q = true;
  private long r;
  private int s;
  
  public b(Context paramContext, com.tencent.mobileqq.msf.core.stepcount.c paramc)
  {
    this.i = paramContext;
    this.j = paramc;
  }
  
  private void a(int paramInt, long paramLong)
  {
    Pair localPair = this.j.b();
    long l1 = ((Long)localPair.first).longValue();
    int i1 = ((Integer)localPair.second).intValue();
    boolean bool = a(paramLong, l1);
    if (paramInt <= i1) {
      bool = false;
    }
    long l2 = paramLong - l1;
    int i2 = paramInt - i1;
    float f1 = 0.0F;
    if (l2 != 0L) {
      f1 = i2 * 1.0F / (float)l2;
    }
    if (60.0F * f1 > g.a().d()) {
      bool = false;
    }
    if (bool)
    {
      this.j.b(i2, l1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StepEventHandlerImpl", 2, String.format(Locale.getDefault(), "newSensorValue invalid offset, discard it. lastSensorValue: %d; sensorValue: %d; lastTimestamp: %d; timestamp: %d; curCadence: %.2f", new Object[] { Integer.valueOf(i1), Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(paramLong), Float.valueOf(f1) }));
    }
  }
  
  private void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportStepsToBeacon, timestamp:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" , reportCaller:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("StepEventHandlerImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent("action_step_compare_report");
    HashMap localHashMap = new HashMap();
    localHashMap.put("data1", String.valueOf(v.f()));
    localHashMap.putAll(this.j.d(paramLong));
    ((Intent)localObject).putExtra("health_compare_report_params", localHashMap);
    localHashMap.put("src_id", String.valueOf(paramInt));
    this.i.sendBroadcast((Intent)localObject);
  }
  
  private void a(long paramLong, int paramInt, String paramString, ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StepEventHandlerImpl", 2, "reportStepToServer");
    }
    this.r = paramLong;
    this.s = paramInt;
    HashMap localHashMap = this.j.a(paramLong, this.o);
    boolean bool = this.j.c();
    paramLong = ((Long)this.j.b().first).longValue();
    if (paramBoolean)
    {
      FromServiceMsg localFromServiceMsg = u.a(paramToServiceMsg);
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.addAttribute("health_step_count_history", localHashMap);
      localFromServiceMsg.addAttribute("health_has_shutdown_flag", Boolean.valueOf(bool));
      localFromServiceMsg.addAttribute("health_last_sensor_event_time", Long.valueOf(paramLong));
      com.tencent.mobileqq.msf.service.e.a(paramString, paramToServiceMsg, localFromServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("StepEventHandlerImpl", 2, "active report msf server msg sent, ");
      }
    }
    else
    {
      paramString = new Intent("StepAlarmReceiver_long_time_report");
      paramString.putExtra("health_step_count_history", localHashMap);
      paramString.putExtra("health_has_shutdown_flag", bool);
      paramString.putExtra("health_last_sensor_event_time", paramLong);
      this.i.sendBroadcast(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("StepEventHandlerImpl", 2, "passive report broadcast sent,");
      }
    }
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1 * 1000L);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2 * 1000L);
    return (localCalendar1.get(6) == localCalendar2.get(6)) && (localCalendar1.get(1) == localCalendar2.get(1));
  }
  
  private void d()
  {
    if (this.k == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StepEventHandlerImpl", 2, "init SensorEventListener2");
      }
      this.k = new c(this);
      SensorManager localSensorManager = (SensorManager)this.i.getSystemService("sensor");
      Sensor localSensor = localSensorManager.getDefaultSensor(19);
      localSensorManager.registerListener(this.k, localSensor, 0, 360000000);
    }
  }
  
  private void e()
  {
    if (this.k != null)
    {
      ((SensorManager)this.i.getSystemService("sensor")).unregisterListener(this.k);
      this.k = null;
    }
  }
  
  private void f()
  {
    if (this.k != null)
    {
      SensorManager localSensorManager = (SensorManager)this.i.getSystemService("sensor");
      if (localSensorManager != null) {
        localSensorManager.flush(this.k);
      }
    }
  }
  
  private void g()
  {
    if (this.l == null)
    {
      this.l = new d(this);
      this.i.registerReceiver(this.l, new IntentFilter("StepEventHandlerImpl.action_time_monitor"));
      Object localObject = new Intent("StepEventHandlerImpl.action_time_monitor");
      localObject = PendingIntent.getBroadcast(this.i, 1, (Intent)localObject, 134217728);
      AlarmManager localAlarmManager = (AlarmManager)this.i.getSystemService("alarm");
      long l1 = i();
      if (Build.VERSION.SDK_INT >= 23)
      {
        localAlarmManager.setExactAndAllowWhileIdle(0, l1, (PendingIntent)localObject);
        return;
      }
      localAlarmManager.setExact(0, l1, (PendingIntent)localObject);
    }
  }
  
  private void h()
  {
    BroadcastReceiver localBroadcastReceiver = this.l;
    if (localBroadcastReceiver != null)
    {
      this.i.unregisterReceiver(localBroadcastReceiver);
      this.l = null;
    }
  }
  
  private long i()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    return localCalendar.getTimeInMillis();
  }
  
  private void j()
  {
    if (this.m == null)
    {
      this.m = new e(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.ACTION_SHUTDOWN");
      this.i.registerReceiver(this.m, localIntentFilter);
    }
  }
  
  private void k()
  {
    BroadcastReceiver localBroadcastReceiver = this.m;
    if (localBroadcastReceiver != null)
    {
      this.i.unregisterReceiver(localBroadcastReceiver);
      this.m = null;
    }
  }
  
  private void l()
  {
    if (this.n == null) {
      this.n = new Handler(Looper.getMainLooper(), this);
    }
    if (this.n.hasMessages(4)) {
      this.n.removeMessages(4);
    }
    this.n.sendEmptyMessageDelayed(4, g.a().f() * 1000);
  }
  
  public void a()
  {
    if (!g.a().b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StepEventHandlerImpl", 2, "user switch off step counter helper");
      }
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      d();
      g();
      j();
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initListeners, current device sdk version is below kitkat: ");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      QLog.d("StepEventHandlerImpl", 2, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString, ToServiceMsg paramToServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StepEventHandlerImpl", 2, "reportSteps");
    }
    if (!this.q)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StepEventHandlerImpl", 2, "last step report is not completed, cancel the report");
      }
      return;
    }
    this.q = false;
    this.n.sendEmptyMessageDelayed(5, 60000L);
    long l1 = NetConnInfoCenter.getServerTime();
    int i2 = 1;
    boolean bool;
    if ((paramString != null) && (paramToServiceMsg != null)) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      i1 = g.a().e();
    } else {
      i1 = g.a().f();
    }
    if (l1 - this.o < i1 * 1000)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("last report time: ");
        paramString.append(this.o);
        paramString.append(" , current time:");
        paramString.append(l1);
        paramString.append(", interval is too short, cancel report");
        QLog.i("StepEventHandlerImpl", 2, paramString.toString());
      }
      return;
    }
    int i1 = this.j.c(l1);
    if (this.p == i1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StepEventHandlerImpl", 2, "last report step is equal to latest step, cancel report");
      }
      return;
    }
    int i3 = g.a().c();
    if (i3 == 2)
    {
      a(l1, i1, paramString, paramToServiceMsg, bool);
    }
    else if (i3 == 1)
    {
      i1 = i2;
      if (bool) {
        i1 = ((Integer)paramToServiceMsg.getAttribute("health_step_report_caller", Integer.valueOf(-1))).intValue();
      }
      a(l1, i1);
    }
    else if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("illegal step counter mode:");
      paramString.append(i3);
      QLog.d("StepEventHandlerImpl", 2, paramString.toString());
    }
    this.j.a();
  }
  
  public void b()
  {
    e();
    h();
    k();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StepEventHandlerImpl", 2, "notifyReportSuccess");
    }
    this.j.d();
    this.o = this.r;
    this.p = this.s;
    this.q = true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 4)
    {
      QLog.d("StepEventHandlerImpl", 1, "receive message to report steps");
      a(null, null);
      return true;
    }
    if (paramMessage.what == 5)
    {
      this.q = true;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.stepcount.a.b
 * JD-Core Version:    0.7.0.1
 */