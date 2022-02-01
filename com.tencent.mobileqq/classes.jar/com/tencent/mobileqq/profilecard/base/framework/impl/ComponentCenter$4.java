package com.tencent.mobileqq.profilecard.base.framework.impl;

import com.tencent.mobileqq.profilecard.base.framework.IComponent;

class ComponentCenter$4
  implements ComponentCenter.TraversalComponentCallback
{
  ComponentCenter$4(ComponentCenter paramComponentCenter) {}
  
  public void onTraversalComponent(IComponent paramIComponent)
  {
    paramIComponent.onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.4
 * JD-Core Version:    0.7.0.1
 */