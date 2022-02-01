package com.tencent.mobileqq.widget.share;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class ShareActionSheetV2$6
  implements DialogInterface.OnCancelListener
{
  ShareActionSheetV2$6(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    ShareActionSheetV2.c(this.a);
    if (ShareActionSheetV2.g(this.a) != null) {
      ShareActionSheetV2.g(this.a).onCancel(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.6
 * JD-Core Version:    0.7.0.1
 */