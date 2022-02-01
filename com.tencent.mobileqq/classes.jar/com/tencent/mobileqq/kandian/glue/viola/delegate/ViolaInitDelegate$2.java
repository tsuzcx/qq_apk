package com.tencent.mobileqq.kandian.glue.viola.delegate;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;

class ViolaInitDelegate$2
  extends PagerAdapter
{
  ViolaInitDelegate$2(ViolaInitDelegate paramViolaInitDelegate) {}
  
  public int getCount()
  {
    return ViolaInitDelegate.a(this.a).size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = (View)ViolaInitDelegate.a(this.a).get(paramInt);
    if (localView.getParent() == null) {
      paramViewGroup.addView(localView);
    }
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.delegate.ViolaInitDelegate.2
 * JD-Core Version:    0.7.0.1
 */