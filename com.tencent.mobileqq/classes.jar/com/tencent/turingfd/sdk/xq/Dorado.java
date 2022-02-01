package com.tencent.turingfd.sdk.xq;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class Dorado
  implements ViewTreeObserver.OnPreDrawListener
{
  public Dorado(Window paramWindow, String paramString, Cassiopeia paramCassiopeia) {}
  
  public boolean onPreDraw()
  {
    try
    {
      this.zh.getDecorView().getViewTreeObserver().removeOnPreDrawListener(this);
      localObject1 = this.zh;
      int i = private.J();
      localObject3 = null;
      if (i < 30) {}
    }
    catch (Throwable localThrowable1)
    {
      Object localObject1;
      Object localObject3;
      Object localObject2;
      label74:
      label121:
      localThrowable1.printStackTrace();
      label157:
      label220:
      return true;
    }
    try
    {
      localObject2 = localObject1.getClass();
      localObject2 = ((Class)localObject2).getDeclaredMethod("getViewRootImpl", new Class[0]);
      ((Method)localObject2).setAccessible(true);
      localObject1 = ((Method)localObject2).invoke(localObject1, new Object[0]);
    }
    catch (Throwable localThrowable2)
    {
      break label74;
    }
    localObject1 = null;
    if (localObject1 == null) {
      return true;
    }
    try
    {
      localObject2 = localObject1.getClass();
      localObject2 = ((Class)localObject2).getDeclaredMethod("getAccessibilityInteractionController", new Class[0]);
      ((Method)localObject2).setAccessible(true);
      localObject1 = ((Method)localObject2).invoke(localObject1, new Object[0]);
    }
    catch (Throwable localThrowable3)
    {
      break label121;
    }
    localObject1 = null;
    if (localObject1 == null) {
      return true;
    }
    try
    {
      localObject2 = localObject1.getClass().getDeclaredField("mHandler");
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Field)localObject2).get(localObject1);
    }
    catch (Throwable localThrowable5)
    {
      boolean bool;
      break label157;
    }
    localObject2 = null;
    if (localObject2 != null)
    {
      bool = localObject2 instanceof Draco;
      if (bool) {
        return true;
      }
    }
    try
    {
      Object localObject4 = localObject2.getClass();
      localObject4 = ((Class)localObject4).getMethod("getLooper", new Class[0]);
      ((Method)localObject4).setAccessible(true);
      localObject4 = ((Method)localObject4).invoke(localObject2, new Object[0]);
      localObject3 = localObject4;
    }
    catch (Throwable localThrowable6)
    {
      break label220;
    }
    localObject3 = (Looper)localObject3;
    if (localObject3 == null) {
      return true;
    }
    localObject2 = new Draco((Handler)localObject2, this.zh, (Looper)localObject3, this.Bh, this.Ah);
    try
    {
      localObject3 = localObject1.getClass().getDeclaredField("mHandler");
      ((Field)localObject3).setAccessible(true);
      ((Field)localObject3).set(localObject1, localObject2);
      return true;
    }
    catch (Throwable localThrowable4) {}
    return true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Dorado
 * JD-Core Version:    0.7.0.1
 */