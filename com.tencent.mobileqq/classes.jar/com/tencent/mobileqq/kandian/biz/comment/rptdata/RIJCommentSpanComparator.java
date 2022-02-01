package com.tencent.mobileqq.kandian.biz.comment.rptdata;

import android.text.Spanned;
import java.io.Serializable;
import java.util.Comparator;

public class RIJCommentSpanComparator
  implements Serializable, Comparator<Object>
{
  private static final long serialVersionUID = -7165398985269726726L;
  private final Spanned editable;
  
  public RIJCommentSpanComparator(Spanned paramSpanned)
  {
    this.editable = paramSpanned;
  }
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    return Integer.compare(this.editable.getSpanStart(paramObject1), this.editable.getSpanStart(paramObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentSpanComparator
 * JD-Core Version:    0.7.0.1
 */