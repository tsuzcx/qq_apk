package com.tencent.mobileqq.nearby.picbrowser;

import android.view.View;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.io.File;

class PicBrowserGalleryScene$1
  implements ActionSheet.OnButtonClickListener
{
  PicBrowserGalleryScene$1(PicBrowserGalleryScene paramPicBrowserGalleryScene, ActionSheet paramActionSheet, File paramFile, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      AIOGalleryUtils.a(PicBrowserGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryScene), this.jdField_a_of_type_JavaIoFile, Utils.Crc64String(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()));
      return;
    }
    PicBrowserGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryScene, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.PicBrowserGalleryScene.1
 * JD-Core Version:    0.7.0.1
 */