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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("remove sender:");
      localStringBuilder.append(this.a.a());
      QLog.i("FileAssistantMgrNDL", 1, localStringBuilder.toString());
      this.a.c();
      this.this$0.a.remove(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantMgr.1
 * JD-Core Version:    0.7.0.1
 */