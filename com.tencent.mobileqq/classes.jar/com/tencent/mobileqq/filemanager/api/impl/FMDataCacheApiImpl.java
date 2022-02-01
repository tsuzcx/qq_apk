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
    FMDataCache.b(paramFileInfo);
  }
  
  public void addSelected(FileManagerEntity paramFileManagerEntity)
  {
    FMDataCache.b(paramFileManagerEntity);
  }
  
  public void addTmpSig(String paramString, byte[] paramArrayOfByte)
  {
    FMDataCache.a(paramString, paramArrayOfByte);
  }
  
  public void clearFileViewerLocalFiles() {}
  
  public void clearSelected() {}
  
  public ArrayList<FavFileInfo> getFavFiles()
  {
    return FMDataCache.k();
  }
  
  public ArrayList<FileInfo> getFileViewerLocalFiles()
  {
    return FMDataCache.a();
  }
  
  public Set<FileInfo> getLocalFiles()
  {
    return FMDataCache.g();
  }
  
  public ArrayList<OfflineFileInfo> getOfflineFiles()
  {
    return FMDataCache.i();
  }
  
  public ArrayList<FileManagerEntity> getRecentFiles()
  {
    return FMDataCache.h();
  }
  
  public long getSelectedCloudFileSize()
  {
    return FMDataCache.n();
  }
  
  public long getSelectedCount()
  {
    return FMDataCache.e();
  }
  
  public long getSelectedFileSize()
  {
    return FMDataCache.m();
  }
  
  public long getSelectedLocalFileSize()
  {
    return FMDataCache.l();
  }
  
  public ArrayList<WeiYunFileInfo> getWeiYunFiles()
  {
    return FMDataCache.j();
  }
  
  public boolean isDocsFile(FileInfo paramFileInfo)
  {
    return FMDataCache.d(paramFileInfo);
  }
  
  public boolean isDocsFile(FileManagerEntity paramFileManagerEntity)
  {
    return FMDataCache.d(paramFileManagerEntity);
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
    FMDataCache.c(paramFileInfo);
  }
  
  public void removeSelected(FileManagerEntity paramFileManagerEntity)
  {
    FMDataCache.c(paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.FMDataCacheApiImpl
 * JD-Core Version:    0.7.0.1
 */