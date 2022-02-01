package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DovTribeEditVideoButton$1
  implements View.OnClickListener
{
  DovTribeEditVideoButton$1(DovTribeEditVideoButton paramDovTribeEditVideoButton) {}
  
  public void onClick(View paramView)
  {
    if (DovTribeEditVideoButton.a(this.a) == -1) {
      DovTribeEditVideoButton.a(this.a, "Clk_add_topic");
    }
    TroopBarPublishUtils.a((Activity)this.a.a(), 1001, DovTribeEditVideoButton.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.DovTribeEditVideoButton.1
 * JD-Core Version:    0.7.0.1
 */