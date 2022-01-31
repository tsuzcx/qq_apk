package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.sveffects.SLog;

@SuppressLint({"NewApi"})
public class QQFilterLogManager
{
  public static long a;
  public static String a;
  public static boolean a;
  public static long b;
  public static long c;
  public static long d;
  public static long e = 80000000L;
  public static long f = 2000000000L;
  public static long g;
  
  static
  {
    jdField_a_of_type_JavaLangString = "QQFilterLog";
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a()
  {
    b = SystemClock.elapsedRealtimeNanos();
  }
  
  public static void a(String paramString)
  {
    long l = SystemClock.elapsedRealtimeNanos() - b;
    if (((SLog.a()) && (jdField_a_of_type_Boolean)) || ((SLog.a()) && (a(l)))) {
      SLog.d(jdField_a_of_type_JavaLangString, "QQFilterRenderManager_渲染item耗时:[" + paramString + " 毫秒=" + l / 1000000L + "ms 微秒=" + l / 1000L + "us]");
    }
  }
  
  public static void a(String paramString, boolean paramBoolean) {}
  
  public static boolean a(long paramLong)
  {
    return paramLong > e;
  }
  
  public static void b()
  {
    c = SystemClock.elapsedRealtimeNanos();
    if (b(c - g))
    {
      jdField_a_of_type_Boolean = true;
      g = c;
    }
    for (;;)
    {
      if ((SLog.a()) && (jdField_a_of_type_Boolean)) {
        SLog.b(jdField_a_of_type_JavaLangString, "QQFilterRenderManager 一帧开始");
      }
      return;
      jdField_a_of_type_Boolean = false;
    }
  }
  
  public static void b(String paramString)
  {
    jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
    if ((SLog.a()) && (jdField_a_of_type_Boolean)) {
      SLog.d(jdField_a_of_type_JavaLangString, "QQFilterRenderManager 生命周期开始 [" + paramString + "]");
    }
  }
  
  public static boolean b(long paramLong)
  {
    return paramLong > f;
  }
  
  public static void c()
  {
    long l = SystemClock.elapsedRealtimeNanos() - c;
    if ((SLog.a()) && (jdField_a_of_type_Boolean)) {
      SLog.b(jdField_a_of_type_JavaLangString, "QQFilterRenderManager_一帧结束 总耗时[ 毫秒=" + l / 1000000L + "ms 微秒=" + l / 1000L + "us]");
    }
    if (QmcfManager.a().a()) {
      QmcfManager.a().a(l / 1000000L);
    }
  }
  
  public static void c(String paramString)
  {
    long l = SystemClock.elapsedRealtimeNanos() - jdField_a_of_type_Long;
    if ((SLog.a()) && (jdField_a_of_type_Boolean)) {
      SLog.d(jdField_a_of_type_JavaLangString, "QQFilterRenderManager 生命周期结束耗时 [" + paramString + " 毫秒=" + l / 1000000L + "ms 微秒=" + l / 1000L + "us]");
    }
  }
  
  public static void d()
  {
    d = SystemClock.elapsedRealtimeNanos();
  }
  
  public static void d(String paramString)
  {
    long l = SystemClock.elapsedRealtimeNanos() - d;
    if ((SLog.a()) && (jdField_a_of_type_Boolean)) {
      SLog.d(jdField_a_of_type_JavaLangString, "QQFilterRenderManager 挂件：  [" + paramString + " 毫秒=" + l / 1000000L + "ms 微秒=" + l / 1000L + "us]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQFilterLogManager
 * JD-Core Version:    0.7.0.1
 */