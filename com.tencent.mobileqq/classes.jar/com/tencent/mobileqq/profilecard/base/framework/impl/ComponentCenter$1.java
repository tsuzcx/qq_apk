package com.tencent.mobileqq.profilecard.base.framework.impl;

import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;

class ComponentCenter$1
  implements ComponentCenter.TraversalComponentCallback
{
  ComponentCenter$1(ComponentCenter paramComponentCenter, BaseActivity paramBaseActivity, Bundle paramBundle) {}
  
  public void onTraversalComponent(IComponent paramIComponent)
  {
    paramIComponent.onCreate(this.val$activity, this.val$savedInstanceState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter.1
 * JD-Core Version:    0.7.0.1
 */