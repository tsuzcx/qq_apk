package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.Context;
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
    Object localObject = this.a;
    localObject = DialogUtil.a((Context)localObject, 230, null, ((Activity)localObject).getResources().getString(2131916661), 2131916381, 2131887648, null, new LocationDialogUtil.8.1(this));
    ((QQCustomDialog)localObject).setCancelable(false);
    if (!String.valueOf(this.a.hashCode()).equals(LocationDialogUtil.a()))
    {
      LocationDialogUtil.a(this.a, (QQCustomDialog)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("LocationDialogUtil", 2, new Object[] { "showRoomJoinLimitedDialog#run: invoked. ", " currentDialogActivityHash: ", LocationDialogUtil.a() });
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("LocationDialogUtil", 2, new Object[] { "run: invoked. ", " same hash currentDialogActivityHash: ", LocationDialogUtil.a(), " activity: ", Integer.valueOf(this.a.hashCode()) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.8
 * JD-Core Version:    0.7.0.1
 */