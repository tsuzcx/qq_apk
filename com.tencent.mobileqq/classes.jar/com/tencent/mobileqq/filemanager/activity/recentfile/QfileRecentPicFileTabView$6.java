package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileRecentPicFileTabView$6
  implements View.OnClickListener
{
  QfileRecentPicFileTabView$6(QfileRecentPicFileTabView paramQfileRecentPicFileTabView) {}
  
  public void onClick(View paramView)
  {
    QfileRecentPicFileTabView.a(this.a, paramView, true);
    paramView.sendAccessibilityEvent(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView.6
 * JD-Core Version:    0.7.0.1
 */