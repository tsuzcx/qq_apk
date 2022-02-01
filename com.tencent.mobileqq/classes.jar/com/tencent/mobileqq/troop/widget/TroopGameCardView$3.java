package com.tencent.mobileqq.troop.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardConfig;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class TroopGameCardView$3
  implements View.OnClickListener
{
  TroopGameCardView$3(TroopGameCardView paramTroopGameCardView) {}
  
  public void onClick(View paramView)
  {
    TroopReportor.a("grpProfile", "grpProfile_clk", "game_tips_clk", 0, 0, new String[] { this.a.a });
    ReportDialog localReportDialog = new ReportDialog(this.a.getContext(), 2131755842);
    localReportDialog.setContentView(2131559060);
    localReportDialog.setCanceledOnTouchOutside(false);
    Object localObject1 = (TextView)localReportDialog.findViewById(2131365796);
    if (localObject1 != null) {
      ((TextView)localObject1).setVisibility(8);
    }
    localObject1 = (TextView)localReportDialog.findViewById(2131365802);
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText(this.a.getContext().getString(2131720141));
      ((TextView)localObject1).setOnClickListener(new TroopGameCardView.3.1(this, localReportDialog));
    }
    localObject1 = this.a.getContext().getString(2131720142);
    Object localObject2 = (TroopGameCardConfig)QConfigManager.a().a(695);
    if (localObject2 != null) {
      localObject1 = ((TroopGameCardConfig)localObject2).c();
    }
    localObject2 = (TextView)localReportDialog.findViewById(2131365811);
    ((TextView)localObject2).setTypeface(Typeface.DEFAULT_BOLD);
    ((TextView)localObject2).setText(this.a.getContext().getString(2131720143));
    localObject2 = (TextView)localReportDialog.findViewById(2131365807);
    ((TextView)localObject2).setWidth(ViewUtils.b(236.0F));
    ((TextView)localObject2).setText((CharSequence)localObject1);
    localReportDialog.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopGameCardView.3
 * JD-Core Version:    0.7.0.1
 */