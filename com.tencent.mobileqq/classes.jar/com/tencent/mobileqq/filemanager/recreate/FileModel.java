package com.tencent.mobileqq.filemanager.recreate;

import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.api.IFileModel;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRoute;

public class FileModel
{
  private static IFileModel a()
  {
    return (IFileModel)QRoute.api(IFileModel.class);
  }
  
  public static IFModel a(MessageForFile paramMessageForFile)
  {
    return a().newFileModel(paramMessageForFile);
  }
  
  public static IFModel a(FileManagerEntity paramFileManagerEntity)
  {
    return a().newFileModel(paramFileManagerEntity);
  }
  
  public static IFModel a(String paramString)
  {
    return a().newFileModel(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.recreate.FileModel
 * JD-Core Version:    0.7.0.1
 */