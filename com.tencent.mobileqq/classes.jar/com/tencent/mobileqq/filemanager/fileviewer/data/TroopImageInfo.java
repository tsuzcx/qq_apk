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
  
  public boolean c(String paramString)
  {
    FileManagerEntity localFileManagerEntity = this.a.r();
    boolean bool2 = false;
    if (localFileManagerEntity == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (localFileManagerEntity.strTroopFilePath != null)
    {
      bool1 = bool2;
      if (localFileManagerEntity.strTroopFilePath.equalsIgnoreCase(paramString)) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.data.TroopImageInfo
 * JD-Core Version:    0.7.0.1
 */