package com.tencent.mobileqq.filemanager.activity.cloudfile;

import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.widget.ExpandableListView.OnGroupExpandListener;

class QfileBaseCloudFileTabView$1
  implements ExpandableListView.OnGroupExpandListener
{
  QfileBaseCloudFileTabView$1(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onGroupExpand(int paramInt)
  {
    if ((paramInt == this.a.j.getGroupCount() - 1) && (this.a.d != null))
    {
      if (!this.a.e())
      {
        this.a.d.setVisible();
        return;
      }
      this.a.d.setGone();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.1
 * JD-Core Version:    0.7.0.1
 */