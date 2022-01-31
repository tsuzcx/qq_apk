package com.tencent.mobileqq.gallery.view;

import apsm;
import apsp;
import apss;
import apte;
import aptt;
import apub;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;

public class AIOGalleryActivity$2$3
  implements Runnable
{
  public AIOGalleryActivity$2$3(apub paramapub, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (AIOGalleryActivity.a(this.jdField_a_of_type_Apub.a) != null))
    {
      apss localapss = AIOGalleryActivity.a(this.jdField_a_of_type_Apub.a).a;
      try
      {
        GalleryBaseData[] arrayOfGalleryBaseData = aptt.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData);
        if (arrayOfGalleryBaseData == null)
        {
          apsm.a().a().a("IAIOImageProviderCallBack", 4, "galleryBaseDatas is null");
          return;
        }
        if (localapss.a(arrayOfGalleryBaseData, this.jdField_a_of_type_Int))
        {
          AIOGalleryActivity.a(this.jdField_a_of_type_Apub.a).a(arrayOfGalleryBaseData, this.jdField_a_of_type_Int);
          return;
        }
      }
      catch (Exception localException)
      {
        apsm.a().a().a("IAIOImageProviderCallBack", 4, "notifyImageListChanged exception = " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.view.AIOGalleryActivity.2.3
 * JD-Core Version:    0.7.0.1
 */