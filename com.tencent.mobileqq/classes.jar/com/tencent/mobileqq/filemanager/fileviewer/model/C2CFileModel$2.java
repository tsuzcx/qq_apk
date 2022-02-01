package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.recreate.FileModel;

class C2CFileModel$2
  implements IUploadController
{
  C2CFileModel$2(C2CFileModel paramC2CFileModel) {}
  
  public void a()
  {
    this.a.a(true, FileModel.a(this.a.a.a()), this.a.c(), new C2CFileModel.2.1(this));
  }
  
  public void b()
  {
    this.a.d();
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getFileManagerEngine().a(this.a.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel.2
 * JD-Core Version:    0.7.0.1
 */