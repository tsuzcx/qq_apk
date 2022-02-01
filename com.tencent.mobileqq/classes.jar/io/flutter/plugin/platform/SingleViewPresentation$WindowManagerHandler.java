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
    SingleViewPresentation.FakeWindowViewGroup localFakeWindowViewGroup = this.fakeWindowRootView;
    if (localFakeWindowViewGroup == null)
    {
      Log.w("PlatformViewsController", "Embedded view called addView while detached from presentation");
      return;
    }
    localFakeWindowViewGroup.addView((View)paramArrayOfObject[0], (WindowManager.LayoutParams)paramArrayOfObject[1]);
  }
  
  private void removeView(Object[] paramArrayOfObject)
  {
    SingleViewPresentation.FakeWindowViewGroup localFakeWindowViewGroup = this.fakeWindowRootView;
    if (localFakeWindowViewGroup == null)
    {
      Log.w("PlatformViewsController", "Embedded view called removeView while detached from presentation");
      return;
    }
    localFakeWindowViewGroup.removeView((View)paramArrayOfObject[0]);
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
    SingleViewPresentation.FakeWindowViewGroup localFakeWindowViewGroup = this.fakeWindowRootView;
    if (localFakeWindowViewGroup == null)
    {
      Log.w("PlatformViewsController", "Embedded view called updateViewLayout while detached from presentation");
      return;
    }
    localFakeWindowViewGroup.updateViewLayout((View)paramArrayOfObject[0], (WindowManager.LayoutParams)paramArrayOfObject[1]);
  }
  
  public WindowManager getWindowManager()
  {
    return (WindowManager)Proxy.newProxyInstance(WindowManager.class.getClassLoader(), new Class[] { WindowManager.class }, this);
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = paramMethod.getName();
    int i = paramObject.hashCode();
    if (i != -1148522778)
    {
      if (i != 542766184)
      {
        if (i != 931413976)
        {
          if ((i == 1098630473) && (paramObject.equals("removeView")))
          {
            i = 1;
            break label105;
          }
        }
        else if (paramObject.equals("updateViewLayout"))
        {
          i = 3;
          break label105;
        }
      }
      else if (paramObject.equals("removeViewImmediate"))
      {
        i = 2;
        break label105;
      }
    }
    else if (paramObject.equals("addView"))
    {
      i = 0;
      break label105;
    }
    i = -1;
    label105:
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            try
            {
              paramObject = paramMethod.invoke(this.delegate, paramArrayOfObject);
              return paramObject;
            }
            catch (InvocationTargetException paramObject)
            {
              throw paramObject.getCause();
            }
          }
          updateViewLayout(paramArrayOfObject);
          return null;
        }
        removeViewImmediate(paramArrayOfObject);
        return null;
      }
      removeView(paramArrayOfObject);
      return null;
    }
    addView(paramArrayOfObject);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation.WindowManagerHandler
 * JD-Core Version:    0.7.0.1
 */