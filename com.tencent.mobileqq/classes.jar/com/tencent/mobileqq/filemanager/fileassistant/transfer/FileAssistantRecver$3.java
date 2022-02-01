package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class FileAssistantRecver$3
  implements Runnable
{
  FileAssistantRecver$3(FileAssistantRecver paramFileAssistantRecver) {}
  
  public void run()
  {
    FileAssistantRecver.a(this.this$0).getFileManagerNotifyCenter().a(FileAssistantRecver.a(this.this$0).uniseq, FileAssistantRecver.a(this.this$0).nSessionId, FileAssistantRecver.a(this.this$0).peerUin, FileAssistantRecver.a(this.this$0).peerType, 12, null, 6, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantRecver.3
 * JD-Core Version:    0.7.0.1
 */