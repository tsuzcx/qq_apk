package com.tencent.mobileqq.kandian.biz.comment;

import android.text.Editable;
import com.tencent.mobileqq.kandian.biz.biu.BiuNicknameSpan;
import java.util.Comparator;

public class ReadInJoyCommentComponentFragment$BiuSpanComparator
  implements Comparator<BiuNicknameSpan>
{
  private Editable b;
  
  public ReadInJoyCommentComponentFragment$BiuSpanComparator(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment, Editable paramEditable)
  {
    this.b = paramEditable;
  }
  
  public int a(BiuNicknameSpan paramBiuNicknameSpan1, BiuNicknameSpan paramBiuNicknameSpan2)
  {
    int i = this.b.getSpanStart(paramBiuNicknameSpan1);
    int j = this.b.getSpanStart(paramBiuNicknameSpan2);
    if (i > j) {
      return 1;
    }
    if (i < j) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment.BiuSpanComparator
 * JD-Core Version:    0.7.0.1
 */