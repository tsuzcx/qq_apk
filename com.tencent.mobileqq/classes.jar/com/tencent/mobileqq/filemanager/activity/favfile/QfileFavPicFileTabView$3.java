package com.tencent.mobileqq.filemanager.activity.favfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileFavPicFileTabView$3
  implements View.OnClickListener
{
  QfileFavPicFileTabView$3(QfileFavPicFileTabView paramQfileFavPicFileTabView) {}
  
  public void onClick(View paramView)
  {
    QfileFavPicFileTabView.a(this.a, paramView, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavPicFileTabView.3
 * JD-Core Version:    0.7.0.1
 */