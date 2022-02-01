package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IQRResultCallback;
import com.tencent.mobileqq.filemanager.fileviewer.data.FileQRScanResult;
import java.util.HashMap;

class FileBrowserModelBase$1
  implements IQRResultCallback
{
  FileBrowserModelBase$1(FileBrowserModelBase paramFileBrowserModelBase, String paramString) {}
  
  public void a(FileQRScanResult paramFileQRScanResult)
  {
    if (paramFileQRScanResult != null)
    {
      this.b.v.put(this.a, paramFileQRScanResult);
      this.b.k.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.1
 * JD-Core Version:    0.7.0.1
 */