package com.tencent.mobileqq.utils.dialogutils;

import java.util.Comparator;
import java.util.Map;

final class QQCustomMenuItemGuildPriorityHelper$2
  implements Comparator<QQCustomMenuItem>
{
  public int a(QQCustomMenuItem paramQQCustomMenuItem1, QQCustomMenuItem paramQQCustomMenuItem2)
  {
    if (paramQQCustomMenuItem1 == paramQQCustomMenuItem2) {
      return 0;
    }
    if (paramQQCustomMenuItem1 == null) {
      return 1;
    }
    if (paramQQCustomMenuItem2 == null) {
      return -1;
    }
    int j;
    if ((QQCustomMenuItemGuildPriorityHelper.b().containsKey(paramQQCustomMenuItem1.a)) && (QQCustomMenuItemGuildPriorityHelper.b().containsKey(paramQQCustomMenuItem2.a))) {
      j = ((Integer)QQCustomMenuItemGuildPriorityHelper.b().get(paramQQCustomMenuItem2.a)).intValue();
    }
    for (int i = ((Integer)QQCustomMenuItemGuildPriorityHelper.b().get(paramQQCustomMenuItem1.a)).intValue();; i = paramQQCustomMenuItem1.d)
    {
      return j - i;
      j = paramQQCustomMenuItem2.d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemGuildPriorityHelper.2
 * JD-Core Version:    0.7.0.1
 */