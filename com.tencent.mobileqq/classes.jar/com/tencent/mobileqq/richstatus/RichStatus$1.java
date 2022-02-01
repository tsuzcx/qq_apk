package com.tencent.mobileqq.richstatus;

import com.tencent.util.Pair;
import java.util.Comparator;

class RichStatus$1
  implements Comparator<Pair<Integer, Integer>>
{
  RichStatus$1(RichStatus paramRichStatus) {}
  
  public int a(Pair<Integer, Integer> paramPair1, Pair<Integer, Integer> paramPair2)
  {
    if (((Integer)paramPair1.second).intValue() < ((Integer)paramPair2.second).intValue()) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.RichStatus.1
 * JD-Core Version:    0.7.0.1
 */