package com.tencent.mobileqq.selectmember;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;

class BlessSelectMemberActivity$6
  implements View.OnClickListener
{
  BlessSelectMemberActivity$6(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    if (BlessSelectMemberActivity.g() != null) {
      BlessSelectMemberActivity.g().sendEmptyMessage(1);
    }
    if (this.a.c.isShowing()) {
      this.a.c.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.BlessSelectMemberActivity.6
 * JD-Core Version:    0.7.0.1
 */