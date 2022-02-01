package com.tencent.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PinnedHeadAndFootExpandableListView$2
  implements View.OnClickListener
{
  PinnedHeadAndFootExpandableListView$2(PinnedHeadAndFootExpandableListView paramPinnedHeadAndFootExpandableListView1, PinnedHeadAndFootExpandableListView paramPinnedHeadAndFootExpandableListView2) {}
  
  public void onClick(View paramView)
  {
    if (this.b.a != null) {
      this.b.a.a(this.a, this.b.f, this.b.o);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.PinnedHeadAndFootExpandableListView.2
 * JD-Core Version:    0.7.0.1
 */