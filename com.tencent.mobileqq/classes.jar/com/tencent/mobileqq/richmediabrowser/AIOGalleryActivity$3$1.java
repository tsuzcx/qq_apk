package com.tencent.mobileqq.richmediabrowser;

import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

class AIOGalleryActivity$3$1
  implements Runnable
{
  AIOGalleryActivity$3$1(AIOGalleryActivity.3 param3, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void run()
  {
    if (AIOGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOGalleryActivity$3.a) != null)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("IAIOImageProviderCallBack", 4, "IAIOImageProviderCallBack.notifyImageResult():isPart " + this.jdField_a_of_type_Boolean);
      AIOGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOGalleryActivity$3.a).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.3.1
 * JD-Core Version:    0.7.0.1
 */