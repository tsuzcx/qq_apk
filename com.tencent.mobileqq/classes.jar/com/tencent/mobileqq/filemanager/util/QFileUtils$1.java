package com.tencent.mobileqq.filemanager.util;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class QFileUtils$1
  implements View.OnClickListener
{
  QFileUtils$1(FileManagerUtil.TipsClickedInterface paramTipsClickedInterface) {}
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QFileUtils.1
 * JD-Core Version:    0.7.0.1
 */