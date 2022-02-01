package com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl;

import android.widget.EditText;
import com.tencent.mobileqq.kandian.base.view.widget.text.DeleteAsAWholeWatcher;
import com.tencent.tkd.comment.publisher.qq.util.selectionchange.ISelectionChangeObserver;

class QQViewBridgeImpl$EditTextSelectionChangeObserver
  implements ISelectionChangeObserver
{
  public void a(EditText paramEditText, int paramInt1, int paramInt2)
  {
    DeleteAsAWholeWatcher.a(paramEditText, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQViewBridgeImpl.EditTextSelectionChangeObserver
 * JD-Core Version:    0.7.0.1
 */