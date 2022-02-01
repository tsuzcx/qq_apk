package com.tencent.mobileqq.selectmember;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import java.util.List;

class SelectMemberActivity$7
  implements DialogInterface.OnClickListener
{
  SelectMemberActivity$7(SelectMemberActivity paramSelectMemberActivity, List paramList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = ((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName();
    ((ITroopMngHandler)this.b.app.getBusinessHandler(paramDialogInterface)).a(this.b.mGroupCode, this.a, "");
    SelectMemberActivity.access$200(this.b);
    this.b.pd.show();
    this.b.reportInviteFriend("Clk_invite");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberActivity.7
 * JD-Core Version:    0.7.0.1
 */