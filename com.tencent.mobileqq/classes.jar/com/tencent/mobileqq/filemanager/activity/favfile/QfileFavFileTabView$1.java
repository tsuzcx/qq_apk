package com.tencent.mobileqq.filemanager.activity.favfile;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileFavFileTabView$1
  implements View.OnClickListener
{
  QfileFavFileTabView$1(QfileFavFileTabView paramQfileFavFileTabView) {}
  
  public void onClick(View paramView)
  {
    if (!QfileFavFileTabView.a(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QfileFavFileTabView.a(this.a);
      this.a.a();
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount() > 0) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount() - 1);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelection(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getAdapter().getCount() - 1);
      QfileFavFileTabView.a(this.a, false);
      this.a.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileTabView.1
 * JD-Core Version:    0.7.0.1
 */