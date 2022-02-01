package com.tencent.mobileqq.util;

import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;

final class TroopGameCardUtil$1
  implements TroopManager.ITroopMemberInfoCallBack
{
  TroopGameCardUtil$1(TroopGameCardUtil.ICheckShowMsgGameGradeLevelBack paramICheckShowMsgGameGradeLevelBack) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if ((paramTroopMemberInfo == null) || ((paramTroopMemberInfo.cmduinFlagEx3Grocery & 1L) != 0L))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("checkoutMsgShowGameGradeLevel memberInfo");
        if (paramTroopMemberInfo != null) {
          break label66;
        }
      }
      label66:
      for (paramTroopMemberInfo = "is null";; paramTroopMemberInfo = "disable game member card")
      {
        QLog.d("TroopGameCardUtil", 2, paramTroopMemberInfo);
        this.a.a(false);
        return;
      }
    }
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.TroopGameCardUtil.1
 * JD-Core Version:    0.7.0.1
 */