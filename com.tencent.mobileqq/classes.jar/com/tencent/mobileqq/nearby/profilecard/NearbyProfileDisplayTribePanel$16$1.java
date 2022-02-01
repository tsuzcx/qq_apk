package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileEntryUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class NearbyProfileDisplayTribePanel$16$1
  implements ActionSheet.OnButtonClickListener
{
  NearbyProfileDisplayTribePanel$16$1(NearbyProfileDisplayTribePanel.16 param16, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.b.a.L = true;
      Object localObject = this.b.a.e.allinone.uin;
      paramView = (View)localObject;
      if (StringUtil.isEmpty((String)localObject))
      {
        paramView = (View)localObject;
        if (NearbyProfileDisplayTribePanel.j(this.b.a) != null) {
          paramView = NearbyProfileDisplayTribePanel.j(this.b.a).uin;
        }
      }
      if (StringUtil.isEmpty(paramView)) {
        paramView = "0";
      }
      long l;
      if (this.b.a.e.mTinyId == 0L)
      {
        if (NearbyProfileDisplayTribePanel.j(this.b.a) != null) {
          l = NearbyProfileDisplayTribePanel.j(this.b.a).tinyId;
        } else {
          l = 0L;
        }
      }
      else {
        l = this.b.a.e.mTinyId;
      }
      if ((!"0".equals(paramView)) || (l != 0L))
      {
        if (this.b.a.e.app != null) {
          localObject = this.b.a.e.app.getHotChatMng(false);
        } else {
          localObject = null;
        }
        if (((localObject == null) || (!((HotChatManager)localObject).b(this.b.a.e.allinone.troopUin))) && (this.b.a.e.allinone.profileEntryType != 33) && (this.b.a.e.allinone.profileEntryType != 4) && (this.b.a.e.allinone.profileEntryType != 31))
        {
          localObject = null;
          paramInt = 20003;
        }
        else
        {
          localObject = this.b.a.e.allinone.troopUin;
          paramInt = 20012;
        }
        NewReportPlugin.a(this.b.a.e, this.b.a.e.mTinyId, paramView, (String)localObject, paramInt, "", this.b.a.e.allinone.reportExtra);
      }
      ReportController.b(this.b.a.e.app, "CliOper", "", "", "0X8004828", "0X8004828", 0, 0, "", "", "", "");
      if ((NearbyProfileDisplayTribePanel.j(this.b.a) != null) && (NearbyProfileDisplayTribePanel.j(this.b.a).iIsGodFlag == 1)) {
        if (NearbyProfileDisplayTribePanel.j(this.b.a).gender == 0) {
          ReportController.b(this.b.a.e.app, "CliOper", "", "", "0X800528E", "0X800528E", 0, 0, "", "", "", "");
        } else if (NearbyProfileDisplayTribePanel.j(this.b.a).gender == 1) {
          ReportController.b(this.b.a.e.app, "CliOper", "", "", "0X800528F", "0X800528F", 0, 0, "", "", "", "");
        }
      }
      ReportController.b(this.b.a.e.app, "dc00899", "grp_lbs", "", "data_card", "clk_report", 0, 0, "", "", "", "");
      if (ProfileEntryUtils.isFromHotChat(this.b.a.e.allinone.profileEntryType)) {
        ReportController.b(this.b.a.e.app, "CliOper", "", "", "0X800523E", "0X800523E", 0, 0, "", "", "", "");
      }
    }
    paramView = this.a;
    if (paramView != null) {
      paramView.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.16.1
 * JD-Core Version:    0.7.0.1
 */