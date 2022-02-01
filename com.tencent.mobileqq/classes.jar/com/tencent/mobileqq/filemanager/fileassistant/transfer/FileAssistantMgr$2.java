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
      QLog.i("FileAssistantMgrNDL", 1, "remove recver:" + this.a.a());
      this.a.b();
      this.this$0.b.remove(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantMgr.2
 * JD-Core Version:    0.7.0.1
 */