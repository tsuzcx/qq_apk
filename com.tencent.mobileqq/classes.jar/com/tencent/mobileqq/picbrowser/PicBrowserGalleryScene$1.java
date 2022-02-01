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
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.dismiss();
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      PicBrowserGalleryScene.a(this.d, this.c);
      return;
    }
    paramView = PicBrowserGalleryScene.a(this.d);
    File localFile = this.b;
    AIOGalleryUtils.a(paramView, localFile, Utils.Crc64String(localFile.getAbsolutePath()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.picbrowser.PicBrowserGalleryScene.1
 * JD-Core Version:    0.7.0.1
 */