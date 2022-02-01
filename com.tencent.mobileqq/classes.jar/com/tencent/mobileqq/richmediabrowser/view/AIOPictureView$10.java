package com.tencent.mobileqq.richmediabrowser.view;

import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.pic.PictureView;

class AIOPictureView$10
  implements IGalleryImageListener
{
  AIOPictureView$10(AIOPictureView paramAIOPictureView, RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable, AIOPictureData paramAIOPictureData) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.b.setVisibility(8);
    if (paramBoolean)
    {
      AIOPictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentImageURLDrawable, paramInt);
      return;
    }
    AIOPictureView localAIOPictureView = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView;
    if (!AIOPictureView.a(localAIOPictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, localAIOPictureView.a.imageView))
    {
      localAIOPictureView = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView;
      if (!AIOPictureView.a(localAIOPictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, localAIOPictureView.a.imageView))
      {
        localAIOPictureView = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView;
        if (!AIOPictureView.b(localAIOPictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, localAIOPictureView.a.imageView))
        {
          localAIOPictureView = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView;
          AIOPictureView.a(localAIOPictureView, localAIOPictureView.a.imageView);
        }
      }
    }
    AIOPictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_a_of_type_Int, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.10
 * JD-Core Version:    0.7.0.1
 */