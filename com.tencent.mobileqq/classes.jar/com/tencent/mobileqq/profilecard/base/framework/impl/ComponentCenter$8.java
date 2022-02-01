package com.tencent.mobileqq.profilecard.base.framework.impl;

import android.content.Intent;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;

class ComponentCenter$8
  implements ComponentCenter.TraversalComponentCallback
{
  ComponentCenter$8(ComponentCenter paramComponentCenter, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onTraversalComponent(IComponent paramIComponent)
  {
    paramIComponent.onActivityResult(this.val$requestCode, this.val$resultCode, this.val$data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.8
 * JD-Core Version:    0.7.0.1
 */