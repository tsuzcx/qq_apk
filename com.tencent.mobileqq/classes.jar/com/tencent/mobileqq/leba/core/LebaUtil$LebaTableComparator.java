package com.tencent.mobileqq.leba.core;

import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import java.util.Comparator;

public class LebaUtil$LebaTableComparator
  implements Comparator<LebaViewItem>
{
  public int a(LebaViewItem paramLebaViewItem1, LebaViewItem paramLebaViewItem2)
  {
    if (paramLebaViewItem1.b > paramLebaViewItem2.b) {
      return 1;
    }
    if (paramLebaViewItem1.b < paramLebaViewItem2.b) {
      return -1;
    }
    if (paramLebaViewItem1.a.sPriority > paramLebaViewItem2.a.sPriority) {
      return 1;
    }
    if (paramLebaViewItem1.a.sPriority < paramLebaViewItem2.a.sPriority) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.LebaUtil.LebaTableComparator
 * JD-Core Version:    0.7.0.1
 */