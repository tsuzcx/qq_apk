package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.ActionSheet.OnDismissListener;
import mqq.os.MqqHandler;

class ReadInJoyBaseDeliverActivity$13
  implements ActionSheet.OnDismissListener
{
  ReadInJoyBaseDeliverActivity$13(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void onDismiss()
  {
    if ((!this.a.a) && (this.a.j != -1)) {
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyBaseDeliverActivity.13.1(this), 300L);
    }
    this.a.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyBaseDeliverActivity.13
 * JD-Core Version:    0.7.0.1
 */