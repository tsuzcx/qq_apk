package com.tencent.mobileqq.filemanager.excitingtransfer.upload;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class ExtFileAssistOfflineSendWorker
  extends ExtfOfflineSendWorker
{
  public ExtFileAssistOfflineSendWorker(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface, paramFileManagerEntity);
    a(false);
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.upload.ExtFileAssistOfflineSendWorker
 * JD-Core Version:    0.7.0.1
 */