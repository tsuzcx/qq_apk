package com.tencent.mobileqq.transfile.ipv6;

import java.util.ArrayList;

public class Ipv6FirstStrategy
  extends IpStrategyAbstract
{
  protected ArrayList selectIpListWhenDual(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    return selectIpv6First(paramArrayList1, paramArrayList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ipv6.Ipv6FirstStrategy
 * JD-Core Version:    0.7.0.1
 */