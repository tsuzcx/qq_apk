package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyDeliverVideoActivity$2$2
  implements Runnable
{
  ReadInJoyDeliverVideoActivity$2$2(ReadInJoyDeliverVideoActivity.2 param2) {}
  
  public void run()
  {
    QLog.d("ReadInJoyDeliverVideoActivity", 2, "initCompositionManager: error, show toast");
    QQToast.makeText(this.a.a, 2131915358, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverVideoActivity.2.2
 * JD-Core Version:    0.7.0.1
 */