package com.tencent.mobileqq.freshnews;

import android.text.TextUtils;
import android.widget.Button;
import com.tencent.widget.XEditTextEx;

class QQInputView$1
  implements Runnable
{
  QQInputView$1(QQInputView paramQQInputView) {}
  
  public void run()
  {
    Object localObject = QQInputView.a(this.this$0);
    String str = null;
    if (localObject != null)
    {
      str = QQInputView.a(this.this$0).a();
      localObject = QQInputView.a(this.this$0).b();
    }
    else
    {
      localObject = null;
    }
    if (!TextUtils.isEmpty(str))
    {
      QQInputView.a(this.this$0).setText(str);
      QQInputView.a(this.this$0).setSelection(str.length());
      QQInputView.a(this.this$0).setEnabled(true);
      QQInputView.a(this.this$0).setSelected(true);
      return;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      QQInputView.a(this.this$0).setHint((CharSequence)localObject);
      QQInputView.a(this.this$0).setEnabled(false);
      QQInputView.a(this.this$0).setSelected(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.QQInputView.1
 * JD-Core Version:    0.7.0.1
 */