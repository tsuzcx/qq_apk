package com.tencent.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PinnedFooterExpandableListView$1
  implements View.OnClickListener
{
  PinnedFooterExpandableListView$1(PinnedFooterExpandableListView paramPinnedFooterExpandableListView1, PinnedFooterExpandableListView paramPinnedFooterExpandableListView2) {}
  
  public void onClick(View paramView)
  {
    if (PinnedFooterExpandableListView.access$000(this.this$0) != null) {
      PinnedFooterExpandableListView.access$000(this.this$0).onClickHeader(this.val$listView, this.this$0.mHeaderView, this.this$0.mFloatingGroupPos);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.PinnedFooterExpandableListView.1
 * JD-Core Version:    0.7.0.1
 */