package com.tencent.mobileqq.data;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MessageForArkApp$2
  implements View.OnClickListener
{
  MessageForArkApp$2(MessageForArkApp paramMessageForArkApp, QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.c.ark_app_message.appId))
    {
      MessageForArkApp.access$000(this.c, this.a, this.b);
      ArkAppDataReport.a(this.a, this.c.ark_app_message.appName, "AIOArkSdkTailClick", 1, 0, 0L, 0L, 0L, this.c.ark_app_message.appView, "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForArkApp.2
 * JD-Core Version:    0.7.0.1
 */