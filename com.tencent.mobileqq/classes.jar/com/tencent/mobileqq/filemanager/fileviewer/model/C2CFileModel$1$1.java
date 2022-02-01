package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

class C2CFileModel$1$1
  implements FMDialogUtil.FMDialogInterface
{
  C2CFileModel$1$1(C2CFileModel.1 param1) {}
  
  public void a()
  {
    int i = this.a.a.i();
    int j = this.a.a.d();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (i == 6) {
      if (j == 0) {
        localQQAppInterface.getOnlineFileSessionCenter().b(this.a.a.d());
      }
    }
    for (;;)
    {
      if (this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null) {
        this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.d();
      }
      return;
      localQQAppInterface.getFileManagerEngine().a(this.a.a.d());
      continue;
      if (j == 0) {
        localQQAppInterface.getOnlineFileSessionCenter().a(this.a.a.d());
      } else {
        localQQAppInterface.getFileManagerEngine().c(this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel.1.1
 * JD-Core Version:    0.7.0.1
 */