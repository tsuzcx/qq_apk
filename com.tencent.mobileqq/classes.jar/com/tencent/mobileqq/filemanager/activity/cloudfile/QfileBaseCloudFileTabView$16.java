package com.tencent.mobileqq.filemanager.activity.cloudfile;

import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;

class QfileBaseCloudFileTabView$16
  implements Runnable
{
  QfileBaseCloudFileTabView$16(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView, int paramInt) {}
  
  public void run()
  {
    this.this$0.C.a(this.this$0);
    if ((this.this$0.f != null) && (QfileBaseCloudFileTabView.p(this.this$0)))
    {
      if (QLog.isColorLevel())
      {
        String str = QfileBaseCloudFileTabView.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setSelect[");
        localStringBuilder.append(this.a);
        localStringBuilder.append("] success mFileListView");
        QLog.i(str, 2, localStringBuilder.toString());
      }
      this.this$0.f.expandGroup(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.16
 * JD-Core Version:    0.7.0.1
 */