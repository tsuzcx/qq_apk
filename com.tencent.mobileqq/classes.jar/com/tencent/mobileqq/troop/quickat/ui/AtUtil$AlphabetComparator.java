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
    int j = 5;
    int i;
    if (AtUtil.b(paramATroopMember1.jdField_a_of_type_JavaLangString, this.a)) {
      i = 5;
    }
    for (;;)
    {
      if (AtUtil.b(paramATroopMember2.jdField_a_of_type_JavaLangString, this.a)) {}
      for (;;)
      {
        if (i != j)
        {
          return j - i;
          if (AtUtil.a(paramATroopMember1.jdField_a_of_type_JavaLangString, this.a))
          {
            i = 3;
            break;
          }
          if (!paramATroopMember1.jdField_a_of_type_Boolean) {
            break label134;
          }
          i = 1;
          break;
          if (AtUtil.a(paramATroopMember2.jdField_a_of_type_JavaLangString, this.a))
          {
            j = 3;
            continue;
          }
          if (!paramATroopMember2.jdField_a_of_type_Boolean) {
            break label128;
          }
          j = 1;
          continue;
        }
        return ChnToSpell.a(AtUtil.c(paramATroopMember1), 1).compareToIgnoreCase(ChnToSpell.a(AtUtil.c(paramATroopMember2), 1));
        label128:
        j = 0;
      }
      label134:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AtUtil.AlphabetComparator
 * JD-Core Version:    0.7.0.1
 */