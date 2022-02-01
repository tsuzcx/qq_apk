package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IQRResultCallback;
import com.tencent.mobileqq.filemanager.fileviewer.data.FileQRScanResult;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import java.util.ArrayList;
import java.util.List;

class FileBrowserModelBase$2
  implements IQRResultCallback
{
  public void a(FileQRScanResult paramFileQRScanResult)
  {
    if (paramFileQRScanResult != null)
    {
      this.b.w = new ArrayList();
      paramFileQRScanResult = QFileUtils.a(paramFileQRScanResult);
      if ((paramFileQRScanResult != null) && (!paramFileQRScanResult.isEmpty()))
      {
        this.b.w.addAll(paramFileQRScanResult);
        paramFileQRScanResult = this.b;
        paramFileQRScanResult.x = this.a;
        if (paramFileQRScanResult.k != null) {
          this.b.k.h();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.2
 * JD-Core Version:    0.7.0.1
 */