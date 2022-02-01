package com.tencent.mobileqq.troop.filemanager;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager;
import com.tencent.mobileqq.filemanager.util.GetApkPackageInfoCallback;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;

class TroopFileTransferMgr$3
  implements GetApkPackageInfoCallback
{
  TroopFileTransferMgr$3(TroopFileTransferMgr paramTroopFileTransferMgr, TroopFileTransferManager.Item paramItem) {}
  
  public void a(String paramString1, String paramString2)
  {
    TroopFileTransferMgr.f(this.b).getFileManagerEngine().f().a(paramString2, new TroopFileTransferMgr.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr.3
 * JD-Core Version:    0.7.0.1
 */