package com.tencent.mobileqq.filemanager.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileEditBottomBar$2
  implements View.OnClickListener
{
  QfileEditBottomBar$2(QfileEditBottomBar paramQfileEditBottomBar) {}
  
  public void onClick(View paramView)
  {
    QfileEditBottomBar.c(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar.2
 * JD-Core Version:    0.7.0.1
 */