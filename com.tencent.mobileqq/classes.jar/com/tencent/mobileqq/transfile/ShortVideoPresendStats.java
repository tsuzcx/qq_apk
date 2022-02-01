package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ShortVideoPresendStats
{
  private static final String TAG = "ShortVideoPresendStats";
  public static long lOldClickTime;
  public static long lOldCompressCost;
  public static Object sLock = new Object();
  public static HashMap<Long, ShortVideoPresendStats.ReportInfo> sReportInfoMap = new HashMap();
  
  public static ShortVideoPresendStats.ReportInfo getOrCreateReportInfo(long paramLong)
  {
    synchronized (sLock)
    {
      ShortVideoPresendStats.ReportInfo localReportInfo2 = (ShortVideoPresendStats.ReportInfo)sReportInfoMap.get(Long.valueOf(paramLong));
      ShortVideoPresendStats.ReportInfo localReportInfo1 = localReportInfo2;
      if (localReportInfo2 == null) {
        localReportInfo1 = new ShortVideoPresendStats.ReportInfo();
      }
      sReportInfoMap.put(Long.valueOf(paramLong), localReportInfo1);
      return localReportInfo1;
    }
  }
  
  public static void updateClickTime(QQAppInterface arg0, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt)
  {
    synchronized (sLock)
    {
      ShortVideoPresendStats.ReportInfo localReportInfo = getOrCreateReportInfo(paramLong1);
      if (localReportInfo.lClickTime == 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPresendStats", 2, "updateClickTime : uinSeq" + paramLong1 + " Show at " + SystemClock.uptimeMillis() + " clickTime:" + paramLong2 + " recordDuration:" + paramLong3 + " recordTouchUpTime:" + paramLong4 + " recordTouchUpTimes:" + paramInt);
        }
        localReportInfo.lClickTime = paramLong2;
        localReportInfo.lRecordTime = ((int)paramLong3);
        localReportInfo.lTouchUpTime = paramLong4;
        localReportInfo.iTouchUpTimes = paramInt;
      }
      return;
    }
  }
  
  public static void updateCompressInfo(QQAppInterface arg0, long paramLong1, long paramLong2)
  {
    synchronized (sLock)
    {
      ShortVideoPresendStats.ReportInfo localReportInfo = getOrCreateReportInfo(paramLong1);
      if (localReportInfo.lCostMergeC == 0L)
      {
        QLog.d("ShortVideoPresendStats", 2, "updateCompressInfo uinSeq ：" + paramLong1 + " mergeCost：" + paramLong2);
        localReportInfo.lCostMergeC = (paramLong2 / 1000L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoPresendStats
 * JD-Core Version:    0.7.0.1
 */