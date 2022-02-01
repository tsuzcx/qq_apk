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
    if (INSTANCE == null) {}
    try
    {
      if (INSTANCE == null) {
        INSTANCE = new VInstanceManager();
      }
      return INSTANCE;
    }
    finally {}
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public void addVInstance(String paramString1, String paramString2)
  {
    if (this.instanceAction != null) {
      this.instanceAction.addVInstance(paramString1, paramString2);
    }
  }
  
  public void addVInstanceEventListener(String paramString, VInstanceAction.VInstanceEventListener paramVInstanceEventListener)
  {
    if (this.instanceAction != null) {
      this.instanceAction.addListener(paramString, paramVInstanceEventListener);
    }
  }
  
  public boolean bindData(String paramString1, String paramString2, View paramView)
  {
    if (this.instanceAction != null) {
      return this.instanceAction.bindData(paramString1, paramString2, paramView);
    }
    return false;
  }
  
  public boolean bindNativeVueData(String paramString1, String paramString2, View paramView)
  {
    if (this.instanceAction != null) {
      return this.instanceAction.bindNativeVueView(paramString1, paramString2, paramView);
    }
    return false;
  }
  
  public View createNativeVueView(String paramString, Context paramContext)
  {
    if (this.instanceAction != null) {
      return this.instanceAction.createNativeVueView(paramString, paramContext);
    }
    return null;
  }
  
  public void createVInstance(String paramString1, String paramString2)
  {
    if (this.instanceAction != null) {
      this.instanceAction.createVInstance(paramString1, paramString2);
    }
  }
  
  public void createVInstanceSync(String paramString1, String paramString2)
  {
    if (this.instanceAction != null) {
      this.instanceAction.createVInstanceSync(paramString1, paramString2);
    }
  }
  
  public void disappear(View paramView)
  {
    if (this.instanceAction != null) {
      this.instanceAction.disappear(paramView);
    }
  }
  
  public Context getCurrentContext(String paramString)
  {
    if (this.instanceAction != null) {
      return this.instanceAction.getContext(paramString);
    }
    return null;
  }
  
  public int getHeight(String paramString)
  {
    if (this.instanceAction != null) {
      return this.instanceAction.getHeight(paramString);
    }
    return 0;
  }
  
  public int getWidth(String paramString)
  {
    if (this.instanceAction != null) {
      return this.instanceAction.getWidth(paramString);
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
    if (this.instanceAction != null) {
      this.instanceAction.onScroll(paramViewGroup, paramView, paramInt1, paramInt2);
    }
  }
  
  public void release(String paramString1, String paramString2)
  {
    if (this.instanceAction != null) {
      this.instanceAction.release(paramString1, paramString2);
    }
  }
  
  public void release(List<String> paramList, String paramString)
  {
    if (this.instanceAction != null) {
      this.instanceAction.release(paramList, paramString);
    }
  }
  
  public void removeVInstanceEventListener(String paramString)
  {
    if (this.instanceAction != null) {
      this.instanceAction.removeListener(paramString);
    }
  }
  
  public void updateInstance(String paramString1, String paramString2)
  {
    if (this.instanceAction != null) {
      this.instanceAction.updateInstance(paramString1, paramString2);
    }
  }
  
  public void willAppear(View paramView, ViewGroup paramViewGroup)
  {
    if (this.instanceAction != null) {
      this.instanceAction.willAppear(paramView, paramViewGroup);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.viola.vinstance.VInstanceManager
 * JD-Core Version:    0.7.0.1
 */