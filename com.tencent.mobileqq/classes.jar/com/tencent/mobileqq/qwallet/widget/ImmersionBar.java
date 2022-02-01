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
  private Activity a;
  private Window b;
  private View c;
  private boolean d;
  private int e;
  private int f;
  
  public ImmersionBar(Activity paramActivity, int paramInt, View paramView)
  {
    this.a = paramActivity;
    this.b = this.a.getWindow();
    this.c = paramView;
    this.e = paramInt;
    this.f = 0;
    a(paramInt);
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
            if (this.c != null) {
              i = 1280;
            }
            i = b(i);
            this.b.clearFlags(67108864);
            this.b.addFlags(-2147483648);
            this.b.setStatusBarColor(0);
          }
          else
          {
            this.b.addFlags(4194304);
          }
          this.b.getDecorView().setSystemUiVisibility(i);
          if (Build.VERSION.SDK_INT < 24) {
            break label156;
          }
          bool2 = this.a.isInMultiWindowMode();
          bool1 = this.a.isInPictureInPictureMode();
          if ((this.c != null) && (!bool2) && (!bool1))
          {
            c(paramInt);
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
  
  private int b(int paramInt)
  {
    int i = paramInt;
    if (Build.VERSION.SDK_INT >= 23)
    {
      i = paramInt;
      if (this.d) {
        i = paramInt | 0x2000;
      }
    }
    return i;
  }
  
  private void c(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = this.c.getLayoutParams();
    localLayoutParams.height = ImmersiveUtils.getStatusBarHeight(this.a);
    this.c.setLayoutParams(localLayoutParams);
    int i = this.f;
    if (i != 0)
    {
      this.c.setBackgroundResource(i);
      return;
    }
    this.c.setBackgroundColor(paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    try
    {
      if (a())
      {
        a(this.e);
        if (OSUtils.isMIUI6More()) {
          a(this.b, paramBoolean);
        }
        if (OSUtils.isFlymeOS4More())
        {
          FlymeOSStatusBarFontUtils.a(this.a, paramBoolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.widget.ImmersionBar
 * JD-Core Version:    0.7.0.1
 */