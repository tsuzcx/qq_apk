package com.tencent.mobileqq.filemanager.fileviewer.data;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;

public class DeviceImageInfo
  extends DefaultImageInfo
{
  public DeviceImageInfo(IFileViewerAdapter paramIFileViewerAdapter)
  {
    super(paramIFileViewerAdapter);
  }
  
  public boolean a(String paramString)
  {
    FileManagerEntity localFileManagerEntity = this.a.a();
    if (localFileManagerEntity == null) {
      return false;
    }
    return paramString.equals(String.valueOf(localFileManagerEntity.nSessionId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.data.DeviceImageInfo
 * JD-Core Version:    0.7.0.1
 */