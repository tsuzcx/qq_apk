package com.tencent.mobileqq.mini.ui.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Field;

public class DisplayHelper
{
  public static final float DENSITY = Resources.getSystem().getDisplayMetrics().density;
  private static final String TAG = "Devices";
  public static float sDensity = 0.0F;
  
  public static int dp2px(Context paramContext, int paramInt)
  {
    double d = getDensity(paramContext) * paramInt;
    Double.isNaN(d);
    return (int)(d + 0.5D);
  }
  
  public static int dpToPx(int paramInt)
  {
    return (int)(paramInt * DENSITY + 0.5F);
  }
  
  public static float getDensity(Context paramContext)
  {
    if (sDensity == 0.0F) {
      sDensity = getDisplayMetrics(paramContext).density;
    }
    return sDensity;
  }
  
  public static DisplayMetrics getDisplayMetrics(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    return getDisplayMetrics(paramContext).heightPixels;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    return getDisplayMetrics(paramContext).widthPixels;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
      i = paramContext.getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static boolean isFullScreen(Activity paramActivity)
  {
    return (paramActivity.getWindow().getAttributes().flags & 0x400) == 1024;
  }
  
  public static boolean isPackageExist(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      return paramContext != null;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static int px2dp(Context paramContext, int paramInt)
  {
    double d = paramInt / getDensity(paramContext);
    Double.isNaN(d);
    return (int)(d + 0.5D);
  }
  
  public static void setFullScreen(Context paramContext)
  {
    if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      WindowManager.LayoutParams localLayoutParams = paramContext.getWindow().getAttributes();
      localLayoutParams.flags |= 0x400;
      paramContext.getWindow().setAttributes(localLayoutParams);
      paramContext.getWindow().addFlags(512);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.ui.dialog.DisplayHelper
 * JD-Core Version:    0.7.0.1
 */