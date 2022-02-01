package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;

class FileAssistantSender$4
  implements Runnable
{
  FileAssistantSender$4(FileAssistantSender paramFileAssistantSender, String paramString, FileInfo paramFileInfo) {}
  
  public void run()
  {
    String str = FileAssistantSender.e(this.this$0).getCurrentUin();
    FileManagerUtil.g(FileAssistantSender.b(this.this$0));
    FileAssistantSender.e(this.this$0).getFileManagerDataCenter().a(FileAssistantSender.b(this.this$0));
    FileAssistantSender.e(this.this$0).getFileManagerDataCenter().a(this.a, str, true, this.b.d(), this.b.f(), true, 0, "", FileAssistantSender.b(this.this$0).msgSeq, FileAssistantSender.b(this.this$0).uniseq, FileAssistantSender.b(this.this$0).msgUid, -1L, MessageCache.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantSender.4
 * JD-Core Version:    0.7.0.1
 */