package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileBaseCloudFileTabView$10$1
  implements View.OnClickListener
{
  QfileBaseCloudFileTabView$10$1(QfileBaseCloudFileTabView.10 param10, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof ImageHolder))
    {
      localObject = (WeiYunFileInfo)((ImageHolder)this.jdField_a_of_type_AndroidViewView.getTag()).a;
      if ((FMDataCache.a(((WeiYunFileInfo)localObject).a)) && (QLog.isColorLevel())) {
        QLog.d(QfileBaseCloudFileTabView.b, 2, "there is a bug ");
      }
      QfileBaseCloudFileTabView.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileBaseCloudFileTabView$10.a).getFileManagerEngine().a((WeiYunFileInfo)localObject);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileBaseCloudFileTabView$10.a.ao_();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof QfileCloudFileBaseExpandableListAdapter.CloudItemHolder))
      {
        localObject = (WeiYunFileInfo)((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)this.jdField_a_of_type_AndroidViewView.getTag()).a;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseCloudFileTabView.b, 2, "unknow Object");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.10.1
 * JD-Core Version:    0.7.0.1
 */