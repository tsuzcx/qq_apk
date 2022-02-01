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
    paramInt += (paramInt << 15 ^ 0xFFFFCD7D);
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
      if (localObject == null) {
        return null;
      }
      localObject = ((WeakReference)localObject).get();
      return localObject;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      int i = secondaryHash(paramView.hashCode());
      paramView = new StringBuilder();
      paramView.append("hash = ");
      paramView.append(i);
      paramView.append(", masked = ");
      paramView.append(0x7FFFFFFF & i);
      paramView.append(", ");
      paramView.append(localArrayIndexOutOfBoundsException.getMessage());
      throw new ArrayIndexOutOfBoundsException(paramView.toString());
    }
  }
  
  public void onActivityResume(Activity paramActivity)
  {
    Object localObject = paramActivity.getWindow();
    if (localObject == null) {
      return;
    }
    localObject = ((Window)localObject).getDecorView();
    if (localObject != null) {
      bind((View)localObject, paramActivity);
    }
  }
  
  public void onDialogShow(Activity paramActivity, Dialog paramDialog)
  {
    paramActivity = paramDialog.getWindow();
    if (paramActivity == null) {
      return;
    }
    paramActivity = paramActivity.getDecorView();
    if (paramActivity != null) {
      bind(paramActivity, paramDialog);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.ViewContainerBinder
 * JD-Core Version:    0.7.0.1
 */