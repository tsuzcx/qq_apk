package com.tencent.mobileqq.confess;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

final class TroopConfessUtil$1
  implements Runnable
{
  TroopConfessUtil$1(QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      int i;
      if (((QQAppInterface)localObject).getCurrentUin().equals(this.b)) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(this.a, "dc00898", "", "", "0X800956F", "0X800956F", i, 0, "", "", "", "");
    }
    if (this.c == 1) {
      localObject = "0X8009302";
    } else {
      localObject = "0X8009303";
    }
    ReportController.b(this.a, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.TroopConfessUtil.1
 * JD-Core Version:    0.7.0.1
 */