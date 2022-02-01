package com.tencent.mobileqq.richmediabrowser.presenter;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.utils.BrowserUtils;
import com.tencent.richmediabrowser.view.pic.PictureView;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;

class AIOFilePicturePresenter$1
  implements IGalleryImageListener
{
  AIOFilePicturePresenter$1(AIOFilePicturePresenter paramAIOFilePicturePresenter, URLDrawable paramURLDrawable) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a(paramInt, this.jdField_a_of_type_ComTencentImageURLDrawable);
      paramInt = this.jdField_a_of_type_ComTencentImageURLDrawable.getExifOrientation();
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.initDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a.jdField_b_of_type_Int, BrowserUtils.a(paramInt));
      }
    }
    else
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a.jdField_a_of_type_AndroidContentContext.getString(2131718254), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOFilePicturePresenter.1
 * JD-Core Version:    0.7.0.1
 */