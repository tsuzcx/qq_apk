package com.tencent.viola.ui.diff;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.component.VCell;
import com.tencent.viola.ui.component.VRecyclerList;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.utils.ViolaLogUtils;

public class PatchReplace
  extends Patch
{
  private static final String TAG = "PatchReplace";
  private DomObject mNewDom;
  private VComponent mOldComponent;
  
  public PatchReplace(DomObject paramDomObject, VComponent paramVComponent)
  {
    this.mNewDom = paramDomObject;
    this.mOldComponent = paramVComponent;
  }
  
  public void applyPatch(DomDiffUtils.OnComponentDiffListener paramOnComponentDiffListener, DOMActionContext paramDOMActionContext)
  {
    if (this.mNewDom == null)
    {
      ViolaLogUtils.d("PatchReplace", "mNewDom is null");
      return;
    }
    paramDOMActionContext = this.mOldComponent;
    if (paramDOMActionContext == null)
    {
      ViolaLogUtils.d("PatchReplace", "mOldComponent is null");
      return;
    }
    if (paramDOMActionContext.mParent == null)
    {
      ViolaLogUtils.d("PatchReplace", "mPatent is null");
      return;
    }
    this.mNewDom.lazy(false);
    Object localObject = this.mOldComponent.mParent;
    paramDOMActionContext = generateComponentTree(((VComponentContainer)localObject).getInstance(), this.mNewDom, (VComponentContainer)localObject);
    if (paramDOMActionContext != null)
    {
      int i = ((VComponentContainer)localObject).indexOf(this.mOldComponent);
      if (i != -1)
      {
        paramDOMActionContext.lazy(false);
        paramDOMActionContext.createView();
        ((VComponentContainer)localObject).remove(this.mOldComponent, false);
        this.mOldComponent.removedByDiff();
        ((VComponentContainer)localObject).addChild(paramDOMActionContext, i);
        if (((localObject instanceof VRecyclerList)) && (this.mOldComponent.getRealView() != null))
        {
          localObject = (ViewGroup)this.mOldComponent.getRealView().getParent();
          if (localObject != null)
          {
            ((ViewGroup)localObject).removeView(this.mOldComponent.getRealView());
            ((ViewGroup)localObject).addView(paramDOMActionContext.getHostView());
            if (paramOnComponentDiffListener != null)
            {
              localObject = this.mOldComponent;
              if (((localObject instanceof VCell)) && ((paramDOMActionContext instanceof VCell))) {
                paramOnComponentDiffListener.onCellChange((VCell)localObject, (VCell)paramDOMActionContext);
              }
            }
          }
        }
        else
        {
          ((VComponentContainer)localObject).addSubView(paramDOMActionContext.getRealView(), i);
        }
      }
      else if (((localObject instanceof VRecyclerList)) && (((VComponentContainer)localObject).getRealView() != null) && (this.mOldComponent.getRealView() != null))
      {
        ViewGroup localViewGroup = (ViewGroup)this.mOldComponent.getRealView().getParent();
        if (localViewGroup != null)
        {
          paramDOMActionContext.lazy(false);
          paramDOMActionContext.createView();
          ((VComponentContainer)localObject).remove(this.mOldComponent, false);
          this.mOldComponent.removedByDiff();
          ((VComponentContainer)localObject).addChild(paramDOMActionContext);
          localViewGroup.removeView(this.mOldComponent.getRealView());
          localViewGroup.addView(paramDOMActionContext.getHostView());
          if (paramOnComponentDiffListener != null)
          {
            localObject = this.mOldComponent;
            if (((localObject instanceof VCell)) && ((paramDOMActionContext instanceof VCell))) {
              paramOnComponentDiffListener.onCellChange((VCell)localObject, (VCell)paramDOMActionContext);
            }
          }
        }
      }
    }
  }
  
  public String toString()
  {
    return "replace";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.diff.PatchReplace
 * JD-Core Version:    0.7.0.1
 */