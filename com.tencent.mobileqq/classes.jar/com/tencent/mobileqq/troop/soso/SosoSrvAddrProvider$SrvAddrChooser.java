package com.tencent.mobileqq.troop.soso;

import java.util.ArrayList;
import java.util.List;

class SosoSrvAddrProvider$SrvAddrChooser
{
  private int[] jdField_a_of_type_ArrayOfInt;
  
  SosoSrvAddrProvider$SrvAddrChooser(SosoSrvAddrProvider paramSosoSrvAddrProvider) {}
  
  private ISvrAddr a(List<ISvrAddr> paramList, int[] paramArrayOfInt, boolean paramBoolean)
  {
    if (paramArrayOfInt != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      int k;
      for (int j = 5; i < paramArrayOfInt.length; j = k)
      {
        k = j;
        if (((ISvrAddr)paramList.get(i)).a() == paramBoolean) {
          if (paramArrayOfInt[i] < j)
          {
            k = paramArrayOfInt[i];
            localArrayList.clear();
            localArrayList.add(Integer.valueOf(i));
          }
          else
          {
            k = j;
            if (paramArrayOfInt[i] == j)
            {
              localArrayList.add(Integer.valueOf(i));
              k = j;
            }
          }
        }
        i += 1;
      }
      if (localArrayList.size() > 0)
      {
        i = ((Integer)localArrayList.get(0)).intValue();
        if ((i >= 0) && (i < paramList.size())) {
          return (ISvrAddr)paramList.get(i);
        }
      }
    }
    return null;
  }
  
  ISvrAddr a(int paramInt, boolean paramBoolean)
  {
    List localList = SosoSrvAddrProvider.a(this.jdField_a_of_type_ComTencentMobileqqTroopSosoSosoSrvAddrProvider, paramInt);
    if ((localList != null) && (localList.size() > 0)) {
      return a(localList, a(paramInt), paramBoolean);
    }
    return null;
  }
  
  void a(List<ISvrAddr> paramList)
  {
    if ((paramList != null) && (paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_ArrayOfInt = new int[paramList.size()];
    }
  }
  
  int[] a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_a_of_type_ArrayOfInt;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.soso.SosoSrvAddrProvider.SrvAddrChooser
 * JD-Core Version:    0.7.0.1
 */