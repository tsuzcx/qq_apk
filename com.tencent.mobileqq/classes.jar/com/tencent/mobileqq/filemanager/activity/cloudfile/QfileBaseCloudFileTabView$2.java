package com.tencent.mobileqq.filemanager.activity.cloudfile;

import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.widget.ExpandableListView.OnGroupCollapseListener;

class QfileBaseCloudFileTabView$2
  implements ExpandableListView.OnGroupCollapseListener
{
  QfileBaseCloudFileTabView$2(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onGroupCollapse(int paramInt)
  {
    if ((paramInt == this.a.j.getGroupCount() - 1) && (this.a.d != null)) {
      this.a.d.setGone();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.2
 * JD-Core Version:    0.7.0.1
 */