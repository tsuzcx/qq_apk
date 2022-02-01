package com.tencent.mobileqq.onlinestatus.auto.location;

import android.app.Application;
import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.auto.AutoStatus;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.qphone.base.util.QLog;

public abstract class StepMovementDetector
  implements SensorEventListener, Handler.Callback
{
  protected String a = "SensorMovementDetector";
  protected volatile AutoStatus b = new AutoStatus(40001);
  protected volatile double c = 0.0D;
  protected int d = 0;
  protected int e = 0;
  protected int f = 0;
  protected long g = 0L;
  protected long h = 0L;
  private volatile int i;
  private AverageSampler j = new AverageSampler("step", Constant.C);
  private double k = 0.0D;
  private double l = 0.0D;
  private SensorManager m;
  private long n = 0L;
  private StepMovementDetector.StepDurationObserver o;
  private Handler p;
  private AutoLocationCheckListener q;
  
  StepMovementDetector(int paramInt)
  {
    this.j.a(new StepMovementDetector.1(this));
    this.i = paramInt;
    this.p = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
  }
  
  private void k()
  {
    this.p.removeMessages(0);
    this.m.unregisterListener(this);
    this.h = 0L;
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "[status][step] realStopDetector");
    }
  }
  
  private void l()
  {
    this.j.a();
    this.c = 0.0D;
    this.k = 0.0D;
    this.l = 0.0D;
    this.n = 0L;
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, new Object[] { "[status][step] resetTimeAndStep time:", Long.valueOf(this.g), " lastDetectTime:", Double.valueOf(this.c) });
    }
    this.g = 0L;
    this.d = 0;
    this.e = 0;
    this.f = 0;
  }
  
  private void n()
  {
    boolean bool = e();
    int i1 = f();
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, new Object[] { "[status][step] notifyCheckStatus notmoving:", Boolean.valueOf(bool), " status:", Constant.c(i1) });
    }
    if ((!bool) && (i1 != 41042))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "[status][step] notifyCheckStatus ismoving or not right status");
      }
    }
    else
    {
      AutoLocationCheckListener localAutoLocationCheckListener = this.q;
      if (localAutoLocationCheckListener != null)
      {
        localAutoLocationCheckListener.a();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "[status][step] notifyCheckStatus listener empty");
      }
    }
  }
  
  double a()
  {
    return this.l;
  }
  
  void a(double paramDouble)
  {
    String str;
    StringBuilder localStringBuilder;
    if ((paramDouble > Constant.A) && (paramDouble < Constant.B))
    {
      if (QLog.isColorLevel())
      {
        str = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][step] onTriggered stepTime: ");
        localStringBuilder.append(paramDouble);
        localStringBuilder.append(" result: STATUS_RUNNING");
        QLog.d(str, 2, localStringBuilder.toString());
      }
      this.b.a(41013);
    }
    else if ((paramDouble > Constant.y) && (paramDouble < Constant.z))
    {
      if (QLog.isColorLevel())
      {
        str = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][step] onTriggered stepTime: ");
        localStringBuilder.append(paramDouble);
        localStringBuilder.append(" result: STATUS_WALKING");
        QLog.d(str, 2, localStringBuilder.toString());
      }
      this.b.a(41012);
    }
    else if ((paramDouble > Constant.B) && (paramDouble < Constant.y))
    {
      if (QLog.isColorLevel())
      {
        str = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][step] onTriggered stepTime: ");
        localStringBuilder.append(paramDouble);
        localStringBuilder.append(" result: STATUS_WALKING fast");
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if (this.b.a == 40001) {
        this.b.a(41012);
      }
    }
    else if (paramDouble > Constant.z)
    {
      if (QLog.isColorLevel())
      {
        str = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][step] onTriggered stepTime: ");
        localStringBuilder.append(paramDouble);
        localStringBuilder.append(" result: STATUS_IDLE");
        QLog.d(str, 2, localStringBuilder.toString());
      }
      this.b.a();
    }
    else if (QLog.isColorLevel())
    {
      str = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][step] onTriggered too quick average: ");
      localStringBuilder.append(paramDouble);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    i();
    this.l = paramDouble;
  }
  
  protected void a(int paramInt)
  {
    if (System.currentTimeMillis() - this.g > 180000L) {
      m();
    }
    if (this.g == 0L)
    {
      this.g = System.currentTimeMillis();
      this.d += paramInt;
      return;
    }
    if (System.currentTimeMillis() - this.g < 60000L)
    {
      this.d += paramInt;
      return;
    }
    if ((System.currentTimeMillis() - this.g > 60000L) && (System.currentTimeMillis() - this.g <= 120000L))
    {
      this.f = this.e;
      this.e = this.d;
      this.d = paramInt;
      this.g = System.currentTimeMillis();
      this.p.sendEmptyMessage(1);
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, new Object[] { "[status][step] detectStepAndTime last1min: ", Integer.valueOf(this.d), " last2min:", Integer.valueOf(this.e), " last3min:", Integer.valueOf(this.f), " time:", Long.valueOf(this.g), " step:", Integer.valueOf(paramInt) });
      }
    }
    else
    {
      this.f = this.d;
      this.e = 0;
      this.d = paramInt;
      this.g = System.currentTimeMillis();
      if (!this.p.hasMessages(1)) {
        this.p.sendEmptyMessageDelayed(1, 60000L);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, new Object[] { "[status][step] detectStepAndTime last1min: ", Integer.valueOf(this.d), " last2min:", Integer.valueOf(this.e), " last3min:", Integer.valueOf(this.f), " time:", Long.valueOf(this.g), " step:", Integer.valueOf(paramInt) });
      }
    }
  }
  
  void a(Application paramApplication)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][step] startDetect sensor: ");
      localStringBuilder.append(getClass().getSimpleName());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (System.currentTimeMillis() - this.g > 180000L) {
      m();
    }
    if (this.h > 0L)
    {
      if (QLog.isColorLevel())
      {
        paramApplication = this.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[status][step] already startDetect sensor: ");
        ((StringBuilder)localObject).append(getClass().getSimpleName());
        QLog.d(paramApplication, 2, ((StringBuilder)localObject).toString());
      }
      this.p.removeMessages(0);
      a(0);
      return;
    }
    this.p.removeMessages(0);
    this.m = ((SensorManager)paramApplication.getApplicationContext().getSystemService("sensor"));
    paramApplication = this.m.getDefaultSensor(this.i);
    this.m.registerListener(this, paramApplication, 2);
    this.b.a("step");
    this.h = System.currentTimeMillis();
    a(0);
  }
  
  public void a(AutoLocationCheckListener paramAutoLocationCheckListener)
  {
    this.q = paramAutoLocationCheckListener;
  }
  
  void a(StepMovementDetector.StepDurationObserver paramStepDurationObserver)
  {
    this.o = paramStepDurationObserver;
  }
  
  void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][step] stopDetect sensor: ");
      localStringBuilder.append(getClass().getSimpleName());
      QLog.d(str, 2, new Object[] { localStringBuilder.toString(), " delay:", Boolean.valueOf(paramBoolean) });
    }
    if (paramBoolean) {
      this.p.sendEmptyMessageDelayed(0, 300000L);
    } else {
      this.p.sendEmptyMessage(0);
    }
    l();
  }
  
  double b()
  {
    double d1 = System.currentTimeMillis();
    double d2 = this.c;
    Double.isNaN(d1);
    d1 -= d2;
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, new Object[] { "[status][step] getLastRealTimeInternal internal:", Double.valueOf(d1), " mLastRealTimeInternal:", Double.valueOf(this.k) });
    }
    if ((this.c > 0.0D) && (d1 > Constant.z * Constant.C)) {
      return d1;
    }
    return this.k;
  }
  
  public int c()
  {
    double d1 = System.currentTimeMillis();
    double d2 = this.c;
    Double.isNaN(d1);
    d1 -= d2;
    if ((this.c > 0.0D) && (d1 > Constant.z * Constant.C))
    {
      if (QLog.isColorLevel())
      {
        String str = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][step] reset internal: ");
        localStringBuilder.append(d1);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      this.j.a();
      this.b.a();
    }
    return this.b.a;
  }
  
  public int d()
  {
    if (System.currentTimeMillis() - this.g > 180000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, new Object[] { "[status][distance] timeout ", Long.valueOf(this.g) });
      }
      return 70000;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, new Object[] { "[status][distance] check ", Integer.valueOf(this.d), " ", Integer.valueOf(this.e), " ", Integer.valueOf(this.f) });
    }
    if ((this.d < Constant.N) && (this.e < Constant.N))
    {
      if (this.f >= Constant.N) {
        return 0;
      }
      return 70000;
    }
    return 0;
  }
  
  public boolean e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, new Object[] { "[status][distance] isNotMoving mLast1MinSteps ", Integer.valueOf(this.d), " last2:", Integer.valueOf(this.e), " time:", Long.valueOf(this.h) });
    }
    return (this.e < Constant.N) && (System.currentTimeMillis() - this.h > 60000L) && (this.d < Constant.N) && (this.h > 0L);
  }
  
  public int f()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.g;
    int i2 = 40001;
    if (l1 - l2 > 180000L)
    {
      m();
      return 40001;
    }
    int i1;
    if (this.d < Constant.N)
    {
      i1 = i2;
      if (this.e < Constant.N) {}
    }
    else
    {
      l1 = System.currentTimeMillis();
      l2 = this.h;
      i1 = i2;
      if (l1 - l2 > 60000L)
      {
        i1 = i2;
        if (l2 > 0L) {
          i1 = 41042;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, new Object[] { "[status][step] getStatusNew last1min: ", Integer.valueOf(this.d), " last2min:", Integer.valueOf(this.e), " last3min:", Integer.valueOf(this.f), " time:", Long.valueOf(this.h) });
    }
    return i1;
  }
  
  protected void g()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      if (this.c > 0.0D)
      {
        double d1 = l1;
        double d2 = this.c;
        Double.isNaN(d1);
        d1 -= d2;
        this.j.a(d1);
        this.k = d1;
      }
      this.c = l1;
      a(1);
      return;
    }
    finally {}
  }
  
  long h()
  {
    return this.n;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 0)
    {
      if ((i1 == 1) && (this.q != null)) {
        n();
      }
    }
    else {
      k();
    }
    return false;
  }
  
  boolean i()
  {
    StringBuilder localStringBuilder;
    if ((this.b.a != 41012) && (this.b.a != 41013))
    {
      if (QLog.isColorLevel())
      {
        localObject = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][step] recordStepStartTime. stop status: ");
        localStringBuilder.append(this.b);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      this.n = 0L;
      return false;
    }
    if (this.n <= 0L)
    {
      if (QLog.isColorLevel())
      {
        localObject = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][step] recordStepStartTime. start step mStatus: ");
        localStringBuilder.append(this.b);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      this.n = System.currentTimeMillis();
      return false;
    }
    Object localObject = this.o;
    if ((localObject != null) && (((StepMovementDetector.StepDurationObserver)localObject).a()))
    {
      long l1 = System.currentTimeMillis() - this.n;
      if (l1 >= this.o.b())
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, new Object[] { "[status][step] mDurationObserver onTriggered start:", Long.valueOf(this.n), " duration:", Long.valueOf(l1) });
        }
        this.o.a(this.n, l1);
        return true;
      }
    }
    return false;
  }
  
  public String j()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.StepMovementDetector
 * JD-Core Version:    0.7.0.1
 */