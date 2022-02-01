package cooperation.qqcircle.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.utils.ViewUtils;
import mqq.app.MobileQQ;

public class BaseConfig
{
  public static int densityDpi = 0;
  public static String device_info;
  public static boolean isAccessibilityEnable = false;
  private static boolean isAppFeedReport = true;
  public static final boolean isPrintPicLog = false;
  public static final boolean isUserDebug = false;
  private static int mAppFeedTime = 1000;
  public static float mDensity;
  public static int screenHeight;
  public static int screenWidth;
  
  static
  {
    Object localObject1 = MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics();
    mDensity = ((DisplayMetrics)localObject1).density;
    screenWidth = ((DisplayMetrics)localObject1).widthPixels;
    screenHeight = ((DisplayMetrics)localObject1).heightPixels;
    densityDpi = ((DisplayMetrics)localObject1).densityDpi;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("screen_width=");
    ((StringBuilder)localObject1).append(screenWidth);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("screen_height=");
    ((StringBuilder)localObject2).append(screenHeight);
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("&");
    localStringBuilder.append((String)localObject2);
    device_info = localStringBuilder.toString();
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
    return MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int getScreenWidth()
  {
    return ViewUtils.a();
  }
  
  public static boolean isAccessibilityEnable()
  {
    return isAccessibilityEnable;
  }
  
  public static void onConfigChange()
  {
    DisplayMetrics localDisplayMetrics = MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.utils.BaseConfig
 * JD-Core Version:    0.7.0.1
 */