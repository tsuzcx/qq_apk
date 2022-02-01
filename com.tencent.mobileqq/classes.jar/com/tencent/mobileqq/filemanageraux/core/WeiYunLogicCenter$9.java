package com.tencent.mobileqq.filemanageraux.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.weiyun.api.IWeiyunCallback;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskDirFileBatchDeleteExMsgRsp;
import com.tencent.qphone.base.util.QLog;

class WeiYunLogicCenter$9
  implements IWeiyunCallback<WeiyunPB.DiskDirFileBatchDeleteExMsgRsp>
{
  WeiYunLogicCenter$9(WeiYunLogicCenter paramWeiYunLogicCenter, WeiYunFileInfo paramWeiYunFileInfo) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.DiskDirFileBatchDeleteExMsgRsp paramDiskDirFileBatchDeleteExMsgRsp)
  {
    if (QLog.isColorLevel())
    {
      paramDiskDirFileBatchDeleteExMsgRsp = new StringBuilder();
      paramDiskDirFileBatchDeleteExMsgRsp.append("deleteWeiYunFile, onFailed  strFileId[");
      paramDiskDirFileBatchDeleteExMsgRsp.append(this.a.a);
      paramDiskDirFileBatchDeleteExMsgRsp.append("]strFileName[");
      paramDiskDirFileBatchDeleteExMsgRsp.append(this.a.c);
      paramDiskDirFileBatchDeleteExMsgRsp.append("]errorCode[");
      paramDiskDirFileBatchDeleteExMsgRsp.append(paramInt);
      paramDiskDirFileBatchDeleteExMsgRsp.append("],errorMsg[");
      paramDiskDirFileBatchDeleteExMsgRsp.append(paramString);
      paramDiskDirFileBatchDeleteExMsgRsp.append("]");
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, paramDiskDirFileBatchDeleteExMsgRsp.toString());
    }
    WeiYunLogicCenter.c(this.b).getFileManagerNotifyCenter().a(false, 20, new Object[] { Integer.valueOf(paramInt), paramString, this.a.a, this.a.c, Boolean.valueOf(false) });
  }
  
  public void a(WeiyunPB.DiskDirFileBatchDeleteExMsgRsp paramDiskDirFileBatchDeleteExMsgRsp)
  {
    if (QLog.isColorLevel())
    {
      paramDiskDirFileBatchDeleteExMsgRsp = new StringBuilder();
      paramDiskDirFileBatchDeleteExMsgRsp.append("deleteWeiYunFile, onSucceed  strFileId[");
      paramDiskDirFileBatchDeleteExMsgRsp.append(this.a.a);
      paramDiskDirFileBatchDeleteExMsgRsp.append("]strFileName[");
      paramDiskDirFileBatchDeleteExMsgRsp.append(this.a.c);
      paramDiskDirFileBatchDeleteExMsgRsp.append("]");
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, paramDiskDirFileBatchDeleteExMsgRsp.toString());
    }
    WeiYunLogicCenter.c(this.b).getFileManagerNotifyCenter().a(true, 20, new Object[] { Integer.valueOf(0), null, this.a.a, this.a.c, Boolean.valueOf(false) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter.9
 * JD-Core Version:    0.7.0.1
 */