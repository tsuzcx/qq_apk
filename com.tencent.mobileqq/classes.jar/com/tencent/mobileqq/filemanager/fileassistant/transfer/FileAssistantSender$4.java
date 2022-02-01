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
    String str = FileAssistantSender.a(this.this$0).getCurrentUin();
    FileManagerUtil.c(FileAssistantSender.a(this.this$0));
    FileAssistantSender.a(this.this$0).getFileManagerDataCenter().a(FileAssistantSender.a(this.this$0));
    FileAssistantSender.a(this.this$0).getFileManagerDataCenter().a(this.jdField_a_of_type_JavaLangString, str, true, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.a(), true, 0, "", FileAssistantSender.a(this.this$0).msgSeq, FileAssistantSender.a(this.this$0).uniseq, FileAssistantSender.a(this.this$0).msgUid, -1L, MessageCache.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantSender.4
 * JD-Core Version:    0.7.0.1
 */