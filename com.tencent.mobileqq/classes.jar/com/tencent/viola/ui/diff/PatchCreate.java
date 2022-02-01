package com.tencent.viola.ui.diff;

import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.component.VRecyclerList;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.utils.ViolaLogUtils;

public class PatchCreate
  extends Patch
{
  private static final String TAG = "PatchCreate";
  private DomObject mNewDom;
  private VComponentContainer mParent;
  
  public PatchCreate(DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    this.mNewDom = paramDomObject;
    this.mParent = paramVComponentContainer;
  }
  
  public void applyPatch(DomDiffUtils.OnComponentDiffListener paramOnComponentDiffListener, DOMActionContext paramDOMActionContext)
  {
    paramOnComponentDiffListener = this.mNewDom;
    if (paramOnComponentDiffListener == null)
    {
      ViolaLogUtils.d("PatchCreate", "newDom is null");
      return;
    }
    if (this.mParent == null)
    {
      ViolaLogUtils.d("PatchCreate", "parent is null");
      return;
    }
    paramOnComponentDiffListener.lazy(false);
    paramOnComponentDiffListener = generateComponentTree(this.mParent.getInstance(), this.mNewDom, this.mParent);
    if ((paramOnComponentDiffListener instanceof VRecyclerList)) {
      ViolaLogUtils.d("PatchCreate", "");
    }
    if (paramOnComponentDiffListener != null)
    {
      paramOnComponentDiffListener.lazy(false);
      paramOnComponentDiffListener.createView();
      this.mParent.addChild(paramOnComponentDiffListener);
      this.mParent.addSubView(paramOnComponentDiffListener.getRealView(), -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.diff.PatchCreate
 * JD-Core Version:    0.7.0.1
 */