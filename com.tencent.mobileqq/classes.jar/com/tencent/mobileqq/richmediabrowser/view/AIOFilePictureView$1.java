package com.tencent.mobileqq.richmediabrowser.view;

import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOFilePicturePresenter;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;

class AIOFilePictureView$1
  implements FMDialogUtil.FMDialogInterface
{
  AIOFilePictureView$1(AIOFilePictureView paramAIOFilePictureView, AIOFilePictureData paramAIOFilePictureData) {}
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.updateUI();
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Int, 20);
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setDoubleTapEnable(true);
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setScaleEnable(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.d();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a().b();
      return;
    }
    catch (Exception localException)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "showFlowDialog exception = " + localException.getMessage());
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.updateUI();
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.f(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView.1
 * JD-Core Version:    0.7.0.1
 */