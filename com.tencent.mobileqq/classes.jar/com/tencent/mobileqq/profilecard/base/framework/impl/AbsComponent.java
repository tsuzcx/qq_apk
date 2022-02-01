package com.tencent.mobileqq.profilecard.base.framework.impl;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;

public abstract class AbsComponent<VIEW, DATA>
  implements IComponent<VIEW, DATA>
{
  private static final boolean LOG_ENABLE = false;
  private static final String TAG = "AbsComponent";
  protected QBaseActivity mActivity;
  protected AppInterface mApp;
  protected SparseArray<IComponent<? extends View, DATA>> mChildComponent;
  protected IComponentCenter mComponentCenter;
  protected DATA mData;
  protected VIEW mViewContainer;
  
  public AbsComponent(IComponentCenter paramIComponentCenter, DATA paramDATA)
  {
    this.mComponentCenter = paramIComponentCenter;
    this.mData = paramDATA;
    this.mChildComponent = new SparseArray();
  }
  
  public void addComponent(IComponent<? extends View, DATA> paramIComponent)
  {
    this.mChildComponent.put(paramIComponent.getComponentType(), paramIComponent);
  }
  
  public void attachToComponentCenter()
  {
    IComponentCenter localIComponentCenter = this.mComponentCenter;
    if (localIComponentCenter != null) {
      localIComponentCenter.addComponent(this);
    }
  }
  
  public void detachFromComponentCenter()
  {
    IComponentCenter localIComponentCenter = this.mComponentCenter;
    if (localIComponentCenter != null) {
      localIComponentCenter.removeComponent(this);
    }
  }
  
  public IComponent<? extends View, DATA> getComponent(int paramInt)
  {
    return (IComponent)this.mChildComponent.get(paramInt);
  }
  
  public IComponentCenter getComponentCenter()
  {
    return this.mComponentCenter;
  }
  
  public VIEW getContainerView()
  {
    return this.mViewContainer;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    this.mActivity = paramQBaseActivity;
    this.mApp = ((AppInterface)paramQBaseActivity.getAppRuntime());
  }
  
  public boolean onDataUpdate(DATA paramDATA)
  {
    this.mData = paramDATA;
    int j = this.mChildComponent.size();
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2)
    {
      IComponent localIComponent = (IComponent)this.mChildComponent.valueAt(i);
      bool2 = bool1;
      if (localIComponent != null) {
        bool2 = bool1 | localIComponent.onDataUpdate(paramDATA);
      }
      i += 1;
    }
    return bool1;
  }
  
  public void onDestroy()
  {
    this.mActivity = null;
    this.mApp = null;
  }
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void onWindowFocusChanged(boolean paramBoolean) {}
  
  public void removeComponent(IComponent<? extends View, DATA> paramIComponent)
  {
    this.mChildComponent.remove(paramIComponent.getComponentType());
  }
  
  public void setContainerView(VIEW paramVIEW)
  {
    this.mViewContainer = paramVIEW;
  }
  
  public String toString()
  {
    return String.format("Component@%s{componentType=%s componentName=%s}", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getComponentType()), getComponentName() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent
 * JD-Core Version:    0.7.0.1
 */