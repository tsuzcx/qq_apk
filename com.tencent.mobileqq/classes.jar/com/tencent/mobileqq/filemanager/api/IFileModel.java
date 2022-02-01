package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.recreate.IFModel;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IFileModel
  extends QRouteApi
{
  public abstract IFModel newFileModel(MessageForFile paramMessageForFile);
  
  public abstract IFModel newFileModel(FileManagerEntity paramFileManagerEntity);
  
  public abstract IFModel newFileModel(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IFileModel
 * JD-Core Version:    0.7.0.1
 */