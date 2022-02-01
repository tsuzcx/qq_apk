package com.tencent.mobileqq.profile.stickynote.publish.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.stickynote.publish.bean.BackgroundSelectBean;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

class BackgroundSelectorAdapter$1
  implements View.OnClickListener
{
  BackgroundSelectorAdapter$1(BackgroundSelectorAdapter paramBackgroundSelectorAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (BackgroundSelectorAdapter.a(this.b) != this.a)
    {
      Iterator localIterator = BackgroundSelectorAdapter.b(this.b).iterator();
      while (localIterator.hasNext()) {
        ((BackgroundSelectBean)localIterator.next()).b = false;
      }
      ((BackgroundSelectBean)BackgroundSelectorAdapter.b(this.b).get(this.a)).b = true;
      BackgroundSelectorAdapter.a(this.b, this.a);
      this.b.notifyDataSetChanged();
      if (BackgroundSelectorAdapter.c(this.b) != null) {
        BackgroundSelectorAdapter.c(this.b).a((BackgroundSelectBean)BackgroundSelectorAdapter.b(this.b).get(this.a));
      }
      ReportController.b(null, "dc00898", "", "", "0X800AB2B", "0X800AB2B", 0, 0, "0", "0", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.adapter.BackgroundSelectorAdapter.1
 * JD-Core Version:    0.7.0.1
 */