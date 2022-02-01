package com.tencent.mobileqq.nearby.profilecard;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

class NearbyProfileEditPanel$20$2
  implements DialogInterface.OnClickListener
{
  NearbyProfileEditPanel$20$2(NearbyProfileEditPanel.20 param20, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.dismiss();
    this.b.a.F.quitEditWithoutSaving();
    paramInt = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.b.a.F.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    paramDialogInterface = this.b.a.F.app;
    String str = NearbyUtils.b(this.b.a.F.from);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    ReportController.b(paramDialogInterface, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, str, localStringBuilder.toString(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.20.2
 * JD-Core Version:    0.7.0.1
 */