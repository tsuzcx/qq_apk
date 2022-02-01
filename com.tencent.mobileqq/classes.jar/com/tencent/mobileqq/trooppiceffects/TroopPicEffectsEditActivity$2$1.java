package com.tencent.mobileqq.trooppiceffects;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;

class TroopPicEffectsEditActivity$2$1
  implements DialogInterface.OnClickListener
{
  TroopPicEffectsEditActivity$2$1(TroopPicEffectsEditActivity.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = String.format("https://qun.qq.com/qunpay/gifts/buy.html?_bid=2204&_wvSb=1&from=7&troopUin=%s", new Object[] { this.a.a.b });
    Intent localIntent = new Intent(this.a.a, QQBrowserActivity.class);
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131715552));
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", this.a.a.a(paramDialogInterface));
    this.a.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity.2.1
 * JD-Core Version:    0.7.0.1
 */