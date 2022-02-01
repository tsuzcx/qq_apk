package com.tencent.qqlive.module.videoreport.page;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class ViewContainerBinder
  extends DefaultEventListener
{
  private final WeakHashMap<View, WeakReference<Object>> mBound = new WeakHashMap();
  
  public static ViewContainerBinder getInstance()
  {
    return ViewContainerBinder.InstanceHolder.INSTANCE;
  }
  
  private void init()
  {
    EventCollector.getInstance().registerEventListener(this);
  }
  
  private static int secondaryHash(int paramInt)
  {
    paramInt = (paramInt << 15 ^ 0xFFFFCD7D) + paramInt;
    paramInt ^= paramInt >>> 10;
    paramInt += (paramInt << 3);
    paramInt ^= paramInt >>> 6;
    paramInt += (paramInt << 2) + (paramInt << 14);
    return paramInt ^ paramInt >>> 16;
  }
  
  public void bind(View paramView, Object paramObject)
  {
    if (paramView == null) {
      return;
    }
    this.mBound.put(paramView, new WeakReference(paramObject));
  }
  
  public Object getBoundContainer(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    try
    {
      Object localObject = (WeakReference)this.mBound.get(paramView);
      if (localObject == null)
      {
        paramView = null;
      }
      else
      {
        localObject = ((WeakReference)localObject).get();
        paramView = (View)localObject;
      }
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      int i = secondaryHash(paramView.hashCode());
      throw new ArrayIndexOutOfBoundsException("hash = " + i + ", masked = " + (0x7FFFFFFF & i) + ", " + localArrayIndexOutOfBoundsException.getMessage());
    }
    return paramView;
  }
  
  public void onActivityResume(Activity paramActivity)
  {
    Object localObject = paramActivity.getWindow();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((Window)localObject).getDecorView();
    } while (localObject == null);
    bind((View)localObject, paramActivity);
  }
  
  public void onDialogShow(Activity paramActivity, Dialog paramDialog)
  {
    paramActivity = paramDialog.getWindow();
    if (paramActivity == null) {}
    do
    {
      return;
      paramActivity = paramActivity.getDecorView();
    } while (paramActivity == null);
    bind(paramActivity, paramDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.ViewContainerBinder
 * JD-Core Version:    0.7.0.1
 */