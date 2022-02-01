package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopBarPublishActivity$16$2
  implements View.OnClickListener
{
  TroopBarPublishActivity$16$2(TroopBarPublishActivity.16 param16) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("path", this.a.a);
    PublicFragmentActivity.a(this.a.this$0, localIntent, TribeVideoPreviewFragment.class);
    this.a.this$0.overridePendingTransition(2130772343, 2130772344);
    if ((this.a.this$0.b != null) && (this.a.this$0.b.getVisibility() == 0)) {}
    for (int i = 2;; i = 1)
    {
      ReportController.b(null, "dc00899", "Grp_tribe", "", "post", "Clk_full_screen", i, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.16.2
 * JD-Core Version:    0.7.0.1
 */