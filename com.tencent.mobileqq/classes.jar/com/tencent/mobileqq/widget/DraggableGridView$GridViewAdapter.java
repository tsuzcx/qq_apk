package com.tencent.mobileqq.widget;

import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DraggableGridView$GridViewAdapter
  extends BaseAdapter
{
  private int b;
  
  public DraggableGridView$GridViewAdapter(DraggableGridView paramDraggableGridView, int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return DraggableGridView.a(this.a).b(this.b);
  }
  
  public Object getItem(int paramInt)
  {
    return DraggableGridView.a(this.a).c(this.b, paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = DraggableGridView.a(this.a).a(LayoutInflater.from(this.a.getContext()), this.b, paramInt, paramViewGroup);
    }
    DraggableGridView.a(this.a).a(localView, this.b, paramInt);
    paramView = new DraggableGridView.GridItemAction(this.a, this.b, paramInt);
    localView.setOnClickListener(paramView);
    localView.setOnLongClickListener(paramView);
    if ((!DraggableGridView.d(this.a)) && ((DraggableGridView.e(this.a).y != this.b) || (DraggableGridView.e(this.a).x != paramInt) || (!DraggableGridView.f(this.a)))) {
      localView.setVisibility(0);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DraggableGridView.GridViewAdapter
 * JD-Core Version:    0.7.0.1
 */