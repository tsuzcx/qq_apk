package com.tencent.mobileqq.widget;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class FormEditItem$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  FormEditItem$1(FormEditItem paramFormEditItem) {}
  
  public void onGlobalLayout()
  {
    this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    FormEditItem.a(this.a, this.a.getMeasuredWidth());
    FormEditItem.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormEditItem.1
 * JD-Core Version:    0.7.0.1
 */