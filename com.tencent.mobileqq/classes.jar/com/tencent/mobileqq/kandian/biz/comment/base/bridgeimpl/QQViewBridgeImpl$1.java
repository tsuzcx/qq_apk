package com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl;

import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.mobileqq.kandian.biz.biu.BiuTextBuilder;

class QQViewBridgeImpl$1
  extends Editable.Factory
{
  QQViewBridgeImpl$1(QQViewBridgeImpl paramQQViewBridgeImpl) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof BiuTextBuilder)) {
      return (Editable)paramCharSequence;
    }
    return new BiuTextBuilder(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQViewBridgeImpl.1
 * JD-Core Version:    0.7.0.1
 */