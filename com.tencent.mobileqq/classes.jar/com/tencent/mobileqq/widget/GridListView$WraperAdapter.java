package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;

public class GridListView$WraperAdapter
  extends BaseAdapter
{
  public GridListView$WraperAdapter(GridListView paramGridListView) {}
  
  private LinearLayout a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new LinearLayout(this.a.getContext());
    paramViewGroup.setOrientation(0);
    paramViewGroup.setClickable(false);
    paramViewGroup.setLongClickable(false);
    paramViewGroup.setTag(new GridListView.GridGroupHolder(null));
    return paramViewGroup;
  }
  
  public int getCount()
  {
    if (this.a.d == 0)
    {
      if (this.a.l != null) {
        return 1;
      }
      return 0;
    }
    return this.a.d;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.a.d == 0) {
      return 0;
    }
    if (this.a.b == 0) {
      return this.a.a.getItemViewType(paramInt) + 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    if (this.a.d == 0)
    {
      this.a.l.setLayoutParams(new AbsListView.LayoutParams(this.a.getWidth(), this.a.getHeight()));
      localObject1 = this.a.l;
      localObject2 = localObject1;
    }
    else
    {
      if (this.a.b == 1)
      {
        paramView = (LinearLayout)paramView;
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = a(paramViewGroup);
        }
        ((LinearLayout)localObject1).removeAllViews();
        int j = this.a.g - this.a.c * paramInt;
        i = j;
        if (j >= this.a.c) {
          i = this.a.c;
        }
        GridListView.GridGroupHolder localGridGroupHolder = (GridListView.GridGroupHolder)((LinearLayout)localObject1).getTag();
        int k = this.a.c;
        j = 0;
        for (;;)
        {
          paramView = (View)localObject1;
          if (j >= i) {
            break;
          }
          localObject2 = localGridGroupHolder.a[j];
          paramView = this.a.a;
          int m = k * paramInt + j;
          int n = paramView.c(m);
          paramView = (View)localObject2;
          if (localObject2 != null)
          {
            paramView = (View)localObject2;
            if (((Integer)((View)localObject2).getTag(2131427416)).intValue() != n) {
              paramView = null;
            }
          }
          View localView = this.a.a.getView(m, paramView, (ViewGroup)localObject1);
          localView.setTag(2131427416, Integer.valueOf(n));
          localGridGroupHolder.a[j] = localView;
          localObject2 = (LinearLayout.LayoutParams)localView.getLayoutParams();
          paramView = (View)localObject2;
          if (localObject2 == null)
          {
            paramView = new LinearLayout.LayoutParams(this.a.j, this.a.k);
            localView.setLayoutParams(paramView);
          }
          paramView.width = this.a.j;
          paramView.height = this.a.k;
          paramView.leftMargin = this.a.h;
          paramView.topMargin = this.a.i;
          ((LinearLayout)localObject1).addView(localView);
          if ((this.a.e != null) && (this.a.a.isEnabled(m)))
          {
            localView.setTag(2131427368, Integer.valueOf(m));
            localView.setOnClickListener(this.a.f);
          }
          else
          {
            localView.setOnClickListener(null);
          }
          j += 1;
        }
      }
      int i = this.a.a.b(paramInt) + 2;
      localObject1 = paramView;
      if (paramView != null)
      {
        localObject1 = paramView;
        if (((Integer)paramView.getTag(2131427416)).intValue() != i) {
          localObject1 = null;
        }
      }
      paramView = this.a.a.getView(paramInt, (View)localObject1, paramViewGroup);
      paramView.setTag(2131427416, Integer.valueOf(i));
      if ((this.a.e != null) && (this.a.a.isEnabled(paramInt)))
      {
        paramView.setTag(2131427368, Integer.valueOf(paramInt));
        paramView.setOnClickListener(this.a.f);
      }
      else
      {
        paramView.setOnClickListener(null);
      }
      localObject1 = paramView;
      localObject2 = paramView;
      paramView = (View)localObject1;
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject2;
  }
  
  public int getViewTypeCount()
  {
    return this.a.n + 2;
  }
  
  public boolean isEnabled(int paramInt)
  {
    if ((this.a.d != 0) && (this.a.b != 1)) {
      return super.isEnabled(paramInt);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GridListView.WraperAdapter
 * JD-Core Version:    0.7.0.1
 */