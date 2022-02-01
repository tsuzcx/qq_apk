package com.tencent.viola.ui.diff;

import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.action.MethodAbsAdd;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.dom.DomObject;

public abstract class Patch
{
  public static VComponent generateComponentTree(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    if (paramViolaInstance == null) {
      return null;
    }
    return MethodAbsAdd.generateComponentTree(ViolaSDKManager.getInstance().getDomManager().getDomContext(paramViolaInstance.getInstanceId()), paramDomObject, paramVComponentContainer);
  }
  
  public abstract void applyPatch(DomDiffUtils.OnComponentDiffListener paramOnComponentDiffListener, DOMActionContext paramDOMActionContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.diff.Patch
 * JD-Core Version:    0.7.0.1
 */