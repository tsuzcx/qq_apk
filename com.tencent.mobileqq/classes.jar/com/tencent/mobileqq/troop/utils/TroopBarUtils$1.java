package com.tencent.mobileqq.troop.utils;

import android.text.Spanned;
import java.util.Comparator;

final class TroopBarUtils$1
  implements Comparator<Object>
{
  TroopBarUtils$1(Spanned paramSpanned) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    return this.a.getSpanStart(paramObject1) - this.a.getSpanStart(paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBarUtils.1
 * JD-Core Version:    0.7.0.1
 */