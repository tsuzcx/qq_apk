package com.tencent.mobileqq.utils;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class TroopBarShareUtils
{
  public static void a(Activity paramActivity, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("troopbar_share", 2, "notifySDKCanceled:" + paramLong);
    }
    ForwardSdkShareOption.a(paramActivity, false, "shareToTroopBar", paramLong);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_share", "", "to_tribe", paramString1, 0, 0, paramString2, "1", null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.TroopBarShareUtils
 * JD-Core Version:    0.7.0.1
 */