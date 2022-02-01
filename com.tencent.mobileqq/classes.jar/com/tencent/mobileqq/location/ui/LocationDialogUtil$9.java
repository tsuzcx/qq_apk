package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class LocationDialogUtil$9
  implements Runnable
{
  LocationDialogUtil$9(Activity paramActivity, String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a, 230, null, this.b, 2131887648, 2131892267, new LocationDialogUtil.9.1(this), new LocationDialogUtil.9.2(this));
    LocationDialogUtil.a(this.a, localQQCustomDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.9
 * JD-Core Version:    0.7.0.1
 */