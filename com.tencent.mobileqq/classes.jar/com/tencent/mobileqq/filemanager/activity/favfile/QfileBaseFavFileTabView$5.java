package com.tencent.mobileqq.filemanager.activity.favfile;

import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;

class QfileBaseFavFileTabView$5
  implements Runnable
{
  QfileBaseFavFileTabView$5(QfileBaseFavFileTabView paramQfileBaseFavFileTabView, int paramInt) {}
  
  public void run()
  {
    this.this$0.C.a(this.this$0);
    if ((this.this$0.d != null) && (QfileBaseFavFileTabView.a(this.this$0)))
    {
      if (QLog.isColorLevel())
      {
        String str = QfileBaseFavFileTabView.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setSelect[");
        localStringBuilder.append(this.a);
        localStringBuilder.append("] success mFileListView");
        QLog.i(str, 2, localStringBuilder.toString());
      }
      this.this$0.d.expandGroup(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView.5
 * JD-Core Version:    0.7.0.1
 */