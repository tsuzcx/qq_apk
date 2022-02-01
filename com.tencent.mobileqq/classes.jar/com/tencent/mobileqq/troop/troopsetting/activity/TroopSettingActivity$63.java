package com.tencent.mobileqq.troop.troopsetting.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class TroopSettingActivity$63
  implements Runnable
{
  TroopSettingActivity$63(TroopSettingActivity paramTroopSettingActivity) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      if (!this.this$0.a.isShowing()) {
        this.this$0.a.show();
      }
      return;
    }
    Object localObject = this.this$0;
    ((TroopSettingActivity)localObject).a = DialogUtil.a((Context)localObject, 230);
    this.this$0.a.setMessage(this.this$0.getActivity().getResources().getString(2131719913));
    localObject = new TroopSettingActivity.63.1(this);
    this.this$0.a.setPositiveButton(2131691064, (DialogInterface.OnClickListener)localObject);
    if (!this.this$0.a.isShowing()) {
      this.this$0.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.63
 * JD-Core Version:    0.7.0.1
 */