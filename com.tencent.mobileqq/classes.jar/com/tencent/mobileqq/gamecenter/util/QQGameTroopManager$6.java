package com.tencent.mobileqq.gamecenter.util;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import java.util.Comparator;
import java.util.List;

class QQGameTroopManager$6
  implements Comparator<TroopMemberInfo>
{
  QQGameTroopManager$6(QQGameTroopManager paramQQGameTroopManager) {}
  
  public int a(TroopMemberInfo paramTroopMemberInfo1, TroopMemberInfo paramTroopMemberInfo2)
  {
    if ((paramTroopMemberInfo1 != null) && (paramTroopMemberInfo2 != null) && (paramTroopMemberInfo1.memberuin != null) && (paramTroopMemberInfo2.memberuin != null) && (QQGameTroopManager.b != null))
    {
      boolean bool1 = QQGameTroopManager.b.contains(paramTroopMemberInfo1.memberuin);
      boolean bool2 = QQGameTroopManager.b.contains(paramTroopMemberInfo2.memberuin);
      if ((bool1) && (!bool2)) {
        return -1;
      }
      if ((!bool1) && (bool2)) {
        return 1;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.QQGameTroopManager.6
 * JD-Core Version:    0.7.0.1
 */