package com.tencent.viola.vinstance;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.viola.core.ViolaInstance;
import java.util.List;

public class VInstanceManager
{
  private static volatile VInstanceManager INSTANCE;
  public static final String TAG = "VInstanceManager";
  private VInstanceAction instanceAction;
  
  private VInstanceAction createVInstanceAction(ViolaInstance paramViolaInstance, VInstanceManager.Builder paramBuilder, boolean paramBoolean)
  {
    Preconditor localPreconditor = new Preconditor(paramBuilder.preconditions, paramBuilder.preconditionAdapter);
    if (paramBoolean) {
      return new BlockVInstanceAction(localPreconditor, paramViolaInstance, paramBuilder.param);
    }
    return new NoBlockVInstanceAction(localPreconditor, paramViolaInstance, paramBuilder.param);
  }
  
  public static VInstanceManager getInstance()
  {
    if (INSTANCE == null) {
      try
      {
        if (INSTANCE == null) {
          INSTANCE = new VInstanceManager();
        }
      }
      finally {}
    }
    return INSTANCE;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public void addVInstance(String paramString1, String paramString2)
  {
    VInstanceAction localVInstanceAction = this.instanceAction;
    if (localVInstanceAction != null) {
      localVInstanceAction.addVInstance(paramString1, paramString2);
    }
  }
  
  public void addVInstanceEventListener(String paramString, VInstanceAction.VInstanceEventListener paramVInstanceEventListener)
  {
    VInstanceAction localVInstanceAction = this.instanceAction;
    if (localVInstanceAction != null) {
      localVInstanceAction.addListener(paramString, paramVInstanceEventListener);
    }
  }
  
  public boolean bindData(String paramString1, String paramString2, View paramView)
  {
    VInstanceAction localVInstanceAction = this.instanceAction;
    if (localVInstanceAction != null) {
      return localVInstanceAction.bindData(paramString1, paramString2, paramView);
    }
    return false;
  }
  
  public boolean bindNativeVueData(String paramString1, String paramString2, View paramView)
  {
    VInstanceAction localVInstanceAction = this.instanceAction;
    if (localVInstanceAction != null) {
      return localVInstanceAction.bindNativeVueView(paramString1, paramString2, paramView);
    }
    return false;
  }
  
  public View createNativeVueView(String paramString, Context paramContext)
  {
    VInstanceAction localVInstanceAction = this.instanceAction;
    if (localVInstanceAction != null) {
      return localVInstanceAction.createNativeVueView(paramString, paramContext);
    }
    return null;
  }
  
  public void createVInstance(String paramString1, String paramString2)
  {
    VInstanceAction localVInstanceAction = this.instanceAction;
    if (localVInstanceAction != null) {
      localVInstanceAction.createVInstance(paramString1, paramString2);
    }
  }
  
  public void createVInstanceSync(String paramString1, String paramString2)
  {
    VInstanceAction localVInstanceAction = this.instanceAction;
    if (localVInstanceAction != null) {
      localVInstanceAction.createVInstanceSync(paramString1, paramString2);
    }
  }
  
  public void disappear(View paramView)
  {
    VInstanceAction localVInstanceAction = this.instanceAction;
    if (localVInstanceAction != null) {
      localVInstanceAction.disappear(paramView);
    }
  }
  
  public Context getCurrentContext(String paramString)
  {
    VInstanceAction localVInstanceAction = this.instanceAction;
    if (localVInstanceAction != null) {
      return localVInstanceAction.getContext(paramString);
    }
    return null;
  }
  
  public int getHeight(String paramString)
  {
    VInstanceAction localVInstanceAction = this.instanceAction;
    if (localVInstanceAction != null) {
      return localVInstanceAction.getHeight(paramString);
    }
    return 0;
  }
  
  public int getWidth(String paramString)
  {
    VInstanceAction localVInstanceAction = this.instanceAction;
    if (localVInstanceAction != null) {
      return localVInstanceAction.getWidth(paramString);
    }
    return 0;
  }
  
  public void init(VInstanceManager.Builder paramBuilder)
  {
    this.instanceAction = createVInstanceAction(new ViolaInstance(paramBuilder.application, paramBuilder.serviceJsUrl), paramBuilder, paramBuilder.isBlockingMode);
    this.instanceAction.init(false);
  }
  
  public void onScroll(ViewGroup paramViewGroup, View paramView, int paramInt1, int paramInt2)
  {
    VInstanceAction localVInstanceAction = this.instanceAction;
    if (localVInstanceAction != null) {
      localVInstanceAction.onScroll(paramViewGroup, paramView, paramInt1, paramInt2);
    }
  }
  
  public void release(String paramString1, String paramString2)
  {
    VInstanceAction localVInstanceAction = this.instanceAction;
    if (localVInstanceAction != null) {
      localVInstanceAction.release(paramString1, paramString2);
    }
  }
  
  public void release(List<String> paramList, String paramString)
  {
    VInstanceAction localVInstanceAction = this.instanceAction;
    if (localVInstanceAction != null) {
      localVInstanceAction.release(paramList, paramString);
    }
  }
  
  public void removeVInstanceEventListener(String paramString)
  {
    VInstanceAction localVInstanceAction = this.instanceAction;
    if (localVInstanceAction != null) {
      localVInstanceAction.removeListener(paramString);
    }
  }
  
  public void updateInstance(String paramString1, String paramString2)
  {
    VInstanceAction localVInstanceAction = this.instanceAction;
    if (localVInstanceAction != null) {
      localVInstanceAction.updateInstance(paramString1, paramString2);
    }
  }
  
  public void willAppear(View paramView, ViewGroup paramViewGroup)
  {
    VInstanceAction localVInstanceAction = this.instanceAction;
    if (localVInstanceAction != null) {
      localVInstanceAction.willAppear(paramView, paramViewGroup);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.vinstance.VInstanceManager
 * JD-Core Version:    0.7.0.1
 */