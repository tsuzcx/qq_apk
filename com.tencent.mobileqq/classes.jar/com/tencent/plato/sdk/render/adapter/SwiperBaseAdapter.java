package com.tencent.plato.sdk.render.adapter;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.plato.core.utils.PLog;
import java.util.ArrayList;
import java.util.List;

public class SwiperBaseAdapter
  extends PagerAdapter
{
  private List<View> showViews = new ArrayList();
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((this.showViews != null) && (this.showViews.size() > 3)) {
      paramViewGroup.removeView((View)paramObject);
    }
  }
  
  public int getCount()
  {
    return 2147483647;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.showViews != null)
    {
      View localView;
      if (this.showViews.size() > 3)
      {
        paramInt %= this.showViews.size();
        localView = (View)this.showViews.get(paramInt);
        paramViewGroup.addView((View)this.showViews.get(paramInt));
        return localView;
      }
      if (this.showViews.size() == 2) {
        if (paramInt % this.showViews.size() == 1) {
          paramInt = 1;
        }
      }
      for (;;)
      {
        localView = (View)this.showViews.get(paramInt);
        try
        {
          if (localView.getParent() != null) {
            break;
          }
          paramViewGroup.addView(localView);
          return localView;
        }
        catch (Exception paramViewGroup)
        {
          PLog.e(" instantiateItem: ", Log.getStackTraceString(paramViewGroup));
          return localView;
        }
        paramInt = 0;
        continue;
        paramInt %= this.showViews.size();
      }
      ((ViewGroup)localView.getParent()).removeView(localView);
      paramViewGroup.addView(localView);
      return localView;
    }
    return null;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setViews(List<View> paramList)
  {
    if (this.showViews != null) {
      this.showViews.clear();
    }
    this.showViews = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.render.adapter.SwiperBaseAdapter
 * JD-Core Version:    0.7.0.1
 */