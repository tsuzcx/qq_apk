package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import java.lang.reflect.Method;

public class BasePopupMenuDialog
  extends PopupWindow
{
  public BasePopupMenuDialog(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramView, paramInt1, paramInt2, paramBoolean);
  }
  
  public static final View createLineView(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -1);
    localLayoutParams.height = 1;
    paramContext.setBackgroundColor(Color.parseColor("#DEDFE0"));
    paramContext.setLayoutParams(localLayoutParams);
    return paramContext;
  }
  
  public static int getScaledPixelSize(Context paramContext, int paramInt)
  {
    return paramContext.getResources().getDimensionPixelSize(paramInt);
  }
  
  public static void setModeTouch(PopupWindow paramPopupWindow)
  {
    if (!AppSetting.e) {
      return;
    }
    Method[] arrayOfMethod = PopupWindow.class.getMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = arrayOfMethod[i];
      if (localMethod.getName().equals("setTouchModal")) {
        try
        {
          localMethod.invoke(paramPopupWindow, new Object[] { Boolean.valueOf(false) });
          return;
        }
        catch (Exception paramPopupWindow)
        {
          paramPopupWindow.printStackTrace();
          return;
        }
      }
      i += 1;
    }
  }
  
  public static void setWindowType(PopupWindow paramPopupWindow, int paramInt)
  {
    Method[] arrayOfMethod = PopupWindow.class.getMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = arrayOfMethod[i];
      if (localMethod.getName().equals("setWindowLayoutType")) {
        try
        {
          localMethod.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
          return;
        }
        catch (Exception paramPopupWindow)
        {
          paramPopupWindow.printStackTrace();
          return;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.BasePopupMenuDialog
 * JD-Core Version:    0.7.0.1
 */