package com.tencent.mobileqq.mutualmark;

import java.util.Comparator;

final class MutualMarkGrayTipsHelper$1
  implements Comparator<MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo>
{
  public int a(MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo paramGrayTipHighlightItemInfo1, MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo paramGrayTipHighlightItemInfo2)
  {
    if (paramGrayTipHighlightItemInfo1.c < paramGrayTipHighlightItemInfo2.c) {
      return -1;
    }
    if (paramGrayTipHighlightItemInfo1.c > paramGrayTipHighlightItemInfo2.c) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.MutualMarkGrayTipsHelper.1
 * JD-Core Version:    0.7.0.1
 */