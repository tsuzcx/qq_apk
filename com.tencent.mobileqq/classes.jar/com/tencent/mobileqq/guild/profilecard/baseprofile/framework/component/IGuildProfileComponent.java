package com.tencent.mobileqq.guild.profilecard.baseprofile.framework.component;

import androidx.annotation.LayoutRes;

public abstract interface IGuildProfileComponent<VIEW, DATA>
  extends IComponentLifecycle<DATA>
{
  public abstract void detachFromComponentController();
  
  public abstract String getComponentName();
  
  public abstract int getComponentType();
  
  @LayoutRes
  public abstract int getContentLayoutId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.baseprofile.framework.component.IGuildProfileComponent
 * JD-Core Version:    0.7.0.1
 */