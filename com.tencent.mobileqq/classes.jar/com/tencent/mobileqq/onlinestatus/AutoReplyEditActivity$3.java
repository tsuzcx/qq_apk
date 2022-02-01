package com.tencent.mobileqq.onlinestatus;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AutoReplyEditActivity$3
  implements View.OnClickListener
{
  AutoReplyEditActivity$3(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void onClick(View paramView)
  {
    OnlineStatusDataReporter.a(AutoReplyEditActivity.a(this.a), true);
    Intent localIntent = new Intent();
    localIntent.putExtra("AutoReplyEditActivity:new_text", AutoReplyEditActivity.f(this.a));
    if (AutoReplyEditActivity.c(this.a) != null) {
      localIntent.putExtra("AutoReplyEditActivity:text", new AutoReplyText(AutoReplyText.trimRawString(String.valueOf(AutoReplyEditActivity.b(this.a).getText()), false), AutoReplyEditActivity.c(this.a).getTextId()));
    }
    this.a.getQBaseActivity().setResult(325, localIntent);
    this.a.getQBaseActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity.3
 * JD-Core Version:    0.7.0.1
 */