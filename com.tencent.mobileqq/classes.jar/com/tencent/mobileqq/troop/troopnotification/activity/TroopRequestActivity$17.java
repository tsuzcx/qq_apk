package com.tencent.mobileqq.troop.troopnotification.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopRequestActivity$17
  implements View.OnClickListener
{
  TroopRequestActivity$17(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - TroopRequestActivity.c <= 0L) || (l - TroopRequestActivity.c >= 800L))
    {
      TroopRequestActivity.c = l;
      Bundle localBundle = TroopInfoUIUtil.a(this.a.jdField_a_of_type_JavaLangString, 4);
      localBundle.putInt("t_s_f", 1001);
      int i = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      if ((i != 2) && (i != 10) && (i != 12)) {
        i = 0;
      } else {
        i = 1;
      }
      AppInterface localAppInterface = TroopRequestActivity.a(this.a);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
      ((StringBuilder)localObject).append("");
      String str = ((StringBuilder)localObject).toString();
      if (i != 0) {
        localObject = "0";
      } else {
        localObject = "1";
      }
      ReportController.b(localAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, str, (String)localObject, "", "");
      ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).openTroopInfoActivity(this.a, localBundle, 2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.17
 * JD-Core Version:    0.7.0.1
 */