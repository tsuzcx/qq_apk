package com.tencent.mobileqq.filemanager.fileassistant.data;

import com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantRecver;
import com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantSender;

public abstract interface FileAssistantResultCallbak
{
  public abstract void a(FileAssistantRecver paramFileAssistantRecver);
  
  public abstract void a(FileAssistantSender paramFileAssistantSender);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.data.FileAssistantResultCallbak
 * JD-Core Version:    0.7.0.1
 */