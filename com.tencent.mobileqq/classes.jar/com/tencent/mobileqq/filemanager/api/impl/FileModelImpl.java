package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.api.IFileModel;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.recreate.IFModel;
import com.tencent.mobileqq.filemanager.recreate.QQFileModel;

public class FileModelImpl
  implements IFileModel
{
  public IFModel newFileModel(MessageForFile paramMessageForFile)
  {
    return QQFileModel.a(paramMessageForFile);
  }
  
  public IFModel newFileModel(FileManagerEntity paramFileManagerEntity)
  {
    return QQFileModel.a(paramFileManagerEntity);
  }
  
  public IFModel newFileModel(String paramString)
  {
    return QQFileModel.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.FileModelImpl
 * JD-Core Version:    0.7.0.1
 */