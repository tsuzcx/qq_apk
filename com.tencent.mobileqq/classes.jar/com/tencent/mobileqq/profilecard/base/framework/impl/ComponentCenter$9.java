package com.tencent.mobileqq.profilecard.base.framework.impl;

import com.tencent.mobileqq.profilecard.base.framework.IComponent;

class ComponentCenter$9
  implements ComponentCenter.TraversalComponentCallback
{
  ComponentCenter$9(ComponentCenter paramComponentCenter) {}
  
  public void onTraversalComponent(IComponent paramIComponent)
  {
    ComponentCenter localComponentCenter = this.this$0;
    boolean bool = ComponentCenter.access$000(localComponentCenter);
    ComponentCenter.access$002(localComponentCenter, paramIComponent.onBackPressed() | bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.9
 * JD-Core Version:    0.7.0.1
 */