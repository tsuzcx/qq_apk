package com.tencent.viola.ui.diff;

import android.view.ViewGroup;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.component.VRecyclerList;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.ArrayList;

public class PatchDelete
  extends Patch
{
  private static final String TAG = "PatchDelete";
  private VComponent mDeleteComponent;
  private VComponentContainer mParent;
  
  public PatchDelete(VComponentContainer paramVComponentContainer, VComponent paramVComponent)
  {
    this.mParent = paramVComponentContainer;
    this.mDeleteComponent = paramVComponent;
  }
  
  public void applyPatch(DomDiffUtils.OnComponentDiffListener paramOnComponentDiffListener, DOMActionContext paramDOMActionContext)
  {
    if (this.mParent == null)
    {
      ViolaLogUtils.d("PatchDelete", "parent is null");
      return;
    }
    if (this.mDeleteComponent == null)
    {
      ViolaLogUtils.d("PatchDelete", "deleteComponent is null");
      return;
    }
    this.mDeleteComponent.removedByDiff();
    if ((this.mDeleteComponent instanceof VRecyclerList))
    {
      if (this.mParent.mChildren != null) {
        this.mParent.mChildren.remove(this.mDeleteComponent);
      }
      while (this.mParent.getRealView() != null)
      {
        this.mParent.getRealView().removeView(((VRecyclerList)this.mDeleteComponent).getRealParentView());
        this.mParent.getRealView().removeView(this.mDeleteComponent.getRealView());
        return;
        ViolaLogUtils.d("PatchDelete", "child is null");
      }
      ViolaLogUtils.d("PatchDelete", "realView is null");
      return;
    }
    this.mParent.remove(this.mDeleteComponent, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.diff.PatchDelete
 * JD-Core Version:    0.7.0.1
 */