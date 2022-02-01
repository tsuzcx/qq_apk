package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.QFileBrowserUtils;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.filemanageraux.fileviewer.FileView.LocalTdsViewManager.LocalTdsViewManagerCallback;
import com.tencent.widget.immersive.ImmersiveUtils;

class SimpleFilePresenter$6
  implements LocalTdsViewManager.LocalTdsViewManagerCallback
{
  SimpleFilePresenter$6(SimpleFilePresenter paramSimpleFilePresenter) {}
  
  public void a(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.a();
    }
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.e() == 10) {
        QFileBrowserUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c());
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d(), this);
      SimpleFilePresenter.c(this.a, true);
      this.a.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(4);
      SimpleFilePresenter.a(this.a);
      return;
    }
    if (SimpleFilePresenter.b(this.a))
    {
      SimpleFilePresenter.c(this.a, false);
      if (this.a.d) {
        this.a.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
      }
      SimpleFilePresenter.d(this.a, true);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d();
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
      }
    }
    LocalTbsViewManager.a().a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d(), SimpleFilePresenter.a(this.a), true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    SimpleFilePresenter.b(this.a, paramBoolean2);
    SimpleFilePresenter.a(this.a, paramBoolean1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.6
 * JD-Core Version:    0.7.0.1
 */