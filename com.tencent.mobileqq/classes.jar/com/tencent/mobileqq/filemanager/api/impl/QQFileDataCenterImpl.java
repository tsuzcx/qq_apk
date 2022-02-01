package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import java.util.List;
import mqq.app.AppRuntime;

public class QQFileDataCenterImpl
  implements IQQFileDataCenter
{
  QQAppInterface mApp;
  
  public void insertToFMList(FileManagerEntity paramFileManagerEntity)
  {
    this.mApp.getFileManagerDataCenter().a(paramFileManagerEntity);
  }
  
  public void insertToMemMap(FileManagerEntity paramFileManagerEntity)
  {
    this.mApp.getFileManagerDataCenter().d(paramFileManagerEntity);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      this.mApp = ((QQAppInterface)paramAppRuntime);
    }
  }
  
  public void onDestroy() {}
  
  public FileManagerEntity queryByFileIdForMemory(String paramString)
  {
    return this.mApp.getFileManagerDataCenter().c(paramString);
  }
  
  public FileManagerEntity queryBySessionId(long paramLong)
  {
    return this.mApp.getFileManagerDataCenter().a(paramLong);
  }
  
  public FileManagerEntity queryFileEntity(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    return this.mApp.getFileManagerDataCenter().a(paramLong1, paramString, paramInt, paramLong2);
  }
  
  public List<FileManagerEntity> queryMaxRecentReocrds()
  {
    return this.mApp.getFileManagerProxy().a();
  }
  
  public List<FileManagerEntity> queryMaxRecentReocrdsWithUin(String paramString)
  {
    return this.mApp.getFileManagerProxy().a(paramString);
  }
  
  public void updateFileEntity(FileManagerEntity paramFileManagerEntity)
  {
    this.mApp.getFileManagerDataCenter().c(paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QQFileDataCenterImpl
 * JD-Core Version:    0.7.0.1
 */