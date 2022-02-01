package com.tencent.mobileqq.tianshu.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class RedTouchUtil
{
  public static int a(String paramString)
  {
    if (paramString == null)
    {
      QLog.d("RedPointLog.RedTouchUtil", 1, "input path is empty");
      return -1;
    }
    int i;
    StringBuilder localStringBuilder;
    if (paramString.contains("."))
    {
      paramString = paramString.split("\\.");
      if ((paramString == null) || (paramString.length <= 0)) {
        break label124;
      }
      try
      {
        i = Integer.parseInt(paramString[(paramString.length - 1)]);
        return i;
      }
      catch (NumberFormatException paramString)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" parse int error ");
        localStringBuilder.append(paramString);
        QLog.d("RedPointLog.RedTouchUtil", 1, localStringBuilder.toString());
        return -1;
      }
    }
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" parse int error ");
      localStringBuilder.append(paramString);
      QLog.d("RedPointLog.RedTouchUtil", 1, localStringBuilder.toString());
    }
    label124:
    return -1;
  }
  
  public static String a(AppInterface paramAppInterface)
  {
    paramAppInterface = paramAppInterface.getApplicationContext().getSharedPreferences("redTouchPref", 4);
    if (paramAppInterface == null) {
      return "";
    }
    return paramAppInterface.getString("lastClickPath", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.utils.RedTouchUtil
 * JD-Core Version:    0.7.0.1
 */