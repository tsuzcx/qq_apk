package com.tencent.mobileqq.transfile.ipv6;

import java.util.ArrayList;

public class IpFirstAsMSFStrategy
  extends IpStrategyAbstract
{
  private int mMSFConnType;
  
  IpFirstAsMSFStrategy(int paramInt)
  {
    this.mMSFConnType = paramInt;
  }
  
  protected ArrayList selectIpListWhenDual(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if (this.mMSFConnType == 2) {
      return selectIpv6First(paramArrayList1, paramArrayList2);
    }
    return selectIpv4First(paramArrayList1, paramArrayList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ipv6.IpFirstAsMSFStrategy
 * JD-Core Version:    0.7.0.1
 */