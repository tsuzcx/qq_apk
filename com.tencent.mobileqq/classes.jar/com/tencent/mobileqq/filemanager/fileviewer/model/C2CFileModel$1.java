package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.recreate.FileModel;

class C2CFileModel$1
  implements IDownloadController
{
  C2CFileModel$1(C2CFileModel paramC2CFileModel) {}
  
  public void a()
  {
    C2CFileModel localC2CFileModel = this.a;
    localC2CFileModel.a(false, FileModel.a(localC2CFileModel.c.r()), this.a.x(), new C2CFileModel.1.1(this));
  }
  
  public void b()
  {
    this.a.o();
    int i = this.a.w();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (i == 0)
    {
      localQQAppInterface.getOnlineFileSessionCenter().c(this.a.C());
      return;
    }
    localQQAppInterface.getFileManagerEngine().a(this.a.c.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel.1
 * JD-Core Version:    0.7.0.1
 */