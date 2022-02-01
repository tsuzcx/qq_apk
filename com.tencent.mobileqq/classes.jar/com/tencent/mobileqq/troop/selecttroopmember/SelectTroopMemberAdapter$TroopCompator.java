package com.tencent.mobileqq.troop.selecttroopmember;

import java.util.Comparator;

public class SelectTroopMemberAdapter$TroopCompator
  implements Comparator<SelectTroopMemberAdapter.TroopMemInfoData>
{
  private String a(SelectTroopMemberAdapter.TroopMemInfoData paramTroopMemInfoData)
  {
    if ((paramTroopMemInfoData.c == null) || (paramTroopMemInfoData.c.length() == 0)) {
      return "#";
    }
    return paramTroopMemInfoData.c.substring(0, 1);
  }
  
  public int a(SelectTroopMemberAdapter.TroopMemInfoData paramTroopMemInfoData1, SelectTroopMemberAdapter.TroopMemInfoData paramTroopMemInfoData2)
  {
    return a(paramTroopMemInfoData1).compareTo(a(paramTroopMemInfoData2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.SelectTroopMemberAdapter.TroopCompator
 * JD-Core Version:    0.7.0.1
 */