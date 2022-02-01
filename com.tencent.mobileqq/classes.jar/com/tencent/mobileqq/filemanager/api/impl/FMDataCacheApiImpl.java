package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import java.util.ArrayList;
import java.util.Set;

public class FMDataCacheApiImpl
  implements IFMDataCacheApi
{
  public void addFileViewerLocalFiles(ArrayList<FileInfo> paramArrayList)
  {
    FMDataCache.a(paramArrayList);
  }
  
  public void addSelected(FileInfo paramFileInfo)
  {
    FMDataCache.a(paramFileInfo);
  }
  
  public void addSelected(FileManagerEntity paramFileManagerEntity)
  {
    FMDataCache.a(paramFileManagerEntity);
  }
  
  public void addTmpSig(String paramString, byte[] paramArrayOfByte)
  {
    FMDataCache.a(paramString, paramArrayOfByte);
  }
  
  public void clearFileViewerLocalFiles() {}
  
  public void clearSelected() {}
  
  public ArrayList<FavFileInfo> getFavFiles()
  {
    return FMDataCache.e();
  }
  
  public ArrayList<FileInfo> getFileViewerLocalFiles()
  {
    return FMDataCache.a();
  }
  
  public Set<FileInfo> getLocalFiles()
  {
    return FMDataCache.a();
  }
  
  public ArrayList<OfflineFileInfo> getOfflineFiles()
  {
    return FMDataCache.c();
  }
  
  public ArrayList<FileManagerEntity> getRecentFiles()
  {
    return FMDataCache.b();
  }
  
  public long getSelectedCloudFileSize()
  {
    return FMDataCache.e();
  }
  
  public long getSelectedCount()
  {
    return FMDataCache.b();
  }
  
  public long getSelectedFileSize()
  {
    return FMDataCache.d();
  }
  
  public long getSelectedLocalFileSize()
  {
    return FMDataCache.c();
  }
  
  public ArrayList<WeiYunFileInfo> getWeiYunFiles()
  {
    return FMDataCache.d();
  }
  
  public boolean isDocsFile(FileInfo paramFileInfo)
  {
    return FMDataCache.b(paramFileInfo);
  }
  
  public boolean isDocsFile(FileManagerEntity paramFileManagerEntity)
  {
    return FMDataCache.b(paramFileManagerEntity);
  }
  
  public boolean isSelected(FileInfo paramFileInfo)
  {
    return FMDataCache.a(paramFileInfo);
  }
  
  public boolean isSelected(FileManagerEntity paramFileManagerEntity)
  {
    return FMDataCache.a(paramFileManagerEntity);
  }
  
  public void removeSelected(FileInfo paramFileInfo)
  {
    FMDataCache.b(paramFileInfo);
  }
  
  public void removeSelected(FileManagerEntity paramFileManagerEntity)
  {
    FMDataCache.b(paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.FMDataCacheApiImpl
 * JD-Core Version:    0.7.0.1
 */