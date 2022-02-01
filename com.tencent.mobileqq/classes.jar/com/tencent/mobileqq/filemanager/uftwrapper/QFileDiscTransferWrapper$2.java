package com.tencent.mobileqq.filemanager.uftwrapper;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.qphone.base.util.QLog;

class QFileDiscTransferWrapper$2
  implements Runnable
{
  QFileDiscTransferWrapper$2(QFileDiscTransferWrapper paramQFileDiscTransferWrapper, FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, String paramString3, long paramLong) {}
  
  public void run()
  {
    FileManagerUtil.g(this.a);
    Object localObject = TransfileUtile.makeTransFileProtocolData(this.b, 0L, 0, true);
    QFileDiscTransferWrapper.a(this.this$0).getFileManagerDataCenter().a(this.c, this.d, true, this.b, 0L, true, 3000, (String)localObject, this.a.msgSeq, this.e, this.a.msgUid, -1L, MessageCache.c());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_=k Id[");
    ((StringBuilder)localObject).append(this.a.nSessionId);
    ((StringBuilder)localObject).append("] SendLocalfile[");
    ((StringBuilder)localObject).append(this.a.fileName);
    ((StringBuilder)localObject).append("], peerType[");
    ((StringBuilder)localObject).append(this.a.peerType);
    ((StringBuilder)localObject).append("]");
    QLog.i("QFileC2CTransferWrapper<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    localObject = QFileDiscTransferWrapper.b(this.this$0, this.a.nSessionId);
    if (localObject != null)
    {
      ((QFileDiscTransferWrapper.DiscBaseUploadWrapper)localObject).b();
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_=k Id[");
    ((StringBuilder)localObject).append(this.a.nSessionId);
    ((StringBuilder)localObject).append("] SendLocalfile fail. may stoped");
    QLog.w("QFileC2CTransferWrapper<FileAssistant>", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.2
 * JD-Core Version:    0.7.0.1
 */