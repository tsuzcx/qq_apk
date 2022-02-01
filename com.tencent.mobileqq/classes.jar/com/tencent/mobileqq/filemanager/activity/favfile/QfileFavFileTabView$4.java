package com.tencent.mobileqq.filemanager.activity.favfile;

import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.widget.ExpandableListView.OnGroupExpandListener;

class QfileFavFileTabView$4
  implements ExpandableListView.OnGroupExpandListener
{
  QfileFavFileTabView$4(QfileFavFileTabView paramQfileFavFileTabView) {}
  
  public void onGroupExpand(int paramInt)
  {
    if ((paramInt == this.a.e.getGroupCount() - 1) && (this.a.r != null))
    {
      if (!this.a.q())
      {
        this.a.r.setVisible();
        return;
      }
      this.a.r.setGone();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileTabView.4
 * JD-Core Version:    0.7.0.1
 */