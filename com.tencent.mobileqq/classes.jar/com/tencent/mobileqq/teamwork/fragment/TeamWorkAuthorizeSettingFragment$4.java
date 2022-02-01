package com.tencent.mobileqq.teamwork.fragment;

import android.util.SparseArray;
import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TeamWorkAuthorizeSettingFragment$4
  implements ActionSheet.OnButtonClickListener
{
  TeamWorkAuthorizeSettingFragment$4(TeamWorkAuthorizeSettingFragment paramTeamWorkAuthorizeSettingFragment, SparseArray paramSparseArray, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (this.a.get(paramInt) == null) {
      paramInt = -1;
    } else {
      paramInt = ((Integer)this.a.get(paramInt)).intValue();
    }
    switch (paramInt)
    {
    default: 
      break;
    case 2131917066: 
      TeamWorkAuthorizeSettingFragment.a(this.c, 3);
      break;
    case 2131917065: 
      TeamWorkAuthorizeSettingFragment.a(this.c, 2);
    }
    TeamWorkAuthorizeSettingFragment.a(this.c);
    if (this.b.isShowing()) {
      this.b.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment.4
 * JD-Core Version:    0.7.0.1
 */