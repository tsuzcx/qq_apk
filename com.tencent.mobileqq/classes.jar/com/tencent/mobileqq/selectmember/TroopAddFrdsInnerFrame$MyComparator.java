package com.tencent.mobileqq.selectmember;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import java.util.Comparator;

class TroopAddFrdsInnerFrame$MyComparator
  implements Comparator<TroopMemberInfo>
{
  private TroopAddFrdsInnerFrame$MyComparator(TroopAddFrdsInnerFrame paramTroopAddFrdsInnerFrame) {}
  
  public int a(TroopMemberInfo paramTroopMemberInfo1, TroopMemberInfo paramTroopMemberInfo2)
  {
    if (this.a.z == TroopAddFrdsInnerFrame.y)
    {
      int i = paramTroopMemberInfo1.addState - paramTroopMemberInfo2.addState;
      if (i == 0)
      {
        int j;
        if (paramTroopMemberInfo1.commonFrdCnt == -2147483648) {
          j = 0;
        } else {
          j = paramTroopMemberInfo1.commonFrdCnt;
        }
        int k;
        if (paramTroopMemberInfo2.commonFrdCnt == -2147483648) {
          k = 0;
        } else {
          k = paramTroopMemberInfo2.commonFrdCnt;
        }
        int m = k - j;
        i = m;
        if (j == 0)
        {
          i = m;
          if (k == 0)
          {
            i = m;
            if (TroopAddFrdsInnerFrame.d(this.a) != null)
            {
              boolean bool = TroopAddFrdsInnerFrame.d(this.a).isTroopAdmin(paramTroopMemberInfo1.memberuin);
              k = 1;
              if ((!bool) && (!TroopAddFrdsInnerFrame.d(this.a).isTroopOwner(paramTroopMemberInfo1.memberuin))) {
                i = 0;
              } else {
                i = 1;
              }
              j = k;
              if (!TroopAddFrdsInnerFrame.d(this.a).isTroopAdmin(paramTroopMemberInfo2.memberuin)) {
                if (TroopAddFrdsInnerFrame.d(this.a).isTroopOwner(paramTroopMemberInfo2.memberuin)) {
                  j = k;
                } else {
                  j = 0;
                }
              }
              j -= i;
              i = j;
              if (j == 0) {
                i = Long.signum(paramTroopMemberInfo2.last_active_time - paramTroopMemberInfo1.last_active_time);
              }
            }
          }
        }
        return i;
      }
      return i;
    }
    if ((this.a.z == TroopAddFrdsInnerFrame.x) && (paramTroopMemberInfo1 != null) && (paramTroopMemberInfo1.displayedNamePinyinFirst != null) && (paramTroopMemberInfo2 != null)) {
      return paramTroopMemberInfo1.displayedNamePinyinFirst.compareToIgnoreCase(paramTroopMemberInfo2.displayedNamePinyinFirst);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame.MyComparator
 * JD-Core Version:    0.7.0.1
 */