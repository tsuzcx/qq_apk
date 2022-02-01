package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class FileAssistantMgr$2
  implements Runnable
{
  FileAssistantMgr$2(FileAssistantMgr paramFileAssistantMgr, FileAssistantRecver paramFileAssistantRecver) {}
  
  public void run()
  {
    if (this.a != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("remove recver:");
      localStringBuilder.append(this.a.f());
      QLog.i("FileAssistantMgrNDL", 1, localStringBuilder.toString());
      this.a.b();
      this.this$0.c.remove(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantMgr.2
 * JD-Core Version:    0.7.0.1
 */