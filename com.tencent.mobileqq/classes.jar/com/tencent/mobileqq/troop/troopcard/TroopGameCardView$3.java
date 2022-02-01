package com.tencent.mobileqq.troop.troopcard;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.utils.TroopReportor;
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
    ReportDialog localReportDialog = new ReportDialog(this.a.getContext(), 2131756189);
    localReportDialog.setContentView(2131558954);
    localReportDialog.setCanceledOnTouchOutside(false);
    Object localObject = (TextView)localReportDialog.findViewById(2131365633);
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = (TextView)localReportDialog.findViewById(2131365639);
    if (localObject != null)
    {
      ((TextView)localObject).setText(this.a.getContext().getString(2131719874));
      ((TextView)localObject).setOnClickListener(new TroopGameCardView.3.1(this, localReportDialog));
    }
    localObject = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getTroopCardTipsContent(this.a.getContext());
    TextView localTextView = (TextView)localReportDialog.findViewById(2131365648);
    localTextView.setTypeface(Typeface.DEFAULT_BOLD);
    localTextView.setText(this.a.getContext().getString(2131719876));
    localTextView = (TextView)localReportDialog.findViewById(2131365644);
    localTextView.setWidth(ViewUtils.b(236.0F));
    localTextView.setText((CharSequence)localObject);
    localReportDialog.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopGameCardView.3
 * JD-Core Version:    0.7.0.1
 */