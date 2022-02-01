package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class LocationDialogUtil$7
  implements Runnable
{
  LocationDialogUtil$7(Activity paramActivity) {}
  
  public void run()
  {
    Object localObject = this.a;
    localObject = DialogUtil.a((Context)localObject, 230, null, ((Activity)localObject).getResources().getString(2131719124), 2131694583, 2131690728, null, new LocationDialogUtil.7.1(this));
    LocationDialogUtil.a(this.a, (QQCustomDialog)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.7
 * JD-Core Version:    0.7.0.1
 */