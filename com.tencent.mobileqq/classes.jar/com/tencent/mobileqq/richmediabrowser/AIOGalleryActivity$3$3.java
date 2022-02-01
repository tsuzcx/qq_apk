package com.tencent.mobileqq.richmediabrowser;

import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.richmediabrowser.model.AIOBrowserModel;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.mobileqq.richmediabrowser.utils.DataUtils;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

class AIOGalleryActivity$3$3
  implements Runnable
{
  AIOGalleryActivity$3$3(AIOGalleryActivity.3 param3, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (AIOGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOGalleryActivity$3.a) != null))
    {
      AIOBrowserModel localAIOBrowserModel = AIOGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOGalleryActivity$3.a).a;
      try
      {
        AIOBrowserBaseData[] arrayOfAIOBrowserBaseData = DataUtils.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData);
        if (arrayOfAIOBrowserBaseData == null)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("IAIOImageProviderCallBack", 4, "galleryBaseDatas is null");
          return;
        }
        if (localAIOBrowserModel.a(arrayOfAIOBrowserBaseData, this.jdField_a_of_type_Int))
        {
          AIOGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOGalleryActivity$3.a).a(arrayOfAIOBrowserBaseData, this.jdField_a_of_type_Int);
          return;
        }
      }
      catch (Exception localException)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("IAIOImageProviderCallBack", 4, "notifyImageListChanged exception = " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.3.3
 * JD-Core Version:    0.7.0.1
 */