package com.tencent.mobileqq.javahook;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.util.Utils;
import mqq.os.MqqHandler;

@TargetApi(14)
public class BadTokenHooker
{
  private static BadTokenHooker.MyHookMethodCallback a = new BadTokenHooker.MyHookMethodCallback(null);
  
  public static void a()
  {
    try
    {
      Class localClass1 = Class.forName("android.view.ViewRootImpl");
      JavaHookBridge.findAndHookMethod(localClass1, "setView", new Object[] { View.class, WindowManager.LayoutParams.class, View.class, new BadTokenHooker.1(localClass1) });
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      Utils.a(localClassNotFoundException1);
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      Utils.a(localNoSuchMethodException1);
    }
    try
    {
      Class localClass2 = Class.forName("android.view.WindowManagerImpl");
      if (Build.VERSION.SDK_INT <= 16) {
        try
        {
          Class localClass3 = Class.forName("android.view.CompatibilityInfoHolder");
          if (localClass3 == null) {
            break label162;
          }
          JavaHookBridge.findAndHookMethod(localClass2, "addView", new Object[] { View.class, ViewGroup.LayoutParams.class, localClass3, Boolean.class, a });
          return;
        }
        catch (ClassNotFoundException localClassNotFoundException2)
        {
          Utils.a(localClassNotFoundException2);
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          Utils.a(localNoSuchMethodException2);
          return;
        }
      } else {
        try
        {
          JavaHookBridge.findAndHookMethod(localNoSuchMethodException2, "addView", new Object[] { View.class, ViewGroup.LayoutParams.class, a });
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException3)
        {
          Utils.a(localNoSuchMethodException3);
        }
      }
      label162:
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException3)
    {
      Utils.a(localClassNotFoundException3);
    }
  }
  
  private static void b(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new BadTokenHooker.2(paramString1, paramString2, paramInt1), paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.BadTokenHooker
 * JD-Core Version:    0.7.0.1
 */