package com.tencent.mobileqq.troop.navigatebar;

import com.tencent.mobileqq.data.BaseMessageNavigateInfo;
import java.util.Comparator;

public class BaseAioNavigateBarManager$NavigationMsgComparator
  implements Comparator<BaseMessageNavigateInfo>
{
  public int a(BaseMessageNavigateInfo paramBaseMessageNavigateInfo1, BaseMessageNavigateInfo paramBaseMessageNavigateInfo2)
  {
    if (paramBaseMessageNavigateInfo1.type == paramBaseMessageNavigateInfo2.type)
    {
      int i = 0;
      if (paramBaseMessageNavigateInfo1.msgseq > paramBaseMessageNavigateInfo2.msgseq) {
        return -1;
      }
      if (paramBaseMessageNavigateInfo1.msgseq < paramBaseMessageNavigateInfo2.msgseq) {
        i = 1;
      }
      return i;
    }
    return -(NavConstants.a(paramBaseMessageNavigateInfo1.type) - NavConstants.a(paramBaseMessageNavigateInfo2.type));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.BaseAioNavigateBarManager.NavigationMsgComparator
 * JD-Core Version:    0.7.0.1
 */