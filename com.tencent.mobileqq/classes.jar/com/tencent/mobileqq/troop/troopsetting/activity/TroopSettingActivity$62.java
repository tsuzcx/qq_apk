package com.tencent.mobileqq.troop.troopsetting.activity;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class TroopSettingActivity$62
  implements Runnable
{
  TroopSettingActivity$62(TroopSettingActivity paramTroopSettingActivity, String paramString) {}
  
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
    this.this$0.a.setMessage(this.a);
    localObject = new TroopSettingActivity.62.1(this);
    this.this$0.a.setPositiveButton(2131691064, (DialogInterface.OnClickListener)localObject);
    this.this$0.a.setNegativeButton(2131690728, (DialogInterface.OnClickListener)localObject);
    if (!this.this$0.a.isShowing()) {
      this.this$0.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.62
 * JD-Core Version:    0.7.0.1
 */