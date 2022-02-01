package com.tencent.mobileqq.filemanager.core;

import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class FileManagerNotifyCenter$1
  extends MqqHandler
{
  FileManagerNotifyCenter$1(FileManagerNotifyCenter paramFileManagerNotifyCenter, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 10001) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerNotifyCenter<FileAssistant>", 1, "recv Netchang event!");
    }
    this.a.a.getFileManagerRSCenter().a(true);
    this.a.a.getOnlineFileSessionCenter().b(-1);
    FileVideoDownloadManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter.1
 * JD-Core Version:    0.7.0.1
 */