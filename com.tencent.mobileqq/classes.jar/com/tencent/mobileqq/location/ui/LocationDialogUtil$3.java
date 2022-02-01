package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class LocationDialogUtil$3
  implements Runnable
{
  LocationDialogUtil$3(Activity paramActivity, LocationShareController paramLocationShareController) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity;
    localObject = DialogUtil.a((Context)localObject, 230, null, ((Activity)localObject).getResources().getString(2131693808), 2131690728, 2131693809, new LocationDialogUtil.3.1(this), new LocationDialogUtil.3.2(this));
    LocationDialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, (QQCustomDialog)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.3
 * JD-Core Version:    0.7.0.1
 */