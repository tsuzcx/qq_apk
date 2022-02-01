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
    if (this.mNewDom == null) {
      ViolaLogUtils.d("PatchReplace", "mNewDom is null");
    }
    label241:
    do
    {
      Object localObject;
      ViewGroup localViewGroup;
      do
      {
        do
        {
          int i;
          do
          {
            do
            {
              do
              {
                return;
                if (this.mOldComponent == null)
                {
                  ViolaLogUtils.d("PatchReplace", "mOldComponent is null");
                  return;
                }
                if (this.mOldComponent.mParent == null)
                {
                  ViolaLogUtils.d("PatchReplace", "mPatent is null");
                  return;
                }
                this.mNewDom.lazy(false);
                localObject = this.mOldComponent.mParent;
                paramDOMActionContext = generateComponentTree(((VComponentContainer)localObject).getInstance(), this.mNewDom, (VComponentContainer)localObject);
              } while (paramDOMActionContext == null);
              i = ((VComponentContainer)localObject).indexOf(this.mOldComponent);
              if (i == -1) {
                break label241;
              }
              paramDOMActionContext.lazy(false);
              paramDOMActionContext.createView();
              ((VComponentContainer)localObject).remove(this.mOldComponent, false);
              this.mOldComponent.removedByDiff();
              ((VComponentContainer)localObject).addChild(paramDOMActionContext, i);
              if ((!(localObject instanceof VRecyclerList)) || (this.mOldComponent.getRealView() == null)) {
                break;
              }
              localObject = (ViewGroup)this.mOldComponent.getRealView().getParent();
            } while (localObject == null);
            ((ViewGroup)localObject).removeView(this.mOldComponent.getRealView());
            ((ViewGroup)localObject).addView(paramDOMActionContext.getHostView());
          } while ((paramOnComponentDiffListener == null) || (!(this.mOldComponent instanceof VCell)) || (!(paramDOMActionContext instanceof VCell)));
          paramOnComponentDiffListener.onCellChange((VCell)this.mOldComponent, (VCell)paramDOMActionContext);
          return;
          ((VComponentContainer)localObject).addSubView(paramDOMActionContext.getRealView(), i);
          return;
        } while ((!(localObject instanceof VRecyclerList)) || (((VComponentContainer)localObject).getRealView() == null) || (this.mOldComponent.getRealView() == null));
        localViewGroup = (ViewGroup)this.mOldComponent.getRealView().getParent();
      } while (localViewGroup == null);
      paramDOMActionContext.lazy(false);
      paramDOMActionContext.createView();
      ((VComponentContainer)localObject).remove(this.mOldComponent, false);
      this.mOldComponent.removedByDiff();
      ((VComponentContainer)localObject).addChild(paramDOMActionContext);
      localViewGroup.removeView(this.mOldComponent.getRealView());
      localViewGroup.addView(paramDOMActionContext.getHostView());
    } while ((paramOnComponentDiffListener == null) || (!(this.mOldComponent instanceof VCell)) || (!(paramDOMActionContext instanceof VCell)));
    paramOnComponentDiffListener.onCellChange((VCell)this.mOldComponent, (VCell)paramDOMActionContext);
  }
  
  public String toString()
  {
    return "replace";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.diff.PatchReplace
 * JD-Core Version:    0.7.0.1
 */