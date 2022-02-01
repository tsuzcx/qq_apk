package com.tencent.mobileqq.richmediabrowser.view;

import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;

class AIOPictureView$13
  implements IGalleryImageListener
{
  AIOPictureView$13(AIOPictureView paramAIOPictureView, RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable, AIOPictureData paramAIOPictureData) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.b.setVisibility(8);
    if (paramBoolean)
    {
      AIOPictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentImageURLDrawable, paramInt);
      return;
    }
    if ((!AIOPictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.a)) && (!AIOPictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.a)) && (!AIOPictureView.b(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.a))) {
      AIOPictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.a);
    }
    AIOPictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_a_of_type_Int, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.13
 * JD-Core Version:    0.7.0.1
 */