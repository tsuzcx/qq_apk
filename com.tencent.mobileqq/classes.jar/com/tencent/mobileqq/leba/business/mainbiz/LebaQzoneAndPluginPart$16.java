package com.tencent.mobileqq.leba.business.mainbiz;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;

class LebaQzoneAndPluginPart$16
  implements Runnable
{
  LebaQzoneAndPluginPart$16(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart, QQAppInterface paramQQAppInterface, long paramLong) {}
  
  public void run()
  {
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.a.getManager(QQManagerFactory.GAMECENTER_MANAGER);
    if (localGameCenterManagerImp != null) {
      if (!localGameCenterManagerImp.a(601L))
      {
        long l = this.b;
        if ((l <= 0L) || (!localGameCenterManagerImp.a(l))) {}
      }
      else
      {
        ReportController.b(this.a, "CliOper", "", "", "app_center", "new_exposure", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.16
 * JD-Core Version:    0.7.0.1
 */