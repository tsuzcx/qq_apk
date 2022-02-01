package com.tencent.mobileqq.filemanager.activity.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ExpandableListView;

class QfileBaseExpandableListAdapter$1
  implements View.OnClickListener
{
  QfileBaseExpandableListAdapter$1(QfileBaseExpandableListAdapter paramQfileBaseExpandableListAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (QfileBaseExpandableListAdapter.a(this.b).isGroupExpanded(this.a)) {
      QfileBaseExpandableListAdapter.a(this.b).collapseGroup(this.a);
    } else {
      QfileBaseExpandableListAdapter.a(this.b).expandGroup(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter.1
 * JD-Core Version:    0.7.0.1
 */