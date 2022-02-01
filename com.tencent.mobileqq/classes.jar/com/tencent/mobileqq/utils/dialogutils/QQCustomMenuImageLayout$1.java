package com.tencent.mobileqq.utils.dialogutils;

import android.content.Context;
import android.widget.TextView;
import com.tencent.widget.BubblePopupWindow;

class QQCustomMenuImageLayout$1
  extends TextView
{
  QQCustomMenuImageLayout$1(QQCustomMenuImageLayout paramQQCustomMenuImageLayout, Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean performClick()
  {
    boolean bool = super.performClick();
    QQCustomMenuImageLayout.a(this.a).a();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuImageLayout.1
 * JD-Core Version:    0.7.0.1
 */