package com.tencent.mobileqq.onlinestatus.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class DecorViewHelper
{
  public static int a(Context paramContext)
  {
    if ((paramContext instanceof Activity))
    {
      paramContext = ((Activity)paramContext).findViewById(16908290);
      if (paramContext != null) {
        return paramContext.getHeight();
      }
    }
    return 0;
  }
  
  public static Bitmap a(Context paramContext)
  {
    boolean bool = paramContext instanceof QBaseActivity;
    Object localObject1 = null;
    Canvas localCanvas = null;
    Object localObject2;
    if (bool)
    {
      View localView = ((QBaseActivity)paramContext).getWindow().getDecorView();
      int i = localView.getWidth();
      int j = localView.getHeight();
      try
      {
        localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        try
        {
          ((Bitmap)localObject1).setDensity(paramContext.getResources().getDisplayMetrics().densityDpi);
          localCanvas = new Canvas((Bitmap)localObject1);
          localView.draw(localCanvas);
          localCanvas.setBitmap(null);
        }
        catch (Throwable localThrowable1) {}
        QLog.e("onlinestate.DecorViewHelper", 1, "getDecorViewBitmap: ", (Throwable)localObject2);
      }
      catch (Throwable localThrowable2)
      {
        localObject1 = localThrowable1;
        localObject2 = localThrowable2;
      }
      GC.a();
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getDecorViewBitmap() called with: context = [");
      ((StringBuilder)localObject2).append(paramContext);
      ((StringBuilder)localObject2).append("], bitmap = ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("onlinestate.DecorViewHelper", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt, Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cropAIOFromDecorView() called with: input = [");
      localStringBuilder.append(paramBitmap);
      localStringBuilder.append("], contentHeight = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], activity = [");
      localStringBuilder.append(paramActivity);
      localStringBuilder.append("]");
      QLog.d("onlinestate.DecorViewHelper", 2, localStringBuilder.toString());
    }
    if (paramBitmap == null) {
      return null;
    }
    int j = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    a(paramActivity);
    if ((paramInt <= 0) || (paramInt >= i)) {
      paramInt = i;
    }
    i = ImmersiveUtils.getStatusBarHeight(paramActivity);
    paramInt -= i;
    try
    {
      if (QLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("cropAIOFromDecorView() statusBarHeight = ");
        paramActivity.append(i);
        paramActivity.append(", width =");
        paramActivity.append(j);
        paramActivity.append(", finalHeight = ");
        paramActivity.append(paramInt);
        QLog.d("onlinestate.DecorViewHelper", 2, paramActivity.toString());
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, i, j, paramInt);
      return paramBitmap;
    }
    catch (Throwable paramBitmap)
    {
      QLog.e("onlinestate.DecorViewHelper", 1, "cropAIOFromDecorView: ", paramBitmap);
      GC.a();
    }
    return null;
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
      Point localPoint1 = new Point();
      Point localPoint2 = new Point();
      paramActivity.getSize(localPoint1);
      paramActivity.getRealSize(localPoint2);
      return localPoint2.y != localPoint1.y;
    }
    boolean bool1 = ViewConfiguration.get(paramActivity).hasPermanentMenuKey();
    boolean bool2 = KeyCharacterMap.deviceHasKey(4);
    if (!bool1) {
      return !bool2;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.utils.DecorViewHelper
 * JD-Core Version:    0.7.0.1
 */