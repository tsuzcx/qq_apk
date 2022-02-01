package com.tencent.mobileqq.troop.troopCard;

import com.tencent.mobileqq.activity.contact.troop.TroopNotifyHelper.OnTroopSafeDialogClickConfirm;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class VisitorTroopCardFragment$12
  implements TroopNotifyHelper.OnTroopSafeDialogClickConfirm
{
  VisitorTroopCardFragment$12(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  public void a(Object... paramVarArgs)
  {
    if ((TroopInfo.hasPayPrivilege(this.a.a.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.a.a.mTroopPrivilegeFlag, 512))) {}
    for (int i = 1; i != 0; i = 0)
    {
      VisitorTroopCardFragment.c(this.a);
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.12
 * JD-Core Version:    0.7.0.1
 */