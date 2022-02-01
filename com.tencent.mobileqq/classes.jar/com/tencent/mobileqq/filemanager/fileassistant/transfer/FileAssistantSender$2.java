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
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (FileAssistantSender.a(this.a).nSessionId != paramLong2) {}
    do
    {
      return;
      QLog.i("FileAssistantSender<FileAssistant>", 1, "onFileTransferEnd :" + paramLong2 + ", isSuccess:" + paramBoolean);
      FileAssistantSender.a(this.a, false);
      if (!paramBoolean)
      {
        boolean bool = false;
        paramBoolean = bool;
        if (FileAssistantSender.a(this.a) == null)
        {
          paramBoolean = bool;
          if (FileAssistantSender.a(this.a, paramInt2))
          {
            QLog.w("FileAssistantSender<FileAssistant>", 1, "offline failed errCode :" + paramInt2);
            FileAssistantSender.b(this.a, true);
            FileAssistantSender.a(this.a, true);
            paramBoolean = true;
          }
        }
        if ((paramBoolean) || (FileAssistantSender.a(this.a)))
        {
          QLog.e("FileAssistantSender<FileAssistant>", 1, "wlan workind[" + FileAssistantSender.a(this.a) + "], isNeedStartLan[" + paramBoolean + "] : " + FileAssistantSender.a(this.a).nSessionId);
          FileAssistantSender.a(this.a).status = 2;
          FileAssistantSender.a(this.a).getFileManagerNotifyCenter().a(FileAssistantSender.a(this.a).uniseq, FileAssistantSender.a(this.a).nSessionId, FileAssistantSender.a(this.a).peerUin, FileAssistantSender.a(this.a).peerType, 16, null, 0, null);
          return;
        }
        QLog.e("FileAssistantSender<FileAssistant>", 1, "wlan and offline all failed : " + FileAssistantSender.a(this.a).nSessionId);
      }
      paramString1 = (FileAssistantResultCallbak)FileAssistantSender.a(this.a).get();
    } while (paramString1 == null);
    paramString1.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantSender.2
 * JD-Core Version:    0.7.0.1
 */