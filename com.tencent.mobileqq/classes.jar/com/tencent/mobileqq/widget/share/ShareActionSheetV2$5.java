package com.tencent.mobileqq.widget.share;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;

class ShareActionSheetV2$5
  implements DialogInterface.OnShowListener
{
  ShareActionSheetV2$5(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    ShareActionSheetV2.access$602(this.this$0, false);
    if (ShareActionSheetV2.access$700(this.this$0) != null) {
      ShareActionSheetV2.access$700(this.this$0).onShow(paramDialogInterface);
    }
    ShareActionSheetV2.access$800(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.5
 * JD-Core Version:    0.7.0.1
 */