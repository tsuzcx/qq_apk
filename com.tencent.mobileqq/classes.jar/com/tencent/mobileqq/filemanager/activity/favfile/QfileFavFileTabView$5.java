package com.tencent.mobileqq.filemanager.activity.favfile;

import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.widget.ExpandableListView.OnGroupCollapseListener;

class QfileFavFileTabView$5
  implements ExpandableListView.OnGroupCollapseListener
{
  QfileFavFileTabView$5(QfileFavFileTabView paramQfileFavFileTabView) {}
  
  public void onGroupCollapse(int paramInt)
  {
    if ((paramInt == this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount() - 1) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileTabView.5
 * JD-Core Version:    0.7.0.1
 */