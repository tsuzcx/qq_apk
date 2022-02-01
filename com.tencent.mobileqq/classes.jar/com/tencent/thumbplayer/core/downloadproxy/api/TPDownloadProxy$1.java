package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class TPDownloadProxy$1
  extends BroadcastReceiver
{
  TPDownloadProxy$1(TPDownloadProxy paramTPDownloadProxy) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_OFF".equals(paramContext)) {
      this.this$0.pushEvent(20);
    }
    while (!"android.intent.action.SCREEN_ON".equals(paramContext)) {
      return;
    }
    this.this$0.pushEvent(19);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxy.1
 * JD-Core Version:    0.7.0.1
 */