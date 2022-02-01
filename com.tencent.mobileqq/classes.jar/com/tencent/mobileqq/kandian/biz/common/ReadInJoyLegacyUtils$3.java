package com.tencent.mobileqq.kandian.biz.common;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class ReadInJoyLegacyUtils$3
  implements DialogInterface.OnClickListener
{
  ReadInJoyLegacyUtils$3(Activity paramActivity, ProfileParams paramProfileParams, AppInterface paramAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      if (ReadInJoyLegacyUtils.a != null)
      {
        ReadInJoyLegacyUtils.a.dismiss();
        ReadInJoyLegacyUtils.a = null;
        this.jdField_a_of_type_AndroidAppActivity.finish();
        ReadInJoyLegacyUtils.c(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams);
      }
    }
    else
    {
      ForwardSdkShareOption.a(this.jdField_a_of_type_AndroidAppActivity, false, "shareToQzone", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams.a()).longValue());
      paramDialogInterface = this.jdField_a_of_type_AndroidAppActivity;
      if ((paramDialogInterface != null) && (!paramDialogInterface.isFinishing()))
      {
        this.jdField_a_of_type_AndroidAppActivity.setResult(0);
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyLegacyUtils.3
 * JD-Core Version:    0.7.0.1
 */