package com.tencent.mobileqq.troop.filemanager;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.IGetAppDetailCallback;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileTroopTransferWrapper;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.appinfo.data.AppDetail;

class TroopFileTransferMgr$3$1
  implements QFileAppStorePromoteManager.IGetAppDetailCallback
{
  TroopFileTransferMgr$3$1(TroopFileTransferMgr.3 param3) {}
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("waterTest, onGetAppDetailTimeLimit. apkName[");
    localStringBuilder.append(this.a.a.yybApkName);
    localStringBuilder.append("]");
    QLog.i("TroopFileTransferMgr", 1, localStringBuilder.toString());
    if (NetworkUtil.getSystemNetwork(BaseApplication.getContext()) == 0) {
      this.a.b.a(this.a.a, 3, 106);
    }
    TroopFileTransferMgr.e(this.a.b).getFileManagerEngine().m().a(TroopFileTransferMgr.d(this.a.b), this.a.a, null);
  }
  
  public void a(boolean paramBoolean, AppDetail paramAppDetail)
  {
    this.a.a.yybApkPackageName = paramAppDetail.packageName;
    this.a.a.yybApkName = paramAppDetail.appName;
    this.a.a.yybApkIconUrl = paramAppDetail.iconUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr.3.1
 * JD-Core Version:    0.7.0.1
 */