package com.tencent.mobileqq.flashshow.utils;

import android.app.Application;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.flashshow.application.FSApplication;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class FSTextUtils
{
  public static String a(long paramLong)
  {
    return a(paramLong, false);
  }
  
  public static String a(long paramLong, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = FSHardCodeUtil.a(2131889505);
    } else {
      str = "w";
    }
    if (paramLong < 10000L) {
      return String.valueOf(paramLong);
    }
    if (paramLong < 1000000L)
    {
      localObject = new DecimalFormat();
      ((DecimalFormat)localObject).setMaximumFractionDigits(1);
      ((DecimalFormat)localObject).setGroupingSize(0);
      ((DecimalFormat)localObject).setRoundingMode(RoundingMode.HALF_UP);
      StringBuilder localStringBuilder = new StringBuilder();
      double d = paramLong;
      Double.isNaN(d);
      localStringBuilder.append(((DecimalFormat)localObject).format(d / 10000.0D));
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
    if (paramLong < 100000000L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong / 10000L);
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("9999");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
  
  public static String a(String paramString)
  {
    return a(paramString, FSApplication.APP.getResources().getString(2131889506));
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    paramString1 = paramString1.split("-");
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      CharSequence localCharSequence = paramString1[i];
      if ((!TextUtils.isEmpty(localCharSequence)) && (!localCharSequence.equals(paramString2)))
      {
        if (!TextUtils.isEmpty(localStringBuilder)) {
          localStringBuilder.append("·");
        }
        localStringBuilder.append(localCharSequence);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.utils.FSTextUtils
 * JD-Core Version:    0.7.0.1
 */