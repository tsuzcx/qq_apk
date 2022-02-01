package com.tencent.mobileqq.richmediabrowser.view;

import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;

class AIOFilePictureView$6
  implements IGalleryImageListener
{
  AIOFilePictureView$6(AIOFilePictureView paramAIOFilePictureView, RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable, AIOFilePictureData paramAIOFilePictureData) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.b.setVisibility(8);
    if (paramBoolean)
    {
      AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentImageURLDrawable, paramInt);
      return;
    }
    if ((!AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.a)) && (!AIOFilePictureView.b(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.a))) {
      AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.a);
    }
    AIOFilePictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Int, 18);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView.6
 * JD-Core Version:    0.7.0.1
 */