package com.tencent.mobileqq.highway.config;

import java.util.Comparator;

public class HardCodeIpList$CustomComparator
  implements Comparator<HardCodeIpList.Candiate>
{
  public HardCodeIpList$CustomComparator(HardCodeIpList paramHardCodeIpList) {}
  
  public int compare(HardCodeIpList.Candiate paramCandiate1, HardCodeIpList.Candiate paramCandiate2)
  {
    if (paramCandiate1.index < paramCandiate2.index) {
      return -1;
    }
    if (paramCandiate1.index == paramCandiate2.index) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.config.HardCodeIpList.CustomComparator
 * JD-Core Version:    0.7.0.1
 */