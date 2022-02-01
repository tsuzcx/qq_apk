package com.tencent.mobileqq.javahook;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.mobileqq.util.Utils;
import java.lang.reflect.Field;

class BadTokenHooker$MyHookMethodCallback
  implements HookMethodCallback
{
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (paramMethodHookParam.throwable == null) {
      return;
    }
    Object localObject4 = (View)paramMethodHookParam.args[0];
    if (localObject4 == null) {
      return;
    }
    Object localObject3 = ((View)localObject4).getContext();
    Object localObject1 = localObject3;
    Object localObject2;
    if ("android.view.ContextThemeWrapper".equals(localObject3.getClass().getName()))
    {
      try
      {
        localObject1 = Class.forName("android.view.ContextThemeWrapper").getDeclaredField("mBase");
        ((Field)localObject1).setAccessible(true);
        localObject4 = ((Field)localObject1).get(((View)localObject4).getContext());
        localObject1 = localObject3;
        if (localObject4 == null) {
          break label150;
        }
        localObject1 = localObject3;
        if (!(localObject4 instanceof Context)) {
          break label150;
        }
        localObject1 = (Context)localObject4;
      }
      catch (IllegalAccessException localIllegalAccessException) {}catch (IllegalArgumentException localIllegalArgumentException)
      {
        break label126;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        break label135;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        break label144;
      }
      Utils.a(localClassNotFoundException);
      localObject2 = localObject3;
      break label150;
      label126:
      Utils.a(localObject2);
      localObject2 = localObject3;
      break label150;
      label135:
      Utils.a(localObject2);
      localObject2 = localObject3;
      break label150;
      label144:
      Utils.a(localObject2);
      localObject2 = localObject3;
    }
    label150:
    if (paramMethodHookParam.throwable.getCause() != null) {
      localObject3 = paramMethodHookParam.throwable.getCause();
    } else {
      localObject3 = paramMethodHookParam.throwable;
    }
    if ((localObject2 instanceof Activity))
    {
      localObject4 = (Activity)localObject2;
      if ((!((Activity)localObject4).isFinishing()) && ((localObject3 instanceof WindowManager.BadTokenException)))
      {
        BadTokenHooker.a(1, localObject2.getClass().getName(), paramMethodHookParam.throwable.getMessage(), 0);
        BadTokenHooker.a(2, localObject2.getClass().getName(), null, 10000);
        BadTokenHooker.a(3, localObject2.getClass().getName(), null, 60000);
        paramMethodHookParam.throwable = null;
        ((Activity)localObject4).finish();
        return;
      }
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramMethodHookParam.throwable.getMessage());
    ((StringBuilder)localObject3).append(" -- context is ");
    ((StringBuilder)localObject3).append(localObject2.getClass().getName());
    paramMethodHookParam.throwable = new RuntimeException(((StringBuilder)localObject3).toString(), paramMethodHookParam.throwable);
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.BadTokenHooker.MyHookMethodCallback
 * JD-Core Version:    0.7.0.1
 */