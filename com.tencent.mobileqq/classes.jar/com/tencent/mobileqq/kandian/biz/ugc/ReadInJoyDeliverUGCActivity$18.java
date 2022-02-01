package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;

class ReadInJoyDeliverUGCActivity$18
  implements DialogInterface.OnDismissListener
{
  ReadInJoyDeliverUGCActivity$18(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (ReadInJoyDeliverUGCActivity.z(this.a))
    {
      ReadInJoyDeliverUGCActivity.d(this.a, false);
      ReadInJoyDeliverUGCActivity.A(this.a);
      if (!ReadInJoyDeliverUGCActivity.B(this.a))
      {
        paramDialogInterface = this.a;
        paramDialogInterface.a(1, paramDialogInterface.getString(2131915348));
      }
      if (ReadInJoyDeliverUGCActivity.r(this.a) != null) {
        ReadInJoyDeliverUGCActivity.r(this.a).removeCallbacksAndMessages(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity.18
 * JD-Core Version:    0.7.0.1
 */