package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

final class LocationDialogUtil$8
  implements Runnable
{
  LocationDialogUtil$8(Activity paramActivity) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a, 230, null, this.a.getResources().getString(2131719407), 2131719131, 2131690800, null, new LocationDialogUtil.8.1(this));
    localQQCustomDialog.setCancelable(false);
    if (!String.valueOf(this.a.hashCode()).equals(LocationDialogUtil.a()))
    {
      LocationDialogUtil.a(this.a, localQQCustomDialog);
      if (QLog.isColorLevel()) {
        QLog.d("LocationDialogUtil", 2, new Object[] { "showRoomJoinLimitedDialog#run: invoked. ", " currentDialogActivityHash: ", LocationDialogUtil.a() });
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("LocationDialogUtil", 2, new Object[] { "run: invoked. ", " same hash currentDialogActivityHash: ", LocationDialogUtil.a(), " activity: ", Integer.valueOf(this.a.hashCode()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.8
 * JD-Core Version:    0.7.0.1
 */