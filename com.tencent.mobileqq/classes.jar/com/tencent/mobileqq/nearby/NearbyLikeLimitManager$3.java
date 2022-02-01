package com.tencent.mobileqq.nearby;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class NearbyLikeLimitManager$3
  implements DialogInterface.OnClickListener
{
  NearbyLikeLimitManager$3(NearbyLikeLimitManager paramNearbyLikeLimitManager, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager.a;
    if ((paramDialogInterface != null) && (!TextUtils.isEmpty(paramDialogInterface.a)))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramDialogInterface.a);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 1028);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyLikeLimitManager.3
 * JD-Core Version:    0.7.0.1
 */