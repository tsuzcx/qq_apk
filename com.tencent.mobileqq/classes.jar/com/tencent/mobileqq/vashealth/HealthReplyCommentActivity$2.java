package com.tencent.mobileqq.vashealth;

import android.text.Spanned;
import java.util.Comparator;

final class HealthReplyCommentActivity$2
  implements Comparator<Object>
{
  HealthReplyCommentActivity$2(Spanned paramSpanned) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    return this.a.getSpanStart(paramObject1) - this.a.getSpanStart(paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthReplyCommentActivity.2
 * JD-Core Version:    0.7.0.1
 */