package com.tencent.mobileqq.profilecard.base.framework.impl;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import org.jetbrains.annotations.NotNull;

public class ComponentCenter
  implements IComponentCenter
{
  private static final boolean LOG_ENABLE = false;
  private static final String TAG = "ComponentCenter";
  private BaseActivity mActivity;
  private boolean mBackPressed;
  private SparseArray<IComponent> mComponentArray = new SparseArray();
  private ComponentCenter.Lifecycle mCurLifecycle = ComponentCenter.Lifecycle.NONE;
  
  private void callComponentLifecycle(IComponent paramIComponent, ComponentCenter.Lifecycle paramLifecycle1, ComponentCenter.Lifecycle paramLifecycle2)
  {
    int i = paramLifecycle2.compareTo(paramLifecycle1);
    if (i == 0) {
      return;
    }
    if (i > 0)
    {
      switch (ComponentCenter.10.$SwitchMap$com$tencent$mobileqq$profilecard$base$framework$impl$ComponentCenter$Lifecycle[paramLifecycle1.ordinal()])
      {
      default: 
        QLog.w("ComponentCenter", 1, String.format("callComponentLifecycle not support lifecycle, from=%s", new Object[] { paramLifecycle1 }));
        return;
      case 1: 
        paramIComponent.onCreate(this.mActivity, null);
        callComponentLifecycle(paramIComponent, ComponentCenter.Lifecycle.CREATED, paramLifecycle2);
        return;
      case 2: 
        paramIComponent.onStart();
        callComponentLifecycle(paramIComponent, ComponentCenter.Lifecycle.STARTED, paramLifecycle2);
        return;
      case 3: 
        paramIComponent.onResume();
        callComponentLifecycle(paramIComponent, ComponentCenter.Lifecycle.RESUMED, paramLifecycle2);
        return;
      case 4: 
        paramIComponent.onPause();
        callComponentLifecycle(paramIComponent, ComponentCenter.Lifecycle.PAUSED, paramLifecycle2);
        return;
      case 5: 
        paramIComponent.onStop();
        callComponentLifecycle(paramIComponent, ComponentCenter.Lifecycle.STOPPED, paramLifecycle2);
        return;
      }
      paramIComponent.onDestroy();
      callComponentLifecycle(paramIComponent, ComponentCenter.Lifecycle.DESTROYED, paramLifecycle2);
      return;
    }
    QLog.e("ComponentCenter", 1, String.format("callComponentLifecycle not support sequence, form=%s to=%s", new Object[] { paramLifecycle1, paramLifecycle2 }));
  }
  
  private void traversalComponentArray(ComponentCenter.TraversalComponentCallback paramTraversalComponentCallback)
  {
    if (paramTraversalComponentCallback == null) {}
    for (;;)
    {
      return;
      SparseArray localSparseArray = this.mComponentArray.clone();
      int j = localSparseArray.size();
      int i = 0;
      while (i < j)
      {
        paramTraversalComponentCallback.onTraversalComponent((IComponent)localSparseArray.valueAt(i));
        i += 1;
      }
    }
  }
  
  public void addComponent(IComponent paramIComponent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, String.format("addComponent component=%s", new Object[] { paramIComponent }));
    }
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      throw new RuntimeException("This Method Must Call In Main Thread.");
    }
    if (paramIComponent != null)
    {
      int i = paramIComponent.getComponentType();
      if (this.mComponentArray.indexOfKey(i) < 0)
      {
        this.mComponentArray.put(i, paramIComponent);
        callComponentLifecycle(paramIComponent, ComponentCenter.Lifecycle.NONE, this.mCurLifecycle);
      }
    }
    else
    {
      return;
    }
    QLog.e("ComponentCenter", 1, String.format("addComponent component exist. component=%s", new Object[] { paramIComponent }));
  }
  
  public IComponent getComponent(int paramInt)
  {
    return (IComponent)this.mComponentArray.get(paramInt);
  }
  
  public void init(BaseActivity paramBaseActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, String.format("init activity=%s", new Object[] { paramBaseActivity }));
    }
    if (paramBaseActivity != null)
    {
      this.mActivity = paramBaseActivity;
      this.mComponentArray.clear();
      return;
    }
    QLog.e("ComponentCenter", 1, "init params invalid.");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, String.format("onActivityResult requestCode=%s resultCode=%s data=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent }));
    }
    traversalComponentArray(new ComponentCenter.8(this, paramInt1, paramInt2, paramIntent));
  }
  
  public boolean onBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onBackPressed");
    }
    this.mBackPressed = false;
    traversalComponentArray(new ComponentCenter.9(this));
    return this.mBackPressed;
  }
  
  public void onCreate(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, String.format("onCreate activity=%s savedInstanceState=%s", new Object[] { paramBaseActivity, paramBundle }));
    }
    this.mCurLifecycle = ComponentCenter.Lifecycle.CREATED;
    traversalComponentArray(new ComponentCenter.1(this, paramBaseActivity, paramBundle));
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onDestroy");
    }
    this.mCurLifecycle = ComponentCenter.Lifecycle.DESTROYED;
    traversalComponentArray(new ComponentCenter.6(this));
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, String.format("onNewIntent intent=%s", new Object[] { paramIntent }));
    }
    traversalComponentArray(new ComponentCenter.7(this, paramIntent));
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onPause");
    }
    this.mCurLifecycle = ComponentCenter.Lifecycle.PAUSED;
    traversalComponentArray(new ComponentCenter.4(this));
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onResume");
    }
    this.mCurLifecycle = ComponentCenter.Lifecycle.RESUMED;
    traversalComponentArray(new ComponentCenter.3(this));
  }
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onStart");
    }
    this.mCurLifecycle = ComponentCenter.Lifecycle.STARTED;
    traversalComponentArray(new ComponentCenter.2(this));
  }
  
  public void onStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, "onStop");
    }
    this.mCurLifecycle = ComponentCenter.Lifecycle.STOPPED;
    traversalComponentArray(new ComponentCenter.5(this));
  }
  
  public void removeComponent(IComponent paramIComponent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentCenter", 0, String.format("removeComponent component=%s", new Object[] { paramIComponent }));
    }
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      throw new RuntimeException("This Method Must Call In Main Thread.");
    }
    if (paramIComponent != null)
    {
      int i = paramIComponent.getComponentType();
      i = this.mComponentArray.indexOfKey(i);
      if (i >= 0)
      {
        this.mComponentArray.removeAt(i);
        callComponentLifecycle(paramIComponent, this.mCurLifecycle, ComponentCenter.Lifecycle.DESTROYED);
      }
    }
  }
  
  @NotNull
  public String toString()
  {
    return String.format("ComponentCenter@%s", new Object[] { Integer.valueOf(hashCode()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter
 * JD-Core Version:    0.7.0.1
 */