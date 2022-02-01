package com.tencent.mobileqq.transfile.ipv6;

import java.util.ArrayList;

public class Ipv4FirstStrategy
  extends IpStrategyAbstract
{
  protected ArrayList selectIpListWhenDual(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    return selectIpv4First(paramArrayList1, paramArrayList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ipv6.Ipv4FirstStrategy
 * JD-Core Version:    0.7.0.1
 */