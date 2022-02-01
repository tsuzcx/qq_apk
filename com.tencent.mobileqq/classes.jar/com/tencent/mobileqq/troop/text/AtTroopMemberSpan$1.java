package com.tencent.mobileqq.troop.text;

import android.text.Spannable;
import java.util.Comparator;

final class AtTroopMemberSpan$1
  implements Comparator<AtTroopMemberSpan>
{
  AtTroopMemberSpan$1(Spannable paramSpannable) {}
  
  public int a(AtTroopMemberSpan paramAtTroopMemberSpan1, AtTroopMemberSpan paramAtTroopMemberSpan2)
  {
    int i = this.a.getSpanStart(paramAtTroopMemberSpan1);
    int j = this.a.getSpanStart(paramAtTroopMemberSpan2);
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.text.AtTroopMemberSpan.1
 * JD-Core Version:    0.7.0.1
 */