package com.tencent.mobileqq.businessCard.activity;

import com.tencent.mobileqq.businessCard.data.BusinessCard;
import java.util.Comparator;

public class BusinessCardListActivity$MyComparator
  implements Comparator
{
  int a = -1;
  
  public BusinessCardListActivity$MyComparator(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int a(BusinessCard paramBusinessCard1, BusinessCard paramBusinessCard2)
  {
    int j = 0;
    int i;
    if (this.a == 1)
    {
      Object localObject2 = paramBusinessCard1.firstPinyin;
      String str = paramBusinessCard2.firstPinyin;
      Object localObject1 = localObject2;
      if (((String)localObject2).endsWith("#")) {
        localObject1 = "Za";
      }
      localObject2 = str;
      if (str.endsWith("#")) {
        localObject2 = "Za";
      }
      j = ((String)localObject1).compareTo((String)localObject2);
      i = j;
      if (j == 0) {
        i = paramBusinessCard2.allPinyin.compareTo(paramBusinessCard1.allPinyin);
      }
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (this.a != 0);
      i = j;
    } while (paramBusinessCard1.lastUpdateTime == paramBusinessCard2.lastUpdateTime);
    if (paramBusinessCard1.lastUpdateTime > paramBusinessCard2.lastUpdateTime) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardListActivity.MyComparator
 * JD-Core Version:    0.7.0.1
 */