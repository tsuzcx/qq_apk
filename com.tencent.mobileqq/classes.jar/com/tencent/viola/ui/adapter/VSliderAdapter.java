package com.tencent.viola.ui.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.component.VPage;
import com.tencent.viola.ui.component.VPage.PAGEVIEWSTATE;
import com.tencent.viola.ui.view.VFrameLayout;
import java.util.ArrayList;

public class VSliderAdapter
  extends PagerAdapter
{
  private boolean isFirstComponentAppear = false;
  public ArrayList<VComponent> mVComponents = new ArrayList();
  
  public VSliderAdapter(ArrayList<VComponent> paramArrayList)
  {
    setAdapterData(paramArrayList);
  }
  
  public void changeItemByPosition(int paramInt1, int paramInt2)
  {
    VComponent localVComponent1 = (VComponent)this.mVComponents.get(paramInt1);
    VComponent localVComponent2 = (VComponent)this.mVComponents.get(paramInt2);
    this.mVComponents.remove(localVComponent1);
    this.mVComponents.remove(localVComponent2);
    this.mVComponents.add(paramInt1, localVComponent2);
    this.mVComponents.add(paramInt2, localVComponent1);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return this.mVComponents.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    if ((paramObject instanceof VFrameLayout))
    {
      paramObject = ((VFrameLayout)paramObject).getComponent();
      if (this.mVComponents.contains(paramObject))
      {
        paramObject.getRef();
        this.mVComponents.indexOf(paramObject);
        return this.mVComponents.indexOf(paramObject);
      }
    }
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = ((VComponent)this.mVComponents.get(paramInt)).getHostView();
    if (localView.getParent() == null) {
      paramViewGroup.addView(localView);
    }
    if ((!this.isFirstComponentAppear) && ((this.mVComponents.get(paramInt) instanceof VPage)))
    {
      paramViewGroup = (VPage)this.mVComponents.get(paramInt);
      if (paramViewGroup.getCurrentPageState() != VPage.PAGEVIEWSTATE.DIDAPPEAR)
      {
        paramViewGroup.setCurrentPageState(VPage.PAGEVIEWSTATE.DIDAPPEAR);
        this.isFirstComponentAppear = true;
      }
    }
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setAdapterData(ArrayList<VComponent> paramArrayList)
  {
    if ((paramArrayList != null) && (this.mVComponents != null))
    {
      this.mVComponents.clear();
      int i = 0;
      while (i < paramArrayList.size())
      {
        this.mVComponents.add(paramArrayList.get(i));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.adapter.VSliderAdapter
 * JD-Core Version:    0.7.0.1
 */