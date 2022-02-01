package com.tencent.mobileqq.selectmember;

import java.util.Comparator;

public class ResultRecord$DefaultComparator
  implements Comparator<ResultRecord>
{
  public int a(ResultRecord paramResultRecord1, ResultRecord paramResultRecord2)
  {
    long l1;
    if (paramResultRecord1 == null) {
      l1 = 0L;
    } else {
      l1 = paramResultRecord1.lastChooseTime;
    }
    long l2;
    if (paramResultRecord2 == null) {
      l2 = 0L;
    } else {
      l2 = paramResultRecord2.lastChooseTime;
    }
    if (l1 == l2) {
      return 0;
    }
    if (l1 == 0L) {}
    do
    {
      return -1;
      if (l2 == 0L) {
        return 1;
      }
    } while (l1 < l2);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.ResultRecord.DefaultComparator
 * JD-Core Version:    0.7.0.1
 */