package com.tencent.viola.ui.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.viola.ui.action.MethodAbsAdd;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.dom.DomObject;
import java.util.ArrayList;

public class VLoopAbleSliderAdapter
  extends PagerAdapter
{
  private DOMActionContext context;
  private int mCellExactlyWidth = 0;
  private boolean mLoopDisable;
  private float mMinScale = -1.0F;
  private int mStartPosition = 0;
  private ArrayList<VComponent> mVComponents = new ArrayList();
  
  public VLoopAbleSliderAdapter(ArrayList<VComponent> paramArrayList, DOMActionContext paramDOMActionContext, boolean paramBoolean)
  {
    setAdapterData(paramArrayList);
    this.context = paramDOMActionContext;
    this.mLoopDisable = paramBoolean;
  }
  
  private VComponent copyComponent(VComponent paramVComponent)
  {
    if (paramVComponent == null) {
      return null;
    }
    try
    {
      paramVComponent = MethodAbsAdd.generateComponentTree(this.context, paramVComponent.mDomObj, paramVComponent.mParent);
      return paramVComponent;
    }
    catch (Exception paramVComponent)
    {
      paramVComponent.printStackTrace();
    }
    return null;
  }
  
  private void createAndBindHostView(VComponent paramVComponent, DomObject paramDomObject)
  {
    if ((paramVComponent == null) || (paramDomObject == null)) {
      return;
    }
    paramVComponent.createView();
    paramVComponent.applyLayout();
    paramVComponent.applyEvents();
    paramVComponent.bindData(paramDomObject);
  }
  
  private void initCellScale(int paramInt, View paramView, VComponent paramVComponent)
  {
    if (this.mMinScale != -1.0F)
    {
      if (paramInt != (this.mStartPosition + 1) % this.mVComponents.size()) {
        break label63;
      }
      paramView.setPivotX(0.0F);
      paramView.setPivotY(paramVComponent.getDomObject().getLayoutHeight() / 2.0F);
      paramView.setScaleX(this.mMinScale);
      paramView.setScaleY(this.mMinScale);
    }
    label63:
    while (paramInt == this.mStartPosition) {
      return;
    }
    paramView.setPivotX(this.mCellExactlyWidth);
    paramView.setPivotY(paramVComponent.getDomObject().getLayoutHeight() / 2.0F);
    paramView.setScaleX(this.mMinScale);
    paramView.setScaleY(this.mMinScale);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    if (this.mLoopDisable) {
      return this.mVComponents.size();
    }
    return 2147483647;
  }
  
  public int getInitPosition()
  {
    int i = 1073741823;
    if (this.mLoopDisable) {
      i = 0;
    }
    while (this.mVComponents.isEmpty()) {
      return i;
    }
    return 1073741823 - 1073741823 % this.mVComponents.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public int getRealPosition(int paramInt)
  {
    if (this.mLoopDisable) {
      return paramInt;
    }
    if (this.mVComponents.size() == 0) {
      return 0;
    }
    return paramInt % this.mVComponents.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    paramInt = getRealPosition(paramInt);
    if ((paramInt >= this.mVComponents.size()) || (paramInt < 0)) {
      return null;
    }
    Object localObject1 = (VComponent)this.mVComponents.get(paramInt);
    Object localObject2 = ((VComponent)this.mVComponents.get(paramInt)).getHostView();
    if ((localObject2 != null) && (((View)localObject2).getParent() == null)) {
      paramViewGroup.addView((View)localObject2);
    }
    for (;;)
    {
      initCellScale(paramInt, (View)localObject2, (VComponent)localObject1);
      return localObject2;
      localObject2 = ((VComponent)localObject1).mDomObj;
      VComponent localVComponent = copyComponent((VComponent)localObject1);
      createAndBindHostView(localVComponent, (DomObject)localObject2);
      this.mVComponents.set(paramInt, localVComponent);
      View localView = localVComponent.getHostView();
      localObject2 = localView;
      localObject1 = localVComponent;
      if (localView != null)
      {
        localObject2 = localView;
        localObject1 = localVComponent;
        if (localView.getParent() == null)
        {
          paramViewGroup.addView(localView);
          localObject2 = localView;
          localObject1 = localVComponent;
        }
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public boolean loopDisable()
  {
    return this.mLoopDisable;
  }
  
  public void setAdapterData(ArrayList<VComponent> paramArrayList)
  {
    if (paramArrayList != null) {
      this.mVComponents = paramArrayList;
    }
  }
  
  public void setCellExactlyWidth(int paramInt)
  {
    this.mCellExactlyWidth = paramInt;
  }
  
  public void setMinScale(float paramFloat)
  {
    this.mMinScale = paramFloat;
  }
  
  public void setStartPosition(int paramInt)
  {
    this.mStartPosition = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.adapter.VLoopAbleSliderAdapter
 * JD-Core Version:    0.7.0.1
 */