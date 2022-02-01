package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class LocationDialogUtil$7
  implements Runnable
{
  LocationDialogUtil$7(Activity paramActivity) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a, 230, null, this.a.getResources().getString(2131719406), 2131694615, 2131690800, null, new LocationDialogUtil.7.1(this));
    LocationDialogUtil.a(this.a, localQQCustomDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.7
 * JD-Core Version:    0.7.0.1
 */