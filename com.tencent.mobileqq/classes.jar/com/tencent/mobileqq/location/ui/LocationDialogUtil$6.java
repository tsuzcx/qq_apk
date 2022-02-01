package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class LocationDialogUtil$6
  implements Runnable
{
  public void run()
  {
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getResources().getString(2131916659));
    localStringBuilder.append(this.b);
    localObject = DialogUtil.a((Context)localObject, 230, null, localStringBuilder.toString(), 2131892267, 2131887648, new LocationDialogUtil.6.1(this), null);
    LocationDialogUtil.a(this.a, (QQCustomDialog)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.6
 * JD-Core Version:    0.7.0.1
 */