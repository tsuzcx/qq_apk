package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

class FileManagerEngine$1
  implements Runnable
{
  FileManagerEngine$1(FileManagerEngine paramFileManagerEngine, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, long paramLong, String paramString5) {}
  
  public void run()
  {
    FileManagerUtil.g(this.a);
    if (this.b) {
      this.this$0.a.getFileManagerDataCenter().a(this.c, this.d, true, this.e, 0L, true, this.f, this.g, this.a.msgSeq, this.h, this.a.msgUid, -1L, MessageCache.c());
    }
    if (this.b)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_=k Id[");
      ((StringBuilder)localObject).append(this.a.nSessionId);
      ((StringBuilder)localObject).append("] SendLocalfile[");
      ((StringBuilder)localObject).append(this.a.fileName);
      ((StringBuilder)localObject).append("], peerType[");
      ((StringBuilder)localObject).append(this.a.peerType);
      ((StringBuilder)localObject).append("]");
      QLog.i("FileManagerEngine<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_=k Id[");
      ((StringBuilder)localObject).append(this.a.nSessionId);
      ((StringBuilder)localObject).append("] SendLocalfileToWeiyun[");
      ((StringBuilder)localObject).append(this.a.fileName);
      ((StringBuilder)localObject).append("]");
      QLog.i("FileManagerEngine<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    if (!TextUtils.isEmpty(this.i)) {
      ((Bundle)localObject).putString("emptyPathCallStack", this.i);
    }
    this.this$0.a.getFileManagerRSCenter().a(this.a, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileManagerEngine.1
 * JD-Core Version:    0.7.0.1
 */