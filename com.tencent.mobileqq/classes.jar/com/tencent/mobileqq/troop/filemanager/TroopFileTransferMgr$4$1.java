package com.tencent.mobileqq.troop.filemanager;

import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.IGetAppDetailCallback;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.appinfo.data.AppDetail;

class TroopFileTransferMgr$4$1
  implements QFileAppStorePromoteManager.IGetAppDetailCallback
{
  TroopFileTransferMgr$4$1(TroopFileTransferMgr.4 param4) {}
  
  public void a()
  {
    QLog.i("TroopFileTransferMgr", 1, "waterTest, onGetAppDetailTimeLimit. apkName[" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.yybApkName + "]");
    if (NetworkUtil.a(BaseApplication.getContext()) == 0) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferMgr.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 3, 106);
    }
    TroopFileUploadMgr.a().a(TroopFileTransferMgr.e(this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferMgr), this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, null);
  }
  
  public void a(boolean paramBoolean, AppDetail paramAppDetail)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.yybApkPackageName = paramAppDetail.packageName;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.yybApkName = paramAppDetail.appName;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.yybApkIconUrl = paramAppDetail.iconUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr.4.1
 * JD-Core Version:    0.7.0.1
 */