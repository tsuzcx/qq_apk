package com.tencent.mobileqq.search.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MessageSearchDetailActivity$CancelReceiver
  extends BroadcastReceiver
{
  public MessageSearchDetailActivity$CancelReceiver(MessageSearchDetailActivity paramMessageSearchDetailActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.search.cancel".equals(paramIntent.getAction())) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.MessageSearchDetailActivity.CancelReceiver
 * JD-Core Version:    0.7.0.1
 */