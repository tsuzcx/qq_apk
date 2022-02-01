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
    if (paramVComponent != null)
    {
      if (paramInt < -1) {
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
    if (paramView != null)
    {
      if (getRealView() == null) {
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
  }
  
  public void afterBringToRootByAnim()
  {
    Object localObject = this.mChildren;
    if (localObject != null)
    {
      int j = ((ArrayList)localObject).size();
      int i = 0;
      while (i < j)
      {
        localObject = (VComponent)this.mChildren.get(i);
        if (localObject != null) {
          ((VComponent)localObject).afterBringToRootByAnim();
        }
        i += 1;
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
    if ((this.mHost instanceof VRecyclerView))
    {
      super.applyLayout();
      return;
    }
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
  
  public void beforeBringToRootByAnim()
  {
    Object localObject = this.mChildren;
    if (localObject != null)
    {
      int j = ((ArrayList)localObject).size();
      int i = 0;
      while (i < j)
      {
        localObject = (VComponent)this.mChildren.get(i);
        if (localObject != null) {
          ((VComponent)localObject).beforeBringToRootByAnim();
        }
        i += 1;
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
    if (localPair.first != null)
    {
      VComponent localVComponent = (VComponent)localPair.first;
      if (paramContext != null) {
        localVComponent.createView(paramContext);
      } else {
        localVComponent.createView();
      }
      if (localVComponent.isInterceptAddView())
      {
        localVComponent.addSubViewOnIntercept(getRealView(), ((Integer)localPair.second).intValue());
        return;
      }
      if (!localVComponent.isVirtualComponent()) {
        addSubView(localVComponent.getHostView(), ((Integer)localPair.second).intValue());
      }
    }
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
    ArrayList localArrayList = this.mChildren;
    if (localArrayList != null)
    {
      int j = localArrayList.size();
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
    ArrayList localArrayList = this.mChildren;
    if (localArrayList != null)
    {
      int j = localArrayList.size();
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
    ArrayList localArrayList = this.mChildren;
    if ((localArrayList != null) && (paramInt >= 0) && (paramInt < localArrayList.size())) {
      return (VComponent)this.mChildren.get(paramInt);
    }
    return null;
  }
  
  public int getChildCount()
  {
    return this.mChildren.size();
  }
  
  public ViewGroup.LayoutParams getChildLayoutParams(VComponent paramVComponent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramView != null) {
      paramVComponent = paramView.getLayoutParams();
    } else {
      paramVComponent = null;
    }
    if (paramVComponent == null)
    {
      paramVComponent = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      ((FrameLayout.LayoutParams)paramVComponent).setMargins(paramInt3, paramInt5, paramInt4, paramInt6);
      return paramVComponent;
    }
    paramVComponent.width = paramInt1;
    paramVComponent.height = paramInt2;
    if ((paramVComponent instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)paramVComponent).setMargins(paramInt3, paramInt5, paramInt4, paramInt6);
    }
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
    Object localObject = this.mChildren;
    if (localObject != null)
    {
      int j = ((ArrayList)localObject).size();
      int i = 0;
      while (i < j)
      {
        localObject = (VComponent)this.mChildren.get(i);
        if (localObject != null) {
          ((VComponent)localObject).onRecycler();
        }
        i += 1;
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
    if (paramVComponent != null)
    {
      ArrayList localArrayList = this.mChildren;
      if (localArrayList != null)
      {
        if (localArrayList.size() == 0) {
          return;
        }
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
        if (paramBoolean1) {
          paramVComponent.destroy();
        }
      }
    }
  }
  
  public void removedByDiff()
  {
    super.removedByDiff();
    ArrayList localArrayList = this.mChildren;
    if (localArrayList != null)
    {
      int j = localArrayList.size();
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
    ArrayList localArrayList = this.mChildren;
    if (localArrayList != null)
    {
      int j = localArrayList.size();
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
      return;
    }
    if (paramString.equals("hidden"))
    {
      ((ViewGroup)this.mHost).setClipToPadding(true);
      ((ViewGroup)this.mHost).setClipChildren(true);
    }
  }
  
  public boolean setProperty(String paramString, Object paramObject)
  {
    if (ViolaUtils.getString(paramObject, null) != null)
    {
      int i = -1;
      if ((paramString.hashCode() == 529642498) && (paramString.equals("overflow"))) {
        i = 0;
      }
      if (i == 0)
      {
        this.mOverFlowValue = ViolaUtils.getString(paramObject, null);
        if ((!TextUtils.isEmpty(this.mOverFlowValue)) && (this.mHost != null)) {
          setOverFlow(this.mOverFlowValue);
        }
        return true;
      }
    }
    return super.setProperty(paramString, paramObject);
  }
  
  public void unregisterFromContext(boolean paramBoolean)
  {
    super.unregisterFromContext(paramBoolean);
    Object localObject = this.mChildren;
    if (localObject != null)
    {
      int j = ((ArrayList)localObject).size();
      int i = 0;
      while (i < j)
      {
        localObject = (VComponent)this.mChildren.get(i);
        if (localObject != null) {
          ((VComponent)localObject).unregisterFromContext(paramBoolean);
        }
        i += 1;
      }
      this.mChildren.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.VComponentContainer
 * JD-Core Version:    0.7.0.1
 */