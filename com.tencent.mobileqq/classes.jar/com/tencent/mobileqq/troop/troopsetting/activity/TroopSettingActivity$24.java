package com.tencent.mobileqq.troop.troopsetting.activity;

import android.view.View;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopSettingActivity$24
  implements ActionSheet.OnButtonClickListener
{
  TroopSettingActivity$24(TroopSettingActivity paramTroopSettingActivity, int paramInt, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    int i;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          i = -1;
          paramInt = 0;
        }
        else
        {
          i = 3;
          paramInt = 2;
        }
      }
      else
      {
        i = 2;
        paramInt = 1;
      }
    }
    else
    {
      i = 4;
      paramInt = 3;
    }
    if (i != this.a) {
      TroopSettingActivity.b(this.c, i);
    }
    try
    {
      this.b.dismiss();
      TroopReportor.a("Grp_msg", "grpData_admin", "Close_setmsg", 0, 0, new String[] { this.c.i.troopUin, TroopReportor.a(this.c.i), String.valueOf(paramInt) });
      return;
    }
    catch (Exception paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, paramView.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.24
 * JD-Core Version:    0.7.0.1
 */