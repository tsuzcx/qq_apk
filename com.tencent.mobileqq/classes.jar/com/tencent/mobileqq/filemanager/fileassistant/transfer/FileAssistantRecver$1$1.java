package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

class FileAssistantRecver$1$1
  implements Runnable
{
  FileAssistantRecver$1$1(FileAssistantRecver.1 param1) {}
  
  public void run()
  {
    FileAssistantRecver.a(this.a.a).status = 1;
    FileManagerUtil.g(FileAssistantRecver.a(this.a.a));
    FileAssistantRecver.c(this.a.a).getFileManagerDataCenter().c(FileAssistantRecver.a(this.a.a));
    FileAssistantRecver.c(this.a.a).getFileManagerNotifyCenter().a(true, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantRecver.1.1
 * JD-Core Version:    0.7.0.1
 */