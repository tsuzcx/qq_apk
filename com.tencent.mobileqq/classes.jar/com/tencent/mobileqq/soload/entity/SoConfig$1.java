package com.tencent.mobileqq.soload.entity;

import com.tencent.mobileqq.config.QConfItem;
import java.util.Comparator;

class SoConfig$1
  implements Comparator<QConfItem>
{
  SoConfig$1(SoConfig paramSoConfig) {}
  
  public int a(QConfItem paramQConfItem1, QConfItem paramQConfItem2)
  {
    int j = 0;
    int i;
    if (paramQConfItem1 == null)
    {
      i = 0;
      if (paramQConfItem2 != null) {
        break label26;
      }
    }
    for (;;)
    {
      return j - i;
      i = paramQConfItem1.a;
      break;
      label26:
      j = paramQConfItem2.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.entity.SoConfig.1
 * JD-Core Version:    0.7.0.1
 */