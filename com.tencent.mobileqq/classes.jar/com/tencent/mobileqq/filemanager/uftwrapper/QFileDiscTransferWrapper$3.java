package com.tencent.mobileqq.filemanager.uftwrapper;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.GetApkPackageInfoCallback;

class QFileDiscTransferWrapper$3
  implements GetApkPackageInfoCallback
{
  QFileDiscTransferWrapper$3(QFileDiscTransferWrapper paramQFileDiscTransferWrapper, FileManagerEntity paramFileManagerEntity, Runnable paramRunnable) {}
  
  public void a(String paramString1, String paramString2)
  {
    FileManagerEntity localFileManagerEntity = this.a;
    localFileManagerEntity.fileName = paramString1;
    localFileManagerEntity.strApkPackageName = paramString2;
    QFileDiscTransferWrapper.a(this.c).getFileManagerEngine().f().a(paramString2, new QFileDiscTransferWrapper.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.3
 * JD-Core Version:    0.7.0.1
 */