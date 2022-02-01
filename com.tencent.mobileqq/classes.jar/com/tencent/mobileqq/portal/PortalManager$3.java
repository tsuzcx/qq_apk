package com.tencent.mobileqq.portal;

import java.util.Comparator;

final class PortalManager$3
  implements Comparator<PortalManager.TimerConfig>
{
  public int a(PortalManager.TimerConfig paramTimerConfig1, PortalManager.TimerConfig paramTimerConfig2)
  {
    long l = paramTimerConfig1.uiBegin - paramTimerConfig2.uiBegin;
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.3
 * JD-Core Version:    0.7.0.1
 */