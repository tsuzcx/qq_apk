package com.tencent.mobileqq.richstatus;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

class ActionListActivity$ViewPagerAdapter
  extends PagerAdapter
{
  private ArrayList<GridView> b = new ArrayList();
  
  private ActionListActivity$ViewPagerAdapter(ActionListActivity paramActionListActivity) {}
  
  public void a()
  {
    this.b.clear();
    try
    {
      Iterator localIterator = this.a.d.iterator();
      while (localIterator.hasNext())
      {
        StateTag localStateTag = (StateTag)localIterator.next();
        GridView localGridView = new GridView(this.a.getApplicationContext());
        localGridView.setNumColumns(3);
        localGridView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        localGridView.setSelector(new ColorDrawable(0));
        localGridView.setScrollingCacheEnabled(false);
        localGridView.setAdapter(new ActionListActivity.GridAdapter(this.a, localStateTag.b));
        this.b.add(localGridView);
        continue;
        label118:
        System.gc();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label118;
    }
    super.notifyDataSetChanged();
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.b.get(paramInt));
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    GridView localGridView = (GridView)this.b.get(paramInt);
    paramViewGroup.addView(localGridView);
    return localGridView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.ActionListActivity.ViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */