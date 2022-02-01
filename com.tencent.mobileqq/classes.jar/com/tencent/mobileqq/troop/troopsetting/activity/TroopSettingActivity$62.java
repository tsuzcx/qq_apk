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
    if (this.this$0.aW != null)
    {
      if (!this.this$0.aW.isShowing()) {
        this.this$0.aW.show();
      }
      return;
    }
    Object localObject = this.this$0;
    ((TroopSettingActivity)localObject).aW = DialogUtil.a((Context)localObject, 230);
    this.this$0.aW.setMessage(this.a);
    localObject = new TroopSettingActivity.62.1(this);
    this.this$0.aW.setPositiveButton(2131888010, (DialogInterface.OnClickListener)localObject);
    this.this$0.aW.setNegativeButton(2131887648, (DialogInterface.OnClickListener)localObject);
    if (!this.this$0.aW.isShowing()) {
      this.this$0.aW.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.62
 * JD-Core Version:    0.7.0.1
 */