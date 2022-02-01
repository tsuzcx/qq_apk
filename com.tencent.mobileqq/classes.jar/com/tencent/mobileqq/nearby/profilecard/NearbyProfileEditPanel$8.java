package com.tencent.mobileqq.nearby.profilecard;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

class NearbyProfileEditPanel$8
  implements DialogInterface.OnClickListener
{
  NearbyProfileEditPanel$8(NearbyProfileEditPanel paramNearbyProfileEditPanel, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.dismiss();
    this.b.F.showUploadPhotoActionSheet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.8
 * JD-Core Version:    0.7.0.1
 */