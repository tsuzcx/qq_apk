package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileCloudFileTabView$2$1
  implements View.OnClickListener
{
  QfileCloudFileTabView$2$1(QfileCloudFileTabView.2 param2) {}
  
  public void onClick(View paramView)
  {
    QfileCloudFileTabView.a(this.a.a, false);
    this.a.a.h();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.2.1
 * JD-Core Version:    0.7.0.1
 */