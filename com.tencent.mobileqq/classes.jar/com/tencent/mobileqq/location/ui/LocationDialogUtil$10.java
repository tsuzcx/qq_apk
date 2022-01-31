package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.res.Resources;
import atqr;
import atqt;
import bdgm;
import bdjz;
import com.tencent.qphone.base.util.QLog;

public final class LocationDialogUtil$10
  implements Runnable
{
  public LocationDialogUtil$10(Activity paramActivity) {}
  
  public void run()
  {
    bdjz localbdjz = bdgm.a(this.a, 230, null, this.a.getResources().getString(2131720160), 2131719901, 2131690648, null, new atqt(this));
    localbdjz.setCancelable(false);
    if (!String.valueOf(this.a.hashCode()).equals(atqr.a()))
    {
      atqr.a(this.a, localbdjz);
      if (QLog.isColorLevel()) {
        QLog.d("LocationDialogUtil", 2, new Object[] { "showRoomJoinLimitedDialog#run: invoked. ", " currentDialogActivityHash: ", atqr.a() });
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("LocationDialogUtil", 2, new Object[] { "run: invoked. ", " same hash currentDialogActivityHash: ", atqr.a(), " activity: ", Integer.valueOf(this.a.hashCode()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.10
 * JD-Core Version:    0.7.0.1
 */