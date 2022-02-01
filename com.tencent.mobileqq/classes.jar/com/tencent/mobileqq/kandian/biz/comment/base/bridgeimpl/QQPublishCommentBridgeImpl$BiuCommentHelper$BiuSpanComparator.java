package com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl;

import android.text.Editable;
import com.tencent.mobileqq.kandian.biz.biu.BiuNicknameSpan;
import java.util.Comparator;

class QQPublishCommentBridgeImpl$BiuCommentHelper$BiuSpanComparator
  implements Comparator<BiuNicknameSpan>
{
  private final Editable jdField_a_of_type_AndroidTextEditable;
  
  public QQPublishCommentBridgeImpl$BiuCommentHelper$BiuSpanComparator(QQPublishCommentBridgeImpl.BiuCommentHelper paramBiuCommentHelper, Editable paramEditable)
  {
    this.jdField_a_of_type_AndroidTextEditable = paramEditable;
  }
  
  public int a(BiuNicknameSpan paramBiuNicknameSpan1, BiuNicknameSpan paramBiuNicknameSpan2)
  {
    int i = this.jdField_a_of_type_AndroidTextEditable.getSpanStart(paramBiuNicknameSpan1);
    int j = this.jdField_a_of_type_AndroidTextEditable.getSpanStart(paramBiuNicknameSpan2);
    if (i > j) {
      return 1;
    }
    if (i < j) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQPublishCommentBridgeImpl.BiuCommentHelper.BiuSpanComparator
 * JD-Core Version:    0.7.0.1
 */