package com.tencent.mobileqq.utils.dialogutils;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;

class QQCustomMenuNoIconLayout$3
  implements View.OnClickListener
{
  QQCustomMenuNoIconLayout$3(QQCustomMenuNoIconLayout paramQQCustomMenuNoIconLayout, int paramInt, QQCustomMenuItem paramQQCustomMenuItem) {}
  
  public void onClick(View paramView)
  {
    if (QQCustomMenuNoIconLayout.d(this.c) != null) {
      QQCustomMenuNoIconLayout.d(this.c).onClick(paramView);
    }
    QQCustomMenuNoIconLayout.e(this.c).dismiss();
    if (QQCustomMenuNoIconLayout.a(this.c) != null) {
      QQCustomMenuNoIconLayout.a(this.c).a(this.a, this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout.3
 * JD-Core Version:    0.7.0.1
 */