package com.tencent.mobileqq.widget.share;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;

class ShareActionSheetV2$5
  implements DialogInterface.OnShowListener
{
  ShareActionSheetV2$5(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    ShareActionSheetV2.a(this.a, false);
    if (ShareActionSheetV2.e(this.a) != null) {
      ShareActionSheetV2.e(this.a).onShow(paramDialogInterface);
    }
    ShareActionSheetV2.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.5
 * JD-Core Version:    0.7.0.1
 */