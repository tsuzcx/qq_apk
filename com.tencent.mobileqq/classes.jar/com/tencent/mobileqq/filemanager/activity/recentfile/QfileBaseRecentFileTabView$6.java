package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.RecentItemHolder;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileBaseRecentFileTabView$6
  implements View.OnClickListener
{
  QfileBaseRecentFileTabView$6(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    RecentItemHolder localRecentItemHolder = (RecentItemHolder)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)localRecentItemHolder.jdField_a_of_type_JavaLangObject;
    if (5 != localFileManagerEntity.cloudType) {
      QQFileManagerUtil.c(localFileManagerEntity);
    }
    int i = localRecentItemHolder.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            this.a.a.a().ac();
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
            {
              FMToastUtil.a(2131692554);
              break label383;
            }
            if (localFileManagerEntity.status == 16)
            {
              FMToastUtil.a(2131692717);
              break label383;
            }
            boolean bool = localFileManagerEntity.isSend();
            ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).doWithWifiChecked(localFileManagerEntity, bool, this.a.a, new QfileBaseRecentFileTabView.6.2(this, localFileManagerEntity));
          }
        }
        else
        {
          this.a.a.a().ab();
          if (localFileManagerEntity.getCloudType() == 0) {
            ((IQQFileEngine)QfileBaseRecentFileTabView.l(this.a).getRuntimeService(IQQFileEngine.class)).pauseOnlineTrans(localFileManagerEntity.nSessionId);
          } else if (localFileManagerEntity.getCloudType() == 6) {
            ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).cancelDatalineFile(localFileManagerEntity);
          } else {
            ((IQQFileEngine)QfileBaseRecentFileTabView.m(this.a).getRuntimeService(IQQFileEngine.class)).pause(localFileManagerEntity.nSessionId);
          }
        }
      }
      else
      {
        this.a.a.a().aa();
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          FMToastUtil.a(2131692554);
          break label383;
        }
        if (localFileManagerEntity.status == 16)
        {
          FMToastUtil.a(2131692717);
          break label383;
        }
        ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).doWithWifiChecked(localFileManagerEntity, false, this.a.getContext(), new QfileBaseRecentFileTabView.6.1(this, localFileManagerEntity));
      }
    }
    else
    {
      this.a.a.a().Z();
      this.a.a(localFileManagerEntity, localRecentItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, false);
    }
    this.a.i();
    label383:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.6
 * JD-Core Version:    0.7.0.1
 */