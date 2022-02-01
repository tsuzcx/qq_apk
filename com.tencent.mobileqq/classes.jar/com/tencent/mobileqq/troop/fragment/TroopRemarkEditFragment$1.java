package com.tencent.mobileqq.troop.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopRemarkEditFragment$1
  implements View.OnClickListener
{
  TroopRemarkEditFragment$1(TroopRemarkEditFragment paramTroopRemarkEditFragment) {}
  
  public void onClick(View paramView)
  {
    TroopRemarkEditFragment.a(this.a).setText(TroopRemarkEditFragment.a(this.a));
    ReportController.b(TroopRemarkEditFragment.a(this.a), "dc00899", "Grp_set_new", "", "groupnameRemarks", "filling", 0, 0, TroopRemarkEditFragment.b(this.a), "", "", "");
    try
    {
      TroopRemarkEditFragment.a(this.a).setSelection(TroopRemarkEditFragment.a(this.a).length());
      if (TroopRemarkEditFragment.a(this.a).getBytes("utf-8").length > 60) {
        TextUtils.backspace(TroopRemarkEditFragment.a(this.a));
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.fragment.TroopRemarkEditFragment.1
 * JD-Core Version:    0.7.0.1
 */