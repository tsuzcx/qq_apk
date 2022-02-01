package cooperation.qqcircle.utils;

import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.qphone.base.util.BaseApplication;

public class ViewUtils
{
  private static float DEVICE_DENSITY = 0.0F;
  private static final String TAG = "ViewUtils";
  private static float density = -1.0F;
  private static int densityDPI = -1;
  
  public static int dip2px(float paramFloat)
  {
    return (int)(BaseConfig.getDensity() * paramFloat + 0.5F);
  }
  
  public static int dpToPx(float paramFloat)
  {
    return Math.round(getDensity() * paramFloat);
  }
  
  public static float getDensity()
  {
    if (density < 0.0F) {
      density = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    }
    return density;
  }
  
  public static float getDensityDpi()
  {
    if (densityDPI < 0) {
      densityDPI = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    }
    return densityDPI;
  }
  
  public static int getScreenHeight()
  {
    return com.tencent.mobileqq.utils.ViewUtils.getScreenHeight();
  }
  
  public static int getScreenWidth()
  {
    return com.tencent.mobileqq.utils.ViewUtils.getScreenWidth();
  }
  
  public static float getSpValue(float paramFloat)
  {
    if (DEVICE_DENSITY == 0.0F) {
      DEVICE_DENSITY = BaseConfig.getDensityDpi();
    }
    return DEVICE_DENSITY * paramFloat / 160.0F;
  }
  
  public static boolean isInViewArea(View paramView, float paramFloat1, float paramFloat2)
  {
    Rect localRect = new Rect();
    paramView.getLocalVisibleRect(localRect);
    return (paramFloat1 > localRect.left) && (paramFloat1 < localRect.right) && (paramFloat2 > localRect.top) && (paramFloat2 < localRect.bottom);
  }
  
  public static int pxTosp(float paramFloat)
  {
    return (int)(paramFloat / BaseApplication.getContext().getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  public static int spToPx(float paramFloat)
  {
    return (int)(BaseApplication.getContext().getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.utils.ViewUtils
 * JD-Core Version:    0.7.0.1
 */