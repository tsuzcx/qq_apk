package com.tencent.mobileqq.kandian.biz.ugc;

import android.text.Spanned;
import java.util.Comparator;

public class Utils$SpanComparator
  implements Comparator<Object>
{
  private Spanned a;
  
  public Utils$SpanComparator(Spanned paramSpanned)
  {
    this.a = paramSpanned;
  }
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    int i = this.a.getSpanStart(paramObject1);
    int j = this.a.getSpanStart(paramObject2);
    if (i > j) {
      return 1;
    }
    if (i < j) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.Utils.SpanComparator
 * JD-Core Version:    0.7.0.1
 */