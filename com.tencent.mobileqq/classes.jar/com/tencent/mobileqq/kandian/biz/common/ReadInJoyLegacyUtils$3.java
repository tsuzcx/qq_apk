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
        this.a.finish();
        ReadInJoyLegacyUtils.c(this.a, this.c, this.b);
      }
    }
    else
    {
      ForwardSdkShareOption.a(this.a, false, "shareToQzone", Long.valueOf(this.b.a()).longValue());
      paramDialogInterface = this.a;
      if ((paramDialogInterface != null) && (!paramDialogInterface.isFinishing()))
      {
        this.a.setResult(0);
        this.a.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyLegacyUtils.3
 * JD-Core Version:    0.7.0.1
 */