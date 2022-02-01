package com.tencent.mobileqq.troop.troopcard;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.utils.TroopNotifyHelper.OnTroopSafeDialogClickConfirm;

class VisitorTroopCardFragment$12
  implements TroopNotifyHelper.OnTroopSafeDialogClickConfirm
{
  VisitorTroopCardFragment$12(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  public void a(Object... paramVarArgs)
  {
    int i;
    if ((TroopInfo.hasPayPrivilege(this.a.a.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.a.a.mTroopPrivilegeFlag, 512))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      VisitorTroopCardFragment.c(this.a);
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardFragment.12
 * JD-Core Version:    0.7.0.1
 */