package com.tencent.mobileqq.teamwork.fragment;

import android.util.SparseArray;
import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TeamWorkAuthorizeSettingFragment$3
  implements ActionSheet.OnButtonClickListener
{
  TeamWorkAuthorizeSettingFragment$3(TeamWorkAuthorizeSettingFragment paramTeamWorkAuthorizeSettingFragment, SparseArray paramSparseArray, ActionSheet paramActionSheet) {}
  
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
    case 2131917069: 
      TeamWorkAuthorizeSettingFragment.a(this.c, 0);
      break;
    case 2131917068: 
      TeamWorkAuthorizeSettingFragment.a(this.c, 1);
      break;
    case 2131917067: 
      TeamWorkAuthorizeSettingFragment.a(this.c, 2);
    }
    TeamWorkAuthorizeSettingFragment.a(this.c);
    if (this.b.isShowing()) {
      this.b.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */