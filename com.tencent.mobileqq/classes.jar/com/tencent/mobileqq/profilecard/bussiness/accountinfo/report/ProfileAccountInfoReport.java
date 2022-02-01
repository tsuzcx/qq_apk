package com.tencent.mobileqq.profilecard.bussiness.accountinfo.report;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public class ProfileAccountInfoReport
{
  public static void reportAccountInfoClick(AppInterface paramAppInterface, int paramInt)
  {
    ReportController.b(paramAppInterface, "dc00898", "", "", "0X800B1CA", "0X800B1CA", paramInt, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.accountinfo.report.ProfileAccountInfoReport
 * JD-Core Version:    0.7.0.1
 */