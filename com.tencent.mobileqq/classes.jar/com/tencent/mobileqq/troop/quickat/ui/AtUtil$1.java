package com.tencent.mobileqq.troop.quickat.ui;

import android.text.Editable;
import java.util.Comparator;

final class AtUtil$1
  implements Comparator
{
  AtUtil$1(Editable paramEditable) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    return this.a.getSpanStart(paramObject1) - this.a.getSpanStart(paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AtUtil.1
 * JD-Core Version:    0.7.0.1
 */