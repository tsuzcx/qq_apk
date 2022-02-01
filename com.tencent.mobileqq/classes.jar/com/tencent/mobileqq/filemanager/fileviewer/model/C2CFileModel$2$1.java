package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

class C2CFileModel$2$1
  implements FMDialogUtil.FMDialogInterface
{
  C2CFileModel$2$1(C2CFileModel.2 param2) {}
  
  public void a()
  {
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getFileManagerEngine().a(this.a.a.d());
    if (this.a.a.a != null) {
      this.a.a.a.d();
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel.2.1
 * JD-Core Version:    0.7.0.1
 */