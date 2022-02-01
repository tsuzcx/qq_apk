package com.tencent.mobileqq.profilecard.base.framework.impl;

import com.tencent.mobileqq.profilecard.base.framework.IComponent;

class ComponentCenter$2
  implements ComponentCenter.TraversalComponentCallback
{
  ComponentCenter$2(ComponentCenter paramComponentCenter) {}
  
  public void onTraversalComponent(IComponent paramIComponent)
  {
    paramIComponent.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.2
 * JD-Core Version:    0.7.0.1
 */