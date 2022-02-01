package com.tencent.mobileqq.filemanager.uftwrapper;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.GetApkPackageInfoCallback;

class QFileC2CTransferWrapper$3
  implements GetApkPackageInfoCallback
{
  QFileC2CTransferWrapper$3(QFileC2CTransferWrapper paramQFileC2CTransferWrapper, FileManagerEntity paramFileManagerEntity, Runnable paramRunnable) {}
  
  public void a(String paramString1, String paramString2)
  {
    FileManagerEntity localFileManagerEntity = this.a;
    localFileManagerEntity.fileName = paramString1;
    localFileManagerEntity.strApkPackageName = paramString2;
    QFileC2CTransferWrapper.a(this.c).getFileManagerEngine().f().a(paramString2, new QFileC2CTransferWrapper.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper.3
 * JD-Core Version:    0.7.0.1
 */