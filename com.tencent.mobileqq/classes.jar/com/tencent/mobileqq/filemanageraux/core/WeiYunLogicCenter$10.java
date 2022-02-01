package com.tencent.mobileqq.filemanageraux.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.weiyun.api.IWeiyunCallback;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskFileDocDownloadAbsMsgRsp;
import com.tencent.mobileqq.weiyun.utils.StringUtils;
import com.tencent.qphone.base.util.QLog;

class WeiYunLogicCenter$10
  implements IWeiyunCallback<WeiyunPB.DiskFileDocDownloadAbsMsgRsp>
{
  WeiYunLogicCenter$10(WeiYunLogicCenter paramWeiYunLogicCenter) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.DiskFileDocDownloadAbsMsgRsp paramDiskFileDocDownloadAbsMsgRsp)
  {
    if (QLog.isColorLevel())
    {
      paramDiskFileDocDownloadAbsMsgRsp = new StringBuilder();
      paramDiskFileDocDownloadAbsMsgRsp.append("get weiyun file PreviewAddress onFailed,errCode[");
      paramDiskFileDocDownloadAbsMsgRsp.append(paramInt);
      paramDiskFileDocDownloadAbsMsgRsp.append("],errMsg[");
      paramDiskFileDocDownloadAbsMsgRsp.append(paramString);
      paramDiskFileDocDownloadAbsMsgRsp.append("]");
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, paramDiskFileDocDownloadAbsMsgRsp.toString());
    }
    WeiYunLogicCenter.a(this.a).getFileManagerNotifyCenter().a(false, 278, new Object[] { Integer.valueOf(paramInt), paramString, "", "", "", "", Integer.valueOf(0) });
  }
  
  public void a(WeiyunPB.DiskFileDocDownloadAbsMsgRsp paramDiskFileDocDownloadAbsMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "get weiyun file PreviewAddress onSucceed");
    }
    String str = StringUtils.a(paramDiskFileDocDownloadAbsMsgRsp.downloadkey.get());
    WeiYunLogicCenter.a(this.a).getFileManagerNotifyCenter().a(true, 278, new Object[] { Integer.valueOf(0), "", str, paramDiskFileDocDownloadAbsMsgRsp.cookie.get(), paramDiskFileDocDownloadAbsMsgRsp.downloadip.get(), paramDiskFileDocDownloadAbsMsgRsp.downloaddns.get(), Integer.valueOf(paramDiskFileDocDownloadAbsMsgRsp.downloadport.get()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter.10
 * JD-Core Version:    0.7.0.1
 */