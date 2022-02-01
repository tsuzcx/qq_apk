package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.view.View;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.PictureFileViewer;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class PictureFilePresenter$3
  implements AdapterView.OnItemClickListener
{
  PictureFilePresenter$3(PictureFilePresenter paramPictureFilePresenter) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a;
    boolean bool;
    if (!PictureFilePresenter.a(this.a))
    {
      bool = true;
      PictureFilePresenter.a(paramAdapterView, bool);
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.a(PictureFilePresenter.a(this.a));
      }
      if (!PictureFilePresenter.a(this.a)) {
        break label110;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.a(false);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.b(false);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.e(PictureFilePresenter.a(this.a));
      return;
      bool = false;
      break;
      label110:
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.a(true);
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.PictureFilePresenter.3
 * JD-Core Version:    0.7.0.1
 */