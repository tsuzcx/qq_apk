package com.tencent.mobileqq.profilecard.base.framework.impl;

import com.tencent.mobileqq.profilecard.base.framework.IComponent;

class ComponentCenter$3
  implements ComponentCenter.TraversalComponentCallback
{
  ComponentCenter$3(ComponentCenter paramComponentCenter) {}
  
  public void onTraversalComponent(IComponent paramIComponent)
  {
    paramIComponent.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.3
 * JD-Core Version:    0.7.0.1
 */