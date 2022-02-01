package io.flutter.plugin.platform;

import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class SingleViewPresentation$WindowManagerHandler
  implements InvocationHandler
{
  private static final String TAG = "PlatformViewsController";
  private final WindowManager delegate;
  SingleViewPresentation.FakeWindowViewGroup fakeWindowRootView;
  
  SingleViewPresentation$WindowManagerHandler(WindowManager paramWindowManager, SingleViewPresentation.FakeWindowViewGroup paramFakeWindowViewGroup)
  {
    this.delegate = paramWindowManager;
    this.fakeWindowRootView = paramFakeWindowViewGroup;
  }
  
  private void addView(Object[] paramArrayOfObject)
  {
    if (this.fakeWindowRootView == null)
    {
      Log.w("PlatformViewsController", "Embedded view called addView while detached from presentation");
      return;
    }
    View localView = (View)paramArrayOfObject[0];
    paramArrayOfObject = (WindowManager.LayoutParams)paramArrayOfObject[1];
    this.fakeWindowRootView.addView(localView, paramArrayOfObject);
  }
  
  private void removeView(Object[] paramArrayOfObject)
  {
    if (this.fakeWindowRootView == null)
    {
      Log.w("PlatformViewsController", "Embedded view called removeView while detached from presentation");
      return;
    }
    paramArrayOfObject = (View)paramArrayOfObject[0];
    this.fakeWindowRootView.removeView(paramArrayOfObject);
  }
  
  private void removeViewImmediate(Object[] paramArrayOfObject)
  {
    if (this.fakeWindowRootView == null)
    {
      Log.w("PlatformViewsController", "Embedded view called removeViewImmediate while detached from presentation");
      return;
    }
    paramArrayOfObject = (View)paramArrayOfObject[0];
    paramArrayOfObject.clearAnimation();
    this.fakeWindowRootView.removeView(paramArrayOfObject);
  }
  
  private void updateViewLayout(Object[] paramArrayOfObject)
  {
    if (this.fakeWindowRootView == null)
    {
      Log.w("PlatformViewsController", "Embedded view called updateViewLayout while detached from presentation");
      return;
    }
    View localView = (View)paramArrayOfObject[0];
    paramArrayOfObject = (WindowManager.LayoutParams)paramArrayOfObject[1];
    this.fakeWindowRootView.updateViewLayout(localView, paramArrayOfObject);
  }
  
  public WindowManager getWindowManager()
  {
    return (WindowManager)Proxy.newProxyInstance(WindowManager.class.getClassLoader(), new Class[] { WindowManager.class }, this);
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = paramMethod.getName();
    int i = paramObject.hashCode();
    if (i != -1148522778) {
      if (i != 542766184) {
        if (i != 931413976) {
          if (i != 1098630473) {
            i = -1;
          }
        }
      }
    }
    for (;;)
    {
      switch (i)
      {
      }
      try
      {
        paramObject = paramMethod.invoke(this.delegate, paramArrayOfObject);
        return paramObject;
      }
      catch (InvocationTargetException paramObject)
      {
        throw paramObject.getCause();
      }
      if (!paramObject.equals("removeView")) {
        break;
      }
      i = 1;
      continue;
      if (!paramObject.equals("updateViewLayout")) {
        break;
      }
      i = 3;
      continue;
      if (!paramObject.equals("removeViewImmediate")) {
        break;
      }
      i = 2;
      continue;
      if (!paramObject.equals("addView")) {
        break;
      }
      i = 0;
    }
    updateViewLayout(paramArrayOfObject);
    return null;
    removeViewImmediate(paramArrayOfObject);
    return null;
    removeView(paramArrayOfObject);
    return null;
    addView(paramArrayOfObject);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation.WindowManagerHandler
 * JD-Core Version:    0.7.0.1
 */