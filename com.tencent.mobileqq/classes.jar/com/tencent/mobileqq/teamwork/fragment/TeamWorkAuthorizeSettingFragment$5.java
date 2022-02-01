package com.tencent.mobileqq.teamwork.fragment;

import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter;
import com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter.Holder;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TeamWorkAuthorizeSettingFragment$5
  implements ActionSheet.OnButtonClickListener
{
  TeamWorkAuthorizeSettingFragment$5(TeamWorkAuthorizeSettingFragment paramTeamWorkAuthorizeSettingFragment, TeamWorkAuthorizeUinListAdapter.Holder paramHolder, SparseArray paramSparseArray, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    TimDocSSOMsg.UinRightInfo localUinRightInfo = this.a.e;
    if (this.b.get(paramInt) == null) {
      paramInt = -1;
    } else {
      paramInt = ((Integer)this.b.get(paramInt)).intValue();
    }
    switch (paramInt)
    {
    default: 
      break;
    case 2131917066: 
      localUinRightInfo.uint32_right.set(2);
      break;
    case 2131917065: 
      localUinRightInfo.uint32_right.set(1);
      break;
    case 2131887718: 
      if ((localUinRightInfo.uint32_right.get() == 1) && (this.d.k == 1)) {
        paramView = this.d.getString(2131917062);
      } else {
        paramView = this.d.getString(2131917061);
      }
      DialogUtil.a(this.d.getBaseActivity(), 230, HardCodeUtil.a(2131912074), paramView, 2131887648, 2131888438, new TeamWorkAuthorizeSettingFragment.5.1(this, localUinRightInfo), new TeamWorkAuthorizeSettingFragment.5.2(this)).show();
      if (this.d.k == 1) {
        ReportController.b(TeamWorkAuthorizeSettingFragment.b(this.d), "dc00898", "", "", "0x8007CFC", "0x8007CFC", 0, 0, "", "", "", "");
      }
      break;
    }
    TeamWorkAuthorizeSettingFragment.a(this.d);
    this.d.j.notifyDataSetChanged();
    if (this.c.isShowing()) {
      this.c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */