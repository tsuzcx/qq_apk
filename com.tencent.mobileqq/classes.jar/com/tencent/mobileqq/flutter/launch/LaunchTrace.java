package com.tencent.mobileqq.flutter.launch;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class LaunchTrace
{
  private int a;
  public long a;
  public boolean a;
  public long b;
  private boolean b;
  public long c;
  private boolean c;
  public long d;
  private boolean d;
  public long e;
  private boolean e;
  private long f;
  private long g;
  private long h;
  private long i;
  private long j;
  
  void a()
  {
    this.g = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, "installStartTime");
    }
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    if (this.f > 0L) {
      this.jdField_e_of_type_Long = (SystemClock.elapsedRealtime() - this.f);
    }
    this.jdField_a_of_type_Int = paramInt;
    if ((!paramBoolean) && (this.jdField_e_of_type_Boolean)) {
      ThreadManager.getSubThreadHandler().post(new LaunchTrace.1(this));
    }
    QLog.d("QFlutter.LaunchTrace", 1, String.format("[QFlutterLaunchCost]onLaunchFinish,isPreloadProcess: %s, errorCode: %s, isLocalEngineExist: %s, isLocalAppExist: %s, launchCost: %s, installCost: %s, loadAssetCost: %s, loadEngineCost: %s, isQuickInstall: %s", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(paramInt), Boolean.valueOf(this.jdField_c_of_type_Boolean), Boolean.valueOf(this.jdField_d_of_type_Boolean), Long.valueOf(this.jdField_e_of_type_Long), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.jdField_b_of_type_Long), Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_e_of_type_Boolean = paramBoolean2;
    this.f = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, "onLaunchStart");
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.g > 0L) {
      this.jdField_a_of_type_Long = (SystemClock.elapsedRealtime() - this.g);
    }
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.jdField_d_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_Boolean = paramBoolean3;
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, String.format("onInstallFinish, isLocalEngineExist: %s, isLocalAppExist: %s, isQuickInstall: %b, installCost: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Long.valueOf(this.jdField_a_of_type_Long) }));
    }
  }
  
  public boolean a()
  {
    return (this.jdField_d_of_type_Boolean) && (this.jdField_c_of_type_Boolean);
  }
  
  void b()
  {
    this.h = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, "onLoadAssetStart");
    }
  }
  
  void c()
  {
    if (this.h > 0L) {
      this.jdField_b_of_type_Long = (SystemClock.elapsedRealtime() - this.h);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, String.format("onLoadAssetFinish, loadAssetCost: %s", new Object[] { Long.valueOf(this.jdField_b_of_type_Long) }));
    }
  }
  
  void d()
  {
    this.i = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, "onReloadAssetIfNeedStart");
    }
  }
  
  void e()
  {
    if (this.i > 0L) {
      this.jdField_c_of_type_Long = (SystemClock.elapsedRealtime() - this.i);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, String.format("onReloadAssetIfNeedFinish, reloadAssetIfNeedCost: %s", new Object[] { Long.valueOf(this.jdField_c_of_type_Long) }));
    }
  }
  
  void f()
  {
    this.j = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, "onLoadEngineStart");
    }
  }
  
  void g()
  {
    if (this.j > 0L) {
      this.jdField_d_of_type_Long = (SystemClock.elapsedRealtime() - this.j);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, String.format("onLoadEngineFinish, loadEngineCost: %s", new Object[] { Long.valueOf(this.jdField_d_of_type_Long) }));
    }
  }
  
  public void h()
  {
    this.f = 0L;
    this.g = 0L;
    this.jdField_a_of_type_Long = 0L;
    this.h = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.j = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.launch.LaunchTrace
 * JD-Core Version:    0.7.0.1
 */