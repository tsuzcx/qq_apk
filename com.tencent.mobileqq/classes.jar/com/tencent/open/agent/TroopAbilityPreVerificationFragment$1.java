package com.tencent.open.agent;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;

class TroopAbilityPreVerificationFragment$1
  implements DialogInterface.OnClickListener
{
  TroopAbilityPreVerificationFragment$1(TroopAbilityPreVerificationFragment paramTroopAbilityPreVerificationFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == paramDialogInterface)
    {
      if (paramInt != 1) {
        break label92;
      }
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("key_params", this.a.jdField_a_of_type_AndroidOsBundle);
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface.putExtra("fromThirdAppByOpenSDK", true);
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      RouteUtils.a(this.a.getActivity(), paramDialogInterface, "/base/login");
      this.a.getActivity().finish();
    }
    label92:
    while (paramInt != 0) {
      return;
    }
    this.a.getActivity().setResult(0);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.TroopAbilityPreVerificationFragment.1
 * JD-Core Version:    0.7.0.1
 */