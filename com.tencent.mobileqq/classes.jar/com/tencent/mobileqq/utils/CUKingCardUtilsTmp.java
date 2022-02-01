package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class CUKingCardUtilsTmp
{
  public static int a()
  {
    return a(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
  }
  
  public static int a(String paramString)
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CUKingCardFile_");
    localStringBuilder.append(paramString);
    paramString = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 4);
    int i = paramString.getInt("kingCardSdk", -1);
    int j = paramString.getInt("kingCard", -1);
    int k = paramString.getInt("kingCard2", -1);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getCUKingStatus: status1=");
      paramString.append(j);
      paramString.append(" status2=");
      paramString.append(k);
      paramString.append(" sdkStatus=");
      paramString.append(i);
      QLog.i("CUKingCardHelper", 2, paramString.toString());
    }
    if (i >= 0)
    {
      if (i > 0) {
        return 1;
      }
      return 0;
    }
    if ((j < 0) && (k < 0)) {
      return -1;
    }
    if ((j <= 0) && (k <= 0)) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.CUKingCardUtilsTmp
 * JD-Core Version:    0.7.0.1
 */