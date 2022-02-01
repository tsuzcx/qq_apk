package com.tencent.mobileqq.utils;

import android.text.Layout;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.mobileqq.text.QQText;

class QQCustomDialog$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  QQCustomDialog$2(QQCustomDialog paramQQCustomDialog, int paramInt, String paramString) {}
  
  public void onGlobalLayout()
  {
    this.this$0.text.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    int i;
    if (this.this$0.text.getLineCount() > this.val$i)
    {
      i = this.this$0.text.getLayout().getLineEnd(this.val$i - 1);
      if (this.val$strText != null) {
        break label134;
      }
    }
    label134:
    for (String str = "";; str = this.val$strText)
    {
      boolean bool1 = QQText.containsEmoji(str);
      boolean bool2 = QQText.containsExpression(str);
      if ((!bool1) && (!bool2))
      {
        str = this.this$0.text.getText().subSequence(0, i - 3) + "...";
        this.this$0.text.setText(str);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialog.2
 * JD-Core Version:    0.7.0.1
 */