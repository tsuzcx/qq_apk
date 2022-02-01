package com.tencent.mobileqq.leba.utils;

import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.logic.LebaPluginLogic;
import java.util.Iterator;
import java.util.List;

public class LebaPluginGroupManager
{
  private static final long[] a = { 489L, 7719L, 879L };
  
  public static void a(List<LebaViewItem> paramList1, List<LebaViewItem> paramList2)
  {
    if (LebaPluginLogic.a() != 0)
    {
      paramList1.addAll(paramList2);
      return;
    }
    Object localObject1 = paramList2.iterator();
    for (;;)
    {
      boolean bool = ((Iterator)localObject1).hasNext();
      int k = 3;
      if (!bool) {
        break;
      }
      LebaViewItem localLebaViewItem = (LebaViewItem)((Iterator)localObject1).next();
      if (localLebaViewItem.b != null)
      {
        Object localObject2 = a;
        int n = localObject2.length;
        int m = 0;
        int j = 0;
        int i;
        for (;;)
        {
          i = m;
          if (j >= n) {
            break;
          }
          long l = localObject2[j];
          if (localLebaViewItem.b.uiResId == l)
          {
            i = 1;
            break;
          }
          j += 1;
        }
        localObject2 = localLebaViewItem.b;
        j = k;
        if (i != 0) {
          j = 2;
        }
        ((LebaPluginInfo)localObject2).groupId = j;
        if (i != 0) {
          paramList1.add(localLebaViewItem);
        }
      }
    }
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      localObject1 = (LebaViewItem)paramList2.next();
      if ((((LebaViewItem)localObject1).b != null) && (((LebaViewItem)localObject1).b.groupId == 3)) {
        paramList1.add(localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.utils.LebaPluginGroupManager
 * JD-Core Version:    0.7.0.1
 */