package com.tencent.mobileqq.widget;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;

public class QQUIDelegate
{
  public static boolean a = false;
  public static boolean b = AppSetting.e;
  public static boolean c = AppSetting.f;
  
  public static int a(Context paramContext, float paramFloat)
  {
    return ViewUtils.dip2px(paramFloat);
  }
  
  public static String a(int paramInt)
  {
    return HardCodeUtil.a(paramInt);
  }
  
  public static boolean a()
  {
    return QQTheme.isDefaultOrDIYTheme();
  }
  
  public static boolean a(Context paramContext)
  {
    return (DisplayUtils.b(paramContext)) && (DisplayUtils.c(paramContext));
  }
  
  public static int b(Context paramContext)
  {
    return DisplayUtils.d(paramContext);
  }
  
  public static String b()
  {
    return QQTheme.getCurrentThemeId();
  }
  
  public static boolean c()
  {
    return QQTheme.isNowThemeIsNight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQUIDelegate
 * JD-Core Version:    0.7.0.1
 */