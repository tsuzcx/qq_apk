package com.tencent.mobileqq.emosm.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;

class DragSortListView$AdapterWrapper
  extends BaseAdapter
{
  private ListAdapter jdField_a_of_type_AndroidWidgetListAdapter;
  
  public DragSortListView$AdapterWrapper(DragSortListView paramDragSortListView, ListAdapter paramListAdapter)
  {
    this.jdField_a_of_type_AndroidWidgetListAdapter = paramListAdapter;
    this.jdField_a_of_type_AndroidWidgetListAdapter.registerDataSetObserver(new DragSortListView.AdapterWrapper.1(this, paramDragSortListView));
  }
  
  public boolean areAllItemsEnabled()
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter.areAllItemsEnabled();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter.getCount();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter.getItemViewType(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramView != null)
    {
      localObject2 = (DragSortItemView)paramView;
      View localView1 = ((DragSortItemView)localObject2).getChildAt(0);
      View localView2 = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(paramInt, localView1, this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
      localObject1 = localObject2;
      if (localView2 != localView1)
      {
        if (localView1 != null) {
          ((DragSortItemView)localObject2).removeViewAt(0);
        }
        ((DragSortItemView)localObject2).addView(localView2);
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject2 = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(paramInt, null, this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
      if ((localObject2 instanceof Checkable)) {
        localObject1 = new DragSortItemViewCheckable(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getContext());
      } else {
        localObject1 = new DragSortItemView(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getContext());
      }
      ((DragSortItemView)localObject1).setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      ((DragSortItemView)localObject1).addView((View)localObject2);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView;
    DragSortListView.a((DragSortListView)localObject2, ((DragSortListView)localObject2).getHeaderViewsCount() + paramInt, (View)localObject1, true);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public int getViewTypeCount()
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter.getViewTypeCount();
  }
  
  public boolean hasStableIds()
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter.hasStableIds();
  }
  
  public boolean isEmpty()
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter.isEmpty();
  }
  
  public boolean isEnabled(int paramInt)
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter.isEnabled(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.AdapterWrapper
 * JD-Core Version:    0.7.0.1
 */