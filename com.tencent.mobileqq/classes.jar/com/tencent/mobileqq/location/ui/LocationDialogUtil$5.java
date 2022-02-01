package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class LocationDialogUtil$5
  implements Runnable
{
  LocationDialogUtil$5(Activity paramActivity, int paramInt1, String paramString, int paramInt2) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, null, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719408), 2131690800, 2131694615, new LocationDialogUtil.5.1(this), new LocationDialogUtil.5.2(this));
    LocationDialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, localQQCustomDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.5
 * JD-Core Version:    0.7.0.1
 */