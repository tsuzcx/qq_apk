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
    IFileViewerAdapter localIFileViewerAdapter = ((DefaultImageInfo)paramImageFileInfo).a();
    if (localIFileViewerAdapter != null) {
      if (1 == localIFileViewerAdapter.c())
      {
        if (localIFileViewerAdapter.a().isZipInnerFile)
        {
          paramImageFileInfo = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().c(localIFileViewerAdapter.a());
          if ((paramImageFileInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener != null)) {
            this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener.a(String.valueOf(localIFileViewerAdapter.a()), paramImageFileInfo);
          }
        }
        else
        {
          paramImageFileInfo = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localIFileViewerAdapter.a(), 7);
          if ((paramImageFileInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener != null)) {
            this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener.a(localIFileViewerAdapter.c(), paramImageFileInfo);
          }
        }
      }
      else if (2 == localIFileViewerAdapter.c())
      {
        FileManagerEngine localFileManagerEngine = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine();
        String str = localIFileViewerAdapter.e();
        if (localIFileViewerAdapter.a() == null) {
          paramImageFileInfo = null;
        } else {
          paramImageFileInfo = localIFileViewerAdapter.a().e;
        }
        paramImageFileInfo = localFileManagerEngine.a(str, paramImageFileInfo, 7, localIFileViewerAdapter);
        if ((paramImageFileInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener != null)) {
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener.a(localIFileViewerAdapter.e(), paramImageFileInfo);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DefaultFileModel.3
 * JD-Core Version:    0.7.0.1
 */