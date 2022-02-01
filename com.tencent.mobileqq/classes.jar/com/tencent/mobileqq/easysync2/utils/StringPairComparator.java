package com.tencent.mobileqq.easysync2.utils;

import com.tencent.util.Pair;
import java.util.Comparator;

public class StringPairComparator
  implements Comparator<Pair<String, String>>
{
  public int a(Pair<String, String> paramPair1, Pair<String, String> paramPair2)
  {
    int j = ((String)paramPair1.first).compareTo((String)paramPair2.first);
    int i = j;
    if (j == 0) {
      i = ((String)paramPair1.second).compareTo((String)paramPair2.second);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.utils.StringPairComparator
 * JD-Core Version:    0.7.0.1
 */