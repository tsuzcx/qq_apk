package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileBaseCloudFileTabView$5
  implements View.OnClickListener
{
  QfileBaseCloudFileTabView$5(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseCloudFileTabView.b, 2, "qfilebaserecenttabview del error, tag is null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)paramView.getTag();
      if (localWeiYunFileInfo != null)
      {
        if (this.a.a != null) {
          this.a.a.a(null);
        }
        QfileBaseCloudFileTabView.a(this.a).getFileManagerEngine().a(localWeiYunFileInfo);
      }
      this.a.a.a(Integer.valueOf(-1));
      paramView.setVisibility(4);
      this.a.setListFooter();
      this.a.ao_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.5
 * JD-Core Version:    0.7.0.1
 */