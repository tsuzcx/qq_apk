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
    paramDialogInterface = this.a;
    if ((paramDialogInterface != null) && (!paramDialogInterface.isFinishing()))
    {
      ForwardSdkShareOption.a(this.a, true, "shareToQzone", Long.valueOf(this.b.a()).longValue());
      this.a.setResult(0);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyLegacyUtils.4
 * JD-Core Version:    0.7.0.1
 */