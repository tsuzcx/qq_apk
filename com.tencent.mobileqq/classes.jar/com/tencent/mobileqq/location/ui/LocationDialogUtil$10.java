package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.res.Resources;
import arvm;
import arvo;
import bbdj;
import bbgu;
import com.tencent.qphone.base.util.QLog;

public final class LocationDialogUtil$10
  implements Runnable
{
  public LocationDialogUtil$10(Activity paramActivity) {}
  
  public void run()
  {
    bbgu localbbgu = bbdj.a(this.a, 230, null, this.a.getResources().getString(2131719616), 2131719403, 2131690596, null, new arvo(this));
    localbbgu.setCancelable(false);
    if (!String.valueOf(this.a.hashCode()).equals(arvm.a()))
    {
      arvm.a(this.a, localbbgu);
      if (QLog.isColorLevel()) {
        QLog.d("LocationDialogUtil", 2, new Object[] { "showRoomJoinLimitedDialog#run: invoked. ", " currentDialogActivityHash: ", arvm.a() });
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("LocationDialogUtil", 2, new Object[] { "run: invoked. ", " same hash currentDialogActivityHash: ", arvm.a(), " activity: ", Integer.valueOf(this.a.hashCode()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.10
 * JD-Core Version:    0.7.0.1
 */