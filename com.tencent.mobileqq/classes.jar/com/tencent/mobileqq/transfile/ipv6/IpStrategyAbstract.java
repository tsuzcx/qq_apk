package com.tencent.mobileqq.transfile.ipv6;

import java.util.ArrayList;

public abstract class IpStrategyAbstract
  implements IpStrategy
{
  public ArrayList selectIpList(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt)
  {
    if (paramInt == 2) {
      return paramArrayList1;
    }
    if (paramInt == 3) {
      return selectIpListWhenDual(paramArrayList1, paramArrayList2);
    }
    return paramArrayList2;
  }
  
  protected abstract ArrayList selectIpListWhenDual(ArrayList paramArrayList1, ArrayList paramArrayList2);
  
  protected ArrayList selectIpv4First(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList2 != null) && (paramArrayList2.size() > 0)) {
      localArrayList.addAll(paramArrayList2);
    }
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
      localArrayList.add(paramArrayList1.get(0));
    }
    return localArrayList;
  }
  
  protected ArrayList selectIpv6First(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
      localArrayList.add(paramArrayList1.get(0));
    }
    if ((paramArrayList2 != null) && (paramArrayList2.size() > 0)) {
      localArrayList.addAll(paramArrayList2);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ipv6.IpStrategyAbstract
 * JD-Core Version:    0.7.0.1
 */