package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.data.FileAssistantResultCallbak;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class FileAssistantSender$2
  extends FMObserver
{
  FileAssistantSender$2(FileAssistantSender paramFileAssistantSender) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (FileAssistantSender.b(this.a).nSessionId != paramLong2) {
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("onFileTransferEnd :");
    paramString1.append(paramLong2);
    paramString1.append(", isSuccess:");
    paramString1.append(paramBoolean);
    QLog.i("FileAssistantSender<FileAssistant>", 1, paramString1.toString());
    paramString1 = this.a;
    boolean bool = false;
    FileAssistantSender.a(paramString1, false);
    if (!paramBoolean)
    {
      paramBoolean = bool;
      if (FileAssistantSender.c(this.a) == null)
      {
        paramBoolean = bool;
        if (FileAssistantSender.a(this.a, paramInt2))
        {
          paramString1 = new StringBuilder();
          paramString1.append("offline failed errCode :");
          paramString1.append(paramInt2);
          QLog.w("FileAssistantSender<FileAssistant>", 1, paramString1.toString());
          FileAssistantSender.b(this.a, true);
          FileAssistantSender.c(this.a, true);
          paramBoolean = true;
        }
      }
      if ((!paramBoolean) && (!FileAssistantSender.d(this.a)))
      {
        paramString1 = new StringBuilder();
        paramString1.append("wlan and offline all failed : ");
        paramString1.append(FileAssistantSender.b(this.a).nSessionId);
        QLog.e("FileAssistantSender<FileAssistant>", 1, paramString1.toString());
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append("wlan workind[");
        paramString1.append(FileAssistantSender.d(this.a));
        paramString1.append("], isNeedStartLan[");
        paramString1.append(paramBoolean);
        paramString1.append("] : ");
        paramString1.append(FileAssistantSender.b(this.a).nSessionId);
        QLog.e("FileAssistantSender<FileAssistant>", 1, paramString1.toString());
        FileAssistantSender.b(this.a).status = 2;
        FileAssistantSender.e(this.a).getFileManagerNotifyCenter().a(FileAssistantSender.b(this.a).uniseq, FileAssistantSender.b(this.a).nSessionId, FileAssistantSender.b(this.a).peerUin, FileAssistantSender.b(this.a).peerType, 16, null, 0, null);
        return;
      }
    }
    paramString1 = (FileAssistantResultCallbak)FileAssistantSender.f(this.a).get();
    if (paramString1 != null) {
      paramString1.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantSender.2
 * JD-Core Version:    0.7.0.1
 */