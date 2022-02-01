package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileBaseCloudFileTabView$5
  implements View.OnClickListener
{
  QfileBaseCloudFileTabView$5(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseCloudFileTabView.c, 2, "qfilebaserecenttabview del error, tag is null");
      }
    }
    else
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)paramView.getTag();
      if (localWeiYunFileInfo != null)
      {
        if (this.a.j != null) {
          this.a.j.a(null);
        }
        ((IQQFileEngine)QfileBaseCloudFileTabView.a(this.a).getRuntimeService(IQQFileEngine.class, "")).deleteWeiYunFile(localWeiYunFileInfo);
      }
      this.a.j.a(Integer.valueOf(-1));
      paramView.setVisibility(4);
      this.a.setListFooter();
      this.a.cg_();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.5
 * JD-Core Version:    0.7.0.1
 */