package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.res.Resources;
import avxq;
import avxs;
import bglp;
import bgpa;
import com.tencent.qphone.base.util.QLog;

public final class LocationDialogUtil$10
  implements Runnable
{
  public LocationDialogUtil$10(Activity paramActivity) {}
  
  public void run()
  {
    bgpa localbgpa = bglp.a(this.a, 230, null, this.a.getResources().getString(2131718122), 2131717848, 2131690582, null, new avxs(this));
    localbgpa.setCancelable(false);
    if (!String.valueOf(this.a.hashCode()).equals(avxq.a()))
    {
      avxq.a(this.a, localbgpa);
      if (QLog.isColorLevel()) {
        QLog.d("LocationDialogUtil", 2, new Object[] { "showRoomJoinLimitedDialog#run: invoked. ", " currentDialogActivityHash: ", avxq.a() });
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("LocationDialogUtil", 2, new Object[] { "run: invoked. ", " same hash currentDialogActivityHash: ", avxq.a(), " activity: ", Integer.valueOf(this.a.hashCode()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.10
 * JD-Core Version:    0.7.0.1
 */