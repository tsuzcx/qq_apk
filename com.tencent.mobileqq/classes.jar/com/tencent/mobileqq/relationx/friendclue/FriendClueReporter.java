package com.tencent.mobileqq.relationx.friendclue;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.statistics.ReportController;

public class FriendClueReporter
{
  public static void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendClueReporter", 0, String.format("reportFriendClueExpose source=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    ReportController.b(null, "dc00898", "", "", "0X800B6B6", "0X800B6B6", paramInt, 0, "", "", "", "");
  }
  
  public static void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendClueReporter", 0, String.format("reportFriendClueClick source=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    ReportController.b(null, "dc00898", "", "", "0X800B6B7", "0X800B6B7", paramInt, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.friendclue.FriendClueReporter
 * JD-Core Version:    0.7.0.1
 */