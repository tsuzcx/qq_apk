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
    TroopRemarkEditFragment.b(this.a).setText(TroopRemarkEditFragment.a(this.a));
    ReportController.b(TroopRemarkEditFragment.c(this.a), "dc00899", "Grp_set_new", "", "groupnameRemarks", "filling", 0, 0, TroopRemarkEditFragment.d(this.a), "", "", "");
    try
    {
      TroopRemarkEditFragment.b(this.a).setSelection(TroopRemarkEditFragment.a(this.a).length());
      if (TroopRemarkEditFragment.a(this.a).getBytes("utf-8").length > 60) {
        TextUtils.backspace(TroopRemarkEditFragment.b(this.a));
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.fragment.TroopRemarkEditFragment.1
 * JD-Core Version:    0.7.0.1
 */