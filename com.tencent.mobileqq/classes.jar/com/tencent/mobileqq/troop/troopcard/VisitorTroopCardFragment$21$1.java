package com.tencent.mobileqq.troop.troopcard;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class VisitorTroopCardFragment$21$1
  implements DialogInterface.OnClickListener
{
  VisitorTroopCardFragment$21$1(VisitorTroopCardFragment.21 param21) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.this$0.a.cancel();
      return;
    }
    try
    {
      ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).ForwardSdkShareOption_startGameSdkCallback(this.a.this$0.getActivity(), true, "action_game_join_group", Long.valueOf(this.a.this$0.getActivity().getIntent().getStringExtra("appid")).longValue(), -1, this.a.a);
    }
    catch (Exception paramDialogInterface)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showAlertDlg error = ");
      localStringBuilder.append(paramDialogInterface);
      QLog.e("VisitorTroopCardFragment.Activity", 1, localStringBuilder.toString());
    }
    this.a.this$0.a.cancel();
    this.a.this$0.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardFragment.21.1
 * JD-Core Version:    0.7.0.1
 */