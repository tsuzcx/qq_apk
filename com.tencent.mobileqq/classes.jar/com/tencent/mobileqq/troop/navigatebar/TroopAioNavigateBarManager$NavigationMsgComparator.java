package com.tencent.mobileqq.troop.navigatebar;

import com.tencent.mobileqq.data.TroopMessageNavigateInfo;
import java.util.Comparator;

class TroopAioNavigateBarManager$NavigationMsgComparator
  implements Comparator<TroopMessageNavigateInfo>
{
  public int a(TroopMessageNavigateInfo paramTroopMessageNavigateInfo1, TroopMessageNavigateInfo paramTroopMessageNavigateInfo2)
  {
    if (paramTroopMessageNavigateInfo1.type == paramTroopMessageNavigateInfo2.type)
    {
      int i = 0;
      if (paramTroopMessageNavigateInfo1.msgseq > paramTroopMessageNavigateInfo2.msgseq) {
        return -1;
      }
      if (paramTroopMessageNavigateInfo1.msgseq < paramTroopMessageNavigateInfo2.msgseq) {
        i = 1;
      }
      return i;
    }
    return -(NavConstants.a(paramTroopMessageNavigateInfo1.type) - NavConstants.a(paramTroopMessageNavigateInfo2.type));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager.NavigationMsgComparator
 * JD-Core Version:    0.7.0.1
 */