package com.tencent.mobileqq.teamwork;

import java.util.TimerTask;

final class TeamWorkHttpUtils$1
  extends TimerTask
{
  TeamWorkHttpUtils$1(int[] paramArrayOfInt, TenDocOCRExportHandler paramTenDocOCRExportHandler) {}
  
  public void run()
  {
    int[] arrayOfInt = this.a;
    if (arrayOfInt[0] >= 99)
    {
      this.b.notifyUI(4, true, new Object[] { Integer.valueOf(99) });
      return;
    }
    arrayOfInt[0] += 2;
    this.b.notifyUI(4, true, new Object[] { Integer.valueOf(arrayOfInt[0]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkHttpUtils.1
 * JD-Core Version:    0.7.0.1
 */