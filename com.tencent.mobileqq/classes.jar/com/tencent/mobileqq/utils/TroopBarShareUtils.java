package com.tencent.mobileqq.utils;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public class TroopBarShareUtils
{
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2)
  {
    ReportController.b(paramBaseQQAppInterface, "P_CliOper", "Grp_share", "", "to_tribe", paramString1, 0, 0, paramString2, "1", null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.TroopBarShareUtils
 * JD-Core Version:    0.7.0.1
 */