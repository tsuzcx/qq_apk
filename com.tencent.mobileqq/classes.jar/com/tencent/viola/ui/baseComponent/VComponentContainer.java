package com.tencent.viola.ui.baseComponent;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.viola.annotation.VComponentField;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.list.VRecyclerView;
import com.tencent.viola.utils.ViolaUtils;
import java.util.ArrayList;

public abstract class VComponentContainer<T extends ViewGroup>
  extends VComponent<T>
{
  public ArrayList<VComponent> mChildren = new ArrayList();
  @VComponentField(nativeReturnMethod="getClipChildren", propertyName="overflow")
  private String mOverFlowValue;
  
  public VComponentContainer(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  public void addChild(VComponent paramVComponent)
  {
    addChild(paramVComponent, -1);
  }
  
  public void addChild(VComponent paramVComponent, int paramInt)
  {
    System.nanoTime();
    if ((paramVComponent == null) || (paramInt < -1)) {
      return;
    }
    int i = paramInt;
    if (paramInt >= this.mChildren.size()) {
      i = -1;
    }
    if (i == -1)
    {
      this.mChildren.add(paramVComponent);
      return;
    }
    this.mChildren.add(i, paramVComponent);
  }
  
  public void addComponentView(VComponent paramVComponent, int paramInt)
  {
    if (paramVComponent == null) {
      return;
    }
    addChild(paramVComponent, paramInt);
    addSubView(paramVComponent.mHost, paramInt);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public void addSubView(View paramView, int paramInt)
  {
    if ((paramView == null) || (getRealView() == null)) {
      return;
    }
    int i = paramInt;
    if (paramInt >= getRealView().getChildCount()) {
      i = -1;
    }
    if (paramView.getParent() != null) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    getRealView().addView(paramView, i);
  }
  
  public void afterBringToRootByAnim()
  {
    if (this.mChildren != null)
    {
      int j = this.mChildren.size();
      int i = 0;
      if (i < j)
      {
        VComponent localVComponent = (VComponent)this.mChildren.get(i);
        if (localVComponent == null) {}
        for (;;)
        {
          i += 1;
          break;
          localVComponent.afterBringToRootByAnim();
        }
      }
    }
  }
  
  public void applyEvents()
  {
    if (!isLazy())
    {
      super.applyEvents();
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        VComponent localVComponent = getChild(i);
        if (localVComponent != null) {
          localVComponent.applyEvents();
        }
        i += 1;
      }
    }
  }
  
  public void applyLayout()
  {
    if ((this.mHost instanceof VRecyclerView)) {
      super.applyLayout();
    }
    for (;;)
    {
      return;
      if (!isLazy())
      {
        super.applyLayout();
        int j = getChildCount();
        int i = 0;
        while (i < j)
        {
          VComponent localVComponent = getChild(i);
          if (localVComponent != null) {
            localVComponent.applyLayout();
          }
          i += 1;
        }
      }
    }
  }
  
  public void beforeBringToRootByAnim()
  {
    if (this.mChildren != null)
    {
      int j = this.mChildren.size();
      int i = 0;
      if (i < j)
      {
        VComponent localVComponent = (VComponent)this.mChildren.get(i);
        if (localVComponent == null) {}
        for (;;)
        {
          i += 1;
          break;
          localVComponent.beforeBringToRootByAnim();
        }
      }
    }
  }
  
  public void bindData()
  {
    System.nanoTime();
    if (!isLazy())
    {
      super.bindData();
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        VComponent localVComponent = getChild(i);
        if (localVComponent != null) {
          localVComponent.bindData();
        }
        i += 1;
      }
    }
  }
  
  public void bindDomobj(DomObject paramDomObject)
  {
    System.nanoTime();
    if (!isLazy())
    {
      super.bindDomobj(paramDomObject);
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        VComponent localVComponent = getChild(i);
        if (i < paramDomObject.getChildCount())
        {
          DomObject localDomObject = paramDomObject.getChild(i);
          if ((localVComponent != null) && (localDomObject != null)) {
            localVComponent.bindDomobj(localDomObject);
          }
        }
        i += 1;
      }
    }
  }
  
  public void createChildViewAt(int paramInt)
  {
    createChildViewAt(null, paramInt);
  }
  
  public void createChildViewAt(Context paramContext, int paramInt)
  {
    Pair localPair = rearrangeIndexAndGetChild(paramInt);
    VComponent localVComponent;
    if (localPair.first != null)
    {
      localVComponent = (VComponent)localPair.first;
      if (paramContext == null) {
        break label60;
      }
      localVComponent.createView(paramContext);
      if (!localVComponent.isInterceptAddView()) {
        break label68;
      }
      localVComponent.addSubViewOnIntercept(getRealView(), ((Integer)localPair.second).intValue());
    }
    label60:
    label68:
    while (localVComponent.isVirtualComponent())
    {
      return;
      localVComponent.createView();
      break;
    }
    addSubView(localVComponent.getHostView(), ((Integer)localPair.second).intValue());
  }
  
  public void createViewImpl()
  {
    super.createViewImpl();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      createChildViewAt(i);
      i += 1;
    }
    notifyParentWhenChildAddEnd();
  }
  
  protected void createViewImplWithContext(Context paramContext)
  {
    super.createViewImplWithContext(paramContext);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      createChildViewAt(paramContext, i);
      i += 1;
    }
    notifyParentWhenChildAddEnd();
  }
  
  public void destroy()
  {
    super.destroy();
    if (this.mChildren != null)
    {
      int j = this.mChildren.size();
      int i = 0;
      while (i < j)
      {
        ((VComponent)this.mChildren.get(i)).destroy();
        i += 1;
      }
      this.mChildren.clear();
    }
  }
  
  public void destroyComp()
  {
    super.destroyComp();
    if (this.mChildren != null)
    {
      int j = this.mChildren.size();
      int i = 0;
      while (i < j)
      {
        ((VComponent)this.mChildren.get(i)).destroyComp();
        i += 1;
      }
      this.mChildren.clear();
    }
  }
  
  @Nullable
  public VComponent getChild(int paramInt)
  {
    if ((this.mChildren == null) || (paramInt < 0) || (paramInt >= this.mChildren.size())) {
      return null;
    }
    return (VComponent)this.mChildren.get(paramInt);
  }
  
  public int getChildCount()
  {
    return this.mChildren.size();
  }
  
  public ViewGroup.LayoutParams getChildLayoutParams(VComponent paramVComponent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    paramVComponent = null;
    if (paramView != null) {
      paramVComponent = paramView.getLayoutParams();
    }
    if (paramVComponent == null)
    {
      paramView = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      ((FrameLayout.LayoutParams)paramView).setMargins(paramInt3, paramInt5, paramInt4, paramInt6);
    }
    do
    {
      return paramView;
      paramVComponent.width = paramInt1;
      paramVComponent.height = paramInt2;
      paramView = paramVComponent;
    } while (!(paramVComponent instanceof ViewGroup.MarginLayoutParams));
    ((ViewGroup.MarginLayoutParams)paramVComponent).setMargins(paramInt3, paramInt5, paramInt4, paramInt6);
    return paramVComponent;
  }
  
  public ViewGroup getRealView()
  {
    return (ViewGroup)super.getRealView();
  }
  
  public final int indexOf(VComponent paramVComponent)
  {
    return this.mChildren.indexOf(paramVComponent);
  }
  
  public void notifyParentWhenChildAddEnd() {}
  
  public void onBindData(DomObject paramDomObject)
  {
    super.onBindData(paramDomObject);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      VComponent localVComponent = getChild(i);
      if (i < paramDomObject.getChildCount())
      {
        DomObject localDomObject = paramDomObject.getChild(i);
        if ((localDomObject != null) && (localVComponent != null)) {
          localVComponent.onBindData(localDomObject);
        }
      }
      i += 1;
    }
  }
  
  public void onRecycler()
  {
    super.onRecycler();
    if (this.mChildren != null)
    {
      int j = this.mChildren.size();
      int i = 0;
      if (i < j)
      {
        VComponent localVComponent = (VComponent)this.mChildren.get(i);
        if (localVComponent == null) {}
        for (;;)
        {
          i += 1;
          break;
          localVComponent.onRecycler();
        }
      }
    }
  }
  
  protected Pair<VComponent, Integer> rearrangeIndexAndGetChild(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = getChildCount() - 1;
    }
    if (i < 0) {
      return new Pair(null, Integer.valueOf(i));
    }
    return new Pair(getChild(i), Integer.valueOf(i));
  }
  
  public void recycled()
  {
    if ((this.mChildren != null) && (!getDomObject().isFixed()) && (getDomObject().getAttributes().canRecycled()))
    {
      int j = this.mChildren.size();
      int i = 0;
      while (i < j)
      {
        ((VComponent)this.mChildren.get(i)).recycled();
        i += 1;
      }
    }
    super.recycled();
  }
  
  public void remove(VComponent paramVComponent, boolean paramBoolean)
  {
    remove(paramVComponent, paramBoolean, false);
  }
  
  public void remove(VComponent paramVComponent, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramVComponent == null) || (this.mChildren == null) || (this.mChildren.size() == 0)) {}
    do
    {
      return;
      this.mChildren.remove(paramVComponent);
      if ((getRealView() != null) && (!paramVComponent.isVirtualComponent()) && (paramVComponent.getHostView() != null))
      {
        if (paramBoolean2) {
          paramVComponent.beforeBringToRootByAnim();
        }
        getRealView().removeView(paramVComponent.getHostView());
        if (paramBoolean2) {
          paramVComponent.afterBringToRootByAnim();
        }
      }
    } while (!paramBoolean1);
    paramVComponent.destroy();
  }
  
  public void removedByDiff()
  {
    super.removedByDiff();
    if (this.mChildren != null)
    {
      int j = this.mChildren.size();
      int i = 0;
      while (i < j)
      {
        ((VComponent)this.mChildren.get(i)).removedByDiff();
        i += 1;
      }
    }
  }
  
  public void removedByJs()
  {
    super.removedByJs();
    if (this.mChildren != null)
    {
      int j = this.mChildren.size();
      int i = 0;
      while (i < j)
      {
        ((VComponent)this.mChildren.get(i)).removedByJs();
        i += 1;
      }
    }
  }
  
  public void setOverFlow(String paramString)
  {
    if (paramString.equals("visible"))
    {
      ((ViewGroup)this.mHost).setClipToPadding(false);
      ((ViewGroup)this.mHost).setClipChildren(false);
    }
    while (!paramString.equals("hidden")) {
      return;
    }
    ((ViewGroup)this.mHost).setClipToPadding(true);
    ((ViewGroup)this.mHost).setClipChildren(true);
  }
  
  public boolean setProperty(String paramString, Object paramObject)
  {
    int i;
    if (ViolaUtils.getString(paramObject, null) != null)
    {
      i = -1;
      switch (paramString.hashCode())
      {
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return super.setProperty(paramString, paramObject);
        if (paramString.equals("overflow")) {
          i = 0;
        }
        break;
      }
    }
    this.mOverFlowValue = ViolaUtils.getString(paramObject, null);
    if ((!TextUtils.isEmpty(this.mOverFlowValue)) && (this.mHost != null)) {
      setOverFlow(this.mOverFlowValue);
    }
    return true;
  }
  
  public void unregisterFromContext(boolean paramBoolean)
  {
    super.unregisterFromContext(paramBoolean);
    if (this.mChildren != null)
    {
      int j = this.mChildren.size();
      int i = 0;
      if (i < j)
      {
        VComponent localVComponent = (VComponent)this.mChildren.get(i);
        if (localVComponent == null) {}
        for (;;)
        {
          i += 1;
          break;
          localVComponent.unregisterFromContext(paramBoolean);
        }
      }
      this.mChildren.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.VComponentContainer
 * JD-Core Version:    0.7.0.1
 */