package com.tencent.mobileqq.utils.dialogutils;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomMenuNoIconLayout$2
  implements View.OnClickListener
{
  QQCustomMenuNoIconLayout$2(QQCustomMenuNoIconLayout paramQQCustomMenuNoIconLayout, boolean paramBoolean, int paramInt) {}
  
  public void onClick(View paramView)
  {
    QQCustomMenuNoIconLayout localQQCustomMenuNoIconLayout = this.c;
    int i;
    if (this.a) {
      i = QQCustomMenuNoIconLayout.b(localQQCustomMenuNoIconLayout);
    } else {
      i = QQCustomMenuNoIconLayout.c(localQQCustomMenuNoIconLayout);
    }
    QQCustomMenuNoIconLayout.a(localQQCustomMenuNoIconLayout, localQQCustomMenuNoIconLayout.a(i), true);
    if (QQCustomMenuNoIconLayout.a(this.c) != null) {
      QQCustomMenuNoIconLayout.a(this.c).b(this.b, this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout.2
 * JD-Core Version:    0.7.0.1
 */