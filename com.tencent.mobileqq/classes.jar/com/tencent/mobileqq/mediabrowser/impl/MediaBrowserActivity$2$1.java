package com.tencent.mobileqq.mediabrowser.impl;

import com.tencent.mobileqq.richmediabrowser.api.IBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

class MediaBrowserActivity$2$1
  implements Runnable
{
  MediaBrowserActivity$2$1(MediaBrowserActivity.2 param2, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void run()
  {
    if (MediaBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqMediabrowserImplMediaBrowserActivity$2.a) != null)
    {
      IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("IAIOImageProviderCallBack.notifyImageResult():isPart ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localIBrowserLog.d("MediaBrowserActivity", 4, localStringBuilder.toString());
      MediaBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqMediabrowserImplMediaBrowserActivity$2.a).notifyImageResult(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mediabrowser.impl.MediaBrowserActivity.2.1
 * JD-Core Version:    0.7.0.1
 */