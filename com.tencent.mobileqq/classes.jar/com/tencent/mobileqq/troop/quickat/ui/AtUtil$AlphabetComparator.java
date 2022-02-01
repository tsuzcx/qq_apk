package com.tencent.mobileqq.troop.quickat.ui;

import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.ATroopMember;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class AtUtil$AlphabetComparator
  implements Comparator<ChatHistoryTroopMemberFragment.ATroopMember>
{
  private final TroopInfo a;
  
  AtUtil$AlphabetComparator(TroopInfo paramTroopInfo)
  {
    this.a = paramTroopInfo;
  }
  
  public int a(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember1, ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember2)
  {
    boolean bool = AtUtil.b(paramATroopMember1.a, this.a);
    int j = 3;
    int i;
    if (bool) {
      i = 5;
    } else if (AtUtil.a(paramATroopMember1.a, this.a)) {
      i = 3;
    } else if (paramATroopMember1.A) {
      i = 1;
    } else {
      i = 0;
    }
    if (AtUtil.b(paramATroopMember2.a, this.a)) {
      j = 5;
    } else if (!AtUtil.a(paramATroopMember2.a, this.a)) {
      if (paramATroopMember2.A) {
        j = 1;
      } else {
        j = 0;
      }
    }
    if (i != j) {
      return j - i;
    }
    return ChnToSpell.b(AtUtil.c(paramATroopMember1), 1).compareToIgnoreCase(ChnToSpell.b(AtUtil.c(paramATroopMember2), 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AtUtil.AlphabetComparator
 * JD-Core Version:    0.7.0.1
 */