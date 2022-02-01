package com.tencent.mobileqq.vas;

import java.util.Comparator;

class ColorNickManager$AtParagraphComparator
  implements Comparator<ColorNickManager.AtTroopMemberParagraph>
{
  public int a(ColorNickManager.AtTroopMemberParagraph paramAtTroopMemberParagraph1, ColorNickManager.AtTroopMemberParagraph paramAtTroopMemberParagraph2)
  {
    int i = 1;
    if (paramAtTroopMemberParagraph1.a == paramAtTroopMemberParagraph2.a) {
      if (paramAtTroopMemberParagraph1.b == paramAtTroopMemberParagraph2.b) {
        i = 0;
      }
    }
    while (paramAtTroopMemberParagraph1.a > paramAtTroopMemberParagraph2.a)
    {
      do
      {
        return i;
      } while (paramAtTroopMemberParagraph1.b > paramAtTroopMemberParagraph2.b);
      return -1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorNickManager.AtParagraphComparator
 * JD-Core Version:    0.7.0.1
 */