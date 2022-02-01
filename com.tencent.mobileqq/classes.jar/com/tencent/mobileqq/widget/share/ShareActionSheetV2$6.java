package com.tencent.mobileqq.widget.share;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class ShareActionSheetV2$6
  implements DialogInterface.OnCancelListener
{
  ShareActionSheetV2$6(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    ShareActionSheetV2.b(this.a);
    if (ShareActionSheetV2.a(this.a) != null) {
      ShareActionSheetV2.a(this.a).onCancel(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.6
 * JD-Core Version:    0.7.0.1
 */