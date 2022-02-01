package com.tencent.mobileqq.gamecenter.data;

import java.util.Comparator;

final class PadFaceManager$2
  implements Comparator<PadFaceAd>
{
  public int a(PadFaceAd paramPadFaceAd1, PadFaceAd paramPadFaceAd2)
  {
    if (paramPadFaceAd1.startTime < paramPadFaceAd2.startTime) {
      return -1;
    }
    if (paramPadFaceAd1.startTime == paramPadFaceAd2.startTime) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.PadFaceManager.2
 * JD-Core Version:    0.7.0.1
 */