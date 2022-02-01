package com.tencent.mobileqq.troop.troopnotification.ui;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopnotification.adapter.NotifyAndRecAdapter.ViewHolder;
import com.tencent.mobileqq.troop.utils.TroopNotifyHelper.OnTroopSafeDialogClickConfirm;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.TroopReportor;

class TroopNotificationFragment$17
  implements TroopNotifyHelper.OnTroopSafeDialogClickConfirm
{
  TroopNotificationFragment$17(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  public void a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 4))
    {
      NotifyAndRecAdapter.ViewHolder localViewHolder = (NotifyAndRecAdapter.ViewHolder)paramVarArgs[0];
      String str1 = (String)paramVarArgs[1];
      String str2 = (String)paramVarArgs[2];
      paramVarArgs = (String)paramVarArgs[3];
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).requestTroopPrivilege(this.a.g, (AppInterface)TroopNotificationFragment.f(this.a), str1, localViewHolder.r, this.a.E);
      TroopReportor.a("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str1, str2, paramVarArgs, "0" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.17
 * JD-Core Version:    0.7.0.1
 */