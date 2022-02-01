package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.res.Resources;
import awju;
import awjw;
import bhdj;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public final class LocationDialogUtil$10
  implements Runnable
{
  public LocationDialogUtil$10(Activity paramActivity) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = bhdj.a(this.a, 230, null, this.a.getResources().getString(2131718882), 2131718607, 2131690697, null, new awjw(this));
    localQQCustomDialog.setCancelable(false);
    if (!String.valueOf(this.a.hashCode()).equals(awju.a()))
    {
      awju.a(this.a, localQQCustomDialog);
      if (QLog.isColorLevel()) {
        QLog.d("LocationDialogUtil", 2, new Object[] { "showRoomJoinLimitedDialog#run: invoked. ", " currentDialogActivityHash: ", awju.a() });
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("LocationDialogUtil", 2, new Object[] { "run: invoked. ", " same hash currentDialogActivityHash: ", awju.a(), " activity: ", Integer.valueOf(this.a.hashCode()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.10
 * JD-Core Version:    0.7.0.1
 */