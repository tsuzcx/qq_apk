package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class FileAssistantRecver$1
  extends FMObserver
{
  FileAssistantRecver$1(FileAssistantRecver paramFileAssistantRecver) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (FileAssistantRecver.a(this.a).nSessionId != paramLong2) {
      return;
    }
    if ((FileAssistantRecver.a(this.a).status != 16) && (!paramBoolean) && (!FileAssistantRecver.a(this.a).isStartWlan) && (this.a.a != null))
    {
      paramString1 = new StringBuilder();
      paramString1.append("offline failed errCode :");
      paramString1.append(paramInt2);
      QLog.w("FileAssistantRecver<FileAssistant>.NFRV", 1, paramString1.toString());
      FileAssistantRecver.a(this.a);
      FileAssistantRecver.a(this.a).status = 2;
      return;
    }
    if (paramBoolean)
    {
      if (this.a.a != null) {
        this.a.a.b();
      }
      ThreadManagerV2.executeOnFileThread(new FileAssistantRecver.1.1(this));
    }
    paramString1 = new StringBuilder();
    paramString1.append("onFileTransferEnd :");
    paramString1.append(paramLong2);
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, paramString1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantRecver.1
 * JD-Core Version:    0.7.0.1
 */