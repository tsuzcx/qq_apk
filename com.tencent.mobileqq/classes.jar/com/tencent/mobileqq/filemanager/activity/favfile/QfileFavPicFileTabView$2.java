package com.tencent.mobileqq.filemanager.activity.favfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileFavPicFileTabView$2
  implements View.OnClickListener
{
  QfileFavPicFileTabView$2(QfileFavPicFileTabView paramQfileFavPicFileTabView) {}
  
  public void onClick(View paramView)
  {
    QfileFavPicFileTabView.a(this.a, paramView, true);
    paramView.sendAccessibilityEvent(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavPicFileTabView.2
 * JD-Core Version:    0.7.0.1
 */