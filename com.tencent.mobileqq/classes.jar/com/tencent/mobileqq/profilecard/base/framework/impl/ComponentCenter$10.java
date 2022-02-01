package com.tencent.mobileqq.profilecard.base.framework.impl;

import com.tencent.mobileqq.profilecard.base.framework.IComponent;

class ComponentCenter$10
  implements ComponentCenter.TraversalComponentCallback
{
  ComponentCenter$10(ComponentCenter paramComponentCenter, boolean paramBoolean) {}
  
  public void onTraversalComponent(IComponent paramIComponent)
  {
    paramIComponent.onWindowFocusChanged(this.val$isFocused);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.10
 * JD-Core Version:    0.7.0.1
 */