package com.tencent.mobileqq.filemanager.activity.fileviewer.base;

import android.app.Activity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

final class FileViewerFacade$2
  implements FMDialogUtil.FMDialogInterface
{
  FileViewerFacade$2(Activity paramActivity, FileManagerEntity paramFileManagerEntity) {}
  
  public void a()
  {
    FileManagerUtil.b(this.a, this.b.getFilePath());
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileviewer.base.FileViewerFacade.2
 * JD-Core Version:    0.7.0.1
 */