package com.tencent.mobileqq.onlinestatus;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AutoReplyEditActivity$2
  implements View.OnClickListener
{
  AutoReplyEditActivity$2(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void onClick(View paramView)
  {
    OnlineStatusDataReporter.a(AutoReplyEditActivity.a(this.a), false);
    String str2 = String.valueOf(AutoReplyEditActivity.b(this.a).getText());
    String str1;
    if (AutoReplyEditActivity.c(this.a) != null) {
      str1 = AutoReplyEditActivity.c(this.a).getRawText();
    } else {
      str1 = "";
    }
    if (!str2.equals(str1)) {
      AutoReplyEditActivity.d(this.a);
    } else {
      AutoReplyEditActivity.e(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity.2
 * JD-Core Version:    0.7.0.1
 */