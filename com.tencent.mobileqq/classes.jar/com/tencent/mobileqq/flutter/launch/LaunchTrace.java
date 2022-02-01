package com.tencent.mobileqq.flutter.launch;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class LaunchTrace
{
  public long a;
  public long b;
  public long c;
  public long d;
  public long e;
  public boolean f;
  private boolean g;
  private long h;
  private long i;
  private long j;
  private long k;
  private long l;
  private boolean m;
  private boolean n;
  private int o;
  private boolean p;
  
  void a()
  {
    this.i = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, "installStartTime");
    }
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    if (this.h > 0L) {
      this.e = (SystemClock.elapsedRealtime() - this.h);
    }
    this.o = paramInt;
    if ((!paramBoolean) && (this.p)) {
      ThreadManager.getSubThreadHandler().post(new LaunchTrace.1(this));
    }
    QLog.d("QFlutter.LaunchTrace", 1, String.format("[QFlutterLaunchCost]onLaunchFinish,isPreloadProcess: %s, errorCode: %s, isLocalEngineExist: %s, isLocalAppExist: %s, launchCost: %s, installCost: %s, loadAssetCost: %s, loadEngineCost: %s, isQuickInstall: %s", new Object[] { Boolean.valueOf(this.g), Integer.valueOf(paramInt), Boolean.valueOf(this.m), Boolean.valueOf(this.n), Long.valueOf(this.e), Long.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.d), Boolean.valueOf(this.f) }));
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.g = paramBoolean1;
    this.p = paramBoolean2;
    this.h = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, "onLaunchStart");
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.i > 0L) {
      this.a = (SystemClock.elapsedRealtime() - this.i);
    }
    this.m = paramBoolean1;
    this.n = paramBoolean2;
    this.f = paramBoolean3;
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, String.format("onInstallFinish, isLocalEngineExist: %s, isLocalAppExist: %s, isQuickInstall: %b, installCost: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Long.valueOf(this.a) }));
    }
  }
  
  void b()
  {
    this.j = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, "onLoadAssetStart");
    }
  }
  
  void c()
  {
    if (this.j > 0L) {
      this.b = (SystemClock.elapsedRealtime() - this.j);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, String.format("onLoadAssetFinish, loadAssetCost: %s", new Object[] { Long.valueOf(this.b) }));
    }
  }
  
  void d()
  {
    this.k = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, "onReloadAssetIfNeedStart");
    }
  }
  
  void e()
  {
    if (this.k > 0L) {
      this.c = (SystemClock.elapsedRealtime() - this.k);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, String.format("onReloadAssetIfNeedFinish, reloadAssetIfNeedCost: %s", new Object[] { Long.valueOf(this.c) }));
    }
  }
  
  void f()
  {
    this.l = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, "onLoadEngineStart");
    }
  }
  
  void g()
  {
    if (this.l > 0L) {
      this.d = (SystemClock.elapsedRealtime() - this.l);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, String.format("onLoadEngineFinish, loadEngineCost: %s", new Object[] { Long.valueOf(this.d) }));
    }
  }
  
  public boolean h()
  {
    return (this.n) && (this.m);
  }
  
  public void i()
  {
    this.h = 0L;
    this.i = 0L;
    this.a = 0L;
    this.j = 0L;
    this.b = 0L;
    this.l = 0L;
    this.d = 0L;
    this.e = 0L;
    this.o = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.launch.LaunchTrace
 * JD-Core Version:    0.7.0.1
 */