package com.tencent.mobileqq.model;

import com.tencent.mobileqq.data.TroopMessageNavigateInfo;
import java.util.Comparator;

public class TroopInfoManager$NavigationMsgComparator
  implements Comparator
{
  public int a(TroopMessageNavigateInfo paramTroopMessageNavigateInfo1, TroopMessageNavigateInfo paramTroopMessageNavigateInfo2)
  {
    return -(paramTroopMessageNavigateInfo1.type - paramTroopMessageNavigateInfo2.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.model.TroopInfoManager.NavigationMsgComparator
 * JD-Core Version:    0.7.0.1
 */