package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;

class QfileBaseLocalFileTabView$1
  implements Runnable
{
  QfileBaseLocalFileTabView$1(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void run()
  {
    if (this.this$0.r != null)
    {
      if (this.this$0.q == null) {
        return;
      }
      this.this$0.q.setLayoutParams(this.this$0.r.getWidth(), this.this$0.r.getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.1
 * JD-Core Version:    0.7.0.1
 */