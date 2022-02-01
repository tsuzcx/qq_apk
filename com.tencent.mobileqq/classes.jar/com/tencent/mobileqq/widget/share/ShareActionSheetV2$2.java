package com.tencent.mobileqq.widget.share;

import android.graphics.Bitmap;
import com.tencent.mobileqq.armap.FaceObserver;

class ShareActionSheetV2$2
  implements FaceObserver
{
  ShareActionSheetV2$2(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    ShareActionSheetV2.a(this.a, paramString1, paramString2, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.2
 * JD-Core Version:    0.7.0.1
 */