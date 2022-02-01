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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDismiss() called with: dialog = [");
      localStringBuilder.append(paramDialogInterface);
      localStringBuilder.append("] #this = ");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("ShareActionSheetV2", 2, localStringBuilder.toString());
    }
    ShareActionSheetV2.b(this.a);
    if (ShareActionSheetV2.a(this.a) != null) {
      ShareActionSheetV2.a(this.a).onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.4
 * JD-Core Version:    0.7.0.1
 */