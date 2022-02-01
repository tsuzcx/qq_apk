package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyDeliverVideoActivity$4
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      ReadInJoyDeliverVideoActivity.i(this.a);
      this.a.finish();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyDeliverVideoActivity", 2, "qbShowShareResultDialog back");
    }
    paramDialogInterface = this.a;
    ForwardSdkShareOption.a(paramDialogInterface, true, "shareToQQ", ReadInJoyDeliverVideoActivity.h(paramDialogInterface));
    Util.a(this.a, 0, "", "");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverVideoActivity.4
 * JD-Core Version:    0.7.0.1
 */