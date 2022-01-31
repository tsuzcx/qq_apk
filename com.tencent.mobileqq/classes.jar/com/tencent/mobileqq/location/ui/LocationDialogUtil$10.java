package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.res.Resources;
import aqzw;
import aqzy;
import babr;
import bafb;
import com.tencent.qphone.base.util.QLog;

public final class LocationDialogUtil$10
  implements Runnable
{
  public LocationDialogUtil$10(Activity paramActivity) {}
  
  public void run()
  {
    bafb localbafb = babr.a(this.a, 230, null, this.a.getResources().getString(2131653721), 2131653563, 2131625035, null, new aqzy(this));
    if (!String.valueOf(this.a.hashCode()).equals(aqzw.a())) {
      aqzw.a(this.a, localbafb);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("LocationDialogUtil", 2, new Object[] { "run: invoked. ", " currentDialogActivityHash: ", aqzw.a(), " activity: ", Integer.valueOf(this.a.hashCode()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.10
 * JD-Core Version:    0.7.0.1
 */