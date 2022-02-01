package com.tencent.mobileqq.kandian.biz.ugc;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyDeliverVideoActivity$2$1
  implements Runnable
{
  ReadInJoyDeliverVideoActivity$2$1(ReadInJoyDeliverVideoActivity.2 param2) {}
  
  public void run()
  {
    QLog.d("ReadInJoyDeliverVideoActivity", 2, "initCompositionManager: success, update UI");
    ReadInJoyDeliverVideoActivity.a(this.a.a).setVisibility(4);
    ReadInJoyDeliverVideoActivity.a(this.a.a).setVisibility(0);
    ReadInJoyDeliverVideoActivity.a(this.a.a).setClickable(true);
    this.a.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverVideoActivity.2.1
 * JD-Core Version:    0.7.0.1
 */