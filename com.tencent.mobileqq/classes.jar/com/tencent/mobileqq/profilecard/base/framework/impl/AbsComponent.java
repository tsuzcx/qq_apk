package com.tencent.mobileqq.profilecard.base.framework.impl;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;

public abstract class AbsComponent<VIEW, DATA>
  implements IComponent<VIEW, DATA>
{
  private static final boolean LOG_ENABLE = false;
  private static final String TAG = "AbsComponent";
  public BaseActivity mActivity;
  public QQAppInterface mApp;
  protected SparseArray<IComponent<? extends View, DATA>> mChildComponent;
  protected IComponentCenter mComponentCenter;
  public DATA mData;
  public VIEW mViewContainer;
  
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
    if (this.mComponentCenter != null) {
      this.mComponentCenter.addComponent(this);
    }
  }
  
  public void detachFromComponentCenter()
  {
    if (this.mComponentCenter != null) {
      this.mComponentCenter.removeComponent(this);
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
  
  public void onCreate(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    this.mActivity = paramBaseActivity;
    this.mApp = paramBaseActivity.app;
  }
  
  public boolean onDataUpdate(DATA paramDATA)
  {
    this.mData = paramDATA;
    int j = this.mChildComponent.size();
    int i = 0;
    boolean bool = false;
    if (i < j)
    {
      IComponent localIComponent = (IComponent)this.mChildComponent.valueAt(i);
      if (localIComponent == null) {
        break label64;
      }
      bool = localIComponent.onDataUpdate(paramDATA) | bool;
    }
    label64:
    for (;;)
    {
      i += 1;
      break;
      return bool;
    }
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
  
  public void removeComponent(IComponent<? extends View, DATA> paramIComponent)
  {
    this.mChildComponent.remove(paramIComponent.getComponentType());
  }
  
  public void setContainerView(VIEW paramVIEW)
  {
    this.mViewContainer = paramVIEW;
  }
  
  @NonNull
  public String toString()
  {
    return String.format("Component@%s{componentType=%s componentName=%s}", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getComponentType()), getComponentName() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent
 * JD-Core Version:    0.7.0.1
 */