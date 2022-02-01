package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.Set;

@QAPI(process={""})
public abstract interface IFMDataCacheApi
  extends QRouteApi
{
  public abstract void addFileViewerLocalFiles(ArrayList<FileInfo> paramArrayList);
  
  public abstract void addSelected(FileInfo paramFileInfo);
  
  public abstract void addSelected(FileManagerEntity paramFileManagerEntity);
  
  public abstract void addTmpSig(String paramString, byte[] paramArrayOfByte);
  
  public abstract void clearFileViewerLocalFiles();
  
  public abstract void clearSelected();
  
  public abstract ArrayList<FavFileInfo> getFavFiles();
  
  public abstract ArrayList<FileInfo> getFileViewerLocalFiles();
  
  public abstract Set<FileInfo> getLocalFiles();
  
  public abstract ArrayList<OfflineFileInfo> getOfflineFiles();
  
  public abstract ArrayList<FileManagerEntity> getRecentFiles();
  
  public abstract long getSelectedCloudFileSize();
  
  public abstract long getSelectedCount();
  
  public abstract long getSelectedFileSize();
  
  public abstract long getSelectedLocalFileSize();
  
  public abstract ArrayList<WeiYunFileInfo> getWeiYunFiles();
  
  public abstract boolean isDocsFile(FileInfo paramFileInfo);
  
  public abstract boolean isDocsFile(FileManagerEntity paramFileManagerEntity);
  
  public abstract boolean isSelected(FileInfo paramFileInfo);
  
  public abstract boolean isSelected(FileManagerEntity paramFileManagerEntity);
  
  public abstract void removeSelected(FileInfo paramFileInfo);
  
  public abstract void removeSelected(FileManagerEntity paramFileManagerEntity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IFMDataCacheApi
 * JD-Core Version:    0.7.0.1
 */