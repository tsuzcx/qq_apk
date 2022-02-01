package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.GetApkPackageInfoCallback;

class FileManagerEngine$2
  implements GetApkPackageInfoCallback
{
  FileManagerEngine$2(FileManagerEngine paramFileManagerEngine, FileManagerEntity paramFileManagerEntity, Runnable paramRunnable) {}
  
  public void a(String paramString1, String paramString2)
  {
    FileManagerEntity localFileManagerEntity = this.a;
    localFileManagerEntity.fileName = paramString1;
    localFileManagerEntity.strApkPackageName = paramString2;
    this.c.a.getFileManagerEngine().f().a(paramString2, new FileManagerEngine.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileManagerEngine.2
 * JD-Core Version:    0.7.0.1
 */