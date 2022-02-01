package com.tencent.mobileqq.nearby.profilecard;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.qphone.base.util.QLog;

class NearbyProfileDisplayPanel$26
  implements DialogInterface.OnClickListener
{
  NearbyProfileDisplayPanel$26(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    NearbyUtils.a(this.a.e, 1032);
    if (QLog.isColorLevel()) {
      QLog.d("nearby.bindphone", 2, "openBindPhonePage");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.26
 * JD-Core Version:    0.7.0.1
 */