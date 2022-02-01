package com.tencent.mobileqq.nearby.profilecard;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.qphone.base.util.QLog;

class NearbyProfileDisplayPanel$22
  implements DialogInterface.OnClickListener
{
  NearbyProfileDisplayPanel$22(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    NearbyUtils.a(this.a.a, 1032);
    if (QLog.isColorLevel()) {
      QLog.d("nearby.bindphone", 2, "openBindPhonePage");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.22
 * JD-Core Version:    0.7.0.1
 */