package com.tencent.mobileqq.kandian.biz.common;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;

final class ReadInJoyLegacyUtils$4
  implements DialogInterface.OnCancelListener
{
  ReadInJoyLegacyUtils$4(Activity paramActivity, ProfileParams paramProfileParams) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.jdField_a_of_type_AndroidAppActivity;
    if ((paramDialogInterface != null) && (!paramDialogInterface.isFinishing()))
    {
      ForwardSdkShareOption.a(this.jdField_a_of_type_AndroidAppActivity, true, "shareToQzone", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams.a()).longValue());
      this.jdField_a_of_type_AndroidAppActivity.setResult(0);
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyLegacyUtils.4
 * JD-Core Version:    0.7.0.1
 */