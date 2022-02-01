package com.tencent.mobileqq.profile.PersonalityLabel;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class ShareHelper$2
  implements DialogInterface.OnDismissListener
{
  ShareHelper$2(ShareHelper paramShareHelper, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    DialogInterface.OnDismissListener localOnDismissListener = this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener;
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.2
 * JD-Core Version:    0.7.0.1
 */