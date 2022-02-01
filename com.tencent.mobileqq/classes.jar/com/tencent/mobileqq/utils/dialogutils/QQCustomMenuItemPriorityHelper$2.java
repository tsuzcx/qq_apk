package com.tencent.mobileqq.utils.dialogutils;

import java.util.Comparator;

final class QQCustomMenuItemPriorityHelper$2
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
    return paramQQCustomMenuItem2.c - paramQQCustomMenuItem1.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemPriorityHelper.2
 * JD-Core Version:    0.7.0.1
 */