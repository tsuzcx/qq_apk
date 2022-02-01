package com.tencent.mobileqq.vip;

import android.content.SharedPreferences;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class CUKingCardUtils
{
  public static int a()
  {
    return a(VasUtil.a());
  }
  
  public static int a(String paramString)
  {
    BaseApplication localBaseApplication = MobileQQ.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CUKingCardFile_");
    localStringBuilder.append(paramString);
    paramString = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 4);
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
 * Qualified Name:     com.tencent.mobileqq.vip.CUKingCardUtils
 * JD-Core Version:    0.7.0.1
 */