package com.tencent.viola.ui.action;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.component.VRecyclerList;
import com.tencent.viola.ui.component.VSlider;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.context.RenderActionContext;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObjectCell;
import com.tencent.viola.ui.view.VScrollView;
import com.tencent.viola.ui.view.list.VRecyclerView;
import com.tencent.viola.ui.view.refresh.VRefreshViewGroup;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.util.ArrayList;
import org.json.JSONObject;

public class MethodAddElement
  extends MethodAbsAdd
{
  public static String TAG = "MethodAddElement";
  private DomObject mAddDom;
  private int mAddIndex;
  private String mCellInsertParentRef;
  private JSONObject mData;
  private boolean mIsCellInsert;
  private String mParentRef;
  private String mRef;
  
  public MethodAddElement(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    this.mData = paramJSONObject;
    this.mParentRef = paramString;
    this.mAddIndex = paramInt;
  }
  
  private void dealAddView(VComponentContainer paramVComponentContainer, VComponent paramVComponent)
  {
    if ((paramVComponentContainer.getRealView() instanceof ScrollView))
    {
      if (paramVComponentContainer.getRealView().getChildAt(0) == null)
      {
        FrameLayout localFrameLayout = new FrameLayout(paramVComponentContainer.getRealView().getContext());
        localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        localFrameLayout.addView(paramVComponent.getRealView());
        paramVComponentContainer.getRealView().addView(localFrameLayout);
        return;
      }
      paramVComponentContainer = (FrameLayout)paramVComponentContainer.getRealView().getChildAt(0);
      if ((paramVComponent.getRealView() != null) && (paramVComponent.getRealView().getParent() != null)) {
        ((ViewGroup)paramVComponent.getRealView().getParent()).removeView(paramVComponent.getRealView());
      }
      paramVComponentContainer.addView(paramVComponent.getRealView());
      return;
    }
    if ((paramVComponentContainer instanceof VSlider)) {
      return;
    }
    if ((paramVComponent.getRealView() != null) && (paramVComponent.getRealView().getParent() != null)) {
      ((ViewGroup)paramVComponent.getRealView().getParent()).removeView(paramVComponent.getRealView());
    }
    if (paramVComponentContainer.getRealView() != null)
    {
      int j = this.mAddIndex;
      int i = j;
      if (j < -1) {
        i = -1;
      }
      j = i;
      if (i >= paramVComponentContainer.getRealView().getChildCount()) {
        j = -1;
      }
      paramVComponentContainer.getRealView().addView(paramVComponent.getRealView(), j);
    }
  }
  
  private void tryHidePreCreateBody(ViolaInstance paramViolaInstance, DomObject paramDomObject)
  {
    if (paramViolaInstance != null)
    {
      if (paramDomObject == null) {
        return;
      }
      if (ViolaUtils.getBoolean(paramDomObject.getAttributes().get("hidePreCreateBodyWhenMounted"))) {
        paramViolaInstance.hidePreCreateBody();
      }
    }
  }
  
  protected void appendDomToTree(DOMActionContext paramDOMActionContext, DomObject paramDomObject)
  {
    this.mRef = paramDomObject.getRef();
    paramDOMActionContext = paramDOMActionContext.getDomByRef(this.mParentRef);
    if (paramDOMActionContext == null) {
      return;
    }
    paramDOMActionContext.add(paramDomObject, this.mAddIndex);
  }
  
  protected VComponent createComponent(DOMActionContext paramDOMActionContext, DomObject paramDomObject)
  {
    VComponent localVComponent = paramDOMActionContext.getComponent(this.mParentRef);
    Object localObject;
    if (localVComponent != null)
    {
      localObject = localVComponent;
      if ((localVComponent instanceof VComponentContainer)) {}
    }
    else
    {
      localObject = paramDOMActionContext.getDomByRef(this.mParentRef);
      if (!(localObject instanceof DomObjectCell)) {
        break label140;
      }
      this.mIsCellInsert = true;
      this.mCellInsertParentRef = ((DomObject)localObject).getDomParent().getRef();
      localVComponent = generateComponentTree(paramDOMActionContext, (DomObject)localObject, (VComponentContainer)paramDOMActionContext.getComponent(this.mCellInsertParentRef));
      localObject = localVComponent;
      if (localVComponent != null)
      {
        localObject = localVComponent;
        if (localVComponent.getHostView() == null)
        {
          localVComponent.lazy(false);
          localVComponent.createView();
          localVComponent.applyLayout();
          localVComponent.applyEvents();
          localVComponent.bindData();
          localObject = localVComponent;
        }
      }
    }
    return generateComponentTree(paramDOMActionContext, paramDomObject, (VComponentContainer)localObject);
    label140:
    return null;
  }
  
  public void executeDom(DOMActionContext paramDOMActionContext)
  {
    this.mAddDom = addDomInternal(paramDOMActionContext, this.mData);
    if (!isAddVInstance()) {
      paramDOMActionContext.postRenderTask(this);
    }
    this.mRootRef = paramDOMActionContext.getRootRef();
  }
  
  public void executeRender(RenderActionContext paramRenderActionContext)
  {
    if (paramRenderActionContext == null) {
      return;
    }
    ViolaInstance localViolaInstance = paramRenderActionContext.getInstance();
    if (localViolaInstance != null)
    {
      if (TextUtils.isEmpty(this.mRootRef)) {
        return;
      }
      if (!(paramRenderActionContext.getComponent(this.mParentRef) instanceof VComponentContainer)) {
        return;
      }
      if (!(paramRenderActionContext.getComponent(this.mRootRef) instanceof VComponentContainer)) {
        return;
      }
      VComponentContainer localVComponentContainer = (VComponentContainer)paramRenderActionContext.getComponent(this.mParentRef);
      VComponent localVComponent = paramRenderActionContext.getComponent(this.mRef);
      paramRenderActionContext = (VComponentContainer)paramRenderActionContext.getComponent(this.mRootRef);
      if ((paramRenderActionContext != null) && (!paramRenderActionContext.isDestroyed()))
      {
        if ((localVComponentContainer != null) && (!localVComponentContainer.isDestroyed()))
        {
          Object localObject;
          if ((localVComponentContainer instanceof VRecyclerList))
          {
            localObject = this.mAddDom;
            if (localObject != null)
            {
              ((VRecyclerList)localVComponentContainer).notifyItemInsert((DomObject)localObject, this.mAddIndex);
              return;
            }
          }
          localVComponentContainer.notifyChange(3);
          if (localVComponent == null)
          {
            ViolaLogUtils.d(TAG, "component is null");
            return;
          }
          if ((localVComponentContainer.mChildren != null) && (localVComponentContainer.mChildren.contains(localVComponent)))
          {
            ViolaLogUtils.d(TAG, "repeat component");
            return;
          }
          localVComponentContainer.addChild(localVComponent, this.mAddIndex);
          if ((localViolaInstance.getContext() == null) && (!localViolaInstance.isGlobalMode())) {
            return;
          }
          localVComponent.createView();
          if (!(localVComponentContainer.getRealView() instanceof AdapterView)) {
            if ((localVComponent.getRealView() instanceof VScrollView))
            {
              if (localVComponent.getRealView().getParent() != null)
              {
                localObject = (View)localVComponent.getRealView().getParent();
                localVComponentContainer.getRealView().addView((View)localObject);
              }
              else
              {
                dealAddView(localVComponentContainer, localVComponent);
              }
            }
            else if ((localVComponent.getHostView() instanceof VRecyclerView))
            {
              localObject = (VRecyclerList)localVComponent;
              if (((VRecyclerList)localObject).isInterceptAddView())
              {
                ((VRecyclerList)localObject).addSubViewOnIntercept(localVComponentContainer.getRealView(), -1);
              }
              else
              {
                ((VRecyclerList)localObject).getRealParentView().removeView(localVComponent.getHostView());
                localVComponentContainer.getRealView().addView(localVComponent.getHostView());
              }
            }
            else
            {
              dealAddView(localVComponentContainer, localVComponent);
            }
          }
          paramRenderActionContext.applyLayout();
          localVComponent.applyLayout();
          localVComponent.applyEvents();
          localVComponent.bindData();
          localVComponent.notifyChange(3);
          localVComponent.notifyWhenChange("add", this.mAddDom);
          tryHidePreCreateBody(localViolaInstance, this.mAddDom);
          return;
        }
        ViolaLogUtils.d(TAG, "parent  is destroy ");
        return;
      }
      ViolaLogUtils.d(TAG, "rootCmp  is destroy ");
    }
  }
  
  public String getRef()
  {
    return this.mRef;
  }
  
  public boolean isAddVInstance()
  {
    JSONObject localJSONObject = this.mData;
    if (localJSONObject == null) {
      return false;
    }
    return "instance".equals(localJSONObject.optString("type"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.action.MethodAddElement
 * JD-Core Version:    0.7.0.1
 */