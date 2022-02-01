package com.tencent.mobileqq.richmediabrowser;

import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserManager;
import com.tencent.mobileqq.richmediabrowser.utils.DataUtils;
import com.tencent.qphone.base.util.QLog;

class AIOGalleryActivity$2$3
  implements Runnable
{
  AIOGalleryActivity$2$3(AIOGalleryActivity.2 param2, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (AIOGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOGalleryActivity$2.a) != null)) {
      try
      {
        AIOBrowserBaseData[] arrayOfAIOBrowserBaseData = DataUtils.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData);
        AIOGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOGalleryActivity$2.a).notifyImageListChanged(arrayOfAIOBrowserBaseData, this.jdField_a_of_type_Int);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("notifyImageListChanged exception = ");
          localStringBuilder.append(localException.getMessage());
          QLog.d("IAIOImageProviderCallBack", 2, localStringBuilder.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.2.3
 * JD-Core Version:    0.7.0.1
 */