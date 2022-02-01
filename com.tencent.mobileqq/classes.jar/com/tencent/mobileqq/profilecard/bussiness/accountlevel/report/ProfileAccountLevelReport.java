package com.tencent.mobileqq.profilecard.bussiness.accountlevel.report;

import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;

public class ProfileAccountLevelReport
{
  public static void reportAccountDarenClick(QQAppInterface paramQQAppInterface, int paramInt)
  {
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800B1C9", "0X800B1C9", paramInt, 0, "", "", "", "");
  }
  
  public static void reportAccountLevelClick(QQAppInterface paramQQAppInterface, int paramInt)
  {
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800B1C8", "0X800B1C8", paramInt, 0, "", "", "", "");
  }
  
  public static void reportAccountLevelVisible(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    int i = VipInfoHandler.a(paramQQAppInterface, paramQQAppInterface.getCurrentUin(), false);
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A8C6", "0X800A8C6", i, 0, String.valueOf(i), "", "", "");
    if (paramProfileCardInfo.a.a != 0) {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A8C7", "0X800A8C7", i, 0, String.valueOf(i), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.accountlevel.report.ProfileAccountLevelReport
 * JD-Core Version:    0.7.0.1
 */