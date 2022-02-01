package com.tencent.mobileqq.profilecard.base.framework;

import android.view.View;

public abstract interface IComponent<VIEW, DATA>
  extends IComponentLifecycle
{
  public abstract void addComponent(IComponent<? extends View, DATA> paramIComponent);
  
  public abstract void attachToComponentCenter();
  
  public abstract void detachFromComponentCenter();
  
  public abstract IComponent<? extends View, DATA> getComponent(int paramInt);
  
  public abstract IComponentCenter getComponentCenter();
  
  public abstract String getComponentName();
  
  public abstract int getComponentType();
  
  public abstract VIEW getContainerView();
  
  public abstract boolean onDataUpdate(DATA paramDATA);
  
  public abstract void removeComponent(IComponent<? extends View, DATA> paramIComponent);
  
  public abstract void setContainerView(VIEW paramVIEW);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.framework.IComponent
 * JD-Core Version:    0.7.0.1
 */