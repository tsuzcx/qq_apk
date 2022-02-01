package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.res.Resources;
import awql;
import awqn;
import bhlq;
import bhpc;
import com.tencent.qphone.base.util.QLog;

public final class LocationDialogUtil$10
  implements Runnable
{
  public LocationDialogUtil$10(Activity paramActivity) {}
  
  public void run()
  {
    bhpc localbhpc = bhlq.a(this.a, 230, null, this.a.getResources().getString(2131718255), 2131717980, 2131690580, null, new awqn(this));
    localbhpc.setCancelable(false);
    if (!String.valueOf(this.a.hashCode()).equals(awql.a()))
    {
      awql.a(this.a, localbhpc);
      if (QLog.isColorLevel()) {
        QLog.d("LocationDialogUtil", 2, new Object[] { "showRoomJoinLimitedDialog#run: invoked. ", " currentDialogActivityHash: ", awql.a() });
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("LocationDialogUtil", 2, new Object[] { "run: invoked. ", " same hash currentDialogActivityHash: ", awql.a(), " activity: ", Integer.valueOf(this.a.hashCode()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.10
 * JD-Core Version:    0.7.0.1
 */