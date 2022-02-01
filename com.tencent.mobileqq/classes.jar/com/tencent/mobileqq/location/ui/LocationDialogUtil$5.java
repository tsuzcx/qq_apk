package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class LocationDialogUtil$5
  implements Runnable
{
  LocationDialogUtil$5(Activity paramActivity, int paramInt1, String paramString, int paramInt2) {}
  
  public void run()
  {
    Object localObject = this.a;
    localObject = DialogUtil.a((Context)localObject, 230, null, ((Activity)localObject).getResources().getString(2131916662), 2131887648, 2131892267, new LocationDialogUtil.5.1(this), new LocationDialogUtil.5.2(this));
    LocationDialogUtil.a(this.a, (QQCustomDialog)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.5
 * JD-Core Version:    0.7.0.1
 */