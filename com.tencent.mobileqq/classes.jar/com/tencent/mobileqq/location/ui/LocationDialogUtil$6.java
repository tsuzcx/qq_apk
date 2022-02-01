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
    Object localObject = this.jdField_a_of_type_AndroidAppActivity;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719123));
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localObject = DialogUtil.a((Context)localObject, 230, null, localStringBuilder.toString(), 2131694583, 2131690728, new LocationDialogUtil.6.1(this), null);
    LocationDialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, (QQCustomDialog)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.6
 * JD-Core Version:    0.7.0.1
 */