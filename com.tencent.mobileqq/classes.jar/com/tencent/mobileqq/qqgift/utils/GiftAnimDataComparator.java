package com.tencent.mobileqq.qqgift.utils;

import com.tencent.mobileqq.qqgift.mvvm.business.anim.GiftAnimData;
import java.util.Comparator;

public class GiftAnimDataComparator
  implements Comparator<GiftAnimData>
{
  public int a(GiftAnimData paramGiftAnimData1, GiftAnimData paramGiftAnimData2)
  {
    int i = paramGiftAnimData1.f;
    int j = paramGiftAnimData2.f;
    if (i < j) {
      return -1;
    }
    if (i == j) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.utils.GiftAnimDataComparator
 * JD-Core Version:    0.7.0.1
 */