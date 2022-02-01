package com.tencent.mobileqq.qqgamepub.utils;

import com.tencent.mobileqq.statistics.ReportController;

final class GamePubAccountHelper$1
  implements Runnable
{
  GamePubAccountHelper$1(String paramString, long paramLong) {}
  
  public void run()
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append("");
    ReportController.b(null, "dc00898", "", str, "0X800A306", "0X800A306", 0, 0, "", "", localStringBuilder.toString(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper.1
 * JD-Core Version:    0.7.0.1
 */