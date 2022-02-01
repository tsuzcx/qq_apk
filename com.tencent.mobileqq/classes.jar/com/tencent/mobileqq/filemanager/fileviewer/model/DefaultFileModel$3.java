package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IThumbController;
import com.tencent.mobileqq.filemanager.fileviewer.data.DefaultImageInfo;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;

class DefaultFileModel$3
  implements IThumbController
{
  DefaultFileModel$3(DefaultFileModel paramDefaultFileModel) {}
  
  public void a(FileBrowserModelBase.ImageFileInfo paramImageFileInfo)
  {
    IFileViewerAdapter localIFileViewerAdapter = ((DefaultImageInfo)paramImageFileInfo).h();
    if (localIFileViewerAdapter != null) {
      if (1 == localIFileViewerAdapter.m())
      {
        if (localIFileViewerAdapter.r().isZipInnerFile)
        {
          paramImageFileInfo = this.a.a.getFileManagerEngine().d(localIFileViewerAdapter.r());
          if ((paramImageFileInfo != null) && (this.a.s != null)) {
            this.a.s.a(String.valueOf(localIFileViewerAdapter.a()), paramImageFileInfo);
          }
        }
        else
        {
          paramImageFileInfo = this.a.a.getFileManagerEngine().a(localIFileViewerAdapter.r(), 7);
          if ((paramImageFileInfo != null) && (this.a.s != null)) {
            this.a.s.a(localIFileViewerAdapter.h(), paramImageFileInfo);
          }
        }
      }
      else if (2 == localIFileViewerAdapter.m())
      {
        FileManagerEngine localFileManagerEngine = this.a.a.getFileManagerEngine();
        String str = localIFileViewerAdapter.j();
        if (localIFileViewerAdapter.s() == null) {
          paramImageFileInfo = null;
        } else {
          paramImageFileInfo = localIFileViewerAdapter.s().i;
        }
        paramImageFileInfo = localFileManagerEngine.a(str, paramImageFileInfo, 7, localIFileViewerAdapter);
        if ((paramImageFileInfo != null) && (this.a.s != null)) {
          this.a.s.a(localIFileViewerAdapter.j(), paramImageFileInfo);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DefaultFileModel.3
 * JD-Core Version:    0.7.0.1
 */