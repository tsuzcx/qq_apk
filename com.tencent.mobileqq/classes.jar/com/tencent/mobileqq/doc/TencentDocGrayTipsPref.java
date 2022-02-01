package com.tencent.mobileqq.doc;

import android.content.Context;

public class TencentDocGrayTipsPref
  extends MyPref
{
  public static int a(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TencentDocGrayTips_ShowTimes_");
    localStringBuilder.append(paramString);
    return MyPref.a(paramContext, localStringBuilder.toString(), 0);
  }
  
  public static long b(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TencentDocGrayTips_LastShowTime_");
    localStringBuilder.append(paramString);
    return MyPref.a(paramContext, localStringBuilder.toString(), 0L);
  }
  
  public static void c(Context paramContext, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TencentDocGrayTips_ShowTimes_");
    localStringBuilder.append(paramString);
    MyPref.b(paramContext, localStringBuilder.toString(), paramInt);
  }
  
  public static void c(Context paramContext, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TencentDocGrayTips_LastShowTime_");
    localStringBuilder.append(paramString);
    MyPref.b(paramContext, localStringBuilder.toString(), paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doc.TencentDocGrayTipsPref
 * JD-Core Version:    0.7.0.1
 */