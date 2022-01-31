package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.res.Resources;
import atmi;
import atmk;
import bdcd;
import bdfq;
import com.tencent.qphone.base.util.QLog;

public final class LocationDialogUtil$10
  implements Runnable
{
  public LocationDialogUtil$10(Activity paramActivity) {}
  
  public void run()
  {
    bdfq localbdfq = bdcd.a(this.a, 230, null, this.a.getResources().getString(2131720148), 2131719889, 2131690648, null, new atmk(this));
    localbdfq.setCancelable(false);
    if (!String.valueOf(this.a.hashCode()).equals(atmi.a()))
    {
      atmi.a(this.a, localbdfq);
      if (QLog.isColorLevel()) {
        QLog.d("LocationDialogUtil", 2, new Object[] { "showRoomJoinLimitedDialog#run: invoked. ", " currentDialogActivityHash: ", atmi.a() });
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("LocationDialogUtil", 2, new Object[] { "run: invoked. ", " same hash currentDialogActivityHash: ", atmi.a(), " activity: ", Integer.valueOf(this.a.hashCode()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.10
 * JD-Core Version:    0.7.0.1
 */