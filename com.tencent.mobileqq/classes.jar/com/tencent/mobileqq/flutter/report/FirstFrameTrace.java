package com.tencent.mobileqq.flutter.report;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flutter.launch.LaunchResult;
import com.tencent.mobileqq.flutter.launch.LaunchTrace;
import mqq.os.MqqHandler;

public class FirstFrameTrace
{
  private long jdField_a_of_type_Long;
  private LaunchTrace jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchTrace;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long c;
  private long d;
  private long e;
  private long f;
  
  public FirstFrameTrace(String paramString, boolean paramBoolean, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  public void a(LaunchResult paramLaunchResult)
  {
    this.c = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchTrace = paramLaunchResult.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchTrace;
    this.jdField_b_of_type_Boolean = paramLaunchResult.jdField_a_of_type_Boolean;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = SystemClock.elapsedRealtime();
    if (paramBoolean) {
      ThreadManager.getSubThreadHandler().post(new FirstFrameTrace.1(this));
    }
  }
  
  public void b()
  {
    this.e = SystemClock.elapsedRealtime();
  }
  
  public void c()
  {
    this.f = (SystemClock.elapsedRealtime() - this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.report.FirstFrameTrace
 * JD-Core Version:    0.7.0.1
 */