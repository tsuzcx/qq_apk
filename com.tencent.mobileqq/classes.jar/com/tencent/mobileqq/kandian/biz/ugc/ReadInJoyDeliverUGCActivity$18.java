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
    if (ReadInJoyDeliverUGCActivity.e(this.a))
    {
      ReadInJoyDeliverUGCActivity.d(this.a, false);
      ReadInJoyDeliverUGCActivity.f(this.a);
      if (!ReadInJoyDeliverUGCActivity.f(this.a))
      {
        paramDialogInterface = this.a;
        paramDialogInterface.a(1, paramDialogInterface.getString(2131717875));
      }
      if (ReadInJoyDeliverUGCActivity.a(this.a) != null) {
        ReadInJoyDeliverUGCActivity.a(this.a).removeCallbacksAndMessages(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity.18
 * JD-Core Version:    0.7.0.1
 */