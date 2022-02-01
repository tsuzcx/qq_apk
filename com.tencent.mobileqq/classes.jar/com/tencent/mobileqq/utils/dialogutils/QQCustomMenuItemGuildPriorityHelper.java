package com.tencent.mobileqq.utils.dialogutils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class QQCustomMenuItemGuildPriorityHelper
{
  private static int a = 2147483647;
  private static Map<String, Integer> b = new QQCustomMenuItemGuildPriorityHelper.1();
  
  public static void a(QQCustomMenu paramQQCustomMenu)
  {
    ArrayList localArrayList = new ArrayList(paramQQCustomMenu.a);
    Collections.sort(localArrayList, new QQCustomMenuItemGuildPriorityHelper.2());
    paramQQCustomMenu.a.clear();
    paramQQCustomMenu.a.addAll(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemGuildPriorityHelper
 * JD-Core Version:    0.7.0.1
 */