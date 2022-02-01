package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;

class QfileBaseLocalFileTabView$9
  implements Runnable
{
  QfileBaseLocalFileTabView$9(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.this$0.r != null)
    {
      this.this$0.r.expandGroup(this.a);
      if (this.b - 2 < 0) {
        return;
      }
      this.this$0.r.setSelectedChild(this.a, this.b - 2, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.9
 * JD-Core Version:    0.7.0.1
 */