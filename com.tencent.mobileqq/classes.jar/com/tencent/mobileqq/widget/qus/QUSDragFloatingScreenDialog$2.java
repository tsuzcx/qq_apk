package com.tencent.mobileqq.widget.qus;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QUSDragFloatingScreenDialog$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qus.QUSDragFloatingScreenDialog.2
 * JD-Core Version:    0.7.0.1
 */