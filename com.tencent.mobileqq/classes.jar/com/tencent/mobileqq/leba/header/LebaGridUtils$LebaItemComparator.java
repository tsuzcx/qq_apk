package com.tencent.mobileqq.leba.header;

import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.leba.model.PluginInfo;
import java.util.Comparator;

public class LebaGridUtils$LebaItemComparator
  implements Comparator
{
  private boolean a(LebaGridItemInfo paramLebaGridItemInfo)
  {
    return (paramLebaGridItemInfo != null) && (paramLebaGridItemInfo.a != null);
  }
  
  public int a(LebaGridItemInfo paramLebaGridItemInfo1, LebaGridItemInfo paramLebaGridItemInfo2)
  {
    if ((a(paramLebaGridItemInfo1)) && (a(paramLebaGridItemInfo2))) {
      if (paramLebaGridItemInfo1.a.weight <= paramLebaGridItemInfo2.a.weight) {}
    }
    while (a(paramLebaGridItemInfo1))
    {
      return -1;
      if (paramLebaGridItemInfo1.a.weight < paramLebaGridItemInfo2.a.weight) {
        return 1;
      }
      return 0;
    }
    if (a(paramLebaGridItemInfo2)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.header.LebaGridUtils.LebaItemComparator
 * JD-Core Version:    0.7.0.1
 */