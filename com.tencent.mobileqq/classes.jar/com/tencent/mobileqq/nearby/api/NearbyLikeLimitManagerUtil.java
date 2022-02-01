package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class NearbyLikeLimitManagerUtil
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramString1, "", paramString2, "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ReportController.b(paramQQAppInterface, "dc00899", "grp_lbs", paramString2, "pay_like", paramString1, 0, 0, paramString3, paramString4, paramString5, paramString6);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("report, opName=");
      paramQQAppInterface.append(paramString1);
      paramQQAppInterface.append(", toUin=");
      paramQQAppInterface.append(paramString2);
      paramQQAppInterface.append(", extra1=");
      paramQQAppInterface.append(paramString3);
      paramQQAppInterface.append(", extra2=");
      paramQQAppInterface.append(paramString4);
      paramQQAppInterface.append(", extra3=");
      paramQQAppInterface.append(paramString5);
      paramQQAppInterface.append(", extra4=");
      paramQQAppInterface.append(paramString6);
      QLog.d("nearbyLike.report", 2, paramQQAppInterface.toString());
    }
  }
  
  public static boolean a(long paramLong)
  {
    boolean bool;
    if ((paramLong != 6L) && (paramLong != 8L) && (paramLong != 37L) && (paramLong != 41L) && (paramLong != 42L) && (paramLong != 43L) && (paramLong != 45L) && (paramLong != 46L) && (paramLong != 47L) && (paramLong != 51L) && (paramLong != 10002L)) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isNeedNewLimitCheck, source=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", ret=");
      localStringBuilder.append(bool);
      QLog.d("NearbyLikeLimitManager", 2, localStringBuilder.toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.NearbyLikeLimitManagerUtil
 * JD-Core Version:    0.7.0.1
 */