package com.tencent.mobileqq.widget;

import alcb;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
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
    paramViewGroup.setTag(new alcb(null));
    return paramViewGroup;
  }
  
  public int getCount()
  {
    if (this.a.c == 0)
    {
      if (this.a.jdField_a_of_type_AndroidViewView != null) {
        return 1;
      }
      return 0;
    }
    return this.a.c;
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
    if (this.a.c == 0) {
      return 0;
    }
    if (this.a.jdField_a_of_type_Int == 0) {
      return this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.getItemViewType(paramInt) + 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.a.c == 0)
    {
      this.a.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(this.a.getWidth(), this.a.getHeight()));
      paramViewGroup = this.a.jdField_a_of_type_AndroidViewView;
      return paramViewGroup;
    }
    Object localObject;
    int i;
    if (this.a.jdField_a_of_type_Int == 1)
    {
      localObject = (LinearLayout)paramView;
      paramView = (View)localObject;
      if (localObject == null) {
        paramView = a(paramViewGroup);
      }
      paramView.removeAllViews();
      i = this.a.d - this.a.b * paramInt;
      if (i < this.a.b) {
        break label535;
      }
      i = this.a.b;
    }
    label535:
    for (;;)
    {
      alcb localalcb = (alcb)paramView.getTag();
      int j = paramInt * this.a.b;
      paramInt = 0;
      paramViewGroup = paramView;
      if (paramInt >= i) {
        break;
      }
      paramViewGroup = localalcb.a[paramInt];
      int k = this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.b(j + paramInt);
      if ((paramViewGroup != null) && (((Integer)paramViewGroup.getTag(2131362760)).intValue() != k)) {
        paramViewGroup = null;
      }
      for (;;)
      {
        View localView = this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.getView(j + paramInt, paramViewGroup, paramView);
        localView.setTag(2131362760, Integer.valueOf(k));
        localalcb.a[paramInt] = localView;
        localObject = (LinearLayout.LayoutParams)localView.getLayoutParams();
        paramViewGroup = (ViewGroup)localObject;
        if (localObject == null)
        {
          paramViewGroup = new LinearLayout.LayoutParams(this.a.g, this.a.h);
          localView.setLayoutParams(paramViewGroup);
        }
        paramViewGroup.width = this.a.g;
        paramViewGroup.height = this.a.h;
        paramViewGroup.leftMargin = this.a.e;
        paramViewGroup.topMargin = this.a.f;
        paramView.addView(localView);
        if ((this.a.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.isEnabled(j + paramInt)))
        {
          localView.setTag(2131369179, Integer.valueOf(j + paramInt));
          localView.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          localView.setOnClickListener(null);
        }
        i = this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.a(paramInt) + 2;
        localObject = paramView;
        if (paramView != null)
        {
          localObject = paramView;
          if (((Integer)paramView.getTag(2131362760)).intValue() != i) {
            localObject = null;
          }
        }
        paramView = this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.getView(paramInt, (View)localObject, paramViewGroup);
        paramView.setTag(2131362760, Integer.valueOf(i));
        if ((this.a.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.isEnabled(paramInt)))
        {
          paramView.setTag(2131369179, Integer.valueOf(paramInt));
          paramView.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
          return paramView;
        }
        paramView.setOnClickListener(null);
        return paramView;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return this.a.i + 2;
  }
  
  public boolean isEnabled(int paramInt)
  {
    if ((this.a.c == 0) || (this.a.jdField_a_of_type_Int == 1)) {
      return false;
    }
    return super.isEnabled(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GridListView.WraperAdapter
 * JD-Core Version:    0.7.0.1
 */