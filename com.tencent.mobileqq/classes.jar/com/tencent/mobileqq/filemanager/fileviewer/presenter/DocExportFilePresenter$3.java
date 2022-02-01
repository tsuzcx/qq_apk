package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager.LocalTbsViewManagerCallback;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.immersive.ImmersiveUtils;

class DocExportFilePresenter$3
  implements LocalTbsViewManager.LocalTbsViewManagerCallback
{
  DocExportFilePresenter$3(DocExportFilePresenter paramDocExportFilePresenter) {}
  
  public View a()
  {
    return null;
  }
  
  public void a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2, View.OnClickListener paramOnClickListener) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.a(paramBoolean);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a()) && (paramBoolean)) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c();
    }
    while ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b() == null) || (paramBoolean)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a());
  }
  
  public boolean a()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) {
      return this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b();
    }
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.a();
    }
    if (paramBoolean)
    {
      LocalTbsViewManager.a().b(false);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d(), this);
      this.a.jdField_a_of_type_Boolean = false;
      QQToast.a(this.a.jdField_a_of_type_AndroidAppActivity, 2, 2131692352, 1).a();
      ThreadManagerV2.getUIHandlerV2().postDelayed(new DocExportFilePresenter.3.1(this), 800L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.DocExportFilePresenter.3
 * JD-Core Version:    0.7.0.1
 */