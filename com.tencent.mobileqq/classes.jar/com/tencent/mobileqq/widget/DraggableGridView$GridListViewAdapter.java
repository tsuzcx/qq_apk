package com.tencent.mobileqq.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DraggableGridView$GridListViewAdapter
  extends BaseAdapter
{
  DraggableGridView$GridListViewAdapter(DraggableGridView paramDraggableGridView) {}
  
  public int getCount()
  {
    if (DraggableGridView.a(this.a) != null) {
      return DraggableGridView.a(this.a).d() * 2;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((DraggableGridView.a(this.a) != null) && (paramInt % 2 == 0)) {
      return DraggableGridView.a(this.a).a(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt % 2 == 0) {
      return DraggableGridView.a(this.a).c(paramInt / 2) + 1;
    }
    return DraggableGridView.c();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (getItemViewType(paramInt) == DraggableGridView.c())
    {
      if (paramView == null)
      {
        localObject = (MeasureGridView)LayoutInflater.from(this.a.getContext()).inflate(2131626663, paramViewGroup, false);
        ((MeasureGridView)localObject).setClickable(false);
        ((MeasureGridView)localObject).setNumColumns(DraggableGridView.c(this.a));
        ((MeasureGridView)localObject).setAdapter(new DraggableGridView.GridViewAdapter(this.a, paramInt / 2));
        paramView = (View)localObject;
      }
      else
      {
        localObject = (MeasureGridView)paramView;
        ((DraggableGridView.GridViewAdapter)((MeasureGridView)localObject).getAdapter()).a(paramInt / 2);
      }
      ((MeasureGridView)localObject).setTag(Integer.valueOf(paramInt / 2));
    }
    else
    {
      localObject = paramView;
      if (paramView == null) {
        localObject = DraggableGridView.a(this.a).a(LayoutInflater.from(this.a.getContext()), paramInt / 2, paramViewGroup);
      }
      paramView = (View)localObject;
      if (DraggableGridView.a(this.a) != null)
      {
        DraggableGridView.a(this.a).a((View)localObject, paramInt / 2);
        paramView = (View)localObject;
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return DraggableGridView.a(this.a).e() + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DraggableGridView.GridListViewAdapter
 * JD-Core Version:    0.7.0.1
 */