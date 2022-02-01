package com.tencent.mobileqq.multiaio.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

public class VelocityUtil
{
  public static int a = 12;
  public static boolean b = false;
  
  public static int a(Context paramContext)
  {
    paramContext = paramContext.getResources();
    return paramContext.getDisplayMetrics().widthPixels - AIOUtils.b(42.0F, paramContext) * 2;
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    paramInt /= 5;
    int i = a(paramContext);
    paramContext = paramContext.getResources().getDisplayMetrics();
    float f = paramContext.heightPixels * 1.0F / paramContext.widthPixels;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getInitVelocity() displayMetrics.widthPixels = ");
      localStringBuilder.append(paramContext.widthPixels);
      localStringBuilder.append(", displayMetrics.heightPixels = ");
      localStringBuilder.append(paramContext.heightPixels);
      localStringBuilder.append(", ratio = ");
      localStringBuilder.append(f);
      localStringBuilder.append(", 16.F/9.F = ");
      localStringBuilder.append(1.777778F);
      localStringBuilder.append(",viewPagerClientWidth = ");
      localStringBuilder.append(i);
      QLog.d("VelocityUtil", 2, localStringBuilder.toString());
    }
    if ((f > 1.777778F) && (QLog.isColorLevel())) {
      QLog.d("VelocityUtil", 2, "getInitVelocity() ratio > 16.F/9.F");
    }
    paramContext = new StringBuilder();
    paramContext.append("getInitVelocity: pendingVelocity = ");
    paramContext.append(paramInt);
    paramContext.append(", viewPagerClientWidth = ");
    paramContext.append(i);
    QLog.d("VelocityUtil", 1, paramContext.toString());
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.utils.VelocityUtil
 * JD-Core Version:    0.7.0.1
 */