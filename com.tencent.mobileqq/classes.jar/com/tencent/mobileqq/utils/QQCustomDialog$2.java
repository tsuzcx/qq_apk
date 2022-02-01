package com.tencent.mobileqq.utils;

import android.text.Layout;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

class QQCustomDialog$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  QQCustomDialog$2(QQCustomDialog paramQQCustomDialog, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onGlobalLayout()
  {
    this.e.text.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    if (this.e.text.getLineCount() > this.a)
    {
      int i = this.e.text.getLayout().getLineEnd(this.a - 1);
      Object localObject = this.b;
      if ((!this.c) && (!this.d))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.e.text.getText().subSequence(0, i - 3));
        ((StringBuilder)localObject).append("...");
        localObject = ((StringBuilder)localObject).toString();
        this.e.text.setText((CharSequence)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialog.2
 * JD-Core Version:    0.7.0.1
 */