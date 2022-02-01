package com.tencent.mobileqq.troop.text;

import android.text.Spannable;
import java.util.Comparator;

final class AtTroopMemberSpan$1
  implements Comparator<AtTroopMemberSpan>
{
  AtTroopMemberSpan$1(Spannable paramSpannable) {}
  
  public int a(AtTroopMemberSpan paramAtTroopMemberSpan1, AtTroopMemberSpan paramAtTroopMemberSpan2)
  {
    int i = 0;
    int j = this.a.getSpanStart(paramAtTroopMemberSpan1);
    int k = this.a.getSpanStart(paramAtTroopMemberSpan2);
    if (j < k) {
      i = -1;
    }
    while (j <= k) {
      return i;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.text.AtTroopMemberSpan.1
 * JD-Core Version:    0.7.0.1
 */