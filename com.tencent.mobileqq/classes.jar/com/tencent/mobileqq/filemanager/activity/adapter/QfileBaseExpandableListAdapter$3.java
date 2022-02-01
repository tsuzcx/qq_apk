package com.tencent.mobileqq.filemanager.activity.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ExpandableListView;

class QfileBaseExpandableListAdapter$3
  implements View.OnClickListener
{
  QfileBaseExpandableListAdapter$3(QfileBaseExpandableListAdapter paramQfileBaseExpandableListAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (QfileBaseExpandableListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter).isGroupExpanded(this.jdField_a_of_type_Int)) {
      QfileBaseExpandableListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter).collapseGroup(this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QfileBaseExpandableListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter).expandGroup(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter.3
 * JD-Core Version:    0.7.0.1
 */