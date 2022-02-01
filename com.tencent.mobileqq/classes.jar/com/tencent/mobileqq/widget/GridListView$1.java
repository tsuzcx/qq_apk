package com.tencent.mobileqq.widget;

import android.database.DataSetObserver;

class GridListView$1
  extends DataSetObserver
{
  GridListView$1(GridListView paramGridListView) {}
  
  public void onChanged()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter != null)
    {
      GridListView localGridListView = this.a;
      GridListView.a(localGridListView, localGridListView.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.getCount());
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter.notifyDataSetChanged();
    }
  }
  
  public void onInvalidated()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter != null)
    {
      GridListView localGridListView = this.a;
      GridListView.a(localGridListView, localGridListView.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.getCount());
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter.notifyDataSetInvalidated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GridListView.1
 * JD-Core Version:    0.7.0.1
 */