package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IQQFileDataCenter
  extends IRuntimeService
{
  public abstract void insertToFMList(FileManagerEntity paramFileManagerEntity);
  
  public abstract void insertToMemMap(FileManagerEntity paramFileManagerEntity);
  
  public abstract FileManagerEntity queryByFileIdForMemory(String paramString);
  
  public abstract FileManagerEntity queryBySessionId(long paramLong);
  
  public abstract FileManagerEntity queryFileEntity(long paramLong1, String paramString, int paramInt, long paramLong2);
  
  public abstract List<FileManagerEntity> queryMaxRecentReocrds();
  
  public abstract List<FileManagerEntity> queryMaxRecentReocrdsWithUin(String paramString);
  
  public abstract void updateFileEntity(FileManagerEntity paramFileManagerEntity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IQQFileDataCenter
 * JD-Core Version:    0.7.0.1
 */