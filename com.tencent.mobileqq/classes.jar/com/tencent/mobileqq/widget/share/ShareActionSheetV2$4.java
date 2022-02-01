package com.tencent.mobileqq.widget.share;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class ShareActionSheetV2$4
  implements DialogInterface.OnDismissListener
{
  ShareActionSheetV2$4(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "onDismiss() called with: dialog = [" + paramDialogInterface + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    ShareActionSheetV2.b(this.a);
    if (ShareActionSheetV2.a(this.a) != null) {
      ShareActionSheetV2.a(this.a).onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.4
 * JD-Core Version:    0.7.0.1
 */