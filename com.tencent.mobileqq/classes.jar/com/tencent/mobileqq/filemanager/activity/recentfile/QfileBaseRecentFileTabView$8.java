package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileBaseRecentFileTabView$8
  implements View.OnClickListener
{
  QfileBaseRecentFileTabView$8(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    QfileRecentFileBaseExpandableListAdapter.RecentItemHolder localRecentItemHolder = (QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)localRecentItemHolder.jdField_a_of_type_JavaLangObject;
    if (5 != localFileManagerEntity.cloudType) {
      FileManagerUtil.b(localFileManagerEntity);
    }
    switch (localRecentItemHolder.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.a.i();
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.a.a.a().aa();
        if (!NetworkUtil.d(BaseApplication.getContext()))
        {
          FMToastUtil.a(2131692602);
        }
        else if (localFileManagerEntity.status == 16)
        {
          FMToastUtil.a(2131692760);
        }
        else
        {
          FileModel.a(localFileManagerEntity).a(false, this.a.getContext(), new QfileBaseRecentFileTabView.8.1(this, localFileManagerEntity));
          break;
          this.a.a.a().Z();
          this.a.a(localFileManagerEntity, localRecentItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, false);
          break;
          this.a.a.a().ab();
          if (localFileManagerEntity.getCloudType() == 0)
          {
            QfileBaseRecentFileTabView.w(this.a).getOnlineFileSessionCenter().a(localFileManagerEntity.nSessionId);
            break;
          }
          if (localFileManagerEntity.getCloudType() == 6)
          {
            ((DataLineHandler)QfileBaseRecentFileTabView.x(this.a).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(0, localFileManagerEntity.uniseq, false);
            break;
          }
          QfileBaseRecentFileTabView.y(this.a).getFileManagerEngine().a(localFileManagerEntity.nSessionId);
          break;
          this.a.a.a().ac();
          if (!NetworkUtil.d(BaseApplication.getContext()))
          {
            FMToastUtil.a(2131692602);
          }
          else
          {
            if (localFileManagerEntity.status != 16) {
              break label345;
            }
            FMToastUtil.a(2131692760);
          }
        }
      }
      label345:
      boolean bool = localFileManagerEntity.isSend();
      FileModel.a(localFileManagerEntity).a(bool, this.a.a, new QfileBaseRecentFileTabView.8.2(this, localFileManagerEntity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.8
 * JD-Core Version:    0.7.0.1
 */