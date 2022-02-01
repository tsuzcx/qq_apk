package com.tencent.secprotocol.t;

import com.tencent.secprotocol.ByteData;
import java.util.Timer;

public class ReportLogHelper
{
  public static final int DB_NUMBER = 12;
  public static final int LOG_TRACK_TYPE_BMP_RESULT = 2;
  public static final int LOG_TRACK_TYPE_GET_CODE = 5;
  public static final int LOG_TRACK_TYPE_ORDER_RESULT = 3;
  public static final int LOG_TRACK_TYPE_SEQ_INIT = 4;
  public static final int LOG_TRACK_TYPE_TIME_TASK = 1;
  public static int timePeriodCnt;
  public static Timer timer;
  public static boolean timerTaskIsRun;
  
  public static String makeBody(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1).append(",").append(paramInt2).append(",").append(paramInt3);
    return localStringBuilder.toString();
  }
  
  public static void report(int paramInt1, int paramInt2)
  {
    ByteData.getInstance().runTime(12, makeBody(paramInt1, paramInt2, timePeriodCnt), 0);
  }
  
  public static void startTimeTask()
  {
    if (timerTaskIsRun) {
      return;
    }
    timer = new Timer();
    timer.schedule(new ReportLogHelper.a(), 0L, 5000L);
  }
  
  public static void stopTimeTask()
  {
    Timer localTimer = timer;
    if (localTimer != null)
    {
      localTimer.cancel();
      timePeriodCnt = 0;
      timerTaskIsRun = false;
      ByteData.getInstance().runTime(12, makeBody(1, 1, timePeriodCnt), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.secprotocol.t.ReportLogHelper
 * JD-Core Version:    0.7.0.1
 */