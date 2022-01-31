package com.tencent.mobileqq.filemanager.activity.cloudfile;

import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;

class QfileBaseCloudFileTabView$15
  implements Runnable
{
  QfileBaseCloudFileTabView$15(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView, int paramInt) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.this$0);
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView != null) && (QfileBaseCloudFileTabView.d(this.this$0)))
    {
      if (QLog.isColorLevel()) {
        QLog.i(QfileBaseCloudFileTabView.b, 2, "setSelect[" + this.a + "] success mFileListView");
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.15
 * JD-Core Version:    0.7.0.1
 */