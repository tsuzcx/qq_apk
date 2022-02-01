package com.tencent.mobileqq.profilecard.base.framework;

import com.tencent.mobileqq.app.BaseActivity;

public abstract interface IComponentCenter
  extends IComponentLifecycle
{
  public abstract void addComponent(IComponent paramIComponent);
  
  public abstract IComponent getComponent(int paramInt);
  
  public abstract void init(BaseActivity paramBaseActivity);
  
  public abstract void removeComponent(IComponent paramIComponent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.framework.IComponentCenter
 * JD-Core Version:    0.7.0.1
 */