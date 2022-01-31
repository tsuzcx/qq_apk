package com.tencent.mobileqq.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Paint;
import android.os.PowerManager;
import android.view.View;
import com.tencent.util.VersionUtils;

@Deprecated
public class ReflectionUtil
{
  public static int a(Context paramContext)
  {
    return ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass();
  }
  
  @TargetApi(11)
  public static void a(View paramView, int paramInt, Paint paramPaint)
  {
    if (VersionUtils.e()) {
      paramView.setLayerType(paramInt, paramPaint);
    }
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      boolean bool = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.util.ReflectionUtil
 * JD-Core Version:    0.7.0.1
 */