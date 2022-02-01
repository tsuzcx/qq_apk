package com.tencent.mobileqq.filemanager.activity.favfile;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileFavFileTabView$1
  implements View.OnClickListener
{
  QfileFavFileTabView$1(QfileFavFileTabView paramQfileFavFileTabView) {}
  
  public void onClick(View paramView)
  {
    if (QfileFavFileTabView.a(this.a))
    {
      QfileFavFileTabView.b(this.a);
      this.a.e();
      if (this.a.e.getGroupCount() > 0) {
        this.a.d.expandGroup(this.a.e.getGroupCount() - 1);
      }
      this.a.d.setSelection(this.a.d.getAdapter().getCount() - 1);
      QfileFavFileTabView.a(this.a, false);
      this.a.getMoreFileRecord();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileTabView.1
 * JD-Core Version:    0.7.0.1
 */