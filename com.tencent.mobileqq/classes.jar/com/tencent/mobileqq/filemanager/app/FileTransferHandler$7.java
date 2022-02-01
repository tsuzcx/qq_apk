package com.tencent.mobileqq.filemanager.app;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.proto.FMTransC2CMsgInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.resv21.hummer_resv_21.FileImgInfo;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.MsgBody;

class FileTransferHandler$7
  implements Runnable
{
  FileTransferHandler$7(FileTransferHandler paramFileTransferHandler, FileManagerEntity paramFileManagerEntity, hummer_resv_21.FileImgInfo paramFileImgInfo, SubMsgType0x4.MsgBody paramMsgBody, FileTransferObserver paramFileTransferObserver, Handler paramHandler, String paramString) {}
  
  public void run()
  {
    FileManagerUtil.n(this.a);
    if ((this.a.imgHeight > 0) && (this.a.imgWidth > 0))
    {
      this.b.uint32_file_height.set(this.a.imgHeight);
      this.b.uint32_file_width.set(this.a.imgWidth);
      this.c.file_image_info.set(this.b);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Id[");
      ((StringBuilder)localObject1).append(this.a.nSessionId);
      ((StringBuilder)localObject1).append("]Send CCMsg, setThumbSize height[");
      ((StringBuilder)localObject1).append(this.a.imgHeight);
      ((StringBuilder)localObject1).append("], width[");
      ((StringBuilder)localObject1).append(this.a.imgWidth);
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileTransferHandler<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
    }
    else if ((!FileManagerUtil.b(this.a)) && ((this.a.nFileType == 0) || (this.a.nFileType == 2)))
    {
      new Handler(Looper.getMainLooper()).postDelayed(new FileTransferHandler.7.1(this), 1000L);
    }
    Object localObject1 = this.c.toByteArray();
    FMTransC2CMsgInfo localFMTransC2CMsgInfo = new FMTransC2CMsgInfo();
    localFMTransC2CMsgInfo.busiType = 1028;
    localFMTransC2CMsgInfo.uuid = this.a.Uuid;
    localFMTransC2CMsgInfo.uniseq = this.a.uniseq;
    localFMTransC2CMsgInfo.fileTransferObserver = this.d;
    localFMTransC2CMsgInfo.msgSeq = this.a.msgSeq;
    localFMTransC2CMsgInfo.msgUid = this.a.msgUid;
    localFMTransC2CMsgInfo.sessionId = this.a.nSessionId;
    Object localObject2 = this.a;
    localFMTransC2CMsgInfo.entity = ((FileManagerEntity)localObject2);
    ((FileManagerEntity)localObject2).bOnceSuccess = true;
    ((FileManagerEntity)localObject2).strQRUrl = FileManagerUtil.r((FileManagerEntity)localObject2);
    this.this$0.a.getFileManagerDataCenter().c(this.a);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("=_= ^> [Send CC]send offline CC [");
    ((StringBuilder)localObject2).append(this.a.nSessionId);
    ((StringBuilder)localObject2).append("], 0x211, 0x4");
    QLog.i("FileTransferHandler<FileAssistant>", 2, ((StringBuilder)localObject2).toString());
    this.e.post(new FileTransferHandler.7.2(this, (byte[])localObject1, localFMTransC2CMsgInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.7
 * JD-Core Version:    0.7.0.1
 */