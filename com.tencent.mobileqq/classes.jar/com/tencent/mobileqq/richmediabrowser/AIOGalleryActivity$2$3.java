package com.tencent.mobileqq.richmediabrowser;

import axxz;
import axyi;
import axyq;
import axzf;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

public class AIOGalleryActivity$2$3
  implements Runnable
{
  public AIOGalleryActivity$2$3(axxz paramaxxz, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (AIOGalleryActivity.a(this.jdField_a_of_type_Axxz.a) != null))
    {
      axyi localaxyi = AIOGalleryActivity.a(this.jdField_a_of_type_Axxz.a).a;
      try
      {
        AIOBrowserBaseData[] arrayOfAIOBrowserBaseData = axzf.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData);
        if (arrayOfAIOBrowserBaseData == null)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("IAIOImageProviderCallBack", 4, "galleryBaseDatas is null");
          return;
        }
        if (localaxyi.a(arrayOfAIOBrowserBaseData, this.jdField_a_of_type_Int))
        {
          AIOGalleryActivity.a(this.jdField_a_of_type_Axxz.a).a(arrayOfAIOBrowserBaseData, this.jdField_a_of_type_Int);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.2.3
 * JD-Core Version:    0.7.0.1
 */