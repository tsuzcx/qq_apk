package com.tencent.mobileqq.mutualmark;

import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import java.util.Comparator;

final class MutualMarkDataCenter$1
  implements Comparator<MutualMarkForDisplayInfo>
{
  public int a(MutualMarkForDisplayInfo paramMutualMarkForDisplayInfo1, MutualMarkForDisplayInfo paramMutualMarkForDisplayInfo2)
  {
    if (paramMutualMarkForDisplayInfo1.a < paramMutualMarkForDisplayInfo2.a) {
      return -1;
    }
    if (paramMutualMarkForDisplayInfo1.a > paramMutualMarkForDisplayInfo2.a) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.MutualMarkDataCenter.1
 * JD-Core Version:    0.7.0.1
 */