package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileBaseRecentFileTabView$5
  implements View.OnClickListener
{
  QfileBaseRecentFileTabView$5(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    this.a.c.setVisibility(8);
    TencentDocImportFileInfoProcessor.a().a("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.5
 * JD-Core Version:    0.7.0.1
 */