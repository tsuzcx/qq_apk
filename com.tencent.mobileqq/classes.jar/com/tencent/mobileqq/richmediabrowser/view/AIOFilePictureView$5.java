package com.tencent.mobileqq.richmediabrowser.view;

import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.pic.PictureView;

class AIOFilePictureView$5
  implements IGalleryImageListener
{
  AIOFilePictureView$5(AIOFilePictureView paramAIOFilePictureView, RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable, AIOFilePictureData paramAIOFilePictureData) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.b.setVisibility(8);
    if (paramBoolean)
    {
      AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentImageURLDrawable, paramInt);
      return;
    }
    AIOFilePictureView localAIOFilePictureView = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView;
    if (!AIOFilePictureView.a(localAIOFilePictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData, localAIOFilePictureView.a.imageView))
    {
      localAIOFilePictureView = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView;
      if (!AIOFilePictureView.b(localAIOFilePictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData, localAIOFilePictureView.a.imageView))
      {
        localAIOFilePictureView = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView;
        AIOFilePictureView.a(localAIOFilePictureView, localAIOFilePictureView.a.imageView);
      }
    }
    AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Int, 18);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView.5
 * JD-Core Version:    0.7.0.1
 */