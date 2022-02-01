package cooperation.qqcircle.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class BaseConfig
{
  public static int densityDpi;
  public static String device_info;
  public static boolean isAccessibilityEnable;
  private static boolean isAppFeedReport;
  public static final boolean isPrintPicLog = false;
  public static final boolean isUserDebug = false;
  private static int mAppFeedTime = 1000;
  public static float mDensity;
  public static int screenHeight;
  public static int screenWidth;
  
  static
  {
    isAppFeedReport = true;
    Object localObject = BaseApplication.getContext().getResources().getDisplayMetrics();
    mDensity = ((DisplayMetrics)localObject).density;
    screenWidth = ((DisplayMetrics)localObject).widthPixels;
    screenHeight = ((DisplayMetrics)localObject).heightPixels;
    densityDpi = ((DisplayMetrics)localObject).densityDpi;
    localObject = "screen_width=" + screenWidth;
    String str = "screen_height=" + screenHeight;
    device_info = (String)localObject + "&" + str;
  }
  
  public static float getDensity()
  {
    return mDensity;
  }
  
  public static int getDensityDpi()
  {
    return densityDpi;
  }
  
  public static int getScreenHeight()
  {
    return BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int getScreenWidth()
  {
    return ViewUtils.getScreenWidth();
  }
  
  public static boolean isAccessibilityEnable()
  {
    return isAccessibilityEnable;
  }
  
  public static void onConfigChange()
  {
    DisplayMetrics localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
    screenWidth = localDisplayMetrics.widthPixels;
    screenHeight = localDisplayMetrics.heightPixels;
  }
  
  public static void setAccessibilityEnable(boolean paramBoolean)
  {
    isAccessibilityEnable = paramBoolean;
  }
  
  public static void setAppFeedReport(boolean paramBoolean)
  {
    isAppFeedReport = paramBoolean;
  }
  
  public static void setAppFeedTime(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    mAppFeedTime = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.utils.BaseConfig
 * JD-Core Version:    0.7.0.1
 */