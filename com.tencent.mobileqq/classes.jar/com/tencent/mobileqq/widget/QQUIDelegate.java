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
  public static boolean b = AppSetting.d;
  public static boolean c = AppSetting.e;
  
  public static int a(Context paramContext)
  {
    return DisplayUtils.b(paramContext);
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return ViewUtils.a(paramFloat);
  }
  
  public static String a()
  {
    return QQTheme.a();
  }
  
  public static String a(int paramInt)
  {
    return HardCodeUtil.a(paramInt);
  }
  
  public static boolean a()
  {
    return QQTheme.b();
  }
  
  public static boolean a(Context paramContext)
  {
    return (DisplayUtils.a(paramContext)) && (DisplayUtils.b(paramContext));
  }
  
  public static boolean b()
  {
    return QQTheme.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQUIDelegate
 * JD-Core Version:    0.7.0.1
 */