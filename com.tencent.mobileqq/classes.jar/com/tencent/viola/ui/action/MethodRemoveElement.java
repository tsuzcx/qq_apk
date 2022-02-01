package com.tencent.viola.ui.action;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.component.VRecyclerList;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.context.RenderActionContext;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObject.Consumer;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.ArrayList;

public class MethodRemoveElement
  implements DOMAction, RenderAction
{
  public static final String TAG = "MethodRemoveElement";
  private DomObject mDomObject;
  private int mIndex;
  private String mParentRef;
  private final String mRef;
  private String mRootRef;
  
  public MethodRemoveElement(String paramString)
  {
    this.mRef = paramString;
  }
  
  private void clearRegistryForComponent(RenderActionContext paramRenderActionContext, VComponent paramVComponent)
  {
    VComponent localVComponent = paramRenderActionContext.unregisterComponent(paramVComponent.getDomObject().getRef());
    if (localVComponent != null) {
      localVComponent.removeAllEvent();
    }
    if ((paramVComponent instanceof VComponentContainer))
    {
      paramVComponent = (VComponentContainer)paramVComponent;
      int i = paramVComponent.getChildCount() - 1;
      while (i >= 0)
      {
        clearRegistryForComponent(paramRenderActionContext, paramVComponent.getChild(i));
        i -= 1;
      }
    }
  }
  
  public void executeDom(DOMActionContext paramDOMActionContext)
  {
    if (paramDOMActionContext.isDestory()) {}
    DomObject localDomObject1;
    DomObject localDomObject2;
    do
    {
      do
      {
        return;
        localDomObject1 = paramDOMActionContext.getDomByRef(this.mRef);
      } while (localDomObject1 == null);
      localDomObject2 = localDomObject1.getDomParent();
    } while (localDomObject2 == null);
    this.mParentRef = localDomObject2.getRef();
    localDomObject1.traverseTree(new DomObject.Consumer[] { paramDOMActionContext.getRemoveElementConsumer() });
    this.mIndex = localDomObject2.remove(localDomObject1);
    paramDOMActionContext.unregisterDOMObject(this.mRef);
    this.mRootRef = paramDOMActionContext.getRootRef();
    this.mDomObject = localDomObject1;
    paramDOMActionContext.postRenderTask(this);
  }
  
  public void executeRender(RenderActionContext paramRenderActionContext)
  {
    VComponent localVComponent = paramRenderActionContext.getComponent(this.mRef);
    VComponentContainer localVComponentContainer = (VComponentContainer)paramRenderActionContext.getComponent(this.mParentRef);
    if (TextUtils.isEmpty(this.mRootRef)) {
      ViolaLogUtils.d("MethodRemoveElement", "mRootRef is null");
    }
    do
    {
      return;
      if (localVComponentContainer == null)
      {
        ViolaLogUtils.d("MethodRemoveElement", "parent is null ");
        return;
      }
      if (localVComponentContainer.isDestroyed())
      {
        ViolaLogUtils.d("MethodRemoveElement", "parent is destroy ");
        return;
      }
      localVComponentContainer.notifyChange();
      if (((localVComponentContainer instanceof VRecyclerList)) && (this.mDomObject != null))
      {
        ViolaLogUtils.d("VRecyclerViewAdapter", "remove executeRender index :" + this.mIndex);
        ((VRecyclerList)localVComponentContainer).notifyItemRemove(this.mDomObject);
        return;
      }
      if (((localVComponent instanceof VRecyclerList)) && (localVComponentContainer.mChildren != null) && (localVComponentContainer.getRealView() != null) && (localVComponent.getRealView() != null))
      {
        localVComponentContainer.mChildren.remove(localVComponent);
        localVComponentContainer.getRealView().removeView(((VRecyclerList)localVComponent).getRealParentView());
        localVComponentContainer.getRealView().removeView(localVComponent.getRealView());
        return;
      }
      if (localVComponent == null)
      {
        ViolaLogUtils.d("MethodRemoveElement", "component is null");
        return;
      }
      clearRegistryForComponent(paramRenderActionContext, localVComponent);
      localVComponent.removedByJs();
      localVComponentContainer.remove(localVComponent, true);
      localVComponent.notifyChange();
      localVComponent.notifyWhenChange("remove", this.mDomObject);
      paramRenderActionContext = (VComponentContainer)paramRenderActionContext.getComponent(this.mRootRef);
    } while ((paramRenderActionContext == null) || (paramRenderActionContext.isDestroyed()));
    paramRenderActionContext.applyLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.action.MethodRemoveElement
 * JD-Core Version:    0.7.0.1
 */