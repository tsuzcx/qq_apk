package com.tencent.mtt.hippy.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mtt.hippy.common.HippyMap;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DimensionsUtil
{
  private static int STATUS_BAR_HEIGHT = -1;
  
  public static HippyMap getDimensions(int paramInt1, int paramInt2, Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      return null;
    }
    DisplayMetrics localDisplayMetrics2 = paramContext.getResources().getDisplayMetrics();
    DisplayMetrics localDisplayMetrics1 = new DisplayMetrics();
    localDisplayMetrics1.setTo(localDisplayMetrics2);
    Object localObject1 = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17) {
      ((Display)localObject1).getRealMetrics(localDisplayMetrics1);
    }
    for (;;)
    {
      localObject1 = new HippyMap();
      if (STATUS_BAR_HEIGHT < 0) {}
      try
      {
        Object localObject2 = Class.forName("com.android.internal.R$dimen");
        Object localObject3 = ((Class)localObject2).newInstance();
        int i = Integer.parseInt(((Class)localObject2).getField("status_bar_height").get(localObject3).toString());
        STATUS_BAR_HEIGHT = paramContext.getResources().getDimensionPixelSize(i);
        if (STATUS_BAR_HEIGHT < 1)
        {
          i = paramContext.getResources().getIdentifier("statebar_height", "dimen", paramContext.getPackageName());
          STATUS_BAR_HEIGHT = Math.round(paramContext.getResources().getDimension(i));
        }
        paramContext = new HippyMap();
        if (paramBoolean) {
          if (paramInt1 >= 0)
          {
            paramContext.pushInt("width", paramInt1);
            if (paramInt2 < 0) {
              break label477;
            }
            paramContext.pushInt("height", paramInt2);
            paramContext.pushDouble("scale", localDisplayMetrics1.density);
            paramContext.pushDouble("fontScale", localDisplayMetrics1.scaledDensity);
            paramContext.pushDouble("densityDpi", localDisplayMetrics1.densityDpi);
            paramContext.pushDouble("statusBarHeight", STATUS_BAR_HEIGHT);
            ((HippyMap)localObject1).pushMap("windowPhysicalPixels", paramContext);
            paramContext = new HippyMap();
            paramContext.pushInt("width", localDisplayMetrics1.widthPixels);
            paramContext.pushInt("height", localDisplayMetrics1.heightPixels);
            paramContext.pushDouble("scale", localDisplayMetrics1.density);
            paramContext.pushDouble("fontScale", localDisplayMetrics1.scaledDensity);
            paramContext.pushDouble("densityDpi", localDisplayMetrics1.densityDpi);
            paramContext.pushDouble("statusBarHeight", STATUS_BAR_HEIGHT);
            ((HippyMap)localObject1).pushMap("screenPhysicalPixels", paramContext);
            return localObject1;
            for (;;)
            {
              try
              {
                localObject2 = Display.class.getMethod("getRawHeight", new Class[0]);
                localObject3 = Display.class.getMethod("getRawWidth", new Class[0]).invoke(localObject1, new Object[0]);
                if (localObject3 == null) {
                  break label442;
                }
                i = ((Integer)localObject3).intValue();
                localDisplayMetrics1.widthPixels = i;
                localObject1 = ((Method)localObject2).invoke(localObject1, new Object[0]);
                if (localObject1 == null) {
                  break label448;
                }
                i = ((Integer)localObject1).intValue();
                localDisplayMetrics1.heightPixels = i;
              }
              catch (Throwable localThrowable)
              {
                localThrowable.printStackTrace();
              }
              break;
              label442:
              i = 0;
              continue;
              label448:
              i = 0;
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          STATUS_BAR_HEIGHT = -1;
          localException.printStackTrace();
          continue;
          paramInt1 = localDisplayMetrics1.widthPixels;
          continue;
          label477:
          paramInt2 = localDisplayMetrics1.heightPixels;
        }
      }
    }
    if (paramInt1 >= 0)
    {
      label490:
      paramContext.pushInt("width", paramInt1);
      if (paramInt2 < 0) {
        break label574;
      }
    }
    for (;;)
    {
      paramContext.pushInt("height", paramInt2);
      paramContext.pushDouble("scale", localDisplayMetrics2.density);
      paramContext.pushDouble("fontScale", localDisplayMetrics2.scaledDensity);
      paramContext.pushDouble("densityDpi", localDisplayMetrics2.densityDpi);
      paramContext.pushDouble("statusBarHeight", STATUS_BAR_HEIGHT);
      localThrowable.pushMap("windowPhysicalPixels", paramContext);
      break;
      paramInt1 = localDisplayMetrics2.widthPixels;
      break label490;
      label574:
      paramInt2 = localDisplayMetrics2.heightPixels;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.DimensionsUtil
 * JD-Core Version:    0.7.0.1
 */