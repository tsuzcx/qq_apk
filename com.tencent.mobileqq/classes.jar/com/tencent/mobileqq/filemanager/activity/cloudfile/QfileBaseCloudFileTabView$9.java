package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileBaseCloudFileTabView$9
  implements View.OnClickListener
{
  QfileBaseCloudFileTabView$9(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    if (QfileBaseCloudFileTabView.c(this.a))
    {
      QfileBaseCloudFileTabView.d(this.a);
      this.a.f();
      if (this.a.j.getGroupCount() > 0) {
        this.a.f.expandGroup(this.a.j.getGroupCount() - 1);
      }
      this.a.f.setSelection(this.a.f.getAdapter().getCount() - 1);
      QfileBaseCloudFileTabView.a(this.a, false);
      this.a.h();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.9
 * JD-Core Version:    0.7.0.1
 */