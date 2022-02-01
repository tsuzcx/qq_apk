package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.res.Resources;
import avdr;
import avdt;
import bfur;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public final class LocationDialogUtil$10
  implements Runnable
{
  public LocationDialogUtil$10(Activity paramActivity) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = bfur.a(this.a, 230, null, this.a.getResources().getString(2131718496), 2131718221, 2131690620, null, new avdt(this));
    localQQCustomDialog.setCancelable(false);
    if (!String.valueOf(this.a.hashCode()).equals(avdr.a()))
    {
      avdr.a(this.a, localQQCustomDialog);
      if (QLog.isColorLevel()) {
        QLog.d("LocationDialogUtil", 2, new Object[] { "showRoomJoinLimitedDialog#run: invoked. ", " currentDialogActivityHash: ", avdr.a() });
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("LocationDialogUtil", 2, new Object[] { "run: invoked. ", " same hash currentDialogActivityHash: ", avdr.a(), " activity: ", Integer.valueOf(this.a.hashCode()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.10
 * JD-Core Version:    0.7.0.1
 */