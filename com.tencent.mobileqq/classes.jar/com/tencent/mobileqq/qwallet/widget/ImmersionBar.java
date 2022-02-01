package com.tencent.mobileqq.qwallet.widget;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.mobileqq.activity.qwallet.utils.OSUtils;
import com.tencent.mobileqq.qwallet.utils.FlymeOSStatusBarFontUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ImmersionBar
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private Window jdField_a_of_type_AndroidViewWindow;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public ImmersionBar(Activity paramActivity, int paramInt, View paramView)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewWindow = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
    this.b = 0;
    a(paramInt);
  }
  
  private int a(int paramInt)
  {
    int i = paramInt;
    if (Build.VERSION.SDK_INT >= 23)
    {
      i = paramInt;
      if (this.jdField_a_of_type_Boolean) {
        i = paramInt | 0x2000;
      }
    }
    return i;
  }
  
  private void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          int i = 256;
          int j = Build.VERSION.SDK_INT;
          boolean bool2 = false;
          if ((j >= 21) && (!OSUtils.isEMUI3_1()))
          {
            if (this.jdField_a_of_type_AndroidViewView != null) {
              i = 1280;
            }
            i = a(i);
            this.jdField_a_of_type_AndroidViewWindow.clearFlags(67108864);
            this.jdField_a_of_type_AndroidViewWindow.addFlags(-2147483648);
            this.jdField_a_of_type_AndroidViewWindow.setStatusBarColor(0);
          }
          else
          {
            this.jdField_a_of_type_AndroidViewWindow.addFlags(4194304);
          }
          this.jdField_a_of_type_AndroidViewWindow.getDecorView().setSystemUiVisibility(i);
          if (Build.VERSION.SDK_INT < 24) {
            break label156;
          }
          bool2 = this.jdField_a_of_type_AndroidAppActivity.isInMultiWindowMode();
          bool1 = this.jdField_a_of_type_AndroidAppActivity.isInPictureInPictureMode();
          if ((this.jdField_a_of_type_AndroidViewView != null) && (!bool2) && (!bool1))
          {
            b(paramInt);
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      return;
      label156:
      boolean bool1 = false;
    }
  }
  
  private static void a(Window paramWindow, boolean paramBoolean)
  {
    if (paramWindow != null)
    {
      Object localObject = paramWindow.getClass();
      try
      {
        Class localClass = Class.forName("android.view.MiuiWindowManager$LayoutParams");
        int i = localClass.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(localClass);
        localObject = ((Class)localObject).getMethod("setExtraFlags", new Class[] { Integer.TYPE, Integer.TYPE });
        if (paramBoolean)
        {
          ((Method)localObject).invoke(paramWindow, new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
          return;
        }
        ((Method)localObject).invoke(paramWindow, new Object[] { Integer.valueOf(0), Integer.valueOf(i) });
        return;
      }
      catch (Exception paramWindow)
      {
        paramWindow.printStackTrace();
      }
    }
  }
  
  public static boolean a()
  {
    return (OSUtils.isMIUI6More()) || (OSUtils.isFlymeOS4More()) || (Build.VERSION.SDK_INT >= 23);
  }
  
  private void b(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    int i = this.b;
    if (i != 0)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(i);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    try
    {
      if (a())
      {
        a(this.jdField_a_of_type_Int);
        if (OSUtils.isMIUI6More()) {
          a(this.jdField_a_of_type_AndroidViewWindow, paramBoolean);
        }
        if (OSUtils.isFlymeOS4More())
        {
          FlymeOSStatusBarFontUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramBoolean);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.widget.ImmersionBar
 * JD-Core Version:    0.7.0.1
 */