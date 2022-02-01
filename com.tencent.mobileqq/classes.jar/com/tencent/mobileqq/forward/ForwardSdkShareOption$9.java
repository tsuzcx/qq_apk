package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;

class ForwardSdkShareOption$9
  implements DialogInterface.OnClickListener
{
  ForwardSdkShareOption$9(ForwardSdkShareOption paramForwardSdkShareOption) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (ForwardSdkShareOption.b(this.a))
      {
        this.a.t.putString("uin", "-1010");
        this.a.t.putInt("uintype", -1);
        this.a.t.putInt("key_forward_ability_type", ForwardAbility.ForwardAbilityType.f.intValue());
        this.a.I();
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCountCliOper(this.a.q, this.a.q.getAccount(), "", "multi_account", "click_next", 0, 1, 0);
      return;
    }
    if (paramInt == 0)
    {
      paramDialogInterface = this.a.s;
      Activity localActivity = this.a.s;
      paramDialogInterface.setResult(0);
      StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCountCliOper(this.a.q, this.a.q.getAccount(), "", "multi_account", "click_cancel", 0, 1, 0);
      this.a.s.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption.9
 * JD-Core Version:    0.7.0.1
 */