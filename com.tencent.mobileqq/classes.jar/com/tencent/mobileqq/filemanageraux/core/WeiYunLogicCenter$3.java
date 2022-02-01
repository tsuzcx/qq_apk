package com.tencent.mobileqq.filemanageraux.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.weiyun.api.IWeiyunCallback;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp;
import com.tencent.qphone.base.util.QLog;

class WeiYunLogicCenter$3
  implements IWeiyunCallback<WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp>
{
  WeiYunLogicCenter$3(WeiYunLogicCenter paramWeiYunLogicCenter, FileManagerEntity paramFileManagerEntity, int paramInt) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp paramCrossBidProxyCopyFileToOtherBidMsgRsp)
  {
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = new StringBuilder();
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append("sendWyFile2QqOffline onFailed: errcode[");
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append(paramInt);
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append("], errmsg[");
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append(paramString);
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append("]");
    QLog.i("WeiYunLogicCenter<FileAssistant>", 2, paramCrossBidProxyCopyFileToOtherBidMsgRsp.toString());
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.status = 0;
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.isReaded = false;
    WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter).getFileManagerDataCenter().a();
    WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter).getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter).getFileManagerDataCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, 1005);
    WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter).getFileManagerNotifyCenter().a(false, 33, new Object[] { Integer.valueOf(paramInt), paramString, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) });
    FileManagerUtil.a(WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileWy2Of", 0L, "", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, "", "", paramInt, paramString, 0L, 0L, 0L, "", "", 0, paramString, null);
  }
  
  public void a(WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp paramCrossBidProxyCopyFileToOtherBidMsgRsp)
  {
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = new String(paramCrossBidProxyCopyFileToOtherBidMsgRsp.dst_path.get().toByteArray());
    if (paramCrossBidProxyCopyFileToOtherBidMsgRsp.length() < 1)
    {
      paramCrossBidProxyCopyFileToOtherBidMsgRsp = new StringBuilder();
      paramCrossBidProxyCopyFileToOtherBidMsgRsp.append("=_= ^! [CS Replay]Id[");
      paramCrossBidProxyCopyFileToOtherBidMsgRsp.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      paramCrossBidProxyCopyFileToOtherBidMsgRsp.append("]sendWyFile2Offline onSucceed,But uuid is null!!!");
      QLog.e("WeiYunLogicCenter<FileAssistant>", 2, paramCrossBidProxyCopyFileToOtherBidMsgRsp.toString());
      WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter).getFileManagerNotifyCenter().a(false, 33, new Object[] { Integer.valueOf(13), "", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) });
      FileManagerUtil.a(WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileWy2Of", 0L, "", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, "", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9001L, "onSucceed but guid null", 0L, 0L, 0L, "", "", 0, "onSucceed but guid null", null);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= ^ [CS Replay] Id[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    ((StringBuilder)localObject).append("]sendWyFile2Offline onSucceed, Uuid[");
    ((StringBuilder)localObject).append(paramCrossBidProxyCopyFileToOtherBidMsgRsp);
    ((StringBuilder)localObject).append("]");
    QLog.d("WeiYunLogicCenter<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    ((FileManagerEntity)localObject).Uuid = paramCrossBidProxyCopyFileToOtherBidMsgRsp;
    ((FileManagerEntity)localObject).setCloudType(1);
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.status = 1;
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.isReaded = false;
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.bSend = true;
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.fProgress = 0.0F;
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.bOnceSuccess = true;
    WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter).getFileManagerDataCenter().a();
    WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter).getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.status = 2;
    FileManagerUtil.b(paramCrossBidProxyCopyFileToOtherBidMsgRsp.nSessionId);
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = new StringBuilder();
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append("=_= ^ [CS Replay]->[CC] Id[");
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append("]sendWyFile2Offline onSucceed, entity thumbSize(");
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight);
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append(":");
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth);
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append(")");
    QLog.i("WeiYunLogicCenter<FileAssistant>", 2, paramCrossBidProxyCopyFileToOtherBidMsgRsp.toString());
    if (this.jdField_a_of_type_Int == 3000)
    {
      paramCrossBidProxyCopyFileToOtherBidMsgRsp = new StringBuilder();
      paramCrossBidProxyCopyFileToOtherBidMsgRsp.append("=_= ^ [Disc Feed]sendDiscFileFeed[");
      paramCrossBidProxyCopyFileToOtherBidMsgRsp.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      paramCrossBidProxyCopyFileToOtherBidMsgRsp.append("]");
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, paramCrossBidProxyCopyFileToOtherBidMsgRsp.toString());
      WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter).getFileTransferHandler().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgUid, null);
    }
    else
    {
      paramCrossBidProxyCopyFileToOtherBidMsgRsp = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin.replace("+", "");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_= ^ [Offline CC]sendC2COfflineFileMsg[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      ((StringBuilder)localObject).append("]");
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter).getFileTransferHandler().a(paramCrossBidProxyCopyFileToOtherBidMsgRsp, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, null);
    }
    WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter).getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 8, "");
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = new FileManagerReporter.FileAssistantReportData();
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.b = "send_file_suc";
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.jdField_a_of_type_Int = 1;
    FileManagerReporter.a(WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter).getCurrentAccountUin(), paramCrossBidProxyCopyFileToOtherBidMsgRsp);
    FileManagerUtil.a(WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter.3
 * JD-Core Version:    0.7.0.1
 */