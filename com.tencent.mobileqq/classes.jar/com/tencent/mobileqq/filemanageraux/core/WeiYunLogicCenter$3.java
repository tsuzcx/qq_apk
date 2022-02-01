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
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = this.a;
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.status = 0;
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.isReaded = false;
    WeiYunLogicCenter.c(this.c).getFileManagerDataCenter().a();
    WeiYunLogicCenter.c(this.c).getFileManagerDataCenter().c(this.a);
    WeiYunLogicCenter.c(this.c).getFileManagerDataCenter().a(this.a.nSessionId, 1005);
    WeiYunLogicCenter.c(this.c).getFileManagerNotifyCenter().a(false, 33, new Object[] { Integer.valueOf(paramInt), paramString, Long.valueOf(this.a.nSessionId) });
    FileManagerUtil.a(WeiYunLogicCenter.c(this.c), this.a.nSessionId, "actFileWy2Of", 0L, "", this.a.peerUin, "", "", paramInt, paramString, 0L, 0L, 0L, "", "", 0, paramString, null);
  }
  
  public void a(WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp paramCrossBidProxyCopyFileToOtherBidMsgRsp)
  {
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = new String(paramCrossBidProxyCopyFileToOtherBidMsgRsp.dst_path.get().toByteArray());
    if (paramCrossBidProxyCopyFileToOtherBidMsgRsp.length() < 1)
    {
      paramCrossBidProxyCopyFileToOtherBidMsgRsp = new StringBuilder();
      paramCrossBidProxyCopyFileToOtherBidMsgRsp.append("=_= ^! [CS Replay]Id[");
      paramCrossBidProxyCopyFileToOtherBidMsgRsp.append(this.a.nSessionId);
      paramCrossBidProxyCopyFileToOtherBidMsgRsp.append("]sendWyFile2Offline onSucceed,But uuid is null!!!");
      QLog.e("WeiYunLogicCenter<FileAssistant>", 2, paramCrossBidProxyCopyFileToOtherBidMsgRsp.toString());
      WeiYunLogicCenter.c(this.c).getFileManagerNotifyCenter().a(false, 33, new Object[] { Integer.valueOf(13), "", Long.valueOf(this.a.nSessionId) });
      FileManagerUtil.a(WeiYunLogicCenter.c(this.c), this.a.nSessionId, "actFileWy2Of", 0L, "", this.a.peerUin, "", this.a.strFileMd5, 9001L, "onSucceed but guid null", 0L, 0L, 0L, "", "", 0, "onSucceed but guid null", null);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= ^ [CS Replay] Id[");
    ((StringBuilder)localObject).append(this.a.nSessionId);
    ((StringBuilder)localObject).append("]sendWyFile2Offline onSucceed, Uuid[");
    ((StringBuilder)localObject).append(paramCrossBidProxyCopyFileToOtherBidMsgRsp);
    ((StringBuilder)localObject).append("]");
    QLog.d("WeiYunLogicCenter<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    localObject = this.a;
    ((FileManagerEntity)localObject).Uuid = paramCrossBidProxyCopyFileToOtherBidMsgRsp;
    ((FileManagerEntity)localObject).setCloudType(1);
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = this.a;
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.status = 1;
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.isReaded = false;
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.bSend = true;
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.fProgress = 0.0F;
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.bOnceSuccess = true;
    WeiYunLogicCenter.c(this.c).getFileManagerDataCenter().a();
    WeiYunLogicCenter.c(this.c).getFileManagerDataCenter().c(this.a);
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = this.a;
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.status = 2;
    FileManagerUtil.b(paramCrossBidProxyCopyFileToOtherBidMsgRsp.nSessionId);
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = new StringBuilder();
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append("=_= ^ [CS Replay]->[CC] Id[");
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append(this.a.nSessionId);
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append("]sendWyFile2Offline onSucceed, entity thumbSize(");
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append(this.a.imgHeight);
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append(":");
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append(this.a.imgWidth);
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append(")");
    QLog.i("WeiYunLogicCenter<FileAssistant>", 2, paramCrossBidProxyCopyFileToOtherBidMsgRsp.toString());
    if (this.b == 3000)
    {
      paramCrossBidProxyCopyFileToOtherBidMsgRsp = new StringBuilder();
      paramCrossBidProxyCopyFileToOtherBidMsgRsp.append("=_= ^ [Disc Feed]sendDiscFileFeed[");
      paramCrossBidProxyCopyFileToOtherBidMsgRsp.append(this.a.nSessionId);
      paramCrossBidProxyCopyFileToOtherBidMsgRsp.append("]");
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, paramCrossBidProxyCopyFileToOtherBidMsgRsp.toString());
      WeiYunLogicCenter.c(this.c).getFileTransferHandler().a(this.a.nSessionId, this.a.peerUin, WeiYunLogicCenter.c(this.c).getCurrentAccountUin(), this.a.fileName, this.a.fileSize, this.a.Uuid, this.a.uniseq, this.a.msgUid, null);
    }
    else
    {
      paramCrossBidProxyCopyFileToOtherBidMsgRsp = this.a.peerUin.replace("+", "");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_= ^ [Offline CC]sendC2COfflineFileMsg[");
      ((StringBuilder)localObject).append(this.a.nSessionId);
      ((StringBuilder)localObject).append("]");
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      WeiYunLogicCenter.c(this.c).getFileTransferHandler().a(paramCrossBidProxyCopyFileToOtherBidMsgRsp, this.a, null);
    }
    WeiYunLogicCenter.c(this.c).getFileManagerNotifyCenter().a(this.a, 8, "");
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = new FileManagerReporter.FileAssistantReportData();
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.b = "send_file_suc";
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.c = 1;
    FileManagerReporter.a(WeiYunLogicCenter.c(this.c).getCurrentAccountUin(), paramCrossBidProxyCopyFileToOtherBidMsgRsp);
    FileManagerUtil.a(WeiYunLogicCenter.c(this.c), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter.3
 * JD-Core Version:    0.7.0.1
 */