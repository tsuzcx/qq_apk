package com.tencent.viola.ui.dom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.viola.ui.dom.style.FlexConstants;
import com.tencent.viola.ui.dom.style.StyleSpace;
import java.util.concurrent.atomic.AtomicInteger;

public class DomUtils
{
  private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
  
  @SuppressLint({"NewApi"})
  public static int generateViewId()
  {
    if (Build.VERSION.SDK_INT < 17)
    {
      int k;
      int i;
      do
      {
        k = sNextGeneratedId.get();
        int j = k + 1;
        i = j;
        if (j > 16777215) {
          i = 1;
        }
      } while (!sNextGeneratedId.compareAndSet(k, i));
      return k;
    }
    return View.generateViewId();
  }
  
  public static float getContentWidth(DomObject paramDomObject)
  {
    float f2 = paramDomObject.getLayoutWidth();
    StyleSpace localStyleSpace = paramDomObject.getPadding();
    paramDomObject = paramDomObject.getBorder();
    float f3 = localStyleSpace.get(0);
    float f1 = f2;
    if (!FlexConstants.isUndefined(f3)) {
      f1 = f2 - f3;
    }
    f3 = localStyleSpace.get(2);
    f2 = f1;
    if (!FlexConstants.isUndefined(f3)) {
      f2 = f1 - f3;
    }
    f3 = paramDomObject.get(0);
    f1 = f2;
    if (!FlexConstants.isUndefined(f3)) {
      f1 = f2 - f3;
    }
    f3 = paramDomObject.get(2);
    f2 = f1;
    if (!FlexConstants.isUndefined(f3)) {
      f2 = f1 - f3;
    }
    return f2;
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getResources().getDisplayMetrics().heightPixels;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.dom.DomUtils
 * JD-Core Version:    0.7.0.1
 */