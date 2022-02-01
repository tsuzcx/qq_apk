package com.tencent.mobileqq.widget.qus;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QUSDragFloatingScreenView$1
  implements View.OnClickListener
{
  QUSDragFloatingScreenView$1(QUSDragFloatingScreenView paramQUSDragFloatingScreenView) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QUSDragFloatingScreenView", 2, "on empty click");
    }
    if (QUSDragFloatingScreenView.a(this.a) != null) {
      QUSDragFloatingScreenView.a(this.a).i();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qus.QUSDragFloatingScreenView.1
 * JD-Core Version:    0.7.0.1
 */