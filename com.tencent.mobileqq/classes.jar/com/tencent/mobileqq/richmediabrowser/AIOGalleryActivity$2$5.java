package com.tencent.mobileqq.richmediabrowser;

import axxz;
import axyq;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

public class AIOGalleryActivity$2$5
  implements Runnable
{
  public AIOGalleryActivity$2$5(axxz paramaxxz, long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3) {}
  
  public void run()
  {
    if (AIOGalleryActivity.a(this.jdField_a_of_type_Axxz.a) != null)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("IAIOImageProviderCallBack", 4, "IAIOImageProviderCallBack.notifyVideoUrl");
      AIOGalleryActivity.a(this.jdField_a_of_type_Axxz.a).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.2.5
 * JD-Core Version:    0.7.0.1
 */