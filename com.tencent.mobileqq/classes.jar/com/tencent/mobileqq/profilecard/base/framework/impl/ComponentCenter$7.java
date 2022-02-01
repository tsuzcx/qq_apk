package com.tencent.mobileqq.profilecard.base.framework.impl;

import android.content.Intent;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;

class ComponentCenter$7
  implements ComponentCenter.TraversalComponentCallback
{
  ComponentCenter$7(ComponentCenter paramComponentCenter, Intent paramIntent) {}
  
  public void onTraversalComponent(IComponent paramIComponent)
  {
    paramIComponent.onNewIntent(this.val$intent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.7
 * JD-Core Version:    0.7.0.1
 */