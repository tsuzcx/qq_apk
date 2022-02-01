package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IThumbController;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.ImageFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.PictureFileViewer;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import java.util.List;

class PictureFilePresenter$4
  implements AdapterView.OnItemSelectedListener
{
  PictureFilePresenter$4(PictureFilePresenter paramPictureFilePresenter) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    PictureFilePresenter.a(this.a, paramInt);
    paramAdapterView = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer;
    if (PictureFilePresenter.a(this.a) == PictureFilePresenter.b(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      paramAdapterView.d(bool);
      this.a.a(paramInt);
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.a(paramInt);
      }
      paramAdapterView = (FileBrowserModelBase.ImageFileInfo)PictureFilePresenter.a(this.a).get(paramInt);
      if (paramAdapterView != null) {
        break;
      }
      FMToastUtil.b(BaseApplicationImpl.getContext().getString(2131692421));
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a().a(paramAdapterView);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(paramInt, paramAdapterView);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.c(PictureFilePresenter.a(this.a, PictureFilePresenter.a(this.a)));
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.c();
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.c();
    }
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.a(true);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.a(false);
      PictureFilePresenter.a(this.a, true);
    }
    this.a.jdField_a_of_type_Boolean = true;
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.PictureFilePresenter.4
 * JD-Core Version:    0.7.0.1
 */