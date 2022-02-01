package com.tencent.open.agent;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;

class TroopAbilityPreVerificationFragment$1
  implements DialogInterface.OnClickListener
{
  TroopAbilityPreVerificationFragment$1(TroopAbilityPreVerificationFragment paramTroopAbilityPreVerificationFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.n == paramDialogInterface)
    {
      if (paramInt == 1)
      {
        paramDialogInterface = new Intent();
        paramDialogInterface.putExtra("key_params", this.a.e);
        paramDialogInterface.putExtra("is_change_account", true);
        paramDialogInterface.putExtra("fromThirdAppByOpenSDK", true);
        paramDialogInterface.addFlags(268435456);
        paramDialogInterface.addFlags(67108864);
        RouteUtils.a(this.a.getBaseActivity(), paramDialogInterface, "/base/login");
        this.a.getBaseActivity().finish();
        return;
      }
      if (paramInt == 0)
      {
        this.a.getBaseActivity().setResult(0);
        this.a.getBaseActivity().finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.TroopAbilityPreVerificationFragment.1
 * JD-Core Version:    0.7.0.1
 */