package com.tencent.mobileqq.troopshare;

import android.view.View;
import com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopShareUtility$4
  implements ActionSheet.OnButtonClickListener
{
  public void onClick(View paramView, int paramInt)
  {
    if (this.a.r) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("OnClick.chooseLinkType: ");
      paramView.append(paramInt);
      QLog.i("TroopShareUtility", 2, paramView.toString());
    }
    paramView = this.a;
    paramView.r = true;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        paramView.b(false);
        paramView = this.a;
        paramView.a = -1;
        paramView.b = -1;
        if ((paramView.h instanceof TroopCreateLogicActivity)) {
          ((TroopCreateLogicActivity)this.a.h).finish();
        }
      }
      else
      {
        paramView.b(true);
        paramView = this.a;
        paramView.b = 0;
        TroopShareUtility.b(paramView);
      }
    }
    else
    {
      paramView.b(true);
      paramView = this.a;
      paramView.b = 1;
      TroopShareUtility.b(paramView);
    }
    this.a.q.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.4
 * JD-Core Version:    0.7.0.1
 */