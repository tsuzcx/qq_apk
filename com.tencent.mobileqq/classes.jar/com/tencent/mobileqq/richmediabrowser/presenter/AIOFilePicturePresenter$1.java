package com.tencent.mobileqq.richmediabrowser.presenter;

import android.app.Activity;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;

class AIOFilePicturePresenter$1
  implements IGalleryImageListener
{
  AIOFilePicturePresenter$1(AIOFilePicturePresenter paramAIOFilePicturePresenter, URLDrawable paramURLDrawable, RichMediaBrowserInfo paramRichMediaBrowserInfo) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a.b.setVisibility(8);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a(paramInt, this.jdField_a_of_type_ComTencentImageURLDrawable);
      paramInt = this.jdField_a_of_type_ComTencentImageURLDrawable.getExifOrientation();
      this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo.orientation = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a.a.initDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a.mScreenWidthPx, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a.mScreenHeightPx, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.getRotation(paramInt));
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a.mContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a.mContext.getString(2131695008), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOFilePicturePresenter.1
 * JD-Core Version:    0.7.0.1
 */