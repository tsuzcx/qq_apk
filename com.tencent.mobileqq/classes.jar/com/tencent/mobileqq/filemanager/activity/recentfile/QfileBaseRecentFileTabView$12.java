package com.tencent.mobileqq.filemanager.activity.recentfile;

import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;

class QfileBaseRecentFileTabView$12
  implements Runnable
{
  QfileBaseRecentFileTabView$12(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView, int paramInt) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.this$0);
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView != null) && (QfileBaseRecentFileTabView.c(this.this$0)))
    {
      QLog.e(QfileBaseRecentFileTabView.jdField_a_of_type_JavaLangString, 1, "setSelect[" + this.a + "] success mFileListView");
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.12
 * JD-Core Version:    0.7.0.1
 */