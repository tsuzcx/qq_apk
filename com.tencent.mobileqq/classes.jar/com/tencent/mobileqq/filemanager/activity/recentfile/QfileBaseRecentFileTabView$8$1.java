package com.tencent.mobileqq.filemanager.activity.recentfile;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import java.util.ArrayList;
import java.util.List;

class QfileBaseRecentFileTabView$8$1
  implements FMDialogUtil.FMDialogInterface
{
  QfileBaseRecentFileTabView$8$1(QfileBaseRecentFileTabView.8 param8, FileManagerEntity paramFileManagerEntity) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView$8.a.a.a().aa();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 0) {
      QfileBaseRecentFileTabView.t(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView$8.a).getOnlineFileSessionCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    }
    DataLineHandler localDataLineHandler;
    ArrayList localArrayList;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() != 6) {
        break;
      }
      localDataLineHandler = (DataLineHandler)QfileBaseRecentFileTabView.u(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView$8.a).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq));
    } while (localDataLineHandler.a(localArrayList));
    FMToastUtil.a(2131692601);
    return;
    QfileBaseRecentFileTabView.v(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView$8.a).getFileManagerEngine().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.8.1
 * JD-Core Version:    0.7.0.1
 */