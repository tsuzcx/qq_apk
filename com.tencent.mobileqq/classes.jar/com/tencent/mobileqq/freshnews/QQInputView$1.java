package com.tencent.mobileqq.freshnews;

import android.text.TextUtils;
import android.widget.Button;
import aqkc;
import com.tencent.widget.XEditTextEx;

class QQInputView$1
  implements Runnable
{
  QQInputView$1(QQInputView paramQQInputView) {}
  
  public void run()
  {
    String str1 = null;
    String str2;
    if (QQInputView.a(this.this$0) != null)
    {
      str2 = QQInputView.a(this.this$0).a();
      str1 = QQInputView.a(this.this$0).b();
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str2))
      {
        QQInputView.a(this.this$0).setText(str2);
        QQInputView.a(this.this$0).setSelection(str2.length());
        QQInputView.a(this.this$0).setEnabled(true);
        QQInputView.a(this.this$0).setSelected(true);
      }
      while (TextUtils.isEmpty(str1)) {
        return;
      }
      QQInputView.a(this.this$0).setHint(str1);
      QQInputView.a(this.this$0).setEnabled(false);
      QQInputView.a(this.this$0).setSelected(false);
      return;
      str2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.QQInputView.1
 * JD-Core Version:    0.7.0.1
 */