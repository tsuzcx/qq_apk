package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class FileAssistantMgr$1
  implements Runnable
{
  FileAssistantMgr$1(FileAssistantMgr paramFileAssistantMgr, FileAssistantSender paramFileAssistantSender) {}
  
  public void run()
  {
    if (this.a != null)
    {
      QLog.i("FileAssistantMgrNDL", 1, "remove sender:" + this.a.a());
      this.a.c();
      this.this$0.a.remove(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantMgr.1
 * JD-Core Version:    0.7.0.1
 */