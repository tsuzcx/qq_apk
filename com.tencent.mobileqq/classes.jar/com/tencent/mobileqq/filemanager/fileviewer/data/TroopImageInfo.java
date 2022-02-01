package com.tencent.mobileqq.filemanager.fileviewer.data;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;

public class TroopImageInfo
  extends DefaultImageInfo
{
  public TroopImageInfo(IFileViewerAdapter paramIFileViewerAdapter)
  {
    super(paramIFileViewerAdapter);
  }
  
  public boolean a(String paramString)
  {
    FileManagerEntity localFileManagerEntity = this.a.a();
    if (localFileManagerEntity == null) {}
    while ((localFileManagerEntity.strTroopFilePath == null) || (!localFileManagerEntity.strTroopFilePath.equalsIgnoreCase(paramString))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.data.TroopImageInfo
 * JD-Core Version:    0.7.0.1
 */