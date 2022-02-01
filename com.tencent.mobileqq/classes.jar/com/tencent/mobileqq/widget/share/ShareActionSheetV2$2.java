package com.tencent.mobileqq.widget.share;

import android.graphics.Bitmap;
import aqdb;

class ShareActionSheetV2$2
  implements aqdb
{
  ShareActionSheetV2$2(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onFaceUpdate(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    ShareActionSheetV2.access$200(this.this$0, paramString1, paramString2, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.2
 * JD-Core Version:    0.7.0.1
 */