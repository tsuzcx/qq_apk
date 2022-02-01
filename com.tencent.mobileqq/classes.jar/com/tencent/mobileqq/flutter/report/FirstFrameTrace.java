package com.tencent.mobileqq.flutter.report;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flutter.launch.LaunchResult;
import com.tencent.mobileqq.flutter.launch.LaunchTrace;
import mqq.os.MqqHandler;

public class FirstFrameTrace
{
  private String a;
  private boolean b;
  private boolean c;
  private LaunchTrace d;
  private long e;
  private long f;
  private long g;
  private long h;
  private long i;
  private long j;
  
  public FirstFrameTrace(String paramString, boolean paramBoolean, long paramLong)
  {
    this.a = paramString;
    this.b = paramBoolean;
    this.e = paramLong;
  }
  
  public void a()
  {
    this.f = SystemClock.elapsedRealtime();
  }
  
  public void a(LaunchResult paramLaunchResult)
  {
    this.g = SystemClock.elapsedRealtime();
    this.d = paramLaunchResult.d;
    this.c = paramLaunchResult.b;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = SystemClock.elapsedRealtime();
    if (paramBoolean) {
      ThreadManager.getSubThreadHandler().post(new FirstFrameTrace.1(this));
    }
  }
  
  public void b()
  {
    this.i = SystemClock.elapsedRealtime();
  }
  
  public void c()
  {
    this.j = (SystemClock.elapsedRealtime() - this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.report.FirstFrameTrace
 * JD-Core Version:    0.7.0.1
 */