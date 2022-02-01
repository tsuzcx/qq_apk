package com.tencent.mobileqq.picbrowser;

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
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      PicBrowserGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserGalleryScene, this.jdField_a_of_type_JavaLangString);
      return;
    }
    paramView = PicBrowserGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserGalleryScene);
    File localFile = this.jdField_a_of_type_JavaIoFile;
    AIOGalleryUtils.a(paramView, localFile, Utils.Crc64String(localFile.getAbsolutePath()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.picbrowser.PicBrowserGalleryScene.1
 * JD-Core Version:    0.7.0.1
 */