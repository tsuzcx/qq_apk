package com.tencent.mobileqq.richmediabrowser.view;

import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOFilePicturePresenter;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.view.pic.PictureView;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;

class AIOFilePictureView$1
  implements FMDialogUtil.FMDialogInterface
{
  AIOFilePictureView$1(AIOFilePictureView paramAIOFilePictureView, AIOFilePictureData paramAIOFilePictureData) {}
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.a();
      AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView).a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Int, 20);
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setDoubleTapEnable(true);
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setScaleEnable(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.f();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a().b();
      return;
    }
    catch (Exception localException)
    {
      IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showFlowDialog exception = ");
      localStringBuilder.append(localException.getMessage());
      localIBrowserLog.d("AIOGalleryFilePicView", 4, localStringBuilder.toString());
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.g(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView.1
 * JD-Core Version:    0.7.0.1
 */