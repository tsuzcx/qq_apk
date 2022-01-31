package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ShortVideoPresendStats
{
  public static long a;
  public static Object a;
  public static HashMap a;
  public static long b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static ShortVideoPresendStats.ReportInfo a(long paramLong)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      ShortVideoPresendStats.ReportInfo localReportInfo2 = (ShortVideoPresendStats.ReportInfo)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      ShortVideoPresendStats.ReportInfo localReportInfo1 = localReportInfo2;
      if (localReportInfo2 == null) {
        localReportInfo1 = new ShortVideoPresendStats.ReportInfo();
      }
      jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localReportInfo1);
      return localReportInfo1;
    }
  }
  
  public static void a(QQAppInterface arg0, long paramLong1, long paramLong2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      ShortVideoPresendStats.ReportInfo localReportInfo = a(paramLong1);
      if (localReportInfo.c == 0L)
      {
        QLog.d("ShortVideoPresendStats", 2, "updateCompressInfo uinSeq ：" + paramLong1 + " mergeCost：" + paramLong2);
        localReportInfo.c = (paramLong2 / 1000L);
      }
      return;
    }
  }
  
  public static void a(QQAppInterface arg0, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      ShortVideoPresendStats.ReportInfo localReportInfo = a(paramLong1);
      if (localReportInfo.jdField_a_of_type_Long == 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPresendStats", 2, "updateClickTime : uinSeq" + paramLong1 + " Show at " + SystemClock.uptimeMillis() + " clickTime:" + paramLong2 + " recordDuration:" + paramLong3 + " recordTouchUpTime:" + paramLong4 + " recordTouchUpTimes:" + paramInt);
        }
        localReportInfo.jdField_a_of_type_Long = paramLong2;
        localReportInfo.b = ((int)paramLong3);
        localReportInfo.d = paramLong4;
        localReportInfo.jdField_a_of_type_Int = paramInt;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoPresendStats
 * JD-Core Version:    0.7.0.1
 */