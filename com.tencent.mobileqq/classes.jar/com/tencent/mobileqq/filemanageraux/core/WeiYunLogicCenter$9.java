package com.tencent.mobileqq.filemanageraux.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskDirFileBatchDeleteExMsgRsp;
import cooperation.weiyun.sdk.api.IWeiyunCallback;

class WeiYunLogicCenter$9
  implements IWeiyunCallback<WeiyunPB.DiskDirFileBatchDeleteExMsgRsp>
{
  WeiYunLogicCenter$9(WeiYunLogicCenter paramWeiYunLogicCenter, WeiYunFileInfo paramWeiYunFileInfo) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.DiskDirFileBatchDeleteExMsgRsp paramDiskDirFileBatchDeleteExMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "deleteWeiYunFile, onFailed  strFileId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.a + "]strFileName[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.c + "]errorCode[" + paramInt + "],errorMsg[" + paramString + "]");
    }
    WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter).getFileManagerNotifyCenter().a(false, 20, new Object[] { Integer.valueOf(paramInt), paramString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.a, this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.c, Boolean.valueOf(false) });
  }
  
  public void a(WeiyunPB.DiskDirFileBatchDeleteExMsgRsp paramDiskDirFileBatchDeleteExMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "deleteWeiYunFile, onSucceed  strFileId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.a + "]strFileName[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.c + "]");
    }
    WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter).getFileManagerNotifyCenter().a(true, 20, new Object[] { Integer.valueOf(0), null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.a, this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo.c, Boolean.valueOf(false) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter.9
 * JD-Core Version:    0.7.0.1
 */