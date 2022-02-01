package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class ReadInJoyDeliverUGCActivity$9
  implements DialogInterface.OnDismissListener
{
  ReadInJoyDeliverUGCActivity$9(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ReadInJoyDeliverUGCActivity.b(this.a, false);
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyDeliverUGCActivity.9.1(this), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity.9
 * JD-Core Version:    0.7.0.1
 */