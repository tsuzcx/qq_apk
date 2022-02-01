package com.tencent.qqmini.sdk.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

@MiniKeep
public class ViewUtils
{
  private static float DEVICE_DENSITY = 0.0F;
  private static float density = -1.0F;
  private static int densityDPI = -1;
  public static int densityDpi = 0;
  public static float mDensity = 0.0F;
  private static int pixelPerCM = 0;
  private static float scaleDensity = -1.0F;
  private static int screenHeight = -1;
  private static double screenSizeCM = 0.0D;
  private static int screenWidth = -1;
  
  static
  {
    DisplayMetrics localDisplayMetrics = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics();
    mDensity = localDisplayMetrics.density;
    densityDpi = localDisplayMetrics.densityDpi;
  }
  
  @TargetApi(11)
  public static void changeTransparency(View paramView, int paramInt)
  {
    if (paramView.getBackground() != null) {
      paramView.getBackground().setAlpha(paramInt);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        changeTransparency(paramView.getChildAt(i), paramInt);
        i += 1;
      }
    }
  }
  
  public static int dip2px(float paramFloat)
  {
    return (int)(paramFloat * mDensity + 0.5F);
  }
  
  public static int dpToPx(float paramFloat)
  {
    return Math.round(paramFloat * getDensity());
  }
  
  public static String getBreakString(Paint paramPaint, String paramString, float paramFloat)
  {
    if (paramPaint == null) {
      return paramString;
    }
    for (;;)
    {
      float[] arrayOfFloat;
      int i;
      float f1;
      int j;
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          return paramString;
        }
        arrayOfFloat = new float[paramString.length()];
        paramPaint.getTextWidths(paramString, arrayOfFloat);
        float f2 = 0.0F;
        i = 0;
        f1 = 0.0F;
        if (i < arrayOfFloat.length)
        {
          f1 += arrayOfFloat[i];
          if (f1 <= paramFloat) {
            break label155;
          }
        }
        if (i == arrayOfFloat.length) {
          return paramString;
        }
        f1 = paramPaint.measureText("...");
        if (i <= 0) {
          return "";
        }
        paramFloat = f2;
        j = i;
        if (i > 1) {
          break label164;
        }
        return paramString.substring(0, i);
      }
      catch (Throwable paramPaint)
      {
        QMLog.e("getBreakString", "getBreakString", paramPaint);
        return paramString;
      }
      paramPaint = new StringBuilder();
      paramPaint.append(paramString.substring(0, i));
      paramPaint.append("...");
      paramPaint = paramPaint.toString();
      return paramPaint;
      label155:
      i += 1;
      continue;
      label164:
      do
      {
        i = j - 1;
        paramFloat += arrayOfFloat[i];
        if (paramFloat >= f1) {
          break;
        }
        j = i;
      } while (i > 0);
    }
  }
  
  public static void getChildPos(View paramView1, View paramView2, int[] paramArrayOfInt)
  {
    int j;
    int i;
    if (paramArrayOfInt != null)
    {
      if (paramArrayOfInt.length < 2) {
        return;
      }
      j = 0;
      i = 0;
    }
    for (;;)
    {
      int n = j;
      int i1 = i;
      int k;
      int m;
      if (paramView1.getParent() != null)
      {
        k = j + paramView1.getLeft();
        m = i + paramView1.getTop();
        if (paramView1.getParent() == paramView2)
        {
          paramArrayOfInt[0] = k;
          paramArrayOfInt[1] = m;
          n = k;
          i1 = m;
          if (paramArrayOfInt.length < 4) {
            break label158;
          }
          paramArrayOfInt[2] = paramView1.getMeasuredWidth();
          paramArrayOfInt[3] = paramView1.getMeasuredHeight();
          n = k;
          i1 = m;
        }
      }
      try
      {
        View localView = (View)paramView1.getParent();
        j = k;
        i = m;
        paramView1 = localView;
        if (paramArrayOfInt.length >= 4)
        {
          paramArrayOfInt[2] = localView.getMeasuredWidth();
          paramArrayOfInt[3] = localView.getMeasuredHeight();
          j = k;
          i = m;
          paramView1 = localView;
        }
      }
      catch (ClassCastException paramView1)
      {
        for (;;)
        {
          label158:
          n = k;
          i1 = m;
        }
      }
    }
    if (paramView2 == null)
    {
      paramArrayOfInt[0] = n;
      paramArrayOfInt[1] = i1;
    }
  }
  
  public static Point getChildPositionInParent(View paramView, ViewGroup paramViewGroup)
  {
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    paramView.getGlobalVisibleRect(localRect1);
    paramViewGroup.getGlobalVisibleRect(localRect2);
    return new Point(localRect1.left - localRect2.left, localRect1.top - localRect2.top);
  }
  
  public static float getDensity()
  {
    if (density < 0.0F) {
      density = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics().density;
    }
    return density;
  }
  
  public static float getDensity(Activity paramActivity)
  {
    if ((paramActivity != null) && (paramActivity.getResources() != null))
    {
      DisplayMetrics localDisplayMetrics = paramActivity.getResources().getDisplayMetrics();
      if (Build.VERSION.SDK_INT >= 17)
      {
        localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
      }
      return localDisplayMetrics.density;
    }
    return getDensity();
  }
  
  public static float getDensityDpi()
  {
    if (densityDPI < 0) {
      densityDPI = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics().densityDpi;
    }
    return densityDPI;
  }
  
  public static int getPixelPerCM()
  {
    if (pixelPerCM <= 0)
    {
      double d = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics().xdpi;
      Double.isNaN(d);
      pixelPerCM = (int)(d / 2.54D);
    }
    return pixelPerCM;
  }
  
  public static float getScaleDensity()
  {
    if (scaleDensity < 0.0F) {
      scaleDensity = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics().scaledDensity;
    }
    return scaleDensity;
  }
  
  public static int getScreenHeight()
  {
    if (screenHeight < 0) {
      if (AppLoaderFactory.g().getContext().getResources().getConfiguration().orientation == 2) {
        screenHeight = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics().widthPixels;
      } else {
        screenHeight = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics().heightPixels;
      }
    }
    return screenHeight;
  }
  
  private static int getScreenHeightByConfig(Configuration paramConfiguration)
  {
    if (paramConfiguration != null)
    {
      if (paramConfiguration.orientation == 2) {
        return dpToPx(paramConfiguration.screenWidthDp);
      }
      return dpToPx(paramConfiguration.screenHeightDp);
    }
    return 0;
  }
  
  public static double getScreenSizeCM()
  {
    if (screenSizeCM <= 0.0D)
    {
      DisplayMetrics localDisplayMetrics = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics();
      double d1 = Math.sqrt(Math.pow(localDisplayMetrics.widthPixels, 2.0D) + Math.pow(localDisplayMetrics.heightPixels, 2.0D));
      double d2 = getPixelPerCM();
      Double.isNaN(d2);
      screenSizeCM = d1 / d2;
    }
    return screenSizeCM;
  }
  
  public static int getScreenWidth()
  {
    if (screenWidth < 0) {
      if (AppLoaderFactory.g().getContext().getResources().getConfiguration().orientation == 2) {
        screenWidth = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics().heightPixels;
      } else {
        screenWidth = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics().widthPixels;
      }
    }
    return screenWidth;
  }
  
  private static int getScreenWidthByConfig(Configuration paramConfiguration)
  {
    if (paramConfiguration != null)
    {
      if (paramConfiguration.orientation == 2) {
        return dpToPx(paramConfiguration.screenHeightDp);
      }
      return dpToPx(paramConfiguration.screenWidthDp);
    }
    return 0;
  }
  
  public static float getSpValue(float paramFloat)
  {
    if (DEVICE_DENSITY == 0.0F) {
      DEVICE_DENSITY = densityDpi;
    }
    return paramFloat * DEVICE_DENSITY / 160.0F;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i = paramContext.getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {
      return paramContext.getDimensionPixelSize(i);
    }
    return 0;
  }
  
  public static int getTextWidth(Paint paramPaint, CharSequence paramCharSequence)
  {
    int j = 0;
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      int m = paramCharSequence.length();
      float[] arrayOfFloat = new float[m];
      paramPaint.getTextWidths(paramCharSequence.toString(), arrayOfFloat);
      int i = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        i += (int)Math.ceil(arrayOfFloat[j]);
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
  
  public static boolean isChildOf(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    if ((paramView2 instanceof ViewGroup))
    {
      paramView2 = (ViewGroup)paramView2;
      int j = paramView2.getChildCount();
      int i = 0;
      while (i < j)
      {
        if (isChildOf(paramView1, paramView2.getChildAt(i))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static int pxToDp(float paramFloat)
  {
    return Math.round(paramFloat / getDensity());
  }
  
  public static int pxTosp(float paramFloat)
  {
    return (int)(paramFloat / AppLoaderFactory.g().getContext().getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  public static void resetScreenSize()
  {
    screenWidth = -1;
    screenHeight = -1;
  }
  
  @TargetApi(11)
  public static void setAlpha(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView.setAlpha(paramFloat);
      return;
    }
    if (paramView.getBackground() != null) {
      paramView.getBackground().setAlpha((int)(paramFloat * 255.0F));
    }
  }
  
  public static void setEnableForAllChild(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    paramView.setEnabled(paramBoolean);
    if (!(paramView instanceof ViewGroup)) {
      return;
    }
    paramView = (ViewGroup)paramView;
    int j = paramView.getChildCount();
    int i = 0;
    while (i < j)
    {
      setEnableForAllChild(paramView.getChildAt(i), paramBoolean);
      i += 1;
    }
  }
  
  @TargetApi(11)
  public static void setPivotX(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setPivotX(paramFloat);
    }
  }
  
  @TargetApi(11)
  public static void setPivotY(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setPivotY(paramFloat);
    }
  }
  
  @TargetApi(11)
  public static void setRotation(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setRotation(paramFloat);
    }
  }
  
  @TargetApi(11)
  public static void setScaleX(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setScaleX(paramFloat);
    }
  }
  
  @TargetApi(11)
  public static void setScaleY(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setScaleY(paramFloat);
    }
  }
  
  public static void setScreenSizeByConfig(Configuration paramConfiguration)
  {
    screenWidth = getScreenWidthByConfig(paramConfiguration);
    screenHeight = getScreenHeightByConfig(paramConfiguration);
  }
  
  @TargetApi(11)
  public static void setTranslationX(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setTranslationX(paramFloat);
    }
  }
  
  @TargetApi(11)
  public static void setTranslationY(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setTranslationY(paramFloat);
    }
  }
  
  @TargetApi(16)
  public static void setViewBackground(View paramView, Drawable paramDrawable)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT < 16)
    {
      paramView.setBackgroundDrawable(paramDrawable);
      return;
    }
    paramView.setBackground(paramDrawable);
  }
  
  public static boolean setViewVisibility(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView.setVisibility(paramInt);
      return true;
    }
    return false;
  }
  
  public static void setVisible(View paramView, int paramInt)
  {
    if ((paramView != null) && (paramView.getVisibility() != paramInt)) {
      paramView.setVisibility(paramInt);
    }
  }
  
  public static int spToPx(float paramFloat)
  {
    return (int)(paramFloat * AppLoaderFactory.g().getContext().getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.ViewUtils
 * JD-Core Version:    0.7.0.1
 */