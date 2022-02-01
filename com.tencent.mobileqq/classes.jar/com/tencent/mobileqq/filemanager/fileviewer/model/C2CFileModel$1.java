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
    this.a.a(false, FileModel.a(this.a.a.a()), this.a.c(), new C2CFileModel.1.1(this));
  }
  
  public void b()
  {
    this.a.d();
    int i = this.a.d();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (i == 0)
    {
      localQQAppInterface.getOnlineFileSessionCenter().a(this.a.d());
      return;
    }
    localQQAppInterface.getFileManagerEngine().a(this.a.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel.1
 * JD-Core Version:    0.7.0.1
 */