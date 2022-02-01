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
    if ((paramInt == this.a.e.getGroupCount() - 1) && (this.a.r != null)) {
      this.a.r.setGone();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileTabView.5
 * JD-Core Version:    0.7.0.1
 */