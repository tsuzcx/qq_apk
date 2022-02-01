package com.tencent.mobileqq.filemanageraux.core;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.weiyun.api.IWeiyunCallback;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp;
import com.tencent.qphone.base.util.QLog;

class WeiYunLogicCenter$4
  implements IWeiyunCallback<WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp>
{
  WeiYunLogicCenter$4(WeiYunLogicCenter paramWeiYunLogicCenter, TroopFileTransferManager paramTroopFileTransferManager, TroopFileStatusInfo paramTroopFileStatusInfo, FileManagerEntity paramFileManagerEntity) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp paramCrossBidProxyCopyFileToOtherBidMsgRsp)
  {
    if (QLog.isColorLevel())
    {
      paramCrossBidProxyCopyFileToOtherBidMsgRsp = new StringBuilder();
      paramCrossBidProxyCopyFileToOtherBidMsgRsp.append("sendWeiYun2Troop onFailed: errcode[");
      paramCrossBidProxyCopyFileToOtherBidMsgRsp.append(paramInt);
      paramCrossBidProxyCopyFileToOtherBidMsgRsp.append("], errmsg[");
      paramCrossBidProxyCopyFileToOtherBidMsgRsp.append(paramString);
      paramCrossBidProxyCopyFileToOtherBidMsgRsp.append("]");
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, paramCrossBidProxyCopyFileToOtherBidMsgRsp.toString());
    }
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.status = 0;
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.isReaded = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.a, paramInt, null, paramString);
  }
  
  public void a(WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp paramCrossBidProxyCopyFileToOtherBidMsgRsp)
  {
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = new String(paramCrossBidProxyCopyFileToOtherBidMsgRsp.dst_path.get().toByteArray());
    if (paramCrossBidProxyCopyFileToOtherBidMsgRsp.length() < 1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2Troop onSucceed,But uuid is null!!!");
      }
      paramCrossBidProxyCopyFileToOtherBidMsgRsp = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager;
      if (paramCrossBidProxyCopyFileToOtherBidMsgRsp != null) {
        paramCrossBidProxyCopyFileToOtherBidMsgRsp.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.a, -1, null, HardCodeUtil.a(2131716400));
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendWeiYun2Troop onSucceed, Uuid[");
      ((StringBuilder)localObject).append(paramCrossBidProxyCopyFileToOtherBidMsgRsp);
      ((StringBuilder)localObject).append("]");
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager;
    if (localObject != null) {
      ((TroopFileTransferManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.a, 0, paramCrossBidProxyCopyFileToOtherBidMsgRsp, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter.4
 * JD-Core Version:    0.7.0.1
 */